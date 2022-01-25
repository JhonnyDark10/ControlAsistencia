package com.control.asistencia.repository;

import com.control.asistencia.entity.SisUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<SisUsuario, Integer> {


public Optional<SisUsuario> findByUsuUsuario(String usuUsuario);


}
