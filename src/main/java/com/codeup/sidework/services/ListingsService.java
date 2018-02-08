package com.codeup.sidework.services;


import com.codeup.sidework.daos.ListingsRepository;
import com.codeup.sidework.models.Listing;
import org.springframework.stereotype.Service;

@Service
public class ListingsService {
    private ListingsRepository listingsDao;

    public ListingsService(ListingsRepository listingsDao) {
        this.listingsDao = listingsDao;
    }

    public Iterable<Listing> findAll() {
        return listingsDao.findAll();
    }

    public void save(Listing listing) {
        listingsDao.save(listing);
    }

    public Listing findOne(long id) {
        return listingsDao.findOne(id);
    }
}
