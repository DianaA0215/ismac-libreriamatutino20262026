package com.distribuida.dao;

import com.distribuida.model.Categoria;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class CategoriaTestIntegracion {

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Test
    public void findAll() {

        List<Categoria> categorias = categoriaDAO.findAll();

        assertNotNull(categorias);
        assertTrue(categorias.size() > 0);

        for (Categoria item : categorias) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne() {

        Optional<Categoria> categoria = categoriaDAO.findById(1);

        assertTrue(
                categoria.isPresent(),
                "La categoria con id = 1 debería existir"
        );

        System.out.println(categoria.toString());
    }

    @Test
    public void save() {

        Categoria categoria = new Categoria(
                0,
                "Novela",
                "Libros de ficción narrativa"
        );

        Categoria categoriaGuardada = categoriaDAO.save(categoria);

        assertNotNull(
                categoriaGuardada.getIdCategoria(),
                "La categoría guardada debe tener un id."
        );

        assertEquals(
                "Novela",
                categoriaGuardada.getNombreCategoria()
        );

        assertEquals(
                "Libros de ficción narrativa",
                categoriaGuardada.getDescripcion()
        );
    }

    @Test
    public void update() {

        Optional<Categoria> categoria = categoriaDAO.findById(58);

        assertTrue(
                categoria.isPresent(),
                "La categoría con id = 58 debe existir para ser actualizada"
        );

        categoria.orElse(null).setNombreCategoria("Ciencia Ficción");
        categoria.orElse(null).setDescripcion("Libros futuristas y tecnológicos");

        Categoria categoriaActualizada =
                categoriaDAO.save(categoria.orElse(null));

        assertEquals(
                "Ciencia Ficción",
                categoriaActualizada.getNombreCategoria()
        );

        assertEquals(
                "Libros futuristas y tecnológicos",
                categoriaActualizada.getDescripcion()
        );
    }

    @Test
    public void delete() {

        if (categoriaDAO.existsById(58)) {
            categoriaDAO.deleteById(58);
        }

        assertFalse(
                categoriaDAO.existsById(58),
                "El id = 58 debería haberse eliminado"
        );
    }
}