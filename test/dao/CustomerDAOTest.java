package dao;

import entity.Customer;

import java.util.List;

public class CustomerDAOTest {

    public static void main(String[] args) {
//        List<Customer> allCustomers = CustomerDAO.findAllCustomers();
//        for (Customer customer: allCustomers) {
//            System.out.println(customer);

//        assert false:"Pissu double";
        assert CustomerDAO.findAllCustomers().size() ==6;
        }
    }

