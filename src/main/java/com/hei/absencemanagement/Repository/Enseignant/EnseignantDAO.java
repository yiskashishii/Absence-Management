package com.hei.absencemanagement.Repository.Enseignant;

import com.hei.absencemanagement.model.Enseignant;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EnseignantDAO {
    // Créer un nouvel enseignant
    void createEnseignant(Enseignant enseignant);

    // Lire un enseignant par son ID
    Enseignant getEnseignantById(int id);

    // Mettre à jour un enseignant
    void updateEnseignant(Enseignant enseignant);

    // Supprimer un enseignant par son ID
    void deleteEnseignant(int id);

    // Récupérer tous les enseignants
    List<Enseignant> getAllEnseignants();
}
