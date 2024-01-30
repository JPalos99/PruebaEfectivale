/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JairPalos.Prueba.JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author 1105884865
 */
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteid;
    private boolean clienteactivo;
    private String clientenombre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date clientefechacreacion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date clientefechamodificacion;

    public Cliente() {
    }

    public Cliente(int clienteid, boolean clienteactivo, String clientenombre, Date clientefechacreacion, Date clientefechamodificacion) {
        this.clienteid = clienteid;
        this.clienteactivo = clienteactivo;
        this.clientenombre = clientenombre;
        this.clientefechacreacion = clientefechacreacion;
        this.clientefechamodificacion = clientefechamodificacion;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public boolean isClienteactivo() {
        return clienteactivo;
    }

    public void setClienteactivo(boolean clienteactivo) {
        this.clienteactivo = clienteactivo;
    }

    public String getClientenombre() {
        return clientenombre;
    }

    public void setClientenombre(String clientenombre) {
        this.clientenombre = clientenombre;
    }

    public Date getClientefechacreacion() {
        return clientefechacreacion;
    }

    public void setClientefechacreacion(Date clientefechacreacion) {
        this.clientefechacreacion = clientefechacreacion;
    }

    public Date getClientefechamodificacion() {
        return clientefechamodificacion;
    }

    public void setClientefechamodificacion(Date clientefechamodificacion) {
        this.clientefechamodificacion = clientefechamodificacion;
    }

   
}
