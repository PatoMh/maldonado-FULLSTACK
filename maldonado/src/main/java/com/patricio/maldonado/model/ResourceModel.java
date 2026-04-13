package com.patricio.maldonado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceModel {
    private Long id;
    private String nombre;
    private String descripcion;
    private boolean disponible;
    private String responsable;
    private String fechaCreacion;
    private String tipo;
    private int cantidad;
}