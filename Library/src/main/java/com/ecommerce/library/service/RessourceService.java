package com.ecommerce.library.service;

import com.ecommerce.library.model.Ressource;

import java.util.List;

public interface RessourceService {

    List<Ressource> getAllRessources();
    List<Ressource> getRessourcesByMembreDepartement(String id);
    Ressource addRessource(Ressource ressource);


    List<Ressource> addMultipleRessources(List<Ressource> ressources);
    Ressource updateRessource(Ressource ressource);
    void deleteRessource(Long id);
    List<Ressource> getRessourcesByDepartement(Long id);

    public List<Ressource> listRessourcesLivrees();

    public List<Ressource> listRessourcesDisponibles();

    List<Ressource> findByType(String type);

    List<Ressource> findAllByType(String type);

    List<Ressource> getRessourcesByType(String type);
    Long getRessourceIdByCodeBarre(String codeBarre);
    Long findIdByCodeBarre(String codeBarre);

}
