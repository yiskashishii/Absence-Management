package com.hei.absencemanagement.repository;

import com.hei.absencemanagement.Repository.Cours.CoursDAO;
import com.hei.absencemanagement.model.Cours;
import com.hei.absencemanagement.DatabaseConnection.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CoursRepository implements CoursDAO {

    @Override
    public void createCours(Cours cours) {
        String sql = "INSERT INTO Cours (nom_cours, description, enseignant_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cours.getNomCours());
            pstmt.setString(2, cours.getDescription());
            pstmt.setInt(3, cours.getEnseignantId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cours getCoursById(int id) {
        String sql = "SELECT * FROM Cours WHERE id_cours = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Cours cours = new Cours();
                cours.setIdCours(rs.getInt("id_cours"));
                cours.setNomCours(rs.getString("nom_cours"));
                cours.setDescription(rs.getString("description"));
                cours.setEnseignantId(rs.getInt("enseignant_id"));
                return cours;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCours(Cours cours) {
        String sql = "UPDATE Cours SET nom_cours = ?, description = ?, enseignant_id = ? WHERE id_cours = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cours.getNomCours());
            pstmt.setString(2, cours.getDescription());
            pstmt.setInt(3, cours.getEnseignantId());
            pstmt.setInt(4, cours.getIdCours());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCours(int id) {
        String sql = "DELETE FROM Cours WHERE id_cours = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cours> getAllCours() {
        List<Cours> coursList = new ArrayList<>();
        String sql = "SELECT * FROM Cours";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cours cours = new Cours();
                cours.setIdCours(rs.getInt("id_cours"));
                cours.setNomCours(rs.getString("nom_cours"));
                cours.setDescription(rs.getString("description"));
                cours.setEnseignantId(rs.getInt("enseignant_id"));
                coursList.add(cours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coursList;
    }
}
