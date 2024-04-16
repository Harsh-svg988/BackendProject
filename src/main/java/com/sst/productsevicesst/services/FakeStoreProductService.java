package com.sst.productsevicesst.services;

import com.sst.productsevicesst.dtos.FakeStoreProductDto;
import com.sst.productsevicesst.models.Category;
import com.sst.productsevicesst.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        throw new RuntimeException("something went exception");
//        RestTemplate restTemplate = new RestTemplate();
//        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
//                FakeStoreProductDto.class);
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setId(fakeStoreProductDto.getId());
        category.setTitle(fakeStoreProductDto.getTitle());
        category.setDescription(fakeStoreProductDto.getDescription());
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

}
