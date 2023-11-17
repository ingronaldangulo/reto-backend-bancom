package pe.com.bancom.domain.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.com.bancom.domain.builder.PostBuilder;
import pe.com.bancom.domain.builder.UsuarioBuilder;
import pe.com.bancom.domain.dto.PostDto;
import pe.com.bancom.domain.dto.UsuarioDto;
import pe.com.bancom.domain.entity.PostEntity;
import pe.com.bancom.domain.entity.UsuarioEntity;
import pe.com.bancom.infraestructure.repository.PostRepository;
import pe.com.bancom.infraestructure.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Post service")
public class PostServiceImplTest {

    @InjectMocks
    private PostServiceImpl postService;

    @Mock
    private PostRepository postRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    private PostBuilder postBuilder;

    private UsuarioBuilder usuarioBuilder;

    @BeforeEach
    void beforeEach() {
        postBuilder = new PostBuilder();
        usuarioBuilder = new UsuarioBuilder();
    }

    @Test
    @DisplayName("Listar posts")
    void testListarPosts() {

        UsuarioEntity usuarioEntity = usuarioBuilder.buildUsuarioEntity();
        List<PostEntity> lstPostRepositoryList = postBuilder.buildListaPosts(usuarioEntity);
        when(postRepository.findAll()).thenReturn(lstPostRepositoryList);

        List<PostDto> postDtos = postService.findAll();

        assertNotNull(postDtos, "Lista de posts no es nula.");
        assertEquals(3, postDtos.size(), "Lista de post es correcto.");
        assertEquals("Post 1", postDtos.get(0).getText(), "Text correcto del primer post de la lista");
        assertEquals("Post 3", postDtos.get(2).getText(), "Text correcto del último post de la lista");
    }

    @Test
    @DisplayName("Crear post")
    void testCrearPost() {
        UsuarioDto usuarioDto = usuarioBuilder.buildUsuarioDto();
        UsuarioEntity usuarioEntity = usuarioBuilder.buildUsuarioEntity();

        PostDto postDto = postBuilder.buildPostDto(usuarioDto);
        PostEntity postEntity = postBuilder.buildPostEntity(usuarioEntity);

        when(postRepository.save(any(PostEntity.class))).thenReturn(postEntity);

        PostDto postCreadoDto = postService.create(postDto);

        assertNotNull(postCreadoDto, "Post creado no es nulo.");
        assertEquals(postEntity.getId(), postCreadoDto.getId(), "Post creado correctamente.");
        assertEquals(postEntity.getText(), postCreadoDto.getText(), "Text correcto del post creado.");

    }

    @Test
    @DisplayName("Modificar post")
    void testModificarPost() {

        UsuarioDto usuarioDto = usuarioBuilder.buildUsuarioDto();
        UsuarioEntity usuarioEntity = usuarioBuilder.buildUsuarioEntity();

        PostDto postDto = postBuilder.buildPostDto(usuarioDto);
        PostEntity postEntity = postBuilder.buildPostEntity(usuarioEntity);

        when(postRepository.findById(any(Integer.class))).thenReturn(Optional.of(postEntity));
        when(postRepository.save(any(PostEntity.class))).thenReturn(postEntity);


        PostDto postModificadoDto = postService.update(postDto);

        assertNotNull(postModificadoDto, "Post modificado no es nulo.");
        assertEquals(postEntity.getId(), postModificadoDto.getId(), "Post modificado correctamente.");
        assertEquals(postEntity.getText(), postModificadoDto.getText(), "Text correcto del post modificado.");

    }


}
