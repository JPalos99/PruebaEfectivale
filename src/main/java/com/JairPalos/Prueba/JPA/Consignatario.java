/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JairPalos.Prueba.JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author 1105884865
 */
@Entity
public class Consignatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int consignatarioid;
    private boolean consignatarioactivo;
    private String consignatarionombre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date consignatariofechacreacion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date consignatariofechamodificacion;
    @ManyToOne
    @JoinColumn(name="clienteid")
    private Cliente cliente;

    public Consignatario() {
    }

    public Consignatario(int consignatarioid, boolean consignatarioactivo, String consignatarionombre, Date consignatariofechacreacion, Date consignatariofechamodificacion, Cliente cliente) {
        this.consignatarioid = consignatarioid;
        this.consignatarioactivo = consignatarioactivo;
        this.consignatarionombre = consignatarionombre;
        this.consignatariofechacreacion = consignatariofechacreacion;
        this.consignatariofechamodificacion = consignatariofechamodificacion;
        this.cliente = cliente;
    }

    public int getConsignatarioid() {
        return consignatarioid;
    }

    public void setConsignatarioid(int consignatarioid) {
        this.consignatarioid = consignatarioid;
    }

    public boolean isConsignatarioactivo() {
        return consignatarioactivo;
    }

    public void setConsignatarioactivo(boolean consignatarioactivo) {
        this.consignatarioactivo = consignatarioactivo;
    }

    public String getConsignatarionombre() {
        return consignatarionombre;
    }

    public void setConsignatarionombre(String consignatarionombre) {
        this.consignatarionombre = consignatarionombre;
    }

    public Date getConsignatariofechacreacion() {
        return consignatariofechacreacion;
    }

    public void setConsignatariofechacreacion(Date consignatariofechacreacion) {
        this.consignatariofechacreacion = consignatariofechacreacion;
    }

    public Date getConsignatariofechamodificacion() {
        return consignatariofechamodificacion;
    }

    public void setConsignatariofechamodificacion(Date consignatariofechamodificacion) {
        this.consignatariofechamodificacion = consignatariofechamodificacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

}
