package pe.com.bancom.domain.service;

import pe.com.bancom.domain.dto.UsuarioDto;
import pe.com.bancom.domain.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> findAll();


    UsuarioDto create(UsuarioDto usuarioDto);

    String delete(Integer idUsuario);

    UsuarioEntity findById(Integer id);
}
