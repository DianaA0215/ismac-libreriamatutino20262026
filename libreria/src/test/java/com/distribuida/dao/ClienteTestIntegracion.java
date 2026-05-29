package com.distribuida.dao;

import com.distribuida.model.Cliente;
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
public class ClienteTestIntegracion {

   @Autowired
    private ClienteDAO clienteDAO;

   @Test
    public void findAll(){
       List<Cliente> clientes = clienteDAO.findAll();
       assertNotNull(clientes);
       assertTrue(clientes.size()>0);
       for (Cliente item : clientes){
           System.out.println(item.toString());
       }
   }
   @Test
    public void findOne(){
       Optional<Cliente> cliente = clienteDAO.findById(1);
       assertTrue(cliente.isPresent(),"El cliente con id = 1, deberia existir");
       System.out.println(cliente.toString());
   }
   @Test
    public void save(){
       Cliente cliente = new Cliente(
               0,"1701234566","Juanó","Taipeó",
               "Av . por ahi","0987653216","jtaipeó@correo.com");
       Cliente clienteGuardado = clienteDAO.save(cliente);
       assertNotNull(clienteGuardado.getIdCliente(),"El cliente guardado debe tener un id.");
       assertEquals("1701234566",clienteGuardado.getCedula());
       assertEquals("Juanó", clienteGuardado.getNombre());
   }

   @Test
    public void update(){
       Optional<Cliente> cliente = clienteDAO.findById(47);
       assertTrue(cliente.isPresent(),"El cliente con id=46 debe de existir para ser actualizado");

       cliente.orElse(null).setCedula("1751550804");
       cliente.orElse(null).setNombre("Juan4");
       cliente.orElse(null).setApellido("Taipe4");
       cliente.orElse(null).setDireccion("Av. 33");
       cliente.orElse(null).setTelefono("0987654333");
       cliente.orElse(null).setCorreo("jtaipe33@correo.com");

       Cliente clienteActualizado = clienteDAO.save(cliente.orElse(null));

       assertEquals("Juan4",clienteActualizado.getNombre());
       assertEquals("Taipe4",clienteActualizado.getApellido());


   }

   @Test
    public void delete(){

       if(clienteDAO.existsById(47)){
           clienteDAO.deleteById(47);
       }
       assertFalse(clienteDAO.existsById(47),"El id=47 deberia haberse eliminado");
   }
}
