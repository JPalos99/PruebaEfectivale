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
        ServiceConsignatario.ConsignatarioAdd(Consignatario.isConsignatarioactivo(), Consignatario.getConsignatarionombre(), Consignatario.getConsignatariofechacreacion(), Consignatario.getConsignatariofechamodificacion());
    }

    public void actualizar(Consignatario Consignatario) {
        ServiceConsignatario.ConsignatarioUpdate(Consignatario.getConsignatarioid(),Consignatario.isConsignatarioactivo(), Consignatario.getConsignatarionombre(), Consignatario.getConsignatariofechacreacion(), Consignatario.getConsignatariofechamodificacion());
    }

    public void eliminar(int consignatarioid) {
        ServiceConsignatario.ConsignatarioDelete(consignatarioid);
    }
}
