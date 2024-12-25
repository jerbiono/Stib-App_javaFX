/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.repository;

import java.util.List;
import stib.dao.FavoryDao;
import stib.dto.FavoryDto;

/**
 *
 * @author nadou
 */
public class FavoryRepository implements Repository<String, FavoryDto> {

    private final FavoryDao favoryDao;

    public FavoryRepository() throws RepositoryException {
        favoryDao = FavoryDao.getInstance();
    }

    FavoryRepository(FavoryDao favoryDao) {
        this.favoryDao = favoryDao;
    }

    @Override
    public List<FavoryDto> getAll() throws RepositoryException {
        return this.favoryDao.selectAll();
    }

    @Override
    public void add(FavoryDto item) throws RepositoryException {
        if (this.contains(item.getKey())) {
            this.favoryDao.update(item);
        } else {
            this.favoryDao.insert(item);
        }
    }

    @Override
    public boolean remove(String key) throws RepositoryException {
        if (this.contains(key)) {
            this.favoryDao.delete(key);
            return true;
        }
            return false;
        
    }

    @Override
    public boolean contains(String key) throws RepositoryException {
        return this.favoryDao.select(key) != null;
    }

}
