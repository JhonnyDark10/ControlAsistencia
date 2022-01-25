package com.control.asistencia.service;

import com.control.asistencia.entity.SisUsuario;
import com.control.asistencia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public Iterable<SisUsuario> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public SisUsuario createUser(SisUsuario sisUsuario) throws Exception {
        if (checkUsernameAvailable(sisUsuario) && checkPasswordValid(sisUsuario)) {
            sisUsuario = userRepository.save(sisUsuario);
        }
        return sisUsuario;
    }


    private boolean checkUsernameAvailable(SisUsuario sisUsuario) throws Exception {
        Optional<SisUsuario> userFound = userRepository.findByUsuUsuario(sisUsuario.getUsuUsuario());
        if (userFound.isPresent()) {
            throw new Exception("Username no disponible");
        }
        return true;
    }

    private boolean checkPasswordValid(SisUsuario sisUsuario) throws Exception {
        if ( !sisUsuario.getUsuContrasena().equals(sisUsuario.getConfirmPassword())) {
            throw new Exception("Password y Confirm Password no son iguales");
        }
        return true;
    }


}

