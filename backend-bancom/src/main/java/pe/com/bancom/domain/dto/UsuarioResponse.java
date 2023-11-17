package pe.com.bancom.domain.dto;

import java.util.Date;

public interface UsuarioResponse {

     Integer getId();

     String getName();

     String getLastname();

     String getPassword();

     String getCellphone();

     Date getDateCreation();

     Date getDateModification();
}
