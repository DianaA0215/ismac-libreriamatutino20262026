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
                "Andres",
                "Jacome Nuñez",
                "Ecuador",
                "Loja",
                "0999999999",
                "andres@gmail.com"
        );
    }

    @Test
    public void testAutorConstructorAndGetters() {

        assertAll("Pruebas unitarias constructor Autor",

                () -> assertEquals(1, autor.getIdAutor()),
                () -> assertEquals("Andres", autor.getNombre()),
                () -> assertEquals("Jacome Nuñez", autor.getApellido()),
                () -> assertEquals("Ecuador", autor.getPais()),
                () -> assertEquals("Loja", autor.getDireccion()),
                () -> assertEquals("0999999999", autor.getTelefono()),
                () -> assertEquals("andres@gmail.com", autor.getCorreo())

        );

        System.out.println(autor.toString());
    }

    @Test
    public void testAutorSetter() {

        autor.setIdAutor(2);
        autor.setNombre("Maria");
        autor.setApellido("Fernandez");
        autor.setPais("Alemania");
        autor.setDireccion("Berlin");
        autor.setTelefono("0988888888");
        autor.setCorreo("maria@gmail.com");

        assertAll("Pruebas unitarias setter Autor",

                () -> assertEquals(2, autor.getIdAutor()),
                () -> assertEquals("Maria", autor.getNombre()),
                () -> assertEquals("Fernandez", autor.getApellido()),
                () -> assertEquals("Alemania", autor.getPais()),
                () -> assertEquals("Berlin", autor.getDireccion()),
                () -> assertEquals("0988888888", autor.getTelefono()),
                () -> assertEquals("maria@gmail.com", autor.getCorreo())

        );

        System.out.println(autor.toString());
    }

    @Test
    public void testAutorToString() {

        String str = autor.toString();

        assertAll("Pruebas unitarias toString",

                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Andres")),
                () -> assertTrue(str.contains("Jacome Nuñez")),
                () -> assertTrue(str.contains("Ecuador")),
                () -> assertTrue(str.contains("Loja")),
                () -> assertTrue(str.contains("0999999999")),
                () -> assertTrue(str.contains("andres@gmail.com"))

        );
    }
}