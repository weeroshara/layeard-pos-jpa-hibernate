package lk.ijse.dep.poss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item implements SuperEntity {
        @Id
        private String itemCode;
        private String description;
        private BigDecimal unitPrice;
        private int qtyOnHand;



        //    public Item() {
//    }
//
//    public Item(String itemCode, String description, BigDecimal unitPrice, int qtyOnHand) {
//        this.itemCode = itemCode;
//        this.description = description;
//        this.unitPrice = unitPrice;
//        this.qtyOnHand = qtyOnHand;
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
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public BigDecimal getUnitPrice() {
//        return unitPrice;
//    }
//
//    public void setUnitPrice(BigDecimal unitPrice) {
//        this.unitPrice = unitPrice;
//    }
//
//    public int getQtyOnHand() {
//        return qtyOnHand;
//    }
//
//    public void setQtyOnHand(int qtyOnHand) {
//        this.qtyOnHand = qtyOnHand;
//    }
//
//    @Override
//    public String toString() {
//        return "Item{" +
//                "itemCode='" + itemCode + '\'' +
//                ", description='" + description + '\'' +
//                ", unitPrice=" + unitPrice +
//                ", qtyOnHand=" + qtyOnHand +
//                '}';
//    }
}
