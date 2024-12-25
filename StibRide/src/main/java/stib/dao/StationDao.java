package stib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import stib.dto.StationDto;
import stib.model.StationNeighbors;
import stib.repository.RepositoryException;

/**
 * Allows the physical acess to the data base.
 *
 * @author nadou
 */
public class StationDao implements Dao<Integer, StationDto> {

    private Connection connexion;

    private StationDao() throws RepositoryException {
        connexion = DbManager.getInstance().getConnection();
    }

    public static StationDao getInstance() throws RepositoryException {
        return StationDaoHolder.getInstance();
    }

    private static class StationDaoHolder {

        private static StationDao getInstance() throws RepositoryException {
            return new StationDao();
        }
    }

    /**
     * Allows to get all neighbor og the given station.
     *
     * @param item the given station.
     * @return a list of it's neighbors.
     * @throws RepositoryException
     */
    public List<StationNeighbors> getAdjacentNeighbors(StationDto item) throws RepositoryException {

        List<StationNeighbors> stationsNeighbors = new ArrayList<>();

        String query = "select distinct origin.id , origin.name  , secondStop.id_station  , neighbor.name\n"
                + "                from stations origin \n"
                + "                join stops firstStop on origin.id = firstStop.id_station\n"
                + "                join stops secondStop on firstStop.id_order = secondStop.id_order-1 or firstStop.id_order = secondStop.id_order+1\n"
                + "                join stations neighbor on secondStop.id_station = neighbor.id\n"
                + "                where origin.id = ? and secondStop.id_line = firstStop.id_line";
        try (PreparedStatement pstmt = connexion.prepareStatement(query)) {
            pstmt.setInt(1, item.getKey());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                int originId = rs.getInt(1);
                String originName = rs.getString(2);
                StationDto stationOrigin = new StationDto(originId, originName);

                int neighborId = rs.getInt(3);
                String neighborName = rs.getString(4);
                StationDto stationNeighbors = new StationDto(neighborId, neighborName);

                List<Integer> linesNeighbors = SearchLines(stationNeighbors.getKey());
                List<Integer> linesSources = SearchLines(stationOrigin.getKey());

                StationNeighbors sN = new StationNeighbors(stationOrigin, stationNeighbors, linesNeighbors, linesSources);
                stationsNeighbors.add(sN);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return stationsNeighbors;
    }

    /**
     * Search lines of the given sitation according to it's id.
     *
     * @param idStation the given id.
     * @return a list which contain the different lines
     * @throws RepositoryException if there is a problem in connection de the
     * db.
     */
    private List<Integer> SearchLines(int idStation) throws RepositoryException {
        List<Integer> lines = new ArrayList<>();
        String query = "select id_line "
                + "from stops where id_station = ?";
        try (PreparedStatement pstmt = connexion.prepareStatement(query)) {
            pstmt.setInt(1, idStation);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int line = rs.getInt("id_line");
                lines.add(line);
            }

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return lines;
    }

    /**
     * Calculates the number of existing stations.
     *
     * @return the number of stations.
     * @throws RepositoryException if there is a problem to link the data base.
     */
    public int countStations() throws RepositoryException {
        int cpt = 0;
        String query = "SELECT count(*) FROM STATIONS";
        try (Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            cpt = rs.getInt(1);
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return cpt;
    }

    @Override
    public List<StationDto> selectAll() throws RepositoryException {
        String query = "SELECT * FROM STATIONS";
        List<StationDto> dtos = new ArrayList<>();
        try (Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                StationDto dto = new StationDto(rs.getInt(1), rs.getString(2));
                dtos.add(dto);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }

    @Override
    public Integer insert(StationDto item) throws RepositoryException {
        return -1;
    }

    @Override
    public void delete(Integer key) throws RepositoryException {
    }

    @Override
    public void update(StationDto item) throws RepositoryException {
    }

    @Override
    public StationDto select(Integer key) throws RepositoryException {
        return null;
    }
}
