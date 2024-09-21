package com.hei.absencemanagement.Repository.Absence;

import com.hei.absencemanagement.model.Absence;
import com.hei.absencemanagement.DatabaseConnection.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AbsenceRepository implements AbsenceDAO {

    @Override
    public void createAbsence(Absence absence) {
        String sql = "INSERT INTO Absence (date_absence, etudiant_id, cours_id, justification) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(absence.getDateAbsence().getTime()));
            pstmt.setString(2, absence.getEtudiantId());
            pstmt.setInt(3, absence.getCoursId());
            pstmt.setString(4, absence.getJustification());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Absence getAbsenceById(int id) {
        String sql = "SELECT * FROM Absence WHERE id_absence = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Absence absence = new Absence();
                absence.setIdAbsence(rs.getInt("id_absence"));
                absence.setDateAbsence(rs.getDate("date_absence"));
                absence.setEtudiantId(rs.getString("etudiant_id"));
                absence.setCoursId(rs.getInt("cours_id"));
                absence.setJustification(rs.getString("justification"));
                return absence;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAbsence(Absence absence) {
        String sql = "UPDATE Absence SET date_absence = ?, etudiant_id = ?, cours_id = ?, justification = ? WHERE id_absence = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(absence.getDateAbsence().getTime()));
            pstmt.setString(2, absence.getEtudiantId());
            pstmt.setInt(3, absence.getCoursId());
            pstmt.setString(4, absence.getJustification());
            pstmt.setInt(5, absence.getIdAbsence());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAbsence(int id) {
        String sql = "DELETE FROM Absence WHERE id_absence = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Absence> getAllAbsences() {
        List<Absence> absences = new ArrayList<>();
        String sql = "SELECT * FROM Absence";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Absence absence = new Absence();
                absence.setIdAbsence(rs.getInt("id_absence"));
                absence.setDateAbsence(rs.getDate("date_absence"));
                absence.setEtudiantId(rs.getString("etudiant_id"));
                absence.setCoursId(rs.getInt("cours_id"));
                absence.setJustification(rs.getString("justification"));
                absences.add(absence);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return absences;
    }
}
