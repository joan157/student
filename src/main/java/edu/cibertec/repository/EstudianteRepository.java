package edu.cibertec.repository;

import edu.cibertec.entity.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Integer> {

    public List<EstudianteEntity> findAll();
    public EstudianteEntity findByIdestudiante(Integer idestudiante);

}
