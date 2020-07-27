package business;

import dao.DataLayer;
import util.CustomerTM;
import util.ItemTM;
import util.OrderDetailTM;
import util.OrderTM;

import java.util.List;

public class BusinessLogic {

    public static String getNewCustomerId() {
        String lastCustomerId = DataLayer.getLastCustomerId();
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
        String lastItemCode = DataLayer.getLastItemCode();
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
        String lastOrderId = DataLayer.getLastOrderId();
        if (lastOrderId == null){
            return "OD001";
        }else{
            int maxId=  Integer.parseInt(lastOrderId.replace("OD",""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "OD00" + maxId;
            } else if (maxId < 100) {
                id = "OD0" + maxId;
            } else {
                id = "OD" + maxId;
            }
            return id;
        }
    }

    public static List<CustomerTM> getAllCustomers(){
        return DataLayer.getAllCustomers();
    }

    public static boolean saveCustomer(String id, String name, String address){
        return DataLayer.saveCustomer(new CustomerTM(id,name,address));
    }

    public static boolean deleteCustomer(String customerId){
        return DataLayer.deleteCustomer(customerId);
    }

    public static boolean updateCustomer(String name, String address, String customerId){
        return DataLayer.updateCustomer(new CustomerTM(name, address, customerId));
    }

    public static List<ItemTM> getAllItems(){
        return DataLayer.getAllItems();
    }

    public static boolean saveItem(String code, String description, int qtyOnHand, double unitPrice){
        return DataLayer.saveItem(new ItemTM(code, description, qtyOnHand, unitPrice));
    }

    public static boolean deleteItem(String itemCode){
        return DataLayer.deleteItem(itemCode);
    }

    public static boolean updateItem(String description, int qtyOnHand, double unitPrice, String itemCode){
        return DataLayer.updateItem(new ItemTM(itemCode, description, qtyOnHand, unitPrice));
    }

    public static boolean placeOrder(OrderTM order, List<OrderDetailTM> orderDetails){
        return DataLayer.placeOrder(order, orderDetails);
    }
}
