package com.hei.absencemanagement.Service;

import com.hei.absencemanagement.Repository.COR.CORDAO;
import com.hei.absencemanagement.model.COR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CORService {

    private final CORDAO corDAO;

    @Autowired
    public CORService(CORDAO corDAO) {
        this.corDAO = corDAO;
    }

    public void createCOR(COR cor) {
        corDAO.createCOR(cor);
    }

    public COR getCORById(int id) {
        return corDAO.getCORById(id);
    }

    public void updateCOR(COR cor) {
        corDAO.updateCOR(cor);
    }

    public void deleteCOR(int id) {
        corDAO.deleteCOR(id);
    }

    public List<COR> getAllCOR() {
        return corDAO.getAllCOR();
    }
}
