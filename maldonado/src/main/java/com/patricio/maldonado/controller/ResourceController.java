package com.patricio.maldonado.controller;

import com.patricio.maldonado.model.ResourceModel;
import com.patricio.maldonado.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class ResourceController {

    @Autowired
    private ResourceService service;

    @PostMapping
    public ResponseEntity<ResourceModel> crear(@RequestBody ResourceModel recurso) {
        return new ResponseEntity<>(service.crearRecurso(recurso), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ResourceModel> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceModel> buscar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.obtenerPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResourceModel> actualizar(@PathVariable Long id, @RequestBody ResourceModel recurso) {
        return ResponseEntity.ok(service.actualizarRecurso(id, recurso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarRecurso(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint de procesamiento adicional
    @GetMapping("/ordenados")
    public List<ResourceModel> listarOrdenados() {
        return service.obtenerOrdenadosPorNombre();
    }
}