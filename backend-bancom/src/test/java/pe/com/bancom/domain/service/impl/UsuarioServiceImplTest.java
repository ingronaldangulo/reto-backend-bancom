package pe.com.bancom.domain.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.com.bancom.domain.dto.UsuarioDto;
import pe.com.bancom.infraestructure.repository.UsuarioRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Usuario service")
public class UsuarioServiceImplTest {

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    private UsuarioBuilder usuarioBuilder;

    @BeforeEach
    void beforeEach() {
        usuarioBuilder = new usuarioBuilder();
    }

    @Test
    @DisplayName("Listar usuarios")
    void testListarUsuarios() {

        List<UsuarioRepository> lstUsuarioRepositoryList = usuarioBuilder.buildListaUsuarios();
        when(usuarioRepository.findAll()).thenReturn(lstUsuarioRepositoryList);

        List<UsuarioDto> usuarioDtos = usuarioService.findAll();

        assertNotNull(usuarioDtos, "Lista de usuarios no es nula.");
        assertEquals(3, usuarioDtos.size(), "Lista de usuarios es correcto.");
        assertEquals("Angulo", usuarioDtos.get(0).getLastname(), "Lastname correcto de la primera persona de la lista");
        assertEquals("920203030", usuarioDtos.get(2).getCellphone(), "Cellphone correcto de la última persona de la lista");
    }
}
