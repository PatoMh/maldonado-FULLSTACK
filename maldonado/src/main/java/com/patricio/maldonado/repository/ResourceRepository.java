package com.patricio.maldonado.repository;

import com.patricio.maldonado.model.ResourceModel;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ResourceRepository {
    private List<ResourceModel> recursos = new ArrayList<>();
    private Long nextId = 1L;

    public ResourceModel save(ResourceModel recurso) {
        if (recurso.getId() == null) {
            recurso.setId(nextId++);
            recursos.add(recurso);
        } else {
            deleteById(recurso.getId());
            recursos.add(recurso);
        }
        return recurso;
    }

    public List<ResourceModel> findAll() {
        return new ArrayList<>(recursos);
    }

    public Optional<ResourceModel> findById(Long id) {
        return recursos.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        recursos.removeIf(r -> r.getId().equals(id));
    }

    public List<ResourceModel> findByTipo(String tipo) {
        return recursos.stream()
                .filter(r -> r.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }
}