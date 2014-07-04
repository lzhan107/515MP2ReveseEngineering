/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Country;
import java.util.List;
import javax.persistence.NoResultException;
import org.junit.Test;
import static org.junit.Assert.*;
import util.ReUtil;

/**
 *
 * @author Lei
 * JUnit test cases for country table
 */
public class CountryJUnitTest extends ReUtil{
    
    public CountryJUnitTest() {
    }
    
    //Get top ten countries and display them
    @Test
    public void getTopTenCountries() {
        List<Country> countries = em.createNamedQuery("Country.findAll", Country.class).getResultList();
        for (int i = 0 ; i < 10; i++) {
            System.out.println(countries.get(i));
        }
    }
    
    //Get the total number of countries
    @Test
    public void getNumOfCountries(){
        Long numOfCountries = (Long) em.createQuery("SELECT COUNT(c.name) FROM Country c").getSingleResult();
        assertEquals(new Long(239), numOfCountries);
    }
    
    //Get the country info using country name of 'NoNameCountry', this show throw an exception
    @Test(expected = NoResultException.class)
    public void findCountryByName(){
        em.createNamedQuery("Country.findByName", Country.class).setParameter("name", "NoNameCountry").getSingleResult();
    }
}