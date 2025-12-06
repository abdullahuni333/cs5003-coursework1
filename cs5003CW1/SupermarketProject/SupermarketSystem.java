
/**
 * Write a description of class SupermarketSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;


public class SupermarketSystem {

    //System stores all products in an ArrayList
    private ArrayList<Product> products;
    
    //Constructor - when system starts, creates an empty ArrayList
    public SupermarketSystem() {
        products = new ArrayList<>();
        
        //test products
        products.add(new Product(1, "Bread", "2025-11-27", 20));
        products.add(new Product(2, "Eggs", "2025-11-27", 30));
        products.add(new Product(3, "Milk", "2025-11-27", 15));
        products.add(new Product(4, "Beans", "2025-11-27", 40));
        products.add(new Product(5, "Chicken", "2025-11-27", 10));
}

//Getter Method so GUI can access product list
public ArrayList<Product> getProducts() {
    return products;
 }

//Method used by GUI to create new product
public Product addProduct(String name, int qty) {
    //Assign id based on list size
    int newId = products.size() +1; 
    String today = java.time.LocalDate.now().toString(); 
    //auto entrydate
    
    //Creates new product object and stores in list
    Product p = new Product(newId, name, today, qty);
    
    //Add to list
    products.add(p);
    
    System.out.println("Product added: " + p.getProductName());
    return p;

 }
 
//Method to delete by id
public boolean deleteProduct(int id) {
    for (int i = 0 ; i < products.size(); i++) {
        if (products.get(i).getProductID() == id) {
            products.remove(i);
            return true;
        }
    }
    return false;
}


//Main method
public static void main (String[] args) {
    SupermarketSystem system = new SupermarketSystem();
    new SupermarketGUI(system);
 }
 
}
