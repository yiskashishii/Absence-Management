package com.hei.absencemanagement.Repository.Enseignant;

import com.hei.absencemanagement.Repository.Enseignant.EnseignantDAO;
import com.hei.absencemanagement.model.Enseignant;
import com.hei.absencemanagement.DatabaseConnection.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class EnseignantRepository implements EnseignantDAO {

    @Override
    public void createEnseignant(Enseignant enseignant) {
        String sql = "INSERT INTO Enseignant (matiere, utilisateur_id) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, enseignant.getMatiere());
            pstmt.setInt(2, enseignant.getUtilisateurId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Enseignant getEnseignantById(int id) {
        String sql = "SELECT * FROM Enseignant WHERE id_enseignant = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Enseignant enseignant = new Enseignant();
                enseignant.setIdEnseignant(rs.getInt("id_enseignant"));
                enseignant.setMatiere(rs.getString("matiere"));
                enseignant.setUtilisateurId(rs.getInt("utilisateur_id"));
                return enseignant;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEnseignant(Enseignant enseignant) {
        String sql = "UPDATE Enseignant SET matiere = ?, utilisateur_id = ? WHERE id_enseignant = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, enseignant.getMatiere());
            pstmt.setInt(2, enseignant.getUtilisateurId());
            pstmt.setInt(3, enseignant.getIdEnseignant());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEnseignant(int id) {
        String sql = "DELETE FROM Enseignant WHERE id_enseignant = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        List<Enseignant> enseignants = new ArrayList<>();
        String sql = "SELECT * FROM Enseignant";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Enseignant enseignant = new Enseignant();
                enseignant.setIdEnseignant(rs.getInt("id_enseignant"));
                enseignant.setMatiere(rs.getString("matiere"));
                enseignant.setUtilisateurId(rs.getInt("utilisateur_id"));
                enseignants.add(enseignant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignants;
    }
}
