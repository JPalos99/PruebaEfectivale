/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JairPalos.Prueba.RestController;

import com.JairPalos.Prueba.DAO.ConsignatarioService;
import com.JairPalos.Prueba.JPA.Cliente;
import com.JairPalos.Prueba.JPA.Consignatario;
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
@RequestMapping("/ConsignatarioApi")
public class ConsignatarioRestController {
    
    ConsignatarioService ConsignatarioService ;

    @Autowired
    public ConsignatarioRestController(ConsignatarioService ConsignatarioService) {
        this.ConsignatarioService = ConsignatarioService;
    }

    @GetMapping("/Listado")
    public ResponseEntity<List<Consignatario>> Listado() {
        List<Consignatario> consignatario = ConsignatarioService.GetAll();
        if (consignatario == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consignatario, HttpStatus.OK);
        }
    }

    @GetMapping("/Add&Update/{id}")
    public ResponseEntity<Consignatario> obtenerAlumnoPorId(@PathVariable int id) {
        Optional<Consignatario> consignatarioOptional = ConsignatarioService.GetAll(id);
        Consignatario consignatario =consignatarioOptional.get();
        if (consignatario == null) {

            return new ResponseEntity<>(new Consignatario(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(consignatario, HttpStatus.OK);
        }
    }

    @PostMapping("/From")
    public ResponseEntity<Consignatario> Form(@RequestBody Consignatario consignatario) {
        if (consignatario.getConsignatarioid()== 0) {
            ConsignatarioService.agregar(consignatario);
            if (consignatario == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(consignatario, HttpStatus.OK);
            }
        } else {
            ConsignatarioService.actualizar(consignatario);

            if (consignatario == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(consignatario, HttpStatus.OK);
            }

        }
    }

    @GetMapping("/elimina/{id}")
    public Map<String, Integer> Delete(@PathVariable int id) {
        Map<String, Integer> map = new HashMap<>();
        
        ConsignatarioService.eliminar(id);
        map.put("Se elimino el  consignatario con el id: ", id);
        return map;
    }

    
    
}
