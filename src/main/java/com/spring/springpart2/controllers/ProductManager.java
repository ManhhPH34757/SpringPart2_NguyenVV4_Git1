package com.spring.springpart2.controllers;

import com.spring.springpart2.entities.Product;
import com.spring.springpart2.repositories.BrandRepo;
import com.spring.springpart2.repositories.CategoryRepo;
import com.spring.springpart2.repositories.ProductRepo;
import com.spring.springpart2.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductManager {

    private final ProductRepo productRepo;

    private final ProductService productService;

    private final BrandRepo brandRepo;

    private final CategoryRepo categoryRepo;

    public ProductManager(ProductRepo productRepo, ProductService productService, BrandRepo brandRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.productService = productService;
        this.brandRepo = brandRepo;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping("/home")
    public String homeProduct(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            final Model model) {
        Page<Product> pagination = productService.getProducts(page, pageSize, sortBy);
        model.addAttribute("listBrand", brandRepo.findAll());
        model.addAttribute("listCategory", categoryRepo.findAll());
        model.addAttribute("currentPage", pagination.getNumber() + 1);
        model.addAttribute("totalPages", pagination.getTotalPages());
        model.addAttribute("totalItems", pagination.getTotalElements());
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNumbers", productService.getPageNumbers(pagination));
        model.addAttribute("listProduct", pagination.getContent());
        return "/products/home";
    }

    @PostMapping("/storeProduct")
    public String storeProduct(@ModelAttribute("product") Product product) {
        productRepo.save(product);
        return "redirect:/products/home";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, final Model model) {
        model.addAttribute("product", productRepo.findById(id).get());
        model.addAttribute("listBrand", brandRepo.findAll());
        model.addAttribute("listCategory", categoryRepo.findAll());
        return "products/update";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") Integer id, @ModelAttribute("product") Product product) {
        product.setId(id);
        productRepo.save(product);
        return "redirect:/products/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productRepo.deleteById(id);
        return "redirect:/products/home";
    }

}
