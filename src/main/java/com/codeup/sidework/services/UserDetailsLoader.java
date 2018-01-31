package com.codeup.sidework.services;


import com.codeup.sidework.models.User;
import com.codeup.sidework.models.UserWithRoles;
import com.codeup.sidework.repositories.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final Users users;

    public UserDetailsLoader(Users users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("The username " + username + "could not be found.");
        }

        return new UserWithRoles(user);
    }
}
