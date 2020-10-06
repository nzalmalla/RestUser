package Controller;

import Model.Product;
import Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ApiOperation(value = "create a product", response = ResponseEntity.class)
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity createProduct(@RequestBody Product body){
        if(body!=null) {
            productService.createProduct(body);
            return new ResponseEntity("Product is created successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "update a product", response = ResponseEntity.class)
    @PutMapping(value = "/update")
    @ResponseBody
    public ResponseEntity updateProduct(@RequestBody Product body){
        if(productService.updateProduct(body)) {
            return new ResponseEntity("Product is updated successsfully", HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "View a list of Products", response = List.class)
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


}
