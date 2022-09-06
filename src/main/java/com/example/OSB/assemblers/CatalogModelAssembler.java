package com.example.OSB.assemblers;

import com.example.OSB.controllers.CatalogController;
import com.example.OSB.entities.Catalog;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CatalogModelAssembler implements RepresentationModelAssembler<Catalog, EntityModel<Catalog>> {
    @Override
    public EntityModel<Catalog> toModel(Catalog model) {
        return EntityModel.of(model, linkTo(methodOn(CatalogController.class).get(model.getId())).withSelfRel());
    }
}
