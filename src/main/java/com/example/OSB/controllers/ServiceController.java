package com.example.OSB.controllers;

import com.example.OSB.assemblers.ServiceModelAssembler;
import com.example.OSB.entities.Binding;
import com.example.OSB.entities.Service;
import com.example.OSB.repositories.BindingRepository;
import com.example.OSB.repositories.ServiceRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class ServiceController {
    private final ServiceRepository repository;
    private final BindingRepository bindingRepository;
    private final ServiceModelAssembler assembler;

    public ServiceController(ServiceRepository repository, BindingRepository bindingRepository, ServiceModelAssembler assembler) {
        this.repository = repository;
        this.bindingRepository = bindingRepository;
        this.assembler = assembler;
    }

    @PostMapping("/service")
    public ResponseEntity<?> create(@RequestBody Service newService) {
        EntityModel<Service> entityModel = assembler.toModel(repository.save(newService));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/service/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Service service = repository.findById(id).get();
        bindingRepository.deleteAllById(service.getBindings().stream().map(Binding::getId).collect(Collectors.toList()));
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
