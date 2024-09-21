package com.hei.absencemanagement.Repository.Utilisateur;

import com.hei.absencemanagement.Repository.Utilisateur.UtilisateurDAO;
import com.hei.absencemanagement.model.Utilisateurs;
import com.hei.absencemanagement.DatabaseConnection.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UtilisateurRepository implements UtilisateurDAO {

    @Override
    public void createUtilisateur(Utilisateurs utilisateur) {
        String sql = "INSERT INTO Utilisateurs (nom, prenom, email, mot_de_passe) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, utilisateur.getNom());
            pstmt.setString(2, utilisateur.getPrenom());
            pstmt.setString(3, utilisateur.getEmail());
            pstmt.setString(4, utilisateur.getMotDePasse());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Utilisateurs getUtilisateurById(int id) {
        String sql = "SELECT * FROM Utilisateurs WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Utilisateurs utilisateur = new Utilisateurs();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
                return utilisateur;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUtilisateur(Utilisateurs utilisateur) {
        String sql = "UPDATE Utilisateurs SET nom = ?, prenom = ?, email = ?, mot_de_passe = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, utilisateur.getNom());
            pstmt.setString(2, utilisateur.getPrenom());
            pstmt.setString(3, utilisateur.getEmail());
            pstmt.setString(4, utilisateur.getMotDePasse());
            pstmt.setInt(5, utilisateur.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUtilisateur(int id) {
        String sql = "DELETE FROM Utilisateurs WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Utilisateurs> getAllUtilisateurs() {
        List<Utilisateurs> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM Utilisateurs";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Utilisateurs utilisateur = new Utilisateurs();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }
}
