package edu.cibertec.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EstudianteResponseDto {

    private String nombre;
    private String apellido;
    private String email;
    private Integer edad;
    private LocalDate fechaRegistro;
}
