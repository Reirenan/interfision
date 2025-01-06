package br.com.interfision.interfision.api.especialidades.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import br.com.interfision.interfision.api.especialidades.controllers.EspecialidadeRestController;
import br.com.interfision.interfision.api.especialidades.dtos.EspecialidadeResponse;

@Component
public class EspecialidadeAssembler implements SimpleRepresentationModelAssembler<EspecialidadeResponse> {

    @Override
    public void addLinks(EntityModel<EspecialidadeResponse> resource) {
        var id = resource.getContent().getId();

        var selfLink = linkTo(methodOn(EspecialidadeRestController.class).findById(id))
            .withSelfRel()
            .withType("GET");

        var updateLink = linkTo(methodOn(EspecialidadeRestController.class).update(null, id))
            .withRel("update")
            .withType("PUT");

        var deleteLink = linkTo(methodOn(EspecialidadeRestController.class).delete(id))
            .withRel("delete")
            .withType("DELETE");

        resource.add(selfLink, updateLink, deleteLink);
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<EspecialidadeResponse>> resources) {
        var selfLink = linkTo(methodOn(EspecialidadeRestController.class).findAll(null))
            .withSelfRel()
            .withType("GET");

        var createLink = linkTo(methodOn(EspecialidadeRestController.class).create(null))
            .withRel("create")
            .withType("POST");

        resources.add(selfLink, createLink);
    }
}
