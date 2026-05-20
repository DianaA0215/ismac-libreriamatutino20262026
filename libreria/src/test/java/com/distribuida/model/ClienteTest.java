package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ClienteTest {

    private Cliente cliente;
@BeforeEach
    public void setUp(){
        cliente = new Cliente(
                1,
                "1751550805",
                "Diana",
                "Alomoto",
                "Puembo",
                "0980079227",
                "diana@gmail.com"
        );
    }
@Test
    public void testClienteConstructorAndGetters(){
        assertAll("Pruebas unitarias constructor Cliente",
                () -> assertEquals(1,cliente.getIdCliente()),
                () ->assertEquals("1751550805",cliente.getCedula()),
                () ->assertEquals("Diana",cliente.getNombre()),
                () ->assertEquals("Alomoto",cliente.getApellido()),
                () ->assertEquals("Puembo",cliente.getDireccion()),
                () ->assertEquals("0980079227",cliente.getTelefono()),
                () ->assertEquals("diana@gmail.com",cliente.getCorreo())
                );
        System.out.println(cliente.toString());
}
    @Test
    public void testClienteSetter(){
    cliente.setIdCliente(2);
    cliente.setCedula("17515508052");
    cliente.setNombre("Diana 2");
    cliente.setApellido("Alomoto 2");
    cliente.setDireccion("Puembo 2");
    cliente.setTelefono("09800792272");
    cliente.setCorreo("diana2@gmail.com");

        assertAll("Pruebas unitarias constructor Cliente",
                () -> assertEquals(2,cliente.getIdCliente()),
                () ->assertEquals("17515508052",cliente.getCedula()),
                () ->assertEquals("Diana 2",cliente.getNombre()),
                () ->assertEquals("Alomoto 2",cliente.getApellido()),
                () ->assertEquals("Puembo 2",cliente.getDireccion()),
                () ->assertEquals("09800792272",cliente.getTelefono()),
                () ->assertEquals("diana2@gmail.com",cliente.getCorreo())
        );
        System.out.println(cliente.toString());
    }
    @Test
    public void testClienteToString(){
    String str = cliente.toString();
    assertAll("Pruebas unitarias",
            () -> assertTrue(str.contains("1")),
            ()-> assertTrue(str.contains("1751550805")),
            ()-> assertTrue(str.contains("Diana")),
            ()-> assertTrue(str.contains("Alomoto")),
            ()-> assertTrue(str.contains("Puembo")),
            ()-> assertTrue(str.contains("0980079227")),
            ()-> assertTrue(str.contains("diana@gmail.com"))
            );
    }
}
