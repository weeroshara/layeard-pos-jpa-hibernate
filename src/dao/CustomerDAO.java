package dao;

import db.DBConnection;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    public String getLastCustomerId(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT CustomerID FROM Customer ORDER BY CustomerID DESC LIMIT 1");
            if (rst.next()){
                return rst.getString(1);
            }else{
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public List<Customer> findAllCustomers(){
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM Customer");
            ArrayList<Customer>customers = new ArrayList<>();
            while (resultSet.next()){
                customers.add(new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Customer findCustomer(String customerId){
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE customerId=?");
            pstm.setObject(1,customerId);
            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()){
                return new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean saveCustomer(Customer customer){

        Connection connection = DBConnection.getInstance().getConnection();

        try {
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?)");
            pstm.setObject(1,customer.getCustomerId());
            pstm.setObject(2,customer.getCustomerName());
            pstm.setObject(3,customer.getCustomerAddress());
            return pstm.executeUpdate()>0;

            } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }

    public boolean updateCustomer(Customer customer){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET customerName=?, customerAddress=? WHERE customerId=?");
            pstm.setObject(1, customer.getCustomerId());
            pstm.setObject(2, customer.getCustomerName());
            pstm.setObject(3, customer.getCustomerAddress());
            return pstm.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }

    public boolean deleteCustomer(String customerId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE customerId=?");
            pstm.setObject(1, customerId);
            return pstm.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
