package pe.com.bancom.domain.service;

import pe.com.bancom.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();


    PostDto create(PostDto usuarioDto);

    String delete(Integer idUsuario);
}
