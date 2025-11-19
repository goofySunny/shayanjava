package ir.najaftech.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import ir.najaftech.dto.request.ProductRequest;
import ir.najaftech.dto.response.ProductResponse;
import ir.najaftech.model.Product;
import ir.najaftech.repository.ProductRepository;
import ir.najaftech.service.ProductService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;
    private final ModelMapper modelMapper;

    @Override
    public ProductResponse getProductById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("Product id is null");
        }
        Product product = repo.findById(id).orElseThrow(() -> new Exception("Product not found"));
        ProductResponse response = modelMapper.map(product, ProductResponse.class);
        if (response == null) {
            throw new Exception("Failed to map Product to ProductResponse");
        }
        response.setCategoryName(product.getCategory().getName());
        return response;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> responses = new java.util.ArrayList<>();
        repo.findAll().forEach(product -> {
            ProductResponse response = modelMapper.map(product, ProductResponse.class);
            response.setCategoryName(product.getCategory().getName());
            responses.add(response);
        });
        return responses;
    }

    @Override
    public List<ProductResponse> getProductsByCategoryId(Long categoryId) {
        List<ProductResponse> responses = new java.util.ArrayList<>();
        repo.findByCategoryId(categoryId).forEach(product -> {
            ProductResponse response = modelMapper.map(product, ProductResponse.class);
            response.setCategoryName(product.getCategory().getName());
            responses.add(response);
        });
        return responses;
    }

    @Override
    public ProductResponse createProduct(ProductRequest product) throws Exception {
        Product save = modelMapper.map(product, Product.class);
        if (save != null) {
            return modelMapper.map(repo.save(save), ProductResponse.class);
        } else {
            throw new Exception("Failed to save Product");
        }
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        if (id == null) {
            throw new Exception("Product id is null");
        }
        repo.findById(id).orElseThrow(() -> new Exception("Product not found"));
        repo.deleteById(id);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) throws Exception {
        if (id == null) {
            throw new Exception("Product id is null");
        }
        Product existingProduct = repo.findById(id).orElseThrow(() -> new Exception("Product not found"));
        modelMapper.map(productRequest, existingProduct);
        if (existingProduct == null) {
            throw new Exception("Failed to update Product");
        }
        return modelMapper.map(repo.save(existingProduct), ProductResponse.class);
    }

}
