package pe.com.bancom.domain.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.bancom.domain.dto.UsuarioDto;
import pe.com.bancom.domain.entity.UsuarioEntity;
import pe.com.bancom.domain.service.UsuarioService;
import pe.com.bancom.infraestructure.repository.UsuarioRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public static UsuarioDto createDtoFromEntity(UsuarioEntity entity) {
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
    public List<UsuarioDto> findAll() {
        List<UsuarioEntity> usuarioEntities = this.usuarioRepository.findAll();
        return mapEntitiesToDtos(usuarioEntities);
    }

    @Override
    public UsuarioDto create(UsuarioDto usuarioDto) {
        usuarioDto.setDateCreation(new Date());
        UsuarioEntity usuarioEntity = createEntityFromDto(usuarioDto);
        usuarioEntity = usuarioRepository.save(usuarioEntity);
        return createDtoFromEntity(usuarioEntity);
    }

    @Override
    public String delete(Integer idUsuario) {
        Optional<UsuarioEntity> usuarioEntityOptional = this.usuarioRepository.findById(idUsuario);
        if (usuarioEntityOptional.isPresent()) {
            usuarioRepository.delete(usuarioEntityOptional.get());
            return "Usuario eliminado correctamente.";
        }
        return "Usuario no pudo eliminarse correctamente.";
    }

    private UsuarioEntity createEntityFromDto(UsuarioDto usuarioDto) {
        return UsuarioEntity.builder()
                .name(usuarioDto.getName())
                .lastname(usuarioDto.getLastname())
                .cellphone(usuarioDto.getCellphone())
                .password(usuarioDto.getPassword())
                .dateCreation(usuarioDto.getDateCreation())
                .dateModification(usuarioDto.getDateModification())
                .build();
    }

    private List<UsuarioDto> mapEntitiesToDtos(List<UsuarioEntity> usuarioEntities) {
        return usuarioEntities.stream()
                .map(UsuarioServiceImpl::createDtoFromEntity
                ).toList();
    }

    public UsuarioDto update(UsuarioDto usuarioDto) {
        usuarioDto.setDateModification(new Date());
        UsuarioEntity usuarioEntity = createEntityFromDto(usuarioDto);
        usuarioEntity = usuarioRepository.save(usuarioEntity);
        return createDtoFromEntity(usuarioEntity);
    }
}
