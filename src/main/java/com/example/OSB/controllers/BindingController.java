package com.example.OSB.controllers;

import com.example.OSB.entities.Binding;
import com.example.OSB.entities.Service;
import com.example.OSB.repositories.BindingRepository;
import com.example.OSB.repositories.ServiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BindingController {
    private final BindingRepository repository;
    private final ServiceRepository serviceRepository;

    public BindingController(BindingRepository repository, ServiceRepository serviceRepository) {
        this.repository = repository;
        this.serviceRepository = serviceRepository;
    }

    /*
        This is an example of a simple REST call
        In the others APIs I am using spring HATEOS to make the REST API genuinely RESTful!!
    */
    @PostMapping("/binding/{serviceId}")
    public Binding create(@RequestBody Binding newBinding, @PathVariable Long serviceId) {
        Service service = serviceRepository.getById(serviceId);
        newBinding.setService(service);
        return repository.save(newBinding);
    }

    @DeleteMapping("/binding/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
