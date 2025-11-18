package ir.najaftech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.najaftech.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long categoryId);
    
}
