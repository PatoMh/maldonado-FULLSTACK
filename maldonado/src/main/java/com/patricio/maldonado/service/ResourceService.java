package com.patricio.maldonado.service;

import com.patricio.maldonado.model.ResourceModel;
import com.patricio.maldonado.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository repository;

    public ResourceModel crearRecurso(ResourceModel recurso) {
        return repository.save(recurso);
    }

    public List<ResourceModel> obtenerTodos() {
        return repository.findAll();
    }
}