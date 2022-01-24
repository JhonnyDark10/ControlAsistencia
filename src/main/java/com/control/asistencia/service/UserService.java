package com.control.asistencia.service;

import com.control.asistencia.entity.SisUsuario;

public interface UserService {

    public Iterable<SisUsuario> getAllUsers();
}
