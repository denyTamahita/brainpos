package com.brainmatics.pos;

import com.brainmatics.pos.core.*;
import com.brainmatics.pos.infra.data.inmemory.ProductMemRepo;
import com.brainmatics.pos.infra.data.jdbc.ProductJdbcRepo;
import com.brainmatics.pos.infra.data.jdbc.SalejdbcRepo;
import com.brainmatics.pos.infra.data.mongodb.ProductMongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PosApplication implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbc;

    public static void main(String[] args) {
        SpringApplication.run(PosApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
//        jdbc.execute("CREATE TABLE Employee (id int primary key ,name varchar(50) )");
//        jdbc.execute("INSERT INTO Employee (id,name) values (1,'Michael Suyama')");
//        jdbc.execute("INSERT INTO Employee (id,name) values (2,'Nancy Davolio')");
//        jdbc.execute("INSERT INTO Employee (id,name) values (3,'Deny Baskoro')");

//        List<Employee> emps = jdbc.query("SELECT id, name FROM Employee ", (rs, num) -> {
//            Employee e = new Employee();
//            e.setId(rs.getInt("id"));
//            e.setName(rs.getString("name"));
//            return e;
//        });
//
//
//        for (Employee e : emps) {
//            System.out.println(e.getName());
//
//        }

        ProductJdbcRepo repo = new ProductJdbcRepo(jdbc);
//        Product p = repo.getById(2);
//        System.out.println(p.getName());
//        System.out.println(repo.getCount());


//        for (Product p : all)
//            System.out.println(p.getName());

//        Product p = new Product();
//        p.setId(4);
//        p.setCode("E04");
//        p.setPrice(BigDecimal.valueOf(1000));
//        p.setName("tes insert");
//        repo.save(p);
//        repo.remove(4);

//        List<Product> all = repo.getAll();
//        for (Product p1 : all)
//            System.out.println(p1.getName());


        SalejdbcRepo salerepo =  new SalejdbcRepo(jdbc);

        Sale s = salerepo.getByidEager(1);

        ArrayList<SaleLineItem> slis = s.getLineItems();

        for (SaleLineItem sli: slis) {
            System.out.print(sli.getProduct().getName());
            System.out.print('-');
            System.out.println(sli.getProduct().getPrice());
        }

//        for (Sale s1 : slis) {
//            System.out.println(s1.getCashier());
//        }


    }


    public static void mainManual(String[] args) {
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("Momogi");
        p1.setPrice(BigDecimal.valueOf(500));

        Product p2 = new Product();
        p2.setId(2);
        p2.setName("Pepsi");
        p2.setPrice(BigDecimal.valueOf(5000));

        Product p3 = new Product();
        p3.setId(3);
        p3.setName("Ajam");
        p3.setPrice(BigDecimal.valueOf(50_000));

        ProductMemRepo repo = new ProductMemRepo();
        repo.save(p1);
        repo.save(p2);
        repo.save(p3);

//        Product prd2 = repo.getById(2);
//        System.out.println(prd2.getName());

        // tampilkan semua product
//        ArrayList<Product> all = repo.getAll();
//        for (Product p: all)
//            System.out.println(p.getName());

//        ProductService service = new ProductService(new ProductMongoRepo());
        ProductService service = new ProductService(new ProductMemRepo());
        System.out.println(service.generateCode());
    }


    public static void main1(String[] args) {
//        Employee e1 = new Employee();
//        e1.setId(1);
//        e1.setName("Michael Suyama");
//        e1.setBirthDate(LocalDate.of(1970, 3, 20));
//
//        Employee e2 = new Employee();
//        e2.setId(2);
//        e2.setName("Nancy Davolio");
//        e2.setBirthDate(LocalDate.of(1960, 3, 3));
//        System.out.println(e1.getAge());
//
//        Product p1 = new Product();
//        p1.setId(1);
//        p1.setName("Momogi");
//        p1.setPrice(BigDecimal.valueOf(500));
//
//        Product p2 = new Product();
//        p2.setId(2);
//        p2.setName("Pepsi");
//        p2.setPrice(BigDecimal.valueOf(5000));
//
//        Product p3 = new Product();
//        p3.setId(3);
//        p3.setName("Ajam");
//        p3.setPrice(BigDecimal.valueOf(50_000));
//
//        Sale s1 = new Sale();
//        s1.setId(1);
//        s1.setCashier(e1);
//        s1.addProduct(p1);
//        s1.addProduct(p1);
//        s1.addProduct(p2);
//        for (Product p: s1.getProducts()) {
//            System.out.println(p.getName());
//        }
//
//        System.out.println(s1.getTotal());
//
//        Sale s2 = new Sale();
//        s2.setId(2);
//        s2.setCashier(e2);
    }
}
