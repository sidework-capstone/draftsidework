package com.codeup.sidework.services;


import com.codeup.sidework.daos.ListingsRepository;
import com.codeup.sidework.models.Listings;
import org.springframework.stereotype.Service;

@Service
public class ListingsService {
    private ListingsRepository listingsDao;

    public ListingsService(ListingsRepository listingsDao) {
        this.listingsDao = listingsDao;
    }

    public Iterable<Listings> findAll() {
        return listingsDao.findAll();
    }

    public void save(Listings listing) {
        listingsDao.save(listing);
    }

    public Listings findOne(long id) {
        return listingsDao.findOne(id);
    }
}
