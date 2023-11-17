package pe.com.bancom.domain.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.bancom.domain.dto.UsuarioDto;
import pe.com.bancom.domain.service.UsuarioService;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    @Override
    public List<UsuarioDto> findAll() {
        return null;
    }
}
