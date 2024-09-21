package com.hei.absencemanagement.model;

import lombok.Data;
import java.util.Date;

@Data
public class Etudiants {
    private String idEtudiant;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String email;
}
