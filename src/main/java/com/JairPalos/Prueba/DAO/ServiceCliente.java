/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JairPalos.Prueba.DAO;

import com.JairPalos.Prueba.JPA.Cliente;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author 1105884865
 */
public interface ServiceCliente extends JpaRepository<Cliente, Integer> {
    
    @Procedure(name = "ClienteAdd")
    void ClienteAdd(
            @Param("clienteactivo") boolean clienteactivo,
            @Param("clientenombre") String clientenombre
         
    );

    @Procedure(name = "ClienteUpdate")
    void ClienteUpdate(
            @Param("clienteid") int clienteid,
            @Param("clienteactivo") boolean clienteactivo,
             @Param("clientenombre") String clientenombre
       
    );

    @Procedure(name = "ClienteDelete")
    void ClienteDelete(@Param("clienteid") int clienteid);

   
    
    
}
