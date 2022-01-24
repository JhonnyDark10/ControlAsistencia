package com.control.asistencia.service;

import com.control.asistencia.entity.SisUsuario;
import com.control.asistencia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public Iterable<SisUsuario> getAllUsers() {
        return userRepository.findAll();
    }
}

