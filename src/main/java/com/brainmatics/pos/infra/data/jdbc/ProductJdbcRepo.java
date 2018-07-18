package com.brainmatics.pos.infra.data.jdbc;

import com.brainmatics.pos.core.Employee;
import com.brainmatics.pos.core.Product;
import com.brainmatics.pos.core.ProductRepo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductJdbcRepo implements ProductRepo {

    private final String COUNT   = "SELECT COUNT(*) FROM Product";
    private final String INSERT  = "INSERT INTO Product (id, code, name, price) VALUES (?,?,?,?)";
    private final String GETALL  = "SELECT id,code,name,price FROM Product";
    private final String DELETE  = "Delete From Product where id = ?";
    private final String GETBYID = "SELECT id,code,name,price FROM Product Where id = ?";

    private JdbcTemplate jdbc;

    public ProductJdbcRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int getCount() {
        return jdbc.query(COUNT, rs -> {
            rs.next();
            return rs.getInt(1);

        });
    }

    @Override
    public Product getById(int id) {
        return jdbc.query(GETBYID, new Object[]{id}, rs -> {
            rs.next();
            return map(rs);
        });
    }

    @Override
    public List<Product> getAll() {
        return jdbc.query(GETALL, (rs, num) -> map(rs));
    }

    @Override
    public void save(Product product) {

        jdbc.update(INSERT, product.getId(), product.getCode(), product.getName(), product.getPrice());
    }

    @Override
    public void remove(int id) {
        jdbc.update(DELETE, id);

    }

    private Product map(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setCode(rs.getString("code"));
        p.setName(rs.getString("name"));
        p.setPrice(rs.getBigDecimal("price"));
        return p;
    }
}
