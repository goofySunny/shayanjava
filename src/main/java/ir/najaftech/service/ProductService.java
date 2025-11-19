package ir.najaftech.service;

import java.util.List;

import ir.najaftech.dto.request.ProductRequest;
import ir.najaftech.dto.response.ProductResponse;

public interface ProductService {

    ProductResponse getProductById(Long id) throws Exception;

    List<ProductResponse> getAllProducts();

    List<ProductResponse> getProductsByCategoryId(Long categoryId);

    ProductResponse createProduct(ProductRequest product) throws Exception;

    void deleteProduct(Long id) throws Exception;

    ProductResponse updateProduct(Long id, ProductRequest productRequest) throws Exception;
}
