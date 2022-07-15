package uz.pdp.service;

import uz.pdp.database.Database;
import uz.pdp.enums.CustomerStatus;
import uz.pdp.model.CartProduct;
import uz.pdp.model.Customer;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerService {

    public static Customer getCustomerById(String id) {
        loadCustomerList();
        Optional<Customer> optional = Database.customerList.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
        return optional.orElse(null);
    }


    public static List<CartProduct> getCartProducts(String userId){
        List<CartProduct> cartProductProducts = Database.cartProductList.stream()
                .filter(cartProduct -> cartProduct.getCustomerId().equals(userId))
                .collect(Collectors.toList());
        return cartProductProducts;
    }


    public static void loadCustomerList() {
        Connection connection = Database.getConnection();
        if (connection != null) {

            try (Statement statement = connection.createStatement()) {

                Database.customerList.clear();

                String query = " SELECT * FROM customer; ";

                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String phoneNumber = resultSet.getString("phone_number");
                    String status = resultSet.getString("status");

                    Customer customer = new Customer(id, firstName, lastName, phoneNumber,
                            CustomerStatus.valueOf(status));

                    Database.customerList.add(customer);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }


    public static void addCustomer( Customer customer) {
        Connection connection = Database.getConnection();
        if(connection != null){

            String query = " INSERT INTO customer(id, first_name, last_name, phone_number, status)" +
                    " VALUES(?, ?, ?, ?, ?); ";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, customer.getId());
                preparedStatement.setString(2, customer.getFirstName());
                preparedStatement.setString(3, customer.getLastName());
                preparedStatement.setString(4, customer.getPhoneNumber());
                preparedStatement.setString(5, String.valueOf(customer.getStatus()));


                int executeUpdate = preparedStatement.executeUpdate();
                System.out.println(executeUpdate);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        loadCustomerList();
    }
}
