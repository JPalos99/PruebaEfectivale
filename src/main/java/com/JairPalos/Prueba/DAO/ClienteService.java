/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JairPalos.Prueba.DAO;

import com.JairPalos.Prueba.JPA.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 1105884865
 */

@Service
public class ClienteService {
    
    
    ServiceCliente ServiceCliente;

     @Autowired
   
    public ClienteService(ServiceCliente ServiceCliente) {
        this.ServiceCliente = ServiceCliente;
    }
    
     public List<Cliente> GetAll(){
        return ServiceCliente.findAll();
    }

    public Optional<Cliente> GetAll(int clienteid){
        return ServiceCliente.findById(clienteid);
    }
 
     
    public void agregar(Cliente cliente) {
        ServiceCliente.ClienteAdd(cliente.isClienteactivo(), cliente.getClientenombre(), cliente.getClientefechacreacion(),cliente.getClientefechamodificacion());
    }
    public void actualizar(Cliente cliente) {
        ServiceCliente.ClienteUpdate(cliente.getClienteid(),cliente.isClienteactivo(), cliente.getClientenombre(), cliente.getClientefechacreacion(),cliente.getClientefechamodificacion());
    }
    
    public void eliminar(int clienteid){
        ServiceCliente.ClienteDelete(clienteid);
    }
    
    
    
}
