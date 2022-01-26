package com.control.asistencia.service;

import com.control.asistencia.entity.SisUsuario;

public interface UserService {

    public Iterable<SisUsuario> getAllUsers();

    public SisUsuario createUser(SisUsuario sisUsuario) throws Exception;


    public SisUsuario getSisUsuarioById(Integer id) throws Exception;

    public SisUsuario updateUser(SisUsuario sisUsuario) throws Exception;

    public void deleteUser(Integer id) throws Exception;
}
