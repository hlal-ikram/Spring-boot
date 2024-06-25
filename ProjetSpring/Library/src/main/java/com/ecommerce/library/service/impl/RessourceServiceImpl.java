package com.ecommerce.library.service.impl;

import com.ecommerce.library.model.Ressource;
import com.ecommerce.library.repository.RessourceRepository;
import com.ecommerce.library.service.RessourceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class RessourceServiceImpl implements RessourceService {

    private final RessourceRepository ressourceRepository;


    @Override
    public List<Ressource> getAllRessources() {
        return ressourceRepository.findAll();
    }

    @Override
    public List<Ressource> getRessourcesByMembreDepartement(String id) {
        return ressourceRepository.getRessourceByIdMembreDepartement(id);
    }

    @Override
    public Ressource addRessource(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }


    @Override
    public List<Ressource> addMultipleRessources(List<Ressource> ressources) {
        return ressourceRepository.saveAll(ressources);
    }

    @Override
    public Ressource updateRessource(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }

    @Override
    public void deleteRessource(Long id) {
        Ressource ressource = ressourceRepository.findById(id).orElseThrow();
        ressource.setIsDeleted(true);
        ressourceRepository.save(ressource);
    }

    @Override
    public List<Ressource> getRessourcesByDepartement(Long id) {
        return ressourceRepository.getRessourceByIdDepartement(id);
    }

    @Override
    public List<Ressource> listRessourcesLivrees() {
        return ressourceRepository.findAllByCodeBarreIsNull();
    }

    @Override
    public List<Ressource> listRessourcesDisponibles() {
        return ressourceRepository.findAllByCodeBarreIsNullAndMarqueIsNotNull();
    }

}
