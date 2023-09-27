package com.example.SecurityJWT.controllers;

import com.example.SecurityJWT.models.Product;
import com.example.SecurityJWT.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository repo;

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR')")
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        Product savedProduct = repo.save(product);
        URI productURI = URI.create("/api/products/" + savedProduct.getId());
        return ResponseEntity.created(productURI).body(savedProduct);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Product> list() {
        return repo.findAll();
    }
}
