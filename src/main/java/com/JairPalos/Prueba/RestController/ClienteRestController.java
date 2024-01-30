/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JairPalos.Prueba.RestController;

import com.JairPalos.Prueba.DAO.ClienteService;
import com.JairPalos.Prueba.JPA.Cliente;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 1105884865
 */
@RestController
@RequestMapping("/ClienteApi")
public class ClienteRestController {

    ClienteService ClienteService;

    @Autowired
    public ClienteRestController(ClienteService ClienteService) {
        this.ClienteService = ClienteService;
    }

    @GetMapping("/Listado")
    public ResponseEntity<List<Cliente>> Listado() {
        List<Cliente> cliente = ClienteService.GetAll();
        if (cliente == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
    }

    @GetMapping("/Add&Update/{id}")
    public ResponseEntity<Cliente> obtenerAlumnoPorId(@PathVariable int id) {
        Optional<Cliente> clienteOptional = ClienteService.GetAll(id);
        Cliente cliente =clienteOptional.get();
        if (cliente != null) {

            return new ResponseEntity<>(new Cliente(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
    }

    @PostMapping("/From")
    public ResponseEntity<Cliente> Form(@RequestBody Cliente cliente) {
        if (cliente.getClienteid() == 0) {
            ClienteService.agregar(cliente);
            if (cliente == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(cliente, HttpStatus.OK);
            }
        } else {
            ClienteService.actualizar(cliente);

            if (cliente == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(cliente, HttpStatus.OK);
            }

        }
    }

    @GetMapping("/elimina/{id}")
    public Map<String, Integer> Delete(@PathVariable int id) {
        Map<String, Integer> map = new HashMap<>();
        ClienteService.eliminar(id);
        map.put("Se elimino el  cliente con el id: ", id);
        return map;
    }

}
