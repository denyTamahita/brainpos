package com.brainmatics.pos.infra.data.inmemory;

import com.brainmatics.pos.core.Product;
import com.brainmatics.pos.core.ProductRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductMemRepo implements ProductRepo {

    private static ArrayList<Product> data = new ArrayList<>();

    public int getCount() {
        System.out.println("from mem");
        return data.size();
    }

    public Product getById(int id) {

        for (Product p: data) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    public List<Product> getAll() {
        return data;
    }

    public void save(Product product) {
        data.add(product);
    }

    public void remove(int id) {
        for (Product p: data) {
            if (p.getId() == id)
                data.remove(p);
        }
    }
}


//    String query = "SELECT * FROM Products";
//    ResultSet rs = executeQuery(query);
//    rs.next();
//    int id = rs.getInt("Id");
//    String name = rs.getString("Name");
//    BigDecimal price = rs.getBigDecimal("UnitPrice");
//
//    Product result = new Product();
//    result.setId(id);
//    result.setName(name);
//    result.setPrice(price);
//    return result;
