package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutorTest {

    private Autor autor;

    @BeforeEach
    public void setUp() {

        autor = new Autor(
                1,
                "Gabriel Garcia Marquez",
                "Colombiano"
        );
    }

    @Test
    public void testAutorConstructorAndGetters() {

        assertAll("Pruebas unitarias constructor Autor",

                () -> assertEquals(1, autor.getIdAutor()),
                () -> assertEquals("Gabriel Garcia Marquez", autor.getNombre()),
                () -> assertEquals("Colombiano", autor.getNacionalidad())

        );

        System.out.println(autor.toString());
    }

    @Test
    public void testAutorSetter() {

        autor.setIdAutor(2);
        autor.setNombre("Mario Vargas Llosa");
        autor.setNacionalidad("Peruano");

        assertAll("Pruebas unitarias setter Autor",

                () -> assertEquals(2, autor.getIdAutor()),
                () -> assertEquals("Mario Vargas Llosa", autor.getNombre()),
                () -> assertEquals("Peruano", autor.getNacionalidad())

        );

        System.out.println(autor.toString());
    }

    @Test
    public void testAutorToString() {

        String str = autor.toString();

        assertAll("Pruebas unitarias toString",

                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Gabriel Garcia Marquez")),
                () -> assertTrue(str.contains("Colombiano"))

        );
    }
}
