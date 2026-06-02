package com.distribuida.dao;

import com.distribuida.model.Autor;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class AutorTestIntegracion {

    @Autowired
    private AutorDAO autorDAO;

    @Test
    public void findAll() {

        List<Autor> autores = autorDAO.findAll();

        assertNotNull(autores);
        assertTrue(autores.size() > 0);

        for (Autor item : autores) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne() {

        Optional<Autor> autor = autorDAO.findById(1);

        assertTrue(
                autor.isPresent(),
                "El autor con id = 1 debería existir"
        );

        System.out.println(autor.toString());
    }

    @Test
    public void save() {

        Autor autor = new Autor(
                0,
                "Gabriel",
                "García Márquez",
                "Colombia",
                "Aracataca",
                "0999999999",
                "gabriel@correo.com"
        );

        Autor autorGuardado = autorDAO.save(autor);

        assertNotNull(
                autorGuardado.getIdAutor(),
                "El autor guardado debe tener un id."
        );

        assertEquals(
                "Gabriel",
                autorGuardado.getNombre()
        );

        assertEquals(
                "García Márquez",
                autorGuardado.getApellido()
        );
    }

    @Test
    public void update() {

        Optional<Autor> autor = autorDAO.findById(54);

        assertTrue(
                autor.isPresent(),
                "El autor con id = 54 debe existir para ser actualizado"
        );

        autor.orElse(null).setNombre("Mario");
        autor.orElse(null).setApellido("Vargas Llosa");
        autor.orElse(null).setPais("Perú");
        autor.orElse(null).setDireccion("Lima");
        autor.orElse(null).setTelefono("0988888888");
        autor.orElse(null).setCorreo("mario@correo.com");

        Autor autorActualizado =
                autorDAO.save(autor.orElse(null));

        assertEquals(
                "Mario",
                autorActualizado.getNombre()
        );

        assertEquals(
                "Vargas Llosa",
                autorActualizado.getApellido()
        );
    }

    @Test
    public void delete() {

        if (autorDAO.existsById(54)) {
            autorDAO.deleteById(54);
        }

        assertFalse(
                autorDAO.existsById(54),
                "El id = 54 debería haberse eliminado"
        );
    }
}