package edu.cibertec.service.impl;

import edu.cibertec.dto.EstudianteRequestDto;
import edu.cibertec.entity.EstudianteEntity;
import edu.cibertec.exception.EstudianteNoEncontradoException;
import edu.cibertec.mapper.EstudianteMapper;
import edu.cibertec.repository.EstudianteRepository;
import edu.cibertec.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EstudianteMapper estudianteMapper;


    @Override
    public List<EstudianteEntity> listarTodo() {
        return estudianteRepository.findAll();
    }



    //Excepciones
    // orElseThrow

    @Override
    public List<EstudianteEntity> listarMayoresde(Integer mayorque) {
        if(mayorque>50){
            throw new EstudianteNoEncontradoException("La edad maxima es 50");
        }else{
            List<EstudianteEntity> lsitadoE= estudianteRepository.findAll().stream()
                    .filter(listado -> listado.getEdad()>mayorque)
                    .toList();
            if(lsitadoE.isEmpty()){
                throw  new EstudianteNoEncontradoException("No se Encontraron Estudiantes mayores de "+mayorque);
            }
            return lsitadoE;// Hola
        }

    }

    @Override
    public List<EstudianteEntity> listarMayorqueMedia() {
        //media
      double media = estudianteRepository.findAll().stream()
               .mapToInt(listado -> listado.getEdad())
               .average()
               .orElse(0.0);

      return estudianteRepository.findAll().stream()
              .filter(listado -> listado.getEdad()>(int)estudianteRepository.findAll().stream()
                                                                                                      .mapToInt(listado2 -> listado2.getEdad())
                                                                                                      .average()
                                                                                                      .orElse(0.0)
              )
              .toList();


    }

    @Override
    public void registrarEstudiante(EstudianteRequestDto estudiante) {
        estudianteRepository.save(estudianteMapper.toEntity(estudiante));
    }

    @Override
    public EstudianteEntity listarEstudianteXId(Integer id) {
        return estudianteRepository.findByIdestudiante(id);
    }

    @Override
    public void actualizarEstudiante(EstudianteRequestDto estudiante, Integer id) {
        EstudianteEntity ides= listarEstudianteXId(id);
        if(ides==null){
            throw  new EstudianteNoEncontradoException("Estudiante no encontrado");
        }else{
            estudianteRepository.save(estudianteMapper.toEntityUpdate(estudiante, id));
        }

    }
}
