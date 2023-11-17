package pe.com.bancom.domain.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.bancom.domain.dto.UsuarioDto;
import pe.com.bancom.domain.entity.UsuarioEntity;
import pe.com.bancom.domain.service.UsuarioService;
import pe.com.bancom.infraestructure.repository.UsuarioRepository;

import java.util.List;

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

    private List<UsuarioDto> mapEntitiesToDtos(List<UsuarioEntity> usuarioEntities) {
        return usuarioEntities.stream()
                .map(UsuarioServiceImpl::createDtoFromEntity
                ).toList();
    }
}
