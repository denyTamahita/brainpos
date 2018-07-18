package com.brainmatics.pos.core;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepo {

    int getCount();
    Product getById(int id);
    List<Product> getAll();

    void save(Product product);
    void remove(int id);
}
