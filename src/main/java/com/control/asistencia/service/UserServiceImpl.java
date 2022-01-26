package com.control.asistencia.service;

import com.control.asistencia.entity.SisUsuario;
import com.control.asistencia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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

    @Override
    public SisUsuario getSisUsuarioById(Integer id) throws Exception {
        return userRepository.findById(id). orElseThrow(()-> new Exception("usuario no existe"));
    }

    @Override
    public SisUsuario updateUser(SisUsuario sisUsuario) throws Exception {

        SisUsuario toUser = getSisUsuarioById(sisUsuario.getId());
        mapUser(sisUsuario, toUser);

        return userRepository.save(toUser);

    }

    @Override
    public void deleteUser(Integer id) throws Exception {
        SisUsuario sisUsuario = getSisUsuarioById(id);
        userRepository.delete(sisUsuario);

    }

    protected void mapUser(SisUsuario from,SisUsuario to) {
        to.setUsuCedula(from.getUsuCedula());
        to.setUsuNombres(from.getUsuNombres());
        to.setUsuApellidos(from.getUsuApellidos());
        to.setUsuFechanacimiento(from.getUsuFechanacimiento());
        to.setUsuUsuario(from.getUsuUsuario());
        to.setUsuIdrol(from.getUsuIdrol());
    }


    private boolean checkUsernameAvailable(SisUsuario sisUsuario) throws Exception {
        Optional<SisUsuario> userFound = userRepository.findByUsuUsuario(sisUsuario.getUsuUsuario());
        if (userFound.isPresent()) {
            throw new Exception("Username no disponible");
        }
        return true;
    }

    private boolean checkPasswordValid(SisUsuario sisUsuario) throws Exception {
       if(sisUsuario.getConfirmPassword() == null || sisUsuario.getConfirmPassword().isEmpty()){
           throw new Exception("confirme Password es obligatorio");
       }

        if ( !sisUsuario.getUsuContrasena().equals(sisUsuario.getConfirmPassword())) {
            throw new Exception("Password y Confirm Password no son iguales");
        }
        return true;
    }



}

