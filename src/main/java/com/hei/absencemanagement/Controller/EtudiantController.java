package com.hei.absencemanagement.Controller;

import com.hei.absencemanagement.model.Etudiants;
import com.hei.absencemanagement.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @PostMapping
    public ResponseEntity<Void> createEtudiant(@RequestBody Etudiants etudiant) {
        etudiantService.createEtudiant(etudiant);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiants> getEtudiantById(@PathVariable String id) {
        Etudiants etudiant = etudiantService.getEtudiantById(id);
        if (etudiant != null) {
            return ResponseEntity.ok(etudiant);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEtudiant(@PathVariable String id, @RequestBody Etudiants etudiant) {
        etudiant.setIdEtudiant(id);
        etudiantService.updateEtudiant(etudiant);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable String id) {
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Etudiants>> getAllEtudiants() {
        List<Etudiants> etudiants = etudiantService.getAllEtudiants();
        return ResponseEntity.ok(etudiants);
    }
}
