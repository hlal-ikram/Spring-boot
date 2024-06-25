// PanneService.java
package com.ecommerce.library.service;

import com.ecommerce.library.model.Panne;
import  java.util.Date;


public interface PanneService {
    void savePanne(Panne panne);
    void savePanneWithDetails(java.util.Date dateApparition, Long idRessource, String idMembreDepartement);

}

