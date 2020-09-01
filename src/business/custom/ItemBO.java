package business.custom;

import business.SuperBO;
import util.ItemTM;

import java.util.List;

public interface ItemBO extends SuperBO {

    public String getNewItemCode()throws Exception;

    public List<ItemTM> getAllItems()throws Exception;

    public boolean saveItem(String code, String description, int qtyOnHand, double unitPrice)throws Exception;

    public boolean deleteItem(String itemCode)throws Exception;

    public boolean updateItem(String description, int qtyOnHand, double unitPrice, String itemCode) throws Exception;
}
