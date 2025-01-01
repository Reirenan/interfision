package br.com.interfision.interfision.api.consultas.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import br.com.interfision.interfision.api.consultas.controllers.ConsultaRestController;
import br.com.interfision.interfision.api.consultas.dtos.ConsultaResponse;

@Component
public class ConsultaAssembler implements SimpleRepresentationModelAssembler<ConsultaResponse> {

    @Override
    public void addLinks(EntityModel<ConsultaResponse> resource) {
        var id = resource.getContent().getId();

        var selfLink = linkTo(methodOn(ConsultaRestController.class).findById(id))
            .withSelfRel()
            .withType("GET");

        var updateLink = linkTo(methodOn(ConsultaRestController.class).update(null, id))
            .withRel("update")
            .withType("PUT");

        var deleteLink = linkTo(methodOn(ConsultaRestController.class).delete(id))
            .withRel("delete")
            .withType("DELETE");

        resource.add(selfLink, updateLink, deleteLink);
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<ConsultaResponse>> resources) {
        var selfLink = linkTo(methodOn(ConsultaRestController.class).findAll(null))
            .withSelfRel()
            .withType("GET");

        var createLink = linkTo(methodOn(ConsultaRestController.class).create(null))
            .withRel("create")
            .withType("POST");

        resources.add(selfLink, createLink);
    }
}
