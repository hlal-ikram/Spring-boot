// PanneServiceImpl.java
package com.ecommerce.library.service.impl;

import com.ecommerce.library.model.Panne;
import com.ecommerce.library.repository.PanneRepository;
import com.ecommerce.library.service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PanneServiceImpl implements PanneService {

    private final PanneRepository panneRepository;

    @Autowired
    public PanneServiceImpl(PanneRepository panneRepository) {
        this.panneRepository = panneRepository;
    }

    @Override
    public void savePanne(Panne panne) {
        panneRepository.save(panne);
    }
    public void savePanneWithDetails(Date dateApparition, Long idRessource, String idMembreDepartement) {
        // Convertir java.util.Date en java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(dateApparition.getTime());

        Panne panne = new Panne();
        panne.setDateApparition(sqlDate);
        panne.setIdRessource(idRessource);
        panne.setIdMembreDepartement(idMembreDepartement);
        panneRepository.save(panne);
    }
}
