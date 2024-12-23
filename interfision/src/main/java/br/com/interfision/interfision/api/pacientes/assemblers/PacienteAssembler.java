package br.com.interfision.interfision.api.pacientes.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import br.com.interfision.interfision.api.pacientes.controllers.PacienteRestController;
import br.com.interfision.interfision.api.pacientes.dtos.PacienteResponse;

@Component
public class PacienteAssembler implements SimpleRepresentationModelAssembler<PacienteResponse>{
    @Override
    public void addLinks(EntityModel<PacienteResponse> resource) {
        var id = resource.getContent().getId();

        var selfLink = linkTo(methodOn(PacienteRestController.class).findById(id))
            .withSelfRel()
            .withType("GET");

        var updateLink = linkTo(methodOn(PacienteRestController.class).update(null, id))
            .withRel("update")
            .withType("PUT");

        var deleteLink = linkTo(methodOn(PacienteRestController.class).delete(id))
            .withRel("delete")
            .withType("DELETE");

        

        resource.add(selfLink, updateLink, deleteLink);
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<PacienteResponse>> resources) {
        var selfLink = linkTo(methodOn(PacienteRestController.class).findAll(null))
            .withSelfRel()
            .withType("GET");

        var createLink = linkTo(methodOn(PacienteRestController.class).create(null))
            .withRel("create")
            .withType("POST");

        resources.add(selfLink, createLink);
    }
}
