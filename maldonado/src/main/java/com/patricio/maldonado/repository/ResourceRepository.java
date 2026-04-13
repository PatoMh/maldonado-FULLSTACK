package com.patricio.maldonado.repository;

import com.patricio.maldonado.model.ResourceModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ResourceRepository {
    
    private List<ResourceModel> listaRecursos = new ArrayList<>();
    private Long idCounter = 1L;

    public ResourceModel save(ResourceModel recurso) {
        recurso.setId(idCounter++);
        listaRecursos.add(recurso);
        return recurso;
    }

    public List<ResourceModel> findAll() {
        return listaRecursos;
    }
}