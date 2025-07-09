package edu.cibertec.mapper;

import edu.cibertec.dto.EstudianteRequestDto;
import edu.cibertec.dto.EstudianteResponseDto;
import edu.cibertec.entity.EstudianteEntity;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {

    public EstudianteEntity toEntity(EstudianteRequestDto estudianteDto){
        return EstudianteEntity.builder()
                .nombre(estudianteDto.getNombre())
                .apellido(estudianteDto.getApellido())
                .edad(estudianteDto.getEdad())
                .email(estudianteDto.getEmail())
                .fechaRegistro(estudianteDto.getFechaRegistro())
                .build();
    }

    public EstudianteEntity toEntityUpdate(EstudianteRequestDto estudianteDto,Integer idest){
        return EstudianteEntity.builder()
                .idestudiante(idest)
                .nombre(estudianteDto.getNombre())
                .apellido(estudianteDto.getApellido())
                .edad(estudianteDto.getEdad())
                .email(estudianteDto.getEmail())
                .fechaRegistro(estudianteDto.getFechaRegistro())
                .build();
    }

    public EstudianteResponseDto toResponseDto(EstudianteEntity estudianteEntity){
        return EstudianteResponseDto.builder()
                .nombre(estudianteEntity.getNombre())
                .apellido(estudianteEntity.getApellido())
                .edad(estudianteEntity.getEdad())
                .email(estudianteEntity.getEmail())
                .fechaRegistro(estudianteEntity.getFechaRegistro())
                .build();
    }

}
