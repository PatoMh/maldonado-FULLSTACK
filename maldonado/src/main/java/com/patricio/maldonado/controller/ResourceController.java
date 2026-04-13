package com.patricio.maldonado.controller;

import com.patricio.maldonado.model.ResourceModel;
import com.patricio.maldonado.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coretrack/recursos")
public class ResourceController {

    @Autowired
    private ResourceService service;

    @PostMapping("/crear")
    public ResponseEntity<ResourceModel> crear(@RequestBody ResourceModel recurso) {
        ResourceModel nuevoRecurso = service.crearRecurso(recurso);
        return new ResponseEntity<>(nuevoRecurso, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public List<ResourceModel> listar() {
        return service.obtenerTodos();
    }
}