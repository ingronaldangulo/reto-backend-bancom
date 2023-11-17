package pe.com.bancom.infraestructure.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.bancom.domain.dto.UsuarioDto;
import pe.com.bancom.domain.service.impl.UsuarioServiceImpl;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDto>> findAll() {
        log.info("listar usuarios.");
        return ResponseEntity.ok(usuarioService.findAll());
    }
}
