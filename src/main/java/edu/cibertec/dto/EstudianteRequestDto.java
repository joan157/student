package edu.cibertec.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class EstudianteRequestDto {

    //@NotNull(message = "No debe nulo el nombre")
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "Nombre es obligatorio")
    private String apellido;

    @NotBlank(message = "email es obligatorio")
    @Email(message = "No debe ser vacio el email")
    private String email;

    @NotNull(message = "edad es obligatorio")
    @Min(value = 18, message = "La edad mínima es 18")
    private Integer edad;

    @NotNull(message = "fechaRegistro es obligatorio")
    private LocalDate fechaRegistro;
}
