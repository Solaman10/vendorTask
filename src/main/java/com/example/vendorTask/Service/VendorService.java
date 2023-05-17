package com.example.vendorTask.Service;

import com.example.vendorTask.Domain.Vendor;
import com.example.vendorTask.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.naming.ldap.PagedResultsControl;
import javax.validation.Valid;
import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorRepository repo;

    public List<Vendor> listAll() {
        return repo.findAll();
    }

    public void save(@Valid Vendor vendor) {
        repo.save(vendor);
    }

    public Vendor get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public Page<Vendor> getVendByPaginate(int curPage, int size){

        Pageable p = PageRequest.of(curPage,size);
        return repo.findAll(p);
    }
}
