package com.br.lead.collector.controllers;

import com.br.lead.collector.services.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeadController {

    @Autowired
    private LeadService leadService;

    
}
