package com.brainmatics.pos.infra.data.mongodb;

import com.brainmatics.pos.core.Product;
import com.brainmatics.pos.core.ProductRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class ProductMongoRepo implements ProductRepo {

    public int getCount() {
        System.out.println("from mongodb");
        return 1;
    }

    public Product getById(int id) {
        System.out.println("from mongodb");
        return new Product();
    }

    public List<Product> getAll() {
        return new ArrayList<>();
    }

    public void save(Product product) {
    }

    public void remove(int id) {
    }
}


