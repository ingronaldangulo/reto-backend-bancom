package pe.com.bancom.domain.builder;

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
                        .cellphone("9203030")
                        .password("mypass5678")
                        .dateCreation(new Date()).build());
        return usuarioEntities;

    }
}
