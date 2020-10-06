package Service;

import Model.Product;

import java.util.List;

public interface IProductService {
    void createProduct(Product product);
    boolean updateProduct(Product product);
    List<Product> getAllProducts();
}
