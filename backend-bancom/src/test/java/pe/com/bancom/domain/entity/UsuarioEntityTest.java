package pe.com.bancom.domain.entity;

import org.junit.jupiter.api.Test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioEntityTest {

    @Test
    void testEntityExist(){
        UsuarioEntity usuarioEntity = UsuarioEntity.builder()
                .id(1)
                .name("Ronald")
                .lastname("Angulo")
                .password("mi password reto backend")
                .cellphone("920201010")
                .dateCreation(new Date())
                .build();

        assertEquals(1, usuarioEntity.getId());
        assertEquals("Ronald",usuarioEntity.getName());
        assertEquals("Angulo",usuarioEntity.getLastname());
    }
}
