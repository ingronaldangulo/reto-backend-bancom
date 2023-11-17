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


    @Test
    @DisplayName("Crear usuario")
    void testCrearUsuario() {

        UsuarioDto usuarioDtoMock = usuarioBuilder.buildUsuarioDto();
        UsuarioDto usuarioCreatedDtoMock = usuarioBuilder.buildUsuarioCreatedDto(usuarioDtoMock);
        when(usuarioService.create(usuarioDtoMock)).thenReturn(usuarioCreatedDtoMock);

        ResponseEntity<UsuarioDto> responseEntity = usuarioController.create(usuarioDtoMock);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Estado de respuesta correcta.");

        UsuarioDto body = responseEntity.getBody();
        assertNotNull(body, "El cuerpo de respuesta es valido.");

        assertEquals(usuarioCreatedDtoMock, body, "El usuario fue creado correctamente.");
        assertEquals(usuarioCreatedDtoMock.getId(), body.getId(), "ID correcto del usuario creado.");
        assertEquals(usuarioCreatedDtoMock.getCellphone(), body.getCellphone(), "Cellphone correcto del usuario creado.");
        assertEquals(usuarioCreatedDtoMock.getLastname(), body.getLastname(), "Lastname correcto del usuario creado.");
        assertEquals(usuarioCreatedDtoMock.getName(), body.getName(), "Name correcto del usuario creado.");

    }

    @Test
    @DisplayName("Modificar usuario")
    void testModificarUsuario() {

        UsuarioDto usuarioDtoMock = usuarioBuilder.buildUsuarioDto();
        UsuarioDto usuarioCreatedDtoMock = usuarioBuilder.buildUsuarioCreatedDto(usuarioDtoMock);
        when(usuarioService.update(usuarioDtoMock)).thenReturn(usuarioCreatedDtoMock);

        ResponseEntity<UsuarioDto> responseEntity = usuarioController.update(usuarioDtoMock);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Estado de respuesta correcta.");

        UsuarioDto body = responseEntity.getBody();
        assertNotNull(body, "El cuerpo de respuesta es valido.");

        assertEquals(usuarioCreatedDtoMock, body, "El usuario fue modificado correctamente.");
        assertEquals(usuarioCreatedDtoMock.getId(), body.getId(), "ID modificado del usuario modificado.");
        assertEquals(usuarioCreatedDtoMock.getCellphone(), body.getCellphone(), "Cellphone correcto del usuario modificado.");
        assertEquals(usuarioCreatedDtoMock.getLastname(), body.getLastname(), "Lastname correcto del usuario modificado.");
        assertEquals(usuarioCreatedDtoMock.getName(), body.getName(), "Name correcto del usuario modificado.");

    }

    @Test
    @DisplayName("Eliminar usuario")
    void testEliminarUsuario() {

        Integer idUsuarioMock = 3;
        String deletedMessageMock = "El usuario fue eliminado correctamente.";
        when(usuarioService.delete(idUsuarioMock)).thenReturn(deletedMessageMock);

        ResponseEntity<String> response = usuarioController.delete(idUsuarioMock);
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Estado de respuesta correcta.");

        String body = response.getBody();
        assertNotNull(body, "El cuerpo de respuesta es valido.");
        assertEquals(deletedMessageMock, body, "El usuario fue eliminado correctamente.");


    }
}
