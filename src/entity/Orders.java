package entity;

import java.io.Serializable;
import java.sql.Date;

public class Orders implements Serializable {

    private String orderID;
    private Date orderDate;
    private String customerId;

    public Orders() {
    }

    public Orders(String orderID, Date orderDate, String customerId) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customerId = customerId;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID='" + orderID + '\'' +
                ", orderDate=" + orderDate +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
