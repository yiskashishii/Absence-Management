package com.hei.absencemanagement.model;

import lombok.Data;
import java.util.Date;

@Data
public class Absence {
    private int idAbsence;
    private Date dateAbsence;
    private String etudiantId;
    private int coursId;
    private String justification;
}
