package com.integrationtesting.practice.demo.api.v1;

import com.integrationtesting.practice.demo.api.v1.model.APIProduct;
import com.integrationtesting.practice.demo.service.ProductsService;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/products")
@AllArgsConstructor
public class ProductsController {

    private final ProductsService productsService;
    @PostMapping("/create")
    ResponseEntity postProduct(@RequestBody APIProduct product){
        try {
            productsService.addProduct(product);
        }
        catch (Exception any){
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok("Success");

    }

    @GetMapping
    List<APIProduct> getAll(){
       var a = productsService.getAllProducts();
       return a;
    }
}
