package com.hei.absencemanagement.Repository.Cours;

import com.hei.absencemanagement.model.Cours;
import java.util.List;

public interface CoursDAO {
    // Créer un nouveau cours
    void createCours(Cours cours);

    // Lire un cours par son ID
    Cours getCoursById(int id);

    // Mettre à jour un cours
    void updateCours(Cours cours);

    // Supprimer un cours par son ID
    void deleteCours(int id);

    // Récupérer tous les cours
    List<Cours> getAllCours();
}
