package com.patricio.maldonado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceModel {
    private Long id;
    private String nombre;        // Ej: "Servidor Proliant"
    private String descripcion;
    private boolean disponible;   // Estado de disponibilidad
    private String responsable;   // Persona a cargo
    private LocalDate fechaCreacion; 
    private String tipo;          // Ej: "Hardware", "Software"
    private int cantidad;         // Valor numérico
}