package com.ecommerce.library.repository;

import com.ecommerce.library.model.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RessourceRepository extends JpaRepository<Ressource, Long> {

    List<Ressource> getRessourceByIdDepartement(Long id);

    List<Ressource> getRessourceByIdMembreDepartement(String id);

    List<Ressource> findAllByCodeBarreIsNullAndMarqueIsNotNull();

    List<Ressource> findAllByCodeBarreIsNull();


    List<Ressource> findByType(String type);

    List<Ressource> findAllByType(String type);


    Ressource findByCodeBarre(String codeBarre);
}
