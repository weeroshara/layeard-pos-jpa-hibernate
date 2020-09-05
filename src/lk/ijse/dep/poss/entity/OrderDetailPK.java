package lk.ijse.dep.poss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class OrderDetailPK implements Serializable {
    private String orderId;
    private String itemCode;

//    public OrderDetailPK() {
//    }
//
//    public OrderDetailPK(String orderId, String itemCode) {
//        this.orderId = orderId;
//        this.itemCode = itemCode;
//    }
//
//    public String getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(String orderId) {
//        this.orderId = orderId;
//    }
//
//    public String getItemCode() {
//        return itemCode;
//    }
//
//    public void setItemCode(String itemCode) {
//        this.itemCode = itemCode;
//    }
//
//    @Override
//    public String toString() {
//        return "OrderDetailPK{" +
//                "orderId='" + orderId + '\'' +
//                ", itemCode='" + itemCode + '\'' +
//                '}';
//    }
}
