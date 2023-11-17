package pe.com.bancom.domain.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.bancom.domain.dto.PostDto;
import pe.com.bancom.domain.dto.UsuarioDto;
import pe.com.bancom.domain.entity.PostEntity;
import pe.com.bancom.domain.entity.UsuarioEntity;
import pe.com.bancom.domain.exceptions.UsuarioNotOwnerPost;
import pe.com.bancom.domain.service.PostService;
import pe.com.bancom.infraestructure.repository.PostRepository;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public static PostDto createDtoFromEntity(PostEntity entity) {
        return PostDto.builder()
                .id(entity.getId())
                .text(entity.getText())
                .usuario(mapUsuarioEntityToDto(entity.getUsuario()))
                .dateCreation(entity.getDateCreation())
                .dateModification(entity.getDateModification())
                .build();
    }

    private static UsuarioDto mapUsuarioEntityToDto(UsuarioEntity entity) {
        return UsuarioDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastname(entity.getLastname())
                .cellphone(entity.getCellphone())
                .password(entity.getPassword())
                .dateCreation(entity.getDateCreation())
                .dateModification(entity.getDateModification())
                .build();
    }

    @Override
    public List<PostDto> findAll() {
        List<PostEntity> postEntities = this.postRepository.findAll();
        return mapEntitiesToDtos(postEntities);
    }

    @Override
    public PostDto create(PostDto postDto) {
        postDto.setDateCreation(new Date());
        PostEntity postEntity = createEntityFromDto(postDto);
        postEntity = postRepository.save(postEntity);
        return createDtoFromEntity(postEntity);
    }

    @Override
    public String delete(Integer idPost) {
        Optional<PostEntity> postEntityOptional = this.postRepository.findById(idPost);
        if (postEntityOptional.isPresent()) {
            postRepository.delete(postEntityOptional.get());
            return "Post eliminado correctamente.";
        }
        return "Post no pudo eliminarse correctamente.";
    }

    private PostEntity createEntityFromDto(PostDto postDto) {
        return PostEntity.builder()
                .text(postDto.getText())
                .usuario(mapUsuarioDtoToEntity(postDto.getUsuario()))
                .dateCreation(postDto.getDateCreation())
                .dateModification(postDto.getDateModification())
                .build();
    }

    private UsuarioEntity mapUsuarioDtoToEntity(UsuarioDto usuarioDto) {
        return UsuarioEntity.builder()
                .name(usuarioDto.getName())
                .lastname(usuarioDto.getLastname())
                .cellphone(usuarioDto.getCellphone())
                .password(usuarioDto.getPassword())
                .dateCreation(usuarioDto.getDateCreation())
                .dateModification(usuarioDto.getDateModification())
                .build();
    }

    private List<PostDto> mapEntitiesToDtos(List<PostEntity> postEntities) {
        return postEntities.stream()
                .map(PostServiceImpl::createDtoFromEntity
                ).toList();
    }

    public PostDto update(PostDto postDto) {
        Optional<PostEntity> postEntityOptional = postRepository.findById(postDto.getId());
        log.info("usuario existe: " + postEntityOptional.isPresent());
        if (postEntityOptional.isPresent()) {
            PostEntity postEntity = postEntityOptional.get();
            if (Objects.equals(postEntity.getUsuario().getId(), postDto.getUsuario().getId())) {
                PostEntity usuarioEntity = mapFieldsUpdated(postDto, postEntity);
                usuarioEntity = postRepository.save(usuarioEntity);
                return createDtoFromEntity(usuarioEntity);
            } else {
                throw new UsuarioNotOwnerPost("No puedes modificar un post que no eres autor.");
            }

        }
        return null;
    }

    private PostEntity mapFieldsUpdated(PostDto postDto, PostEntity postEntity) {
        postEntity.setText(postDto.getText());
        postEntity.setDateModification(new Date());
        return postEntity;


    }
}
