package com.br.lead.collector.controllers;

import com.br.lead.collector.models.Lead;
import com.br.lead.collector.services.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/lead")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping("/{indice}")
    public Lead buscarLead(@PathVariable Integer indice){
        Lead lead;
        try{
            lead = leadService.buscarPorIndice(indice);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return lead;
    }

    @PostMapping
    public ResponseEntity<Lead> salvarLead(@RequestBody Lead lead){
        Lead leadObjeto = leadService.salvarLead(lead);
        return ResponseEntity.status(201).body(leadObjeto);
    }

}
