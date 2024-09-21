package com.hei.absencemanagement.Service;

import com.hei.absencemanagement.model.Utilisateurs;
import com.hei.absencemanagement.Repository.Utilisateur.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public void createUtilisateur(Utilisateurs utilisateur) {
        utilisateurRepository.createUtilisateur(utilisateur);
    }

    public Utilisateurs getUtilisateurById(int id) {
        return utilisateurRepository.getUtilisateurById(id);
    }

    public void updateUtilisateur(Utilisateurs utilisateur) {
        utilisateurRepository.updateUtilisateur(utilisateur);
    }

    public void deleteUtilisateur(int id) {
        utilisateurRepository.deleteUtilisateur(id);
    }

    public List<Utilisateurs> getAllUtilisateurs() {
        return utilisateurRepository.getAllUtilisateurs();
    }
}
