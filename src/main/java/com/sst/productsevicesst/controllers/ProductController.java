package com.sst.productsevicesst.controllers;
import com.sst.productsevicesst.dtos.ExceptionDto;
import com.sst.productsevicesst.models.Product;
import com.sst.productsevicesst.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    private  ProductService productService;
    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") Long id){
//        throw new RuntimeException("something went wrong");
        ResponseEntity<Product>responseEntity  = null;
        Product product = null;
        try{
            product = productService.getProductById(id);
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
            return responseEntity;
        }
        catch(RuntimeException exception){
            ExceptionDto dto = new ExceptionDto();
            dto.setMessage("Something is wrong");
            dto.setResolution(" eat 5 star do nothing");
            ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
            return  response;
        }

//        return  productService.getProductById(id);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
