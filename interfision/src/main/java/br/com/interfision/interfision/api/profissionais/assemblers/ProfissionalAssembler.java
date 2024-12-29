package br.com.interfision.interfision.api.profissionais.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import br.com.interfision.interfision.api.profissionais.controllers.ProfissionalRestController;
import br.com.interfision.interfision.api.profissionais.dtos.ProfissionalResponse;

@Component
public class ProfissionalAssembler implements SimpleRepresentationModelAssembler<ProfissionalResponse> {

    @Override
    public void addLinks(EntityModel<ProfissionalResponse> resource) {
        var id = resource.getContent().getId();

        var selfLink = linkTo(methodOn(ProfissionalRestController.class).findById(id))
            .withSelfRel()
            .withType("GET");

        var updateLink = linkTo(methodOn(ProfissionalRestController.class).update(null, id))
            .withRel("update")
            .withType("PUT");

        var deleteLink = linkTo(methodOn(ProfissionalRestController.class).delete(id))
            .withRel("delete")
            .withType("DELETE");

        resource.add(selfLink, updateLink, deleteLink);
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<ProfissionalResponse>> resources) {
        var selfLink = linkTo(methodOn(ProfissionalRestController.class).findAll(null))
            .withSelfRel()
            .withType("GET");

        var createLink = linkTo(methodOn(ProfissionalRestController.class).create(null))
            .withRel("create")
            .withType("POST");

        resources.add(selfLink, createLink);
    }
}
