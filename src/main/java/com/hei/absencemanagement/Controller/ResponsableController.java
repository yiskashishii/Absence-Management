package com.hei.absencemanagement.Controller;

import com.hei.absencemanagement.model.Responsable;
import com.hei.absencemanagement.Service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsables")
public class ResponsableController {

    private final ResponsableService responsableService;

    @Autowired
    public ResponsableController(ResponsableService responsableService) {
        this.responsableService = responsableService;
    }

    @PostMapping
    public ResponseEntity<Void> createResponsable(@RequestBody Responsable responsable) {
        responsableService.createResponsable(responsable);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsable> getResponsableById(@PathVariable int id) {
        Responsable responsable = responsableService.getResponsableById(id);
        if (responsable != null) {
            return ResponseEntity.ok(responsable);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateResponsable(@PathVariable int id, @RequestBody Responsable responsable) {
        responsable.setIdResponsable(id);
        responsableService.updateResponsable(responsable);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponsable(@PathVariable int id) {
        responsableService.deleteResponsable(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Responsable>> getAllResponsables() {
        List<Responsable> responsables = responsableService.getAllResponsables();
        return ResponseEntity.ok(responsables);
    }
}
