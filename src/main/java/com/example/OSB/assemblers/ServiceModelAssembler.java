package com.example.OSB.assemblers;

import com.example.OSB.controllers.ServiceController;
import com.example.OSB.entities.Service;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ServiceModelAssembler implements RepresentationModelAssembler<Service, EntityModel<Service>> {
    @Override
    public EntityModel<Service> toModel(Service model) {
        return EntityModel.of(model, linkTo(methodOn(ServiceController.class).create(model)).withSelfRel());
    }
}
