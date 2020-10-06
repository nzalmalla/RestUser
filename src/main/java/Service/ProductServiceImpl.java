package Service;

import Model.Product;
import Repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public void createProduct(Product product) {
        if(product!=null){
            repository.save(product);
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        if(product!=null && product.getId()!=null){
            repository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
