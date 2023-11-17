package pe.com.bancom.domain.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Integer id;
    private String name;
    private String lastname;
    private String password;
    private String cellphone;
    private Date dateCreation;
    private Date dateModification;
}
