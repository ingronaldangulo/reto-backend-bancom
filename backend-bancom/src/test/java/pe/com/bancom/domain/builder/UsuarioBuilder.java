package pe.com.bancom.domain.builder;

import pe.com.bancom.domain.dto.UsuarioDto;
import pe.com.bancom.domain.entity.UsuarioEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioBuilder {

    public List<UsuarioEntity> buildListaUsuarios() {
        List<UsuarioEntity> usuarioEntities = new ArrayList<>();
        usuarioEntities.add(
                UsuarioEntity.builder()
                        .id(1)
                        .name("Ronald")
                        .lastname("Angulo")
                        .cellphone("910105050")
                        .password("mypass5050")
                        .dateCreation(new Date()).build());
        usuarioEntities.add(
                UsuarioEntity.builder()
                        .id(2)
                        .name("Virginia")
                        .lastname("Guarniz")
                        .cellphone("958584646")
                        .password("mypass4685")
                        .dateCreation(new Date()).build());
        usuarioEntities.add(
                UsuarioEntity.builder()
                        .id(3)
                        .name("Cataleya")
                        .lastname("Vigo")
                        .cellphone("920203030")
                        .password("mypass5678")
                        .dateCreation(new Date()).build());
        return usuarioEntities;

    }

    public List<UsuarioDto> buildListaUsuariosDto() {
        List<UsuarioDto> usuarioDtos = new ArrayList<>();
        usuarioDtos.add(
                UsuarioDto.builder()
                        .id(1)
                        .name("Ronald")
                        .lastname("Angulo")
                        .cellphone("910105050")
                        .password("mypass5050")
                        .dateCreation(new Date()).build());
        usuarioDtos.add(
                UsuarioDto.builder()
                        .id(2)
                        .name("Virginia")
                        .lastname("Guarniz")
                        .cellphone("958584646")
                        .password("mypass4685")
                        .dateCreation(new Date()).build());
        usuarioDtos.add(
                UsuarioDto.builder()
                        .id(3)
                        .name("Cataleya")
                        .lastname("Vigo")
                        .cellphone("920203030")
                        .password("mypass5678")
                        .dateCreation(new Date()).build());
        return usuarioDtos;
    }

    public UsuarioEntity buildUsuarioEntity() {
        return UsuarioEntity.builder()
                .id(3)
                .name("Cataleya")
                .lastname("Vigo")
                .cellphone("920203030")
                .password("mypass5678")
                .dateCreation(new Date()).build();

    }

    public UsuarioDto buildUsuarioDto() {
        return UsuarioDto.builder()
                .id(3)
                .name("Cataleya")
                .lastname("Vigo")
                .cellphone("920203030")
                .password("mypass5678")
                .dateCreation(new Date()).build();
    }
}
