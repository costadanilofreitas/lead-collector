package com.br.lead.collector.controllers;

import com.br.lead.collector.models.Lead;
import com.br.lead.collector.services.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lead")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping("/{indice}")
    public Lead buscarLead(@PathVariable Integer indice){
        Lead lead = leadService.buscarPorIndice(indice);
        return lead;
    }

}
