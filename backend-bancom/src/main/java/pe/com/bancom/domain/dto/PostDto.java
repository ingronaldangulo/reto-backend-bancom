package pe.com.bancom.domain.dto;

import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Integer id;
    private String text;
    private Date dateCreation;
    private Date dateModification;
    private UsuarioDto usuario;
}
