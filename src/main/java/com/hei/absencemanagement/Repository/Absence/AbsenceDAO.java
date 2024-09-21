package com.hei.absencemanagement.Repository.Absence;

import com.hei.absencemanagement.model.Absence;
import java.util.List;

public interface AbsenceDAO {
    // Créer une nouvelle absence
    void createAbsence(Absence absence);

    // Lire une absence par son ID
    Absence getAbsenceById(int id);

    // Mettre à jour une absence
    void updateAbsence(Absence absence);

    // Supprimer une absence par son ID
    void deleteAbsence(int id);

    // Récupérer toutes les absences
    List<Absence> getAllAbsences();
}
