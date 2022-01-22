package com.control.asistencia.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "sis_control")
public class SisControl implements Serializable {

    private static final long serialVersionUID = -2969524610059270447L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "control_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "control_idUsuario", nullable = false)
    private SisUsuario controlIdusuario;

    @Column(name = "control_descripcion", nullable = false, length = 50)
    private String controlDescripcion;

    @Column(name = "control_fechaIngreso")
    private Instant controlFechaingreso;

    @Column(name = "control_fechaSalida")
    private Instant controlFechasalida;

    @Column(name = "control_estado", nullable = false)
    private Character controlEstado;

    public Character getControlEstado() {
        return controlEstado;
    }

    public void setControlEstado(Character controlEstado) {
        this.controlEstado = controlEstado;
    }

    public Instant getControlFechasalida() {
        return controlFechasalida;
    }

    public void setControlFechasalida(Instant controlFechasalida) {
        this.controlFechasalida = controlFechasalida;
    }

    public Instant getControlFechaingreso() {
        return controlFechaingreso;
    }

    public void setControlFechaingreso(Instant controlFechaingreso) {
        this.controlFechaingreso = controlFechaingreso;
    }

    public String getControlDescripcion() {
        return controlDescripcion;
    }

    public void setControlDescripcion(String controlDescripcion) {
        this.controlDescripcion = controlDescripcion;
    }

    public SisUsuario getControlIdusuario() {
        return controlIdusuario;
    }

    public void setControlIdusuario(SisUsuario controlIdusuario) {
        this.controlIdusuario = controlIdusuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}