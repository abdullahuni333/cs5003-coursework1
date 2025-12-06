
/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product {
    private int productID;
    private String productName;
    private String entryDate;
    private int quantity;
    
    public Product(int ID, String aName, String aDate, int aQuantity){
        productID = ID;
        productName = aName;
        entryDate = aDate;
        quantity = aQuantity;    
    }
    
    public int getProductID() {
        return productID;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public String getEntryDate() {
        return entryDate;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setProductName (String aName) {
        productName = aName;
    }
    
    public void setQuantity (int aQuantity) {
        quantity = aQuantity;
    }
    
    public void setProductID (int ID) {
        productID = ID;
    }
    
    public void setEntryDate (String aDate) {
        entryDate = aDate;
    }
    

}