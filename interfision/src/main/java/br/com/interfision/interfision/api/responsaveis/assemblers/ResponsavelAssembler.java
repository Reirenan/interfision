package br.com.interfision.interfision.api.responsaveis.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import br.com.interfision.interfision.api.responsaveis.controllers.ResponsavelRestController;
import br.com.interfision.interfision.api.responsaveis.dtos.ResponsavelResponse;

@Component
public class ResponsavelAssembler implements SimpleRepresentationModelAssembler<ResponsavelResponse> {

    @Override
    public void addLinks(EntityModel<ResponsavelResponse> resource) {
        var id = resource.getContent().getId();

        var selfLink = linkTo(methodOn(ResponsavelRestController.class).findById(id))
            .withSelfRel()
            .withType("GET");

        var updateLink = linkTo(methodOn(ResponsavelRestController.class).update(null, id))
            .withRel("update")
            .withType("PUT");

        var deleteLink = linkTo(methodOn(ResponsavelRestController.class).delete(id))
            .withRel("delete")
            .withType("DELETE");

        resource.add(selfLink, updateLink, deleteLink);
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<ResponsavelResponse>> resources) {
        var selfLink = linkTo(methodOn(ResponsavelRestController.class).findAll(null))
            .withSelfRel()
            .withType("GET");

        var createLink = linkTo(methodOn(ResponsavelRestController.class).create(null))
            .withRel("create")
            .withType("POST");

        resources.add(selfLink, createLink);
    }
}
