package com.patricio.maldonado.service;

import com.patricio.maldonado.model.ResourceModel;
import com.patricio.maldonado.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepository repository;

    public ResourceModel crearRecurso(ResourceModel recurso) {
        // Validación simple: cantidad no negativa
        if (recurso.getCantidad() < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa");
        return repository.save(recurso);
    }

    public List<ResourceModel> obtenerTodos() {
        return repository.findAll();
    }

    public ResourceModel obtenerPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
    }

    public ResourceModel actualizarRecurso(Long id, ResourceModel detalles) {
        ResourceModel recurso = obtenerPorId(id);
        recurso.setNombre(detalles.getNombre());
        recurso.setDisponible(detalles.isDisponible());
        recurso.setResponsable(detalles.getResponsable());
        recurso.setCantidad(detalles.getCantidad());
        return repository.save(recurso);
    }

    public void eliminarRecurso(Long id) {
        repository.deleteById(id);
    }

    // Operación de procesamiento: Ordenar por nombre
    public List<ResourceModel> obtenerOrdenadosPorNombre() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(ResourceModel::getNombre))
                .collect(Collectors.toList());
    }
}