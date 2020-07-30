package business;

import dao.CustomerDAO;
import dao.ItemDAO;
import dao.OrderDetailDAO;
import dao.OrdersDAO;
import dao.impl.CustomerDAOImpl;
import dao.impl.ItemDAOImpl;
import dao.impl.OrderDetailDAOImpl;
import dao.impl.OrdersDAOImpl;
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
        CustomerDAO customerDAO = new CustomerDAOImpl();
        String lastCustomerId = customerDAO.getLastCustomerId();
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
        ItemDAO itemDAO = new ItemDAOImpl();
        String lastItemCode = itemDAO.getLastItemCode();
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
        OrdersDAO ordersDAO = new OrdersDAOImpl();
        String lastOrderId = ordersDAO.getLastOrderId();
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
        CustomerDAO customerDAO = new CustomerDAOImpl();
        List<Object> allCustomers =customerDAO.findAll();
        List<CustomerTM> customers = new ArrayList<>();
        for (Object c: allCustomers) {
            Customer customer = (Customer) c;
            customers.add(new CustomerTM(customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerAddress()));
        }
        return customers;
    }

    public static boolean saveCustomer(String id, String name, String address){
            CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.save(new Customer(id,name,address));
    }

    public static boolean deleteCustomer(String customerId){
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.delete(customerId);
    }

    public static boolean updateCustomer(String name, String address, String customerId){
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.update(new Customer(name, address, customerId));
    }

    public static List<ItemTM> getAllItems(){
        ItemDAO itemDAO = new ItemDAOImpl();
        List<Object> allItems = itemDAO.findAll();
        List<ItemTM> items = new ArrayList<>();
        for (Object i: allItems) {
            Item item = (Item) i;
            items.add(new ItemTM(item.getItemCode(),item.getDescription(),item.getQtyOnHand(),item.getUnitPrice().doubleValue()));
        }
        return items;
    }

    public static boolean saveItem(String code, String description, int qtyOnHand, double unitPrice){
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.save(new Item(code,description, BigDecimal.valueOf(unitPrice),qtyOnHand));
    }

    public static boolean deleteItem(String itemCode){
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.delete(itemCode);
    }

    public static boolean updateItem(String description, int qtyOnHand, double unitPrice, String itemCode){
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.update(new Item(itemCode, description, BigDecimal.valueOf(unitPrice),qtyOnHand ));
    }

    public static boolean placeOrder(OrderTM order, List<OrderDetailTM> orderDetails){
//        System.out.println(order.toString());
//        System.out.println(orderDetails);
        Connection connection = DBConnection.getInstance().getConnection();
        OrdersDAO ordersDAO = new OrdersDAOImpl();
        try {
            connection.setAutoCommit(false);
            boolean result = ordersDAO.save(new Orders(order.getOrderId(),
                    Date.valueOf(order.getOrderDate()),order.getCustomerId()));
            if (!result){
                connection.rollback();
                return false;
            }
            for (OrderDetailTM orderDetail: orderDetails) {
                OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
                result = orderDetailDAO.save(new OrderDetail(order.getOrderId(),orderDetail.getCode(),
                        orderDetail.getQty(),BigDecimal.valueOf(orderDetail.getUnitPrice())));
                if(!result){
                    connection.rollback();
                    return false;
                }
                ItemDAO itemDAO = new ItemDAOImpl();
                Item item = (Item) itemDAO.find(orderDetail.getCode());
                item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
                result = new ItemDAOImpl().update(item);
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
