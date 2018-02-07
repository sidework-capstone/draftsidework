# sidework
This repository contains the code for the Sidework capstone project built by Mary Kathryn Syms, Greg Schmitt, and Michael Cabeza.

[Sidework Capstone Organization Github Project Road Map](https://github.com/orgs/sidework-capstone/projects/1) 


* Sidework [0/4]
- [ ] [0/7] Miscellaneous
    - [ ] Live Site (mary)
    - [ ] Create a seeder with positions -- just a seeder.sql file (~15mins) (mary)
    - [ ] Landing page that isn't hello world
    - [ ] Remove separate logins, should have just one login page
    - [ ] User login is broken this should be at =/login=
    - [ ] Add more test/dummy data to the seeder (for both development and presentation)
    - [ ] Include the navbar on all the pages
- [ ] [0/10] Users (greg)
    - [ ] Create a user =/users/create= (registration page)
        - Rows are inserted into the `users` table
        - uncommenting
    - [ ] View a user =/users/{id}= (worker profile page)
        - Currently there are syntax errors on this page
    - [ ] View a list of users, i.e. all users in the database, with links to individual users =/users= (business dashboard)
    - [ ] Edit a user's information =/users/{id}/edit= (access control)
        - information in the database is changed
    - [ ] Attach a position_id to a user when they are created
        - currently this is non-functional?
    - [ ] Search users by position (blocked by this working on registration)
    - [ ] Search (filter) users by availability, employment status (blocked by these working on the register page)
    - [ ] Delete a user (access control)
    - [ ] Add positions and availability/schedule to user registration
    - [ ] Validation error messages
- [ ] [2/7] Business (michael)
    - [ ] Create a business =/businesses/create= (refactor business registration page)
        - The business should be related to the logged in user when creating
        - just logged in users should be able to visit this page
        - rows are inserted into the `businesses` table
    - [x] View an individual business =/businesses/{id}= (business profile page)
    - [x] View all businesses =/businesses=
    - [ ] Edit businesses page =/businesses/{id}/edit= (access control)
        - information in the database is changed
    - [ ] View the listings a business has created on the individual business page (blocked by creating listings)
    - [ ] Delete a business (access control)
    - [ ] Validation error messages
- [ ] [0/10] Listings (mary)
    - [ ] Create a listing with just details =/listings/create=
        - When a listing is created, the business_id of the logged in user
          should be attached to the listing
        - only users that have created a business should be able to access
          this page
        - rows are inserted into the `listings` table
    - [ ] listings show page =/listings/{id}=
    - [ ] listings index page =/listings= (worker dashboard)
    - [ ] Edit or remove a listing =/listings/{id}/edit= (the position was fileed)
        - rows in the database are updated
    - [ ] a position_id is attached to a listing when it is created
    - [ ] Search listings by position
    - [ ] Add more details and search (filter) by these details
    - [ ] Validation error messages
    - [ ] Live Site (mary)
    - [ ] Create a seeder with positions -- just a seeder.sql file (~15mins) (mary)