/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JairPalos.Prueba.DAO;

import com.JairPalos.Prueba.JPA.Consignatario;
import com.JairPalos.Prueba.JPA.Cliente;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author 1105884865
 */
public interface ServiceConsignatario extends JpaRepository<Consignatario, Integer> {

    @Procedure(name = "ConsignatarioAdd")
    void ConsignatarioAdd(
            @Param(value = "clienteactivo")
                    boolean consignatarioactivo, @Param(value = "clientenombre")
                            String consignatarionombre, @Param(value = "clientefechacreacion")
                                    Date consignatariofechacreacion, @Param(value = "clientefechamodificacion")
                                            Date consignatariofechamodificacion);

    @Procedure(name = "ConsignatarioUpdate")
    void ConsignatarioUpdate(
            @Param(value = "consignatarioid")
                    int consignatarioid, @Param(value = "clienteactivo")
                            boolean consignatarioactivo, @Param(value = "clientenombre")
                                    String consignatarionombre, @Param(value = "clientefechacreacion")
                                            Date consignatariofechacreacion, @Param(value = "clientefechamodificacion")
                                                    Date consignatariofechamodificacion);

    @Procedure(name = "ConsignatarioDelete")
    void ConsignatarioDelete(@Param("consignatarioid") int consignatarioid);

}
