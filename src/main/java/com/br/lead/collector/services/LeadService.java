package com.br.lead.collector.services;

import com.br.lead.collector.enums.TipoDeLead;
import com.br.lead.collector.models.Lead;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LeadService {

    private List<Lead> leads = new ArrayList(Arrays.asList(
            new Lead("Vinicius", "xablau@gmail.com", TipoDeLead.QUENTE)));

    public Lead buscarPorIndice(int indice){
        Lead lead = leads.get(indice);
        return lead;
    }

    public Lead salvarLead(Lead lead){
        leads.add(lead);
        return lead;
    }
}
