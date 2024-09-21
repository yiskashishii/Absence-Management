package com.hei.absencemanagement.Controller;

import com.hei.absencemanagement.model.COR;
import com.hei.absencemanagement.Service.CORService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cor")
public class CORController {

    private final CORService corService;

    @Autowired
    public CORController(CORService corService) {
        this.corService = corService;
    }

    @PostMapping
    public ResponseEntity<Void> createCOR(@RequestBody COR cor) {
        corService.createCOR(cor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<COR> getCORById(@PathVariable int id) {
        COR cor = corService.getCORById(id);
        if (cor != null) {
            return ResponseEntity.ok(cor);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCOR(@PathVariable int id, @RequestBody COR cor) {
        cor.setId(id);
        corService.updateCOR(cor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCOR(@PathVariable int id) {
        corService.deleteCOR(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<COR>> getAllCOR() {
        List<COR> corList = corService.getAllCOR();
        return ResponseEntity.ok(corList);
    }
}
