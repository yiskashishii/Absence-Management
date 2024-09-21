package com.hei.absencemanagement.Repository.Etudiant;

import com.hei.absencemanagement.Repository.Etudiant.EtudiantDAO;
import com.hei.absencemanagement.model.Etudiants;
import com.hei.absencemanagement.DatabaseConnection.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class EtudiantRepository implements EtudiantDAO {

    @Override
    public void createEtudiant(Etudiants etudiant) {
        String sql = "INSERT INTO Etudiants (id_etudiant, nom, prenom, date_naissance, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, etudiant.getIdEtudiant());
            pstmt.setString(2, etudiant.getNom());
            pstmt.setString(3, etudiant.getPrenom());
            pstmt.setDate(4, new java.sql.Date(etudiant.getDateNaissance().getTime()));
            pstmt.setString(5, etudiant.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Etudiants getEtudiantById(String id) {
        String sql = "SELECT * FROM Etudiants WHERE id_etudiant = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Etudiants etudiant = new Etudiants();
                etudiant.setIdEtudiant(rs.getString("id_etudiant"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setDateNaissance(rs.getDate("date_naissance"));
                etudiant.setEmail(rs.getString("email"));
                return etudiant;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEtudiant(Etudiants etudiant) {
        String sql = "UPDATE Etudiants SET nom = ?, prenom = ?, date_naissance = ?, email = ? WHERE id_etudiant = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, etudiant.getNom());
            pstmt.setString(2, etudiant.getPrenom());
            pstmt.setDate(3, new java.sql.Date(etudiant.getDateNaissance().getTime()));
            pstmt.setString(4, etudiant.getEmail());
            pstmt.setString(5, etudiant.getIdEtudiant());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEtudiant(String id) {
        String sql = "DELETE FROM Etudiants WHERE id_etudiant = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Etudiants> getAllEtudiants() {
        List<Etudiants> etudiants = new ArrayList<>();
        String sql = "SELECT * FROM Etudiants";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Etudiants etudiant = new Etudiants();
                etudiant.setIdEtudiant(rs.getString("id_etudiant"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setDateNaissance(rs.getDate("date_naissance"));
                etudiant.setEmail(rs.getString("email"));
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }
}
