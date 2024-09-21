package com.hei.absencemanagement.Controller;

import com.hei.absencemanagement.model.Absence;
import com.hei.absencemanagement.Service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/absences")
public class AbsenceController {

    private final AbsenceService absenceService;

    @Autowired
    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @PostMapping
    public ResponseEntity<Void> createAbsence(@RequestBody Absence absence) {
        absenceService.createAbsence(absence);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable int id) {
        Absence absence = absenceService.getAbsenceById(id);
        if (absence != null) {
            return ResponseEntity.ok(absence);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAbsence(@PathVariable int id, @RequestBody Absence absence) {
        absence.setIdAbsence(id);
        absenceService.updateAbsence(absence);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbsence(@PathVariable int id) {
        absenceService.deleteAbsence(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Absence>> getAllAbsences() {
        List<Absence> absences = absenceService.getAllAbsences();
        return ResponseEntity.ok(absences);
    }
}
