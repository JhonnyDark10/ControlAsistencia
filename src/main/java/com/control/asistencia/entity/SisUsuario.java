package com.control.asistencia.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "sis_usuario")
public class SisUsuario implements Serializable {

    private static final long serialVersionUID = -2969524610059270447L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usu_idrol", nullable = false)
    private SisRol usuIdrol;


    @Column(name = "usu_nombres", nullable = false, length = 50)
    @NotEmpty
    @Size(min=2)
    private String usuNombres;

    @Column(name = "usu_apellidos", nullable = false, length = 50)
    private String usuApellidos;


    @Column(name = "usu_usuario", nullable = false, length = 50)
    @NotEmpty
    @Size(min=3)
    private String usuUsuario;


    @Column(name = "usu_contrasena", nullable = false, length = 50)
    @NotEmpty
    @Size(min=5)
    private String usuContrasena;



    @Column(name = "usu_cedula", nullable = false, length = 13)
    @NotEmpty
    @Size(min = 10,max = 13)
    private String usuCedula;


    @Column(name = "usu_fechanacimiento")
    private Date usuFechanacimiento;

    @Column(name = "usu_estado", nullable = false)
    private Character usuEstado;

    @Transient
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Character getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Character usuEstado) {
        this.usuEstado = usuEstado;
    }

    public Date getUsuFechanacimiento() {
        return usuFechanacimiento;
    }

    public void setUsuFechanacimiento(Date usuFechanacimiento) {
        this.usuFechanacimiento = usuFechanacimiento;
    }

    public String getUsuCedula() {
        return usuCedula;
    }

    public void setUsuCedula(String usuCedula) {
        this.usuCedula = usuCedula;
    }

    public String getUsuContrasena() {
        return usuContrasena;
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena = usuContrasena;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuApellidos() {
        return usuApellidos;
    }

    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
    }

    public String getUsuNombres() {
        return usuNombres;
    }

    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    public SisRol getUsuIdrol() {
        return usuIdrol;
    }

    public void setUsuIdrol(SisRol usuIdrol) {
        this.usuIdrol = usuIdrol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}