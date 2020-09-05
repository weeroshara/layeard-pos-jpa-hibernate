package lk.ijse.dep.poss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements SuperEntity {

    @Id
    private String orderID;
    private Date orderDate;
    private String customerId;


//    public Orders() {
//    }
//
//    public Orders(String orderID, Date orderDate, String customerId) {
//        this.orderID = orderID;
//        this.orderDate = orderDate;
//        this.customerId = customerId;
//    }
//
//    public String getOrderID() {
//        return orderID;
//    }
//
//    public void setOrderID(String orderID) {
//        this.orderID = orderID;
//    }
//
//    public Date getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(Date orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public String getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(String customerId) {
//        this.customerId = customerId;
//    }
//
//    @Override
//    public String toString() {
//        return "Orders{" +
//                "orderID='" + orderID + '\'' +
//                ", orderDate=" + orderDate +
//                ", customerId='" + customerId + '\'' +
//                '}';
//    }

}
