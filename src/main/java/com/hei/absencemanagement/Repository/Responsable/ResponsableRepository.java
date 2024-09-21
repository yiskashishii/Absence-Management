package com.hei.absencemanagement.Repository.Responsable;

import com.hei.absencemanagement.Repository.Responsable.ResponsableDAO;
import com.hei.absencemanagement.model.Responsable;
import com.hei.absencemanagement.DatabaseConnection.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ResponsableRepository implements ResponsableDAO {

    @Override
    public void createResponsable(Responsable responsable) {
        String sql = "INSERT INTO Responsable (utilisateur_id) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, responsable.getUtilisateurId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Responsable getResponsableById(int id) {
        String sql = "SELECT * FROM Responsable WHERE id_responsable = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Responsable responsable = new Responsable();
                responsable.setIdResponsable(rs.getInt("id_responsable"));
                responsable.setUtilisateurId(rs.getInt("utilisateur_id"));
                return responsable;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateResponsable(Responsable responsable) {
        String sql = "UPDATE Responsable SET utilisateur_id = ? WHERE id_responsable = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, responsable.getUtilisateurId());
            pstmt.setInt(2, responsable.getIdResponsable());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteResponsable(int id) {
        String sql = "DELETE FROM Responsable WHERE id_responsable = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Responsable> getAllResponsables() {
        List<Responsable> responsables = new ArrayList<>();
        String sql = "SELECT * FROM Responsable";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Responsable responsable = new Responsable();
                responsable.setIdResponsable(rs.getInt("id_responsable"));
                responsable.setUtilisateurId(rs.getInt("utilisateur_id"));
                responsables.add(responsable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return responsables;
    }
}
