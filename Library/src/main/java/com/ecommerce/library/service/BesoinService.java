package com.ecommerce.library.service;

import com.ecommerce.library.model.Besoin;

import java.util.List;

public interface BesoinService {

    Besoin saveBesoin(Besoin besoin, String userId);
    List<Besoin> getAllBesoins();
    List<Besoin> getBesoinsByDepartement(String id);
    List<Besoin> getBesoinsByMembreDepartement(String id);
    void deleteBesoinOfMembre(String id);
    void deleteBesoin(Long id);
    List<Besoin> getBesoinsDepartementNotInAppelOffre(Long id);
    Besoin updateBesoin(Besoin besoin);
    Besoin getBesoinsDisponiblesByIdMembre(String id);
    List<Besoin> getBesoinsNotInAppelOffre();
    void besoinAddedInAppelOffre(Long id);

}
