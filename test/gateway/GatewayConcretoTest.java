/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package gateway;

import clienti.Cliente;
import fattura.Fattura;
import fattura.Parametri;
import java.util.ArrayList;
import metodoPagamento.MetodoPagamento;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Default
 */
public class GatewayConcretoTest {
    
    public GatewayConcretoTest() {
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
     * Test of memorizzaCliente method, of class GatewayConcreto.
     */
    @Test
    public void testMemorizzaCliente() {
        System.out.println("memorizzaCliente");
        Cliente cliente = null;
        GatewayConcreto instance = new GatewayConcreto();
        Boolean expResult = null;
        Boolean result = instance.memorizzaCliente(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClienti method, of class GatewayConcreto.
     */
    @Test
    public void testGetClienti() {
        System.out.println("getClienti");
        GatewayConcreto instance = new GatewayConcreto();
        ArrayList<Cliente> expResult = null;
        ArrayList<Cliente> result = instance.getClienti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFatture method, of class GatewayConcreto.
     */
    @Test
    public void testGetFatture() {
        System.out.println("getFatture");
        Parametri parametri = null;
        GatewayConcreto instance = new GatewayConcreto();
        ArrayList<Fattura> expResult = null;
        ArrayList<Fattura> result = instance.getFatture(parametri);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertiXmlFattura method, of class GatewayConcreto.
     */
    @Test
    public void testConvertiXmlFattura() {
        System.out.println("convertiXmlFattura");
        String path = "";
        String file = "";
        GatewayConcreto instance = new GatewayConcreto();
        Fattura expResult = null;
        Fattura result = instance.convertiXmlFattura(path, file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaFattura method, of class GatewayConcreto.
     */
    @Test
    public void testModificaFattura() {
        System.out.println("modificaFattura");
        Fattura fattura = null;
        GatewayConcreto instance = new GatewayConcreto();
        Boolean expResult = null;
        Boolean result = instance.modificaFattura(fattura);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of memorizzaMetodoPagamento method, of class GatewayConcreto.
     */
    @Test
    public void testMemorizzaMetodoPagamento() {
        System.out.println("memorizzaMetodoPagamento");
        MetodoPagamento metodoPagamento = null;
        GatewayConcreto instance = new GatewayConcreto();
        Boolean expResult = null;
        Boolean result = instance.memorizzaMetodoPagamento(metodoPagamento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMetodoPagamento method, of class GatewayConcreto.
     */
    @Test
    public void testGetMetodoPagamento() {
        System.out.println("getMetodoPagamento");
        GatewayConcreto instance = new GatewayConcreto();
        MetodoPagamento expResult = null;
        MetodoPagamento result = instance.getMetodoPagamento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of memorizzaFattura method, of class GatewayConcreto.
     */
    @Test
    public void testMemorizzaFattura() {
        System.out.println("memorizzaFattura");
        Fattura fattura = null;
        GatewayConcreto instance = new GatewayConcreto();
        Boolean expResult = null;
        Boolean result = instance.memorizzaFattura(fattura);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creaCartella method, of class GatewayConcreto.
     */
    @Test
    public void testCreaCartella() {
        System.out.println("creaCartella");
        String path = "";
        GatewayConcreto instance = new GatewayConcreto();
        Boolean expResult = null;
        Boolean result = instance.creaCartella(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
