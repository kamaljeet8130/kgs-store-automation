package inventoryproductcatalog;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InventoryService {
    private Map<Integer,Product> products = new HashMap<>();

    public boolean addProduct(Product product){
        if(products.containsKey(product.getId())){
            return false;
        }
        products.put(product.getId(),product);
        return true;
    }
    public Product findProductById(int productId){
        return products.get(productId);
    }
    public void displayProducts(){
        if(products.isEmpty()){
            System.out.println("No Products found");
            return;
        }
        for(Map.Entry<Integer,Product> entry : products.entrySet()){
            System.out.println(
                    entry.getKey() + " -> "+ entry.getValue()
            );
        }
    }
    public boolean removeProduct(int productId){
        if(!products.containsKey(productId)){
            return false;
        }
        products.remove(productId);
        return true;
    }
    public boolean updateProduct(
            int productId,
            String name,
            String category,
            double price
    ){
        Product product = products.get(productId);
        if(product==null)
            return false;

        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);

        return true;
    }
    public void removeProductBelowPrice(double price){
        Iterator<Map.Entry<Integer,Product>> iterator = products.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Product> entry = iterator.next();
            Product product = entry.getValue();
            if(product.getPrice()<price){
                iterator.remove();
            }
        }
    }

}
