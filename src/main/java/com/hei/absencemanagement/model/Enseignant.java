package com.hei.absencemanagement.model;

import lombok.Data;

@Data
public class Enseignant {
    private int idEnseignant;
    private String matiere;
    private int utilisateurId;
}
