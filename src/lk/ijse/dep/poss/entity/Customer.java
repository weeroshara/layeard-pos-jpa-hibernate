package lk.ijse.dep.poss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer implements SuperEntity {
    @Id
    private String customerId;
    private String customerName;
    private String customerAddress;

//    public Customer() {
//    }
//
//    public Customer(String customerId, String customerName, String customerAddress) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.customerAddress = customerAddress;
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
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getCustomerAddress() {
//        return customerAddress;
//    }
//
//    public void setCustomerAddress(String customerAddress) {
//        this.customerAddress = customerAddress;
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "customerId='" + customerId + '\'' +
//                ", customerName='" + customerName + '\'' +
//                ", customerAddress='" + customerAddress + '\'' +
//                '}';
//    }
}
