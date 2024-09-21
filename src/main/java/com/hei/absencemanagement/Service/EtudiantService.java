package com.hei.absencemanagement.Service;

import com.hei.absencemanagement.Repository.Etudiant.EtudiantDAO;
import com.hei.absencemanagement.model.Etudiants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    private final EtudiantDAO etudiantDAO;

    @Autowired
    public EtudiantService(EtudiantDAO etudiantDAO) {
        this.etudiantDAO = etudiantDAO;
    }

    public void createEtudiant(Etudiants etudiant) {
        etudiantDAO.createEtudiant(etudiant);
    }

    public Etudiants getEtudiantById(String id) {
        return etudiantDAO.getEtudiantById(id);
    }

    public void updateEtudiant(Etudiants etudiant) {
        etudiantDAO.updateEtudiant(etudiant);
    }

    public void deleteEtudiant(String id) {
        etudiantDAO.deleteEtudiant(id);
    }

    public List<Etudiants> getAllEtudiants() {
        return etudiantDAO.getAllEtudiants();
    }
}
