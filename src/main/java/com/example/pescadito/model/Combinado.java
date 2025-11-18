
package com.example.pescadito.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

    @Entity
    @Table(name = "combinados")
    public class Combinado {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        @NotBlank
        private String nombre;

        private String descripcion;

        @Column(nullable = false)
        @NotNull
        @DecimalMin("0.01")
        private Double precio;

        private Boolean disponible;

        private String categoria;

        public Combinado() {}

        public Combinado(String nombre, String descripcion, Double precio, Boolean disponible, String categoria) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.disponible = disponible;
            this.categoria = categoria;
        }

        // getters y setters
        public Long getId() { return id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getDescripcion() { return descripcion; }
        public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
        public Double getPrecio() { return precio; }
        public void setPrecio(Double precio) { this.precio = precio; }
        public Boolean getDisponible() { return disponible; }
        public void setDisponible(Boolean disponible) { this.disponible = disponible; }
        public String getCategoria() { return categoria; }
        public void setCategoria(String categoria) { this.categoria = categoria; }
    }


