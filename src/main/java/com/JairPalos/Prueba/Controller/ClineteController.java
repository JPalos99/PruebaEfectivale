/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JairPalos.Prueba.Controller;


import com.JairPalos.Prueba.JPA.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author 1105884865
 */
@Controller
@RequestMapping("/Cliente")
public class ClineteController {
    
    
     @GetMapping("/listado")
    private String listadoCliente(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8080/ClienteApi/Listado";
        ResponseEntity<List<Cliente>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cliente>>() {
        }
        );
        List<Cliente> clientes = response.getBody();
        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", new Cliente());
        return "PaginaCliente";
    }

    @GetMapping("/form/{idCliente}")
    public String Form(@PathVariable int idCliente, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        
        if (idCliente == 0) {
            model.addAttribute("cliente", new Cliente());
            return "FormularioCliente";
        } else {

            String apiUrl = "http://localhost:8080/ClienteApi/Add&Update/" + idCliente;
            ResponseEntity<Optional<Cliente>> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Optional<Cliente>>() {
            }
            );
            Optional<Cliente> clienteOp = response.getBody();
            Cliente cliente = clienteOp.get();
            model.addAttribute("cliente", cliente);
        }
        return "FormularioCliente";

    }

    @PostMapping("form")
    public String Form(@ModelAttribute("materia") Cliente cliente, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        String apiUrl = "http://localhost:8080/ClienteApi/From";
        HttpEntity<Cliente> request
                = new HttpEntity<Cliente>(cliente, headers);
        ResponseEntity<Cliente> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<Cliente>() {
        }
        );
        return "redirect:/Cliente/listado";
        
    }

    @GetMapping("/EliminarCliente/{idcliente}")
    public String Delete(@PathVariable int idcliente) {
        RestTemplate RestTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8080/ClienteApi/elimina/" + idcliente;
        ResponseEntity<Cliente> response = RestTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Cliente>() {
        }
        );
        return "redirect:/Cliente/listado";
    }
    
}
