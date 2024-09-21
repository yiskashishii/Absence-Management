package com.hei.absencemanagement.Repository.Utilisateur;

import com.hei.absencemanagement.model.Utilisateurs;
import java.util.List;

public interface UtilisateurDAO {
    // Créer un nouvel utilisateur
    void createUtilisateur(Utilisateurs utilisateur);

    // Lire un utilisateur par son ID
    Utilisateurs getUtilisateurById(int id);

    // Mettre à jour un utilisateur
    void updateUtilisateur(Utilisateurs utilisateur);

    // Supprimer un utilisateur par son ID
    void deleteUtilisateur(int id);

    // Récupérer tous les utilisateurs
    List<Utilisateurs> getAllUtilisateurs();
}
