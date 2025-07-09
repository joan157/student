package edu.cibertec.controller;

import edu.cibertec.dto.EstudianteRequestDto;
import edu.cibertec.dto.EstudianteResponseDto;
import edu.cibertec.entity.EstudianteEntity;
import edu.cibertec.mapper.EstudianteMapper;
import edu.cibertec.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<EstudianteEntity> listarEstudiante(){
        return estudianteService.listarTodo();
    }
    //@RequestParam(required = false)
    // planilla en tasa
    //
    @GetMapping("/mayores")
    public List<EstudianteEntity>listarEstudiante(@RequestParam Integer edadMayorque){
        return estudianteService.listarMayoresde(edadMayorque);
    }
    @GetMapping("/mediamayores")
    public List<EstudianteEntity>listarEstudianteMayoresMedia(){
        return estudianteService.listarMayorqueMedia();
    }

    @PostMapping
    public void registrarEstudiante(@Valid @RequestBody EstudianteRequestDto estudiante){
        estudianteService.registrarEstudiante(estudiante);
    }
    @PutMapping("/{idestudiante}")
    public void actualizarEstudiante(@Valid @RequestBody EstudianteRequestDto estudiante, @PathVariable Integer idestudiante){
        estudianteService.actualizarEstudiante(estudiante,idestudiante);
    }
}
