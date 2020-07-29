package business;

import dao.*;
import db.DBConnection;
import entity.Customer;
import entity.Item;
import entity.OrderDetail;
import entity.Orders;
import util.CustomerTM;
import util.ItemTM;
import util.OrderDetailTM;
import util.OrderTM;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessLogic {

    public static String getNewCustomerId() {
        String lastCustomerId = new CustomerDAO().getLastCustomerId();
        if (lastCustomerId == null) {
            return "C001";
        } else {
            int maxId = Integer.parseInt(lastCustomerId.replace("C", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "C00" + maxId;
            } else if (maxId < 100) {
                id = "C0" + maxId;
            } else {
                id = "C" + maxId;
            }
            return id;
        }
    }

    public static String getNewItemCode(){
        String lastItemCode = new ItemDAO().getLastItemCode();
        if (lastItemCode == null){
            return "I001";
        }else{
            int maxId=  Integer.parseInt(lastItemCode.replace("I",""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "I00" + maxId;
            } else if (maxId < 100) {
                id = "I0" + maxId;
            } else {
                id = "I" + maxId;
            }
            return id;
        }
    }


    public static String getNewOrderId(){
        String lastOrderId = new OrdersDAO().getLastOrderId();
        if (lastOrderId == null){
            return "D001";
        }else{
            int maxId=  Integer.parseInt(lastOrderId.replace("D",""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "D00" + maxId;
            } else if (maxId < 100) {
                id = "D0" + maxId;
            } else {
                id = "D" + maxId;
            }
            return id;
        }
    }

    public static List<CustomerTM> getAllCustomers(){
        List<Customer> allCustomers = new CustomerDAO().findAllCustomers();
        List<CustomerTM> customers = new ArrayList<>();
        for (Customer customer: allCustomers) {
            customers.add(new CustomerTM(customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerAddress()));
        }
        return customers;
    }

    public static boolean saveCustomer(String id, String name, String address){

        return new CustomerDAO().saveCustomer(new Customer(id,name,address));
    }

    public static boolean deleteCustomer(String customerId){
        return new CustomerDAO().deleteCustomer(customerId);
    }

    public static boolean updateCustomer(String name, String address, String customerId){
        return new CustomerDAO().updateCustomer(new Customer(name, address, customerId));
    }

    public static List<ItemTM> getAllItems(){
        List<Item> allItems = new ItemDAO().findAllItems();
        List<ItemTM> items = new ArrayList<>();
        for (Item item: allItems) {
            items.add(new ItemTM(item.getItemCode(),item.getDescription(),item.getQtyOnHand(),item.getUnitPrice().doubleValue()));
        }
        return items;
    }

    public static boolean saveItem(String code, String description, int qtyOnHand, double unitPrice){
        return new ItemDAO().saveItem(new Item(code,description, BigDecimal.valueOf(unitPrice),qtyOnHand));
    }

    public static boolean deleteItem(String itemCode){
        return new ItemDAO().deleteItem(itemCode);
    }

    public static boolean updateItem(String description, int qtyOnHand, double unitPrice, String itemCode){
        return new ItemDAO().updateItem(new Item(itemCode, description, BigDecimal.valueOf(unitPrice),qtyOnHand ));
    }

    public static boolean placeOrder(OrderTM order, List<OrderDetailTM> orderDetails){
//        System.out.println(order.toString());
//        System.out.println(orderDetails);
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            boolean result = new OrdersDAO().saveOrder(new Orders(order.getOrderId(),
                    Date.valueOf(order.getOrderDate()),order.getCustomerId()));
            if (!result){
                connection.rollback();
                return false;
            }
            for (OrderDetailTM orderDetail: orderDetails) {
                result = new OrderDetailDAO().saveOrderDetail(new OrderDetail(order.getOrderId(),orderDetail.getCode(),
                        orderDetail.getQty(),BigDecimal.valueOf(orderDetail.getUnitPrice())));
                if(!result){
                    connection.rollback();
                    return false;
                }
                Item item = new ItemDAO().findItem(orderDetail.getCode());
                item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
                result = new ItemDAO().updateItem(item);
                if(!result){
                    connection.rollback();
                    return false;
                }
            }
            connection.commit();
            return true;

        } catch (Throwable throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
