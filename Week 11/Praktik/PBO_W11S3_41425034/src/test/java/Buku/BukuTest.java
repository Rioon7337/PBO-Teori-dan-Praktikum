/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Buku;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ASUS
 */
public class BukuTest {
    
    public BukuTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getJudul method, of class Buku.
     */
    @Test
    public void testGetJudul() {
        System.out.println("getJudul");
        Buku instance = null;
        String expResult = "";
        String result = instance.getJudul();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Buku.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Buku instance = null;
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdPeminjam method, of class Buku.
     */
    @Test
    public void testGetIdPeminjam() {
        System.out.println("getIdPeminjam");
        Buku instance = null;
        String expResult = "";
        String result = instance.getIdPeminjam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pinjamBuku method, of class Buku.
     */
    @Test
    public void testPinjamBuku() {
        System.out.println("pinjamBuku");
        String judul = "";
        String idPeminjam = "";
        Buku instance = null;
        instance.pinjamBuku(judul, idPeminjam);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kembalikanBuku method, of class Buku.
     */
    @Test
    public void testKembalikanBuku() {
        System.out.println("kembalikanBuku");
        String judul = "";
        String idPeminjam = "";
        Buku instance = null;
        instance.kembalikanBuku(judul, idPeminjam);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
