package com.hei.absencemanagement.Service;

import com.hei.absencemanagement.Repository.Responsable.ResponsableDAO;
import com.hei.absencemanagement.model.Responsable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsableService {

    private final ResponsableDAO responsableDAO;

    @Autowired
    public ResponsableService(ResponsableDAO responsableDAO) {
        this.responsableDAO = responsableDAO;
    }

    public void createResponsable(Responsable responsable) {
        responsableDAO.createResponsable(responsable);
    }

    public Responsable getResponsableById(int id) {
        return responsableDAO.getResponsableById(id);
    }

    public void updateResponsable(Responsable responsable) {
        responsableDAO.updateResponsable(responsable);
    }

    public void deleteResponsable(int id) {
        responsableDAO.deleteResponsable(id);
    }

    public List<Responsable> getAllResponsables() {
        return responsableDAO.getAllResponsables();
    }
}
