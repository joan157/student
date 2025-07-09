package edu.cibertec.service;


import edu.cibertec.dto.EstudianteRequestDto;
import edu.cibertec.entity.EstudianteEntity;

import java.util.List;

public interface EstudianteService {

    public List<EstudianteEntity> listarTodo();
    public EstudianteEntity listarEstudianteXId(Integer id);
    public List<EstudianteEntity> listarMayoresde(Integer mayorque);
    public List<EstudianteEntity> listarMayorqueMedia();
    public void registrarEstudiante(EstudianteRequestDto estudiante);
    public void actualizarEstudiante(EstudianteRequestDto estudiante, Integer id);
}


