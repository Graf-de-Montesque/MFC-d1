package dao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pkg3iteration.studentorder.domain.CountryArea;
import pkg3iteration.studentorder.domain.PassportOffice;
import pkg3iteration.studentorder.domain.RegisterOffice;
import pkg3iteration.studentorder.domain.Street;

public class DictionaryDaoImplTest {
    @Test
    public void testExample() {
        System.out.println("TEST");
    }
}
    /*
    public DictionaryDaoImplTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testFindStreets() throws Exception {
        System.out.println("findStreets");
        String pattern = "";
        DictionaryDaoImpl instance = new DictionaryDaoImpl();
        List<Street> expResult = null;
        List<Street> result = instance.findStreets(pattern);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testFindPassportOffices() throws Exception {
        System.out.println("findPassportOffices");
        String areaId = "";
        DictionaryDaoImpl instance = new DictionaryDaoImpl();
        List<PassportOffice> expResult = null;
        List<PassportOffice> result = instance.findPassportOffices(areaId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testFindRegisterOffices() throws Exception {
        System.out.println("findRegisterOffices");
        String areaId = "";
        DictionaryDaoImpl instance = new DictionaryDaoImpl();
        List<RegisterOffice> expResult = null;
        List<RegisterOffice> result = instance.findRegisterOffices(areaId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testFindAreas() throws Exception {
        System.out.println("findAreas");
        String areaId = "";
        DictionaryDaoImpl instance = new DictionaryDaoImpl();
        List<CountryArea> expResult = null;
        List<CountryArea> result = instance.findAreas(areaId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
