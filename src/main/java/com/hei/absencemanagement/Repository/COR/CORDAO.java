package com.hei.absencemanagement.Repository.COR;

import com.hei.absencemanagement.model.COR;
import java.util.List;

public interface CORDAO {
    // Créer une nouvelle entrée COR
    void createCOR(COR cor);

    // Lire une entrée COR par son ID
    COR getCORById(int id);

    // Mettre à jour une entrée COR
    void updateCOR(COR cor);

    // Supprimer une entrée COR par son ID
    void deleteCOR(int id);

    // Récupérer toutes les entrées COR
    List<COR> getAllCOR();
}
