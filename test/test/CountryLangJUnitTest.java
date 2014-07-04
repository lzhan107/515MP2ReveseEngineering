/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Countrylanguage;
import java.util.List;
import javax.persistence.NoResultException;
import org.junit.Test;
import static org.junit.Assert.*;
import util.ReUtil;

/**
 *
 * @author Lei
 * JUnit test cases for country language table
 */
public class CountryLangJUnitTest extends ReUtil{
    
    public CountryLangJUnitTest() {
    }
    
    //Get top ten country languages and display them
    @Test
    public void getTopTenCountryLangs() {
        List<Countrylanguage> countryLangs = em.createNamedQuery("Countrylanguage.findAll", Countrylanguage.class).getResultList();
        for (int i = 0 ; i < 10; i++) {
            System.out.println(countryLangs.get(i));
        }
    }
    
    //Get the total number of country languages
    @Test
    public void getNumOfCountrylanguages(){
        Long numOfCountrylangs = (Long) em.createQuery("SELECT COUNT(c.countrylanguagePK) FROM Countrylanguage c").getSingleResult();
        assertEquals(new Long(984), numOfCountrylangs);
    }
    
    //Get the country language info using country code of 'AAA', this show throw an exception
    @Test(expected = NoResultException.class)
    public void findCityById(){
        em.createNamedQuery("Countrylanguage.findByCountryCode", Countrylanguage.class).setParameter("countryCode", "AAA").getSingleResult();
    }
}