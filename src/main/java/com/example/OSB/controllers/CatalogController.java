package com.example.OSB.controllers;

import com.example.OSB.assemblers.CatalogModelAssembler;
import com.example.OSB.entities.Catalog;
import com.example.OSB.exceptions.CatalogNotFoundException;
import com.example.OSB.repositories.CatalogRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {
    private final CatalogRepository repository;
    private final CatalogModelAssembler assembler;

    public CatalogController(CatalogRepository repository, CatalogModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/catalog/{id}")
    public EntityModel<Catalog> get(@PathVariable Long id) {
        Catalog catalog = repository.findById(id).orElseThrow(() -> new CatalogNotFoundException(id));
        return assembler.toModel(catalog);
    }
}
