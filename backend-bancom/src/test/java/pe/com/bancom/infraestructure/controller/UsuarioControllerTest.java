package pe.com.bancom.infraestructure.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pe.com.bancom.domain.builder.UsuarioBuilder;
import pe.com.bancom.domain.dto.UsuarioDto;
import pe.com.bancom.domain.service.impl.UsuarioServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Rest usuario controller")
public class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioServiceImpl usuarioService;

    private UsuarioBuilder usuarioBuilder;

    @BeforeEach
    void beforeEach() {
        usuarioBuilder = new UsuarioBuilder();
    }

    @Test
    @DisplayName("Listar usuarios")
    void testListarUsuarios() {

        List<UsuarioDto> usuarioDtosMock = usuarioBuilder.buildListaUsuariosDto();
        when(usuarioService.findAll()).thenReturn(usuarioDtosMock);

        ResponseEntity<List<UsuarioDto>> responseEntity = usuarioController.findAll();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Estado de respuesta correcta.");

        List<UsuarioDto> body = responseEntity.getBody();
        assertNotNull(body, "El cuerpo de respuesta es valido.");

        assertEquals(usuarioDtosMock, body, "La búsqueda de usuarios se realizó correctamente.");


    }
}
