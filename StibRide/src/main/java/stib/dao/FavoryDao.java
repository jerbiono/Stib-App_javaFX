/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import stib.dto.FavoryDto;
import stib.repository.RepositoryException;

/**
 *
 * @author nadou
 */
public class FavoryDao implements Dao<String, FavoryDto> {

    private Connection connexion;

    public static FavoryDao getInstance() throws RepositoryException {
        return FavoriDaoHolder.getInstance();
    }

    private static class FavoriDaoHolder {

        private static FavoryDao getInstance() throws RepositoryException {
            return new FavoryDao();
        }
    }

    private FavoryDao() throws RepositoryException {
        connexion = DbManager.getInstance().getConnection();
    }

    @Override
    public String insert(FavoryDto item) throws RepositoryException {
        if (item == null) {
            throw new RepositoryException("Aucune élément donné en paramètre");
        }
        String id = "";
        String sql = "insert into favori(Station_Source,Station_Destination, Favori_Name) values(?, ?, ?)";
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setString(1, item.getStationSource());
            pstmt.setString(2, item.getStationDest());
            pstmt.setString(3, item.getKey());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return item.getKey();
    }

    @Override
    public void delete(String key) throws RepositoryException {
        String sql = "delete from favori where Favori_Name = ?";
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setString(1, key);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void update(FavoryDto item) throws RepositoryException {
        String query = "update favori set Station_source = ? , Station_Destination = ? where Favori_Name = ?";
        try (PreparedStatement pstmt = connexion.prepareStatement(query)) {
            pstmt.setString(1, item.getStationSource());
            pstmt.setString(2, item.getStationDest());
            pstmt.setString(3, item.getKey());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    private int selectCountFavorys() throws RepositoryException {
        int cpt = 0;
        try {
            String query = "select count(*) from favori ";
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                cpt = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return cpt;
    }

    @Override
    public FavoryDto select(String key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("param est null");
        }
        FavoryDto favory = null;
        String query = "select * from favori where Favori_Name = ?";
        if (selectCountFavorys() > 0) {
            try (PreparedStatement pstmt = connexion.prepareStatement(query)) {
                pstmt.setString(1, key);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String sourceName = rs.getString(1);
                    String destinationName = rs.getString(2);
                    String favoryName = rs.getString(3);
                    favory = new FavoryDto(sourceName, destinationName, favoryName);
                }
            } catch (SQLException e) {
                throw new RepositoryException(e);
            }
        }
        return favory;
    }

    @Override
    public List<FavoryDto> selectAll() throws RepositoryException {
        String query = "SELECT * FROM favori";
        List<FavoryDto> dtos = new ArrayList<>();
        try (Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                FavoryDto dto = new FavoryDto(rs.getString(1), rs.getString(2), rs.getString(3));
                dtos.add(dto);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }

}
