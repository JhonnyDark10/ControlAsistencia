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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}