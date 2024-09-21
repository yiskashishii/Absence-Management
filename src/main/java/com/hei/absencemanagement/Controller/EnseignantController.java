package com.hei.absencemanagement.Controller;

import com.hei.absencemanagement.model.Enseignant;
import com.hei.absencemanagement.Service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {

    private final EnseignantService enseignantService;

    @Autowired
    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @PostMapping
    public ResponseEntity<Void> createEnseignant(@RequestBody Enseignant enseignant) {
        enseignantService.createEnseignant(enseignant);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> getEnseignantById(@PathVariable int id) {
        Enseignant enseignant = enseignantService.getEnseignantById(id);
        if (enseignant != null) {
            return ResponseEntity.ok(enseignant);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEnseignant(@PathVariable int id, @RequestBody Enseignant enseignant) {
        enseignant.setIdEnseignant(id);
        enseignantService.updateEnseignant(enseignant);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnseignant(@PathVariable int id) {
        enseignantService.deleteEnseignant(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Enseignant>> getAllEnseignants() {
        List<Enseignant> enseignants = enseignantService.getAllEnseignants();
        return ResponseEntity.ok(enseignants);
    }
}
