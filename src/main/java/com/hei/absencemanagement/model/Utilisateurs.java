package com.hei.absencemanagement.model;

import lombok.Data;

@Data
public class Utilisateurs {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
}
