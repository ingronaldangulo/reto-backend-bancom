package pe.com.bancom.infraestructure.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/crear")
    public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto usuarioDto) {
        log.info("crear usuario");
        return ResponseEntity.ok(usuarioService.create(usuarioDto));
    }

    @PutMapping("/modificar")
    public ResponseEntity<UsuarioDto> update(@RequestBody UsuarioDto usuarioDto) {
        log.info("modificar usuario");
        return ResponseEntity.ok(usuarioService.update(usuarioDto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        log.info("eliminar usuario");
        return ResponseEntity.ok(usuarioService.delete(id));
    }
}
