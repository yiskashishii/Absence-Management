package com.hei.absencemanagement.Repository.Responsable;

import com.hei.absencemanagement.model.Responsable;
import java.util.List;

public interface ResponsableDAO {
    // Créer un nouveau responsable
    void createResponsable(Responsable responsable);

    // Lire un responsable par son ID
    Responsable getResponsableById(int id);

    // Mettre à jour un responsable
    void updateResponsable(Responsable responsable);

    // Supprimer un responsable par son ID
    void deleteResponsable(int id);

    // Récupérer tous les responsables
    List<Responsable> getAllResponsables();
}
