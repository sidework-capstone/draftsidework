package com.codeup.sidework.services;


import com.codeup.sidework.daos.ListingsRepository;
import com.codeup.sidework.models.Business;
import com.codeup.sidework.models.Listing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("listingSvc")
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

    public List<Listing> searchForListing(String keyword) {
        return listingsDao.search(keyword);
    }
}
