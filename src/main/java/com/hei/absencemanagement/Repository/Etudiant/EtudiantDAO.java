package com.hei.absencemanagement.Repository.Etudiant;

import com.hei.absencemanagement.model.Etudiants;
import java.util.List;

public interface EtudiantDAO {
    // Créer un nouvel étudiant
    void createEtudiant(Etudiants etudiant);

    // Lire un étudiant par son ID
    Etudiants getEtudiantById(String id);

    // Mettre à jour un étudiant
    void updateEtudiant(Etudiants etudiant);

    // Supprimer un étudiant par son ID
    void deleteEtudiant(String id);

    // Récupérer tous les étudiants
    List<Etudiants> getAllEtudiants();
}
