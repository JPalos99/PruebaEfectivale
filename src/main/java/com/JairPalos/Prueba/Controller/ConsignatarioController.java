/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JairPalos.Prueba.Controller;

import com.JairPalos.Prueba.DAO.ConsignatarioService;
import com.JairPalos.Prueba.JPA.Cliente;
import com.JairPalos.Prueba.JPA.Consignatario;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author 1105884865
 */
@Controller
@RequestMapping("/Consignatario")
public class ConsignatarioController {
    
    
    
    @GetMapping("/listado")
    private String listadoCliente(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8080/ConsignatarioApi/Listado";
        ResponseEntity<List<Consignatario>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Consignatario>>() {
        }
        );
        List<Consignatario> consignatarios = response.getBody();
        model.addAttribute("consignatarios", consignatarios);
        model.addAttribute("consignatario", new Consignatario());
        
        
        return "PaginaConsignatario";
    }


    @GetMapping("/form/{idConsignatario}")
    public String Form(@PathVariable int idConsignatario, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        RestTemplate restTemplateCliente = new RestTemplate();
        String apiUrlcliente = "http://localhost:8080/ClienteApi/Listado";
        ResponseEntity<List<Cliente>> responseCliente = restTemplateCliente.exchange(
                apiUrlcliente,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cliente>>() {
        }
        );
        List<Cliente> clientes = responseCliente.getBody();
        
        

        if (idConsignatario == 0) {
            model.addAttribute("consignatario", new Consignatario());
            model.addAttribute("clientes", clientes);
            return "FormularioConsignatario";
        } else {

            String apiUrl = "http://localhost:8080/ConsignatarioApi/Add&Update/" + idConsignatario;
            ResponseEntity<Optional<Consignatario>> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Optional<Consignatario>>() {
            }
            );
            Optional<Consignatario> consignatarioOp = response.getBody();
            Consignatario consignatario = consignatarioOp.get();
            model.addAttribute("consignatario", consignatario);
            model.addAttribute("clientes", clientes);
        }
        return "FormularioConsignatario";

    }

    @PostMapping("form")
    public String Form(@ModelAttribute("materia") Consignatario consignatario, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String apiUrl = "http://localhost:8080/ConsignatarioApi/From";
        HttpEntity<Consignatario> request
                = new HttpEntity<Consignatario>(consignatario, headers);
        ResponseEntity<Consignatario> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<Consignatario>() {
        }
        );
        return "redirect:/Consignatario/listado";
    }

    @GetMapping("/EliminarConsignatario/{idConsignatario}")
    public String Delete(@PathVariable int idConsignatario) {
       
        RestTemplate RestTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8080/ConsignatarioApi/elimina/" + idConsignatario;
        ResponseEntity<Consignatario> response = RestTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Consignatario>() {
        }
        );
        return "redirect:/Consignatario/listado";
    }
    
    
}
