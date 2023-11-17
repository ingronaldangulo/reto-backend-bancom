package pe.com.bancom.infraestructure.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bancom.domain.dto.PostDto;
import pe.com.bancom.domain.service.impl.PostServiceImpl;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private final PostServiceImpl postService;

    @GetMapping("/listar")
    public ResponseEntity<List<PostDto>> findAll() {
        log.info("listar post.");
        return ResponseEntity.ok(postService.findAll());
    }

    @PostMapping("/crear")
    public ResponseEntity<PostDto> create(@RequestBody PostDto postDto) {
        log.info("crear post");
        return ResponseEntity.ok(postService.create(postDto));
    }

    @PutMapping("/modificar")
    public ResponseEntity<PostDto> update(@RequestBody PostDto postDto) {
        log.info("modificar post");
        return ResponseEntity.ok(postService.update(postDto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        log.info("eliminar post");
        return ResponseEntity.ok(postService.delete(id));
    }
}
