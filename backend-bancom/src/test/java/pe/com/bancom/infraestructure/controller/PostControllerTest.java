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
import pe.com.bancom.domain.builder.PostBuilder;
import pe.com.bancom.domain.builder.UsuarioBuilder;
import pe.com.bancom.domain.dto.PostDto;
import pe.com.bancom.domain.dto.UsuarioDto;
import pe.com.bancom.domain.service.impl.PostServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Rest post controller")
public class PostControllerTest {

    @InjectMocks
    private PostController postController;

    @Mock
    private PostServiceImpl postService;

    private UsuarioBuilder usuarioBuilder;
    private PostBuilder postBuilder;

    @BeforeEach
    void beforeEach() {
        postBuilder = new PostBuilder();
        usuarioBuilder = new UsuarioBuilder();
    }

    @Test
    @DisplayName("Listar post")
    void testListarPost() {

        UsuarioDto usuarioDto = usuarioBuilder.buildUsuarioDto();
        List<PostDto> postDtosMock = postBuilder.buildListaPostsDto(usuarioDto);

        when(postService.findAll()).thenReturn(postDtosMock);

        ResponseEntity<List<PostDto>> responseEntity = postController.findAll();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Estado de respuesta correcta.");

        List<PostDto> body = responseEntity.getBody();
        assertNotNull(body, "El cuerpo de respuesta es valido.");

        assertEquals(postDtosMock, body, "La búsqueda de post se realizó correctamente.");
    }


    @Test
    @DisplayName("Crear post")
    void testCrearPost() {

        UsuarioDto usuarioDto = usuarioBuilder.buildUsuarioDto();
        PostDto postDtoMock = postBuilder.buildPostDto(usuarioDto);

        PostDto postCreatedDtoMock = postBuilder.buildPostCreatedDto(postDtoMock);
        when(postService.create(postDtoMock)).thenReturn(postCreatedDtoMock);

        ResponseEntity<PostDto> responseEntity = postController.create(postDtoMock);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Estado de respuesta correcta.");

        PostDto body = responseEntity.getBody();
        assertNotNull(body, "El cuerpo de respuesta es valido.");

        assertEquals(postCreatedDtoMock, body, "El post fue creado correctamente.");
        assertEquals(postCreatedDtoMock.getId(), body.getId(), "ID correcto del post creado.");
        assertEquals(postCreatedDtoMock.getText(), body.getText(), "Text correcto del post creado.");

    }

    @Test
    @DisplayName("Modificar post")
    void testModificarPost() {

        UsuarioDto usuarioDto = usuarioBuilder.buildUsuarioDto();
        PostDto postDtoMock = postBuilder.buildPostDto(usuarioDto);

        PostDto postUpdatedDtoMock = postBuilder.buildPostUpdatedDto(postDtoMock);
        when(postService.update(postDtoMock)).thenReturn(postUpdatedDtoMock);

        ResponseEntity<PostDto> responseEntity = postController.update(postDtoMock);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Estado de respuesta correcta.");

        PostDto body = responseEntity.getBody();
        assertNotNull(body, "El cuerpo de respuesta es valido.");

        assertEquals(postUpdatedDtoMock, body, "El post fue modificado correctamente.");
        assertEquals(postUpdatedDtoMock.getId(), body.getId(), "ID coorecto del post modificado.");
        assertEquals(postUpdatedDtoMock.getText(), body.getText(), "Text correcto del post modificado.");

    }

    @Test
    @DisplayName("Eliminar post")
    void testEliminarPost() {

        Integer idPostMock = 3;
        String deletedMessageMock = "El post fue eliminado correctamente.";
        when(postService.delete(idPostMock)).thenReturn(deletedMessageMock);

        ResponseEntity<String> response = postController.delete(idPostMock);
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Estado de respuesta correcta.");

        String body = response.getBody();
        assertNotNull(body, "El cuerpo de respuesta es valido.");
        assertEquals(deletedMessageMock, body, "El post fue eliminado correctamente.");


    }
}
