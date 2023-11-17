package pe.com.bancom.domain.builder;

import pe.com.bancom.domain.dto.PostDto;
import pe.com.bancom.domain.dto.UsuarioDto;
import pe.com.bancom.domain.entity.PostEntity;
import pe.com.bancom.domain.entity.UsuarioEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostBuilder {


    public List<PostEntity> buildListaPosts(UsuarioEntity usuarioEntity) {

        List<PostEntity> postEntities = new ArrayList<>();
        postEntities.add(
                PostEntity.builder()
                        .id(1)
                        .text("Post 1")
                        .usuario(usuarioEntity)
                        .dateCreation(new Date()).build());
        postEntities.add(
                PostEntity.builder()
                        .id(2)
                        .text("Post 2")
                        .usuario(usuarioEntity)
                        .dateCreation(new Date()).build());
        postEntities.add(
                PostEntity.builder()
                        .id(3)
                        .text("Post 3")
                        .usuario(usuarioEntity)
                        .dateCreation(new Date()).build());
        return postEntities;

    }

    public List<PostDto> buildListaPostsDto(UsuarioDto usuarioDto) {
        List<PostDto> postDtos = new ArrayList<>();
        postDtos.add(
                PostDto.builder()
                        .id(1)
                        .text("Post 1")
                        .usuario(usuarioDto)
                        .dateCreation(new Date()).build());
        postDtos.add(
                PostDto.builder()
                        .id(2)
                        .text("Post 2")
                        .usuario(usuarioDto)
                        .dateCreation(new Date()).build());
        postDtos.add(
                PostDto.builder()
                        .id(3)
                        .text("Post 3")
                        .usuario(usuarioDto)
                        .dateCreation(new Date()).build());
        return postDtos;
    }

    public PostEntity buildPostEntity(UsuarioEntity usuarioEntity) {
        return PostEntity.builder()
                .id(3)
                .text("Post 1")
                .usuario(usuarioEntity)
                .dateCreation(new Date()).build();

    }

    public PostDto buildPostDto(UsuarioDto usuarioDto) {
        return PostDto.builder()
                .id(3)
                .text("Post 1")
                .usuario(usuarioDto)
                .dateCreation(new Date()).build();
    }

    public PostDto buildPostCreatedDto(PostDto postDtoMock) {
        postDtoMock.setId(100);
        postDtoMock.setDateCreation(new Date());
        return postDtoMock;
    }


    public PostDto buildPostUpdatedDto(PostDto postDtoMock) {
        postDtoMock.setText("Post updated!");
        postDtoMock.setDateModification(new Date());
        return postDtoMock;
    }
}
