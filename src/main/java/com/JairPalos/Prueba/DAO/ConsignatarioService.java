/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JairPalos.Prueba.DAO;

import com.JairPalos.Prueba.JPA.Cliente;
import com.JairPalos.Prueba.JPA.Consignatario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 1105884865
 */
@Service
public class ConsignatarioService {

    ServiceConsignatario ServiceConsignatario;

    @Autowired

    public ConsignatarioService(ServiceConsignatario ServiceConsignatario) {
        this.ServiceConsignatario = ServiceConsignatario;
    }

    public List<Consignatario> GetAll() {
        return ServiceConsignatario.findAll();
    }
    
      public Optional<Consignatario> GetAll(int consignatarioid){
        return ServiceConsignatario.findById(consignatarioid);
    }

    public void agregar(Consignatario Consignatario) {
        ServiceConsignatario.ConsignatarioAdd(Consignatario.isConsignatarioactivo(), Consignatario.getConsignatarionombre(),Consignatario.getCliente().getClienteid());
    }

    public void actualizar(Consignatario Consignatario) {
        ServiceConsignatario.ConsignatarioUpdate(Consignatario.getCliente().getClienteid(),Consignatario.getConsignatarioid(),Consignatario.isConsignatarioactivo(),Consignatario.getConsignatarionombre());
    }

    public void eliminar(int consignatarioid) {
        Optional<Consignatario> consignatario= ServiceConsignatario.findById(consignatarioid);
        Consignatario consignatario1=consignatario.get();
        System.out.println(consignatario1.getCliente().getClienteid());
        ServiceConsignatario.ConsignatarioDelete(consignatarioid,consignatario1.getCliente().getClienteid());
    }
}
