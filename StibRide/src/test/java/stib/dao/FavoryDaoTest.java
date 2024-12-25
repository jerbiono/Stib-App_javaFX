/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import stib.config.ConfigManager;
import stib.dto.FavoryDto;
import stib.repository.RepositoryException;

/**
 *
 * @author nadou
 */
public class FavoryDaoTest {
    
  
        private final FavoryDto workFav;
    private final FavoryDto schoolFav;

    private static final String TestGen = "testGen";
    private static final String schoolName = "trajetEcol";

    private final List<FavoryDto> all;

    private FavoryDao instance;

     public FavoryDaoTest() throws RepositoryException {
        System.out.println("==== favoryDaoTest Constructor =====");
        workFav = new FavoryDto("a", "b" ,TestGen );
        schoolFav = new FavoryDto( "c", "d", schoolName);

        all = new ArrayList<>();
        all.add(new FavoryDto("e", "f", "t1"));
        all.add(new FavoryDto("g", "h", "t2"));
        all.add(new FavoryDto("i", "j", "t3"));
        all.add(new FavoryDto("k", "l", "t4"));
        all.add(new FavoryDto("l", "m", "t5"));
        all.add(workFav);

        
        try {
            ConfigManager.getInstance().load();
            instance = FavoryDao.getInstance();
        } catch (RepositoryException | IOException ex) {
            org.junit.jupiter.api.Assertions.fail("Erreur de connection à la base de données de test", ex);
        }

    }

    @Test
    public void testSelectExist() throws Exception {
        System.out.println("testSelectExist");
        //Arrange
        FavoryDto expected = workFav;
        //Action
        FavoryDto result = instance.select(TestGen);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void testSelectNotExist() throws Exception {
        System.out.println("testSelectNotExist");
        //Arrange
        //Action
        FavoryDto result = instance.select(schoolFav.getKey());
       // Assert
        assertNull(result);
    }

    @Test
    public void testSelectIncorrectParameter() throws Exception {
        System.out.println("testSelectIncorrectParameter");
//        Arrange
        String incorrect = null;
//        Assert
        assertThrows(RepositoryException.class, () -> {
//            Action
            instance.select(incorrect);
        });
    }
}

