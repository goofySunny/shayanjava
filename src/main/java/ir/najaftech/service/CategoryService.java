package ir.najaftech.service;

import java.util.List;

import ir.najaftech.dto.response.CategoryResponse;

public interface CategoryService {

    CategoryResponse findById(Long id) throws Exception;

    List<CategoryResponse> findAll();

}