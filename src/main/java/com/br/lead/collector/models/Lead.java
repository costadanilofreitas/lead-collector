package com.br.lead.collector.models;

import com.br.lead.collector.enums.TipoDeLead;

public class Lead {

    private String nome;
    private String email;
    private TipoDeLead tipoDeLead;

    public Lead() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoDeLead getTipoDeLead() {
        return tipoDeLead;
    }

    public void setTipoDeLead(TipoDeLead tipoDeLead) {
        this.tipoDeLead = tipoDeLead;
    }
}
