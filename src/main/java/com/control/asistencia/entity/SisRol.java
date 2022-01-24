package com.control.asistencia.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sis_rol")
public class SisRol implements Serializable {

    private static final long serialVersionUID = -2969524610059270447L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id", nullable = false)
    private Integer id;

    @Column(name = "rol_descripcion", nullable = false, length = 50)
    private String roldescripcion;

    @Column(name = "rol_estado", nullable = false)
    private Character rolEstado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoldescripcion() {
        return roldescripcion;
    }

    public void setRoldescripcion(String roldescripcion) {
        this.roldescripcion = roldescripcion;
    }

    public Character getRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(Character rolEstado) {
        this.rolEstado = rolEstado;
    }
}