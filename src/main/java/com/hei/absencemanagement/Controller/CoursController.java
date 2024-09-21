package com.hei.absencemanagement.Controller;

import com.hei.absencemanagement.model.Cours;
import com.hei.absencemanagement.Service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    private final CoursService coursService;

    @Autowired
    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    @PostMapping
    public ResponseEntity<Void> createCours(@RequestBody Cours cours) {
        coursService.createCours(cours);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cours> getCoursById(@PathVariable int id) {
        Cours cours = coursService.getCoursById(id);
        if (cours != null) {
            return ResponseEntity.ok(cours);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCours(@PathVariable int id, @RequestBody Cours cours) {
        cours.setIdCours(id);
        coursService.updateCours(cours);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCours(@PathVariable int id) {
        coursService.deleteCours(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Cours>> getAllCours() {
        List<Cours> coursList = coursService.getAllCours();
        return ResponseEntity.ok(coursList);
    }
}
