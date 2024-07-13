package com.spring.springpart2.services;

import com.spring.springpart2.entities.Product;
import com.spring.springpart2.repositories.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Page<Product> getProducts(int page, int pageSize, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.DESC, sortBy);
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        Page<Product> pagination = productRepo.findAll(pageable);
        return pagination;
    }

    public List<Integer> getPageNumbers(Page<Product> pagination) {
        int totalPages = pagination.getTotalPages();
        int currentPage = pagination.getNumber() + 1;
        List<Integer> pageNumbers = new ArrayList<>();
        if (totalPages <= 3){
            for (int i = 1; i <= totalPages; i++) {
                pageNumbers.add(i);
            }
        } else {
            if (currentPage <= 2) {
                for (int i = 1; i <= 3; i++) {
                    pageNumbers.add(i);
                }
            } else if (currentPage >= totalPages - 1) {
                pageNumbers.add(totalPages - 2);
                pageNumbers.add(totalPages - 1);
                pageNumbers.add(totalPages);
            } else {
                for (int i = currentPage - 1; i <= currentPage + 1; i++) {
                    pageNumbers.add(i);
                }
            }
        }
        return pageNumbers;
    }
}
