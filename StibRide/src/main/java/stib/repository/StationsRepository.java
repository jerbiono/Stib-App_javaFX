/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.repository;

import java.util.List;
import stib.dao.StationDao;
import stib.dto.Dto;
import stib.dto.StationDto;
import stib.model.StationNeighbors;

/**
 *
 * @author nadou
 */
public class StationsRepository implements Repository<Integer, StationDto> {

    private final StationDao stationDao;

    public StationsRepository() throws RepositoryException {
        stationDao = StationDao.getInstance();
    }

    StationsRepository(StationDao stationDao) {
        this.stationDao = stationDao;
    }

    @Override
    public List<StationDto> getAll() throws RepositoryException {
        return this.stationDao.selectAll();
    }

    /**
     * Calculates the number of existing stations.
     *
     * @return the number of stations.
     * @throws RepositoryException if there is a problem to link the data base.
     */
    public int getTotalNumberOfStations() throws RepositoryException {
        return this.stationDao.countStations();
    }

    public List<StationNeighbors> getAdjacentNeighbors(StationDto item) throws RepositoryException {

        return this.stationDao.getAdjacentNeighbors(item);

    }

    @Override
    public void add(StationDto item) throws RepositoryException {
    }

    @Override
    public boolean remove(Integer key) throws RepositoryException {
        return false;
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        return false;
    }

}
