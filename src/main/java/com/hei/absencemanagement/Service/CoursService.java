package com.hei.absencemanagement.Service;

import com.hei.absencemanagement.Repository.Cours.CoursDAO;
import com.hei.absencemanagement.model.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService {

    private final CoursDAO coursDAO;

    @Autowired
    public CoursService(CoursDAO coursDAO) {
        this.coursDAO = coursDAO;
    }

    public void createCours(Cours cours) {
        coursDAO.createCours(cours);
    }

    public Cours getCoursById(int id) {
        return coursDAO.getCoursById(id);
    }

    public void updateCours(Cours cours) {
        coursDAO.updateCours(cours);
    }

    public void deleteCours(int id) {
        coursDAO.deleteCours(id);
    }

    public List<Cours> getAllCours() {
        return coursDAO.getAllCours();
    }
}
