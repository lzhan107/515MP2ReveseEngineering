/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author Lei
 * Util class for creating and closing entity manager and entity manager factory
 */
public class ReUtil {

    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lzhang_MP2_REPU");
    protected static EntityManager em;
    protected static EntityTransaction tx;

    //Create entity manager, transaction
    @BeforeClass
    public static void buildEntityManager() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
    //Close entity manager factory and entity manager
    @AfterClass 
    public static void closeResource() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }
}
