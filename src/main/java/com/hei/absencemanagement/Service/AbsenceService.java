package com.hei.absencemanagement.Service;

import com.hei.absencemanagement.Repository.Absence.AbsenceDAO;
import com.hei.absencemanagement.model.Absence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceService {

    private final AbsenceDAO absenceDAO;

    @Autowired
    public AbsenceService(AbsenceDAO absenceDAO) {
        this.absenceDAO = absenceDAO;
    }

    public void createAbsence(Absence absence) {
        absenceDAO.createAbsence(absence);
    }

    public Absence getAbsenceById(int id) {
        return absenceDAO.getAbsenceById(id);
    }

    public void updateAbsence(Absence absence) {
        absenceDAO.updateAbsence(absence);
    }

    public void deleteAbsence(int id) {
        absenceDAO.deleteAbsence(id);
    }

    public List<Absence> getAllAbsences() {
        return absenceDAO.getAllAbsences();
    }
}
