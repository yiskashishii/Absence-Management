package com.hei.absencemanagement.Controller;

import com.hei.absencemanagement.model.Utilisateurs;
import com.hei.absencemanagement.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping
    public ResponseEntity<Void> createUtilisateur(@RequestBody Utilisateurs utilisateur) {
        utilisateurService.createUtilisateur(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateurs> getUtilisateurById(@PathVariable int id) {
        Utilisateurs utilisateur = utilisateurService.getUtilisateurById(id);
        return utilisateur != null ? ResponseEntity.ok(utilisateur) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUtilisateur(@PathVariable int id, @RequestBody Utilisateurs utilisateur) {
        utilisateur.setId(id);
        utilisateurService.updateUtilisateur(utilisateur);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable int id) {
        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Utilisateurs>> getAllUtilisateurs() {
        List<Utilisateurs> utilisateurs = utilisateurService.getAllUtilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }
}
