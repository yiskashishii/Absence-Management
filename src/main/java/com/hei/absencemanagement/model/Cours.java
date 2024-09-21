package com.hei.absencemanagement.model;

import lombok.Data;

@Data
public class Cours {
    private int idCours;
    private String nomCours;
    private String description;
    private int enseignantId;
}
