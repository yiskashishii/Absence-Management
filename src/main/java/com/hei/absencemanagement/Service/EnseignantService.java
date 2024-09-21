package com.hei.absencemanagement.Service;

import com.hei.absencemanagement.Repository.Enseignant.EnseignantDAO;
import com.hei.absencemanagement.model.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService {

    private final EnseignantDAO enseignantDAO;

    @Autowired
    public EnseignantService(EnseignantDAO enseignantDAO) {
        this.enseignantDAO = enseignantDAO;
    }

    public void createEnseignant(Enseignant enseignant) {
        enseignantDAO.createEnseignant(enseignant);
    }

    public Enseignant getEnseignantById(int id) {
        return enseignantDAO.getEnseignantById(id);
    }

    public void updateEnseignant(Enseignant enseignant) {
        enseignantDAO.updateEnseignant(enseignant);
    }

    public void deleteEnseignant(int id) {
        enseignantDAO.deleteEnseignant(id);
    }

    public List<Enseignant> getAllEnseignants() {
        return enseignantDAO.getAllEnseignants();
    }
}
