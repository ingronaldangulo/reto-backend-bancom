package pe.com.bancom.domain.dto;

import org.junit.jupiter.api.Test;
import pe.com.bancom.domain.entity.PostEntity;
import pe.com.bancom.domain.entity.UsuarioEntity;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioDtoTest {

    @Test
    void testDtoExist(){
        UsuarioDto usuarioDto = UsuarioDto.builder()
                .id(1)
                .name("Ronald")
                .lastname("Angulo")
                .password("mi password reto backend")
                .cellphone("920201010")
                .dateCreation(new Date())
                .build();

        assertEquals(1, usuarioDto.getId());
        assertEquals("Ronald",usuarioDto.getName());
        assertEquals("Angulo",usuarioDto.getLastname());
    }
}
