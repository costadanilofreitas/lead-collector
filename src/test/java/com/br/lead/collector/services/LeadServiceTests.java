package com.br.lead.collector.services;

import com.br.lead.collector.enums.TipoDeLead;
import com.br.lead.collector.models.Lead;
import com.br.lead.collector.models.Produto;
import com.br.lead.collector.repositories.LeadRepository;
import com.br.lead.collector.repositories.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

@SpringBootTest
public class LeadServiceTests {

    @MockBean
    LeadRepository leadRepository;

    @MockBean
    ProdutoRepository produtoRepository;

    @Autowired
    LeadService leadService;

    Lead lead;

    @BeforeEach
    public void inicializar(){
        lead = new Lead();
        lead.setId(1);
        lead.setTipoDeLead(TipoDeLead.QUENTE);
        lead.setEmail("vinicius@gmail.com");
        lead.setNome("Vinicius");
        lead.setProdutos(Arrays.asList(new Produto()));
    }

    @Test
    public void testarSalvarLead(){

        Mockito.when(leadRepository.save(Mockito.any(Lead.class))).thenReturn(lead);

        Lead leadObjeto = leadService.salvarLead(lead);

        Assertions.assertEquals(lead, leadObjeto);
        Assertions.assertEquals(lead.getEmail(), leadObjeto.getEmail());

    }

    @Test
    public void testeDeletarLead(){
        leadService.deletarLead(lead);
        Mockito.verify(leadRepository, Mockito.times(1)).delete(Mockito.any(Lead.class));
    }
}
