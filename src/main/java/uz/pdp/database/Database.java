package uz.pdp.database;

import uz.pdp.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Database {
    List<Customer> customerList = new ArrayList<>();
    List<Category> categoryList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    List<CartProduct> cartProductList = new ArrayList<>();
    List<Operations> operationList =  new ArrayList<>();
    List<Order> orderList = new ArrayList<>();


    static Connection getConnection() {
        Connection con = null;
        try {
            // Class.forName("org.postgresql.Driver");  // 1

            con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/nout_uz",
                            "postgres", "Bahodir2011"); //2

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

}
