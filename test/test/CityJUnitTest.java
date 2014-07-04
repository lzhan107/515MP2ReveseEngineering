/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.City;
import java.util.List;
import javax.persistence.NoResultException;
import org.junit.Test;
import static org.junit.Assert.*;
import util.ReUtil;

/**
 *
 * @author Lei
 * JUnit test cases for city table
 */
public class CityJUnitTest extends ReUtil {

    public CityJUnitTest() {
    }

    //Get top ten cities and display them
    @Test
    public void getTopTenCities() {
        List<City> cities = em.createNamedQuery("City.findAll", City.class).getResultList();
        for (int i = 0 ; i < 10; i++) {
            System.out.println(cities.get(i));
        }
    }
    
    //Get the total number of cities
    @Test
    public void getNumOfCities(){
        Long numOfCities = (Long) em.createQuery("SELECT COUNT(c.id) FROM City c").getSingleResult();
        assertEquals(new Long(4063), numOfCities);
    }
    
    //Get the city info using city id of 5555, this show throw an exception
    @Test(expected = NoResultException.class)
    public void findCityById(){
        em.createNamedQuery("City.findById", City.class).setParameter("id", 5555L).getSingleResult();
    }
    
}