/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.repository;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.mockito.junit.jupiter.MockitoExtension;
import stib.dao.FavoryDao;
import stib.dao.FavoryDaoTest;
import stib.dto.FavoryDto;

/**
 *
 * @author nadou
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class FavoryRepositoryTest {

    @Mock
    private FavoryDao mock;

    private final FavoryDto travail;

    private final FavoryDto maison;

    private static final String KEY = "testGen";


    public FavoryRepositoryTest() {
        System.out.println("StudentRepositoryTest Constructor");
        //Test data
        travail = new FavoryDto("a","b",KEY);
        maison = new FavoryDto("x", "y", "t");
//        mock = new FavoryDao();

    }

    @BeforeEach
    void init() throws RepositoryException {
        System.out.println("==== BEFORE EACH =====");
        //Mock behaviour
        Mockito.lenient().when(mock.select(travail.getKey())).thenReturn(travail);
        Mockito.lenient().when(mock.select(maison.getKey())).thenReturn(null);
        Mockito.lenient().when(mock.select(null)).thenThrow(RepositoryException.class);
    }

    @Test
    public void testAddWhenExisting() throws Exception {
        System.out.println("testAddWhenExisting");
        //Arrange
        FavoryRepository repository = new FavoryRepository(mock);
        //Action
        repository.add(travail);
        //Assert        
        Mockito.verify(mock, times(1)).select(KEY);
        Mockito.verify(mock, times(1)).update(travail);
        Mockito.verify(mock, times(0)).insert(any(FavoryDto.class));
    }
    
    
    @Test
    public void testAddWhenNotExisting() throws Exception {
        System.out.println("testAddWhenNotExisting");
        //Arrange
        FavoryRepository repository = new FavoryRepository(mock);
        //Action
        repository.add(maison);
        //Assert        
        Mockito.verify(mock, times(1)).select(maison.getKey());
        Mockito.verify(mock, times(0)).update(maison);
        Mockito.verify(mock, times(0)).insert(any(FavoryDto.class));
    }
    
     @Test
    public void testAddWhenDelete() throws Exception {
        System.out.println("testAddWhenNotExisting");
        //Arrange
        FavoryRepository repository = new FavoryRepository(mock);
        //Action
        repository.remove(KEY);
        //Assert        
        Mockito.verify(mock, times(1)).delete(KEY);
        Mockito.verify(mock, times(0)).select(KEY);
        Mockito.verify(mock, times(0)).update(travail);
        Mockito.verify(mock, times(0)).insert(any(FavoryDto.class));
    }
}
