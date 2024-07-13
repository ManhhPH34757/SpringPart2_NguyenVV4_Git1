package com.spring.springpart2.controllers;

import com.spring.springpart2.entities.Product;
import com.spring.springpart2.entities.Variant;
import com.spring.springpart2.repositories.ColorRepo;
import com.spring.springpart2.repositories.ProductRepo;
import com.spring.springpart2.repositories.SizeRepo;
import com.spring.springpart2.repositories.VariantRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class VariantManager {

    private final VariantRepo variantRepo;

    private final ProductRepo productRepo;

    private final ColorRepo colorRepo;

    private final SizeRepo sizeRepo;

    public VariantManager(VariantRepo variantRepo, ProductRepo productRepo, ColorRepo colorRepo, SizeRepo sizeRepo) {
        this.variantRepo = variantRepo;
        this.productRepo = productRepo;
        this.colorRepo = colorRepo;
        this.sizeRepo = sizeRepo;
    }

    @GetMapping("/variants/{idProduct}")
    public String home(@PathVariable("idProduct") Integer idProduct, final Model model) {
        List<Variant> variantList = variantRepo.findByProductId(idProduct);
        Product product = productRepo.findProductById(idProduct);
        model.addAttribute("product", product);
        model.addAttribute("variants", variantList);
        model.addAttribute("listColor", colorRepo.findAll());
        model.addAttribute("listSize", sizeRepo.findAll());
        return "variants/home";
    }

    @PostMapping("/variants/store/{idProduct}")
    public String storeVariant(@ModelAttribute("variant")Variant variant, @PathVariable("idProduct") Integer idProduct) {
        variant.setProduct(productRepo.findProductById(idProduct));
        variantRepo.save(variant);
        return "redirect:/products/variants/{id}";
    }

    @GetMapping("/variants/edit/{idProduct}/{idVariant}")
    public String editVariant(@PathVariable("idProduct") Integer idProduct, @PathVariable("idVariant") Integer idVariant, final Model model){
        model.addAttribute("variant", variantRepo.findVariantById(idVariant));
        model.addAttribute("product", productRepo.findProductById(idProduct));
        model.addAttribute("listColor", colorRepo.findAll());
        model.addAttribute("listSize", sizeRepo.findAll());
        return "variants/update";
    }

    @GetMapping("/variants/delete/{idProduct}/{idVariant}")
    public String deleteVariant(@PathVariable("idVariant") Integer idVariant, @PathVariable String idProduct) {
        variantRepo.deleteById(idVariant);
        return "redirect:/products/variants/{idProduct}";
    }

}
