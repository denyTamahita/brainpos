package com.brainmatics.pos.infra.data.jdbc;

import com.brainmatics.pos.core.Employee;
import com.brainmatics.pos.core.Product;
import com.brainmatics.pos.core.Sale;
import com.brainmatics.pos.core.SaleLineItem;
import org.springframework.jdbc.core.JdbcTemplate;

public class SalejdbcRepo {

    private JdbcTemplate jdbc;

    public SalejdbcRepo(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public Sale getByidEager(int id){
        String sql =   "SELECT * FROM sale s join saleLineitem sli on s.id = sli.saleid join product p on sli.productid = p.id WHERE S.ID = ?";
        return jdbc.query(sql,new Object[]{id}, (rs) -> {
            Sale sale = new Sale();
            sale.setId(id);
            Employee e = new Employee();
            rs.next();
            e.setId(rs.getInt("employeeid"));
            sale.setCashier(e);
            do{
                Product p = new Product();
                p.setId(rs.getInt("productid"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getBigDecimal("price"));
                sale.addLineItem(p,rs.getInt("quantity"));
            } while (rs.next());

            return sale;
        });
    }


    public Sale getByid(int id){
        String sql = "SELECT * FROM sale s join saleLineitem sli on s.id = sli.saleid  WHERE S.ID = ?";
        return jdbc.query(sql,new Object[]{id}, (rs) -> {
            Sale sale = new Sale();
            sale.setId(id);
            Employee e = new Employee();
            rs.next();
            e.setId(rs.getInt("employeeid"));
            sale.setCashier(e);
            do{
                Product p = new Product();
                p.setId(rs.getInt("productid"));
                sale.addLineItem(p,rs.getInt("quantity"));
            } while (rs.next());

           return sale;
        });
    }
}
