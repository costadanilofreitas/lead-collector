package com.br.lead.collector.controllers;

import com.br.lead.collector.enums.TipoDeLead;
import com.br.lead.collector.models.Lead;
import com.br.lead.collector.models.Produto;
import com.br.lead.collector.services.LeadService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@WebMvcTest(LeadController.class)
public class LeadControllerTests {

    @MockBean
    LeadService leadService;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    Lead lead;
    Produto produto;

    @BeforeEach
    public void iniciar(){
        lead = new Lead();
        lead.setNome("Vinicius");
        lead.setEmail("vinicius@gmail.com");
        lead.setTipoDeLead(TipoDeLead.QUENTE);

        produto = new Produto();
        produto.setNome("Café");
        produto.setId(1);
        produto.setPreco(10.00);
        produto.setDescricao("Café da fazenda boa vista. ");
        lead.setProdutos(Arrays.asList(produto));
    }

    @Test
    public void testarCadastroDeLead() throws Exception {

        Iterable<Produto> produtosIterable = Arrays.asList(produto);

        Mockito.when(leadService.salvarLead(Mockito.any(Lead.class))).thenReturn(lead);
        Mockito.when(leadService.buscarTodosProdutos(Mockito.anyList())).thenReturn(produtosIterable);

        String json = mapper.writeValueAsString(lead);

        mockMvc.perform(MockMvcRequestBuilders.post("/leads")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.produtos[0].id", CoreMatchers.equalTo(1)));

    }
}
