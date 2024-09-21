package com.hei.absencemanagement.Repository.COR;

import com.hei.absencemanagement.model.COR;
import com.hei.absencemanagement.DatabaseConnection.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CORRepository implements CORDAO {

    @Override
    public void createCOR(COR cor) {
        String sql = "INSERT INTO COR (etudiant_id) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cor.getEtudiantId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public COR getCORById(int id) {
        String sql = "SELECT * FROM COR WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                COR cor = new COR();
                cor.setId(rs.getInt("id"));
                cor.setEtudiantId(rs.getString("etudiant_id"));
                return cor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCOR(COR cor) {
        String sql = "UPDATE COR SET etudiant_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cor.getEtudiantId());
            pstmt.setInt(2, cor.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCOR(int id) {
        String sql = "DELETE FROM COR WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<COR> getAllCOR() {
        List<COR> corList = new ArrayList<>();
        String sql = "SELECT * FROM COR";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                COR cor = new COR();
                cor.setId(rs.getInt("id"));
                cor.setEtudiantId(rs.getString("etudiant_id"));
                corList.add(cor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return corList;
    }
}
