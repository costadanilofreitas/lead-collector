package com.br.lead.collector.models;

import com.br.lead.collector.enums.TipoDeLead;
import org.hibernate.ObjectNotFoundException;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_completo")
    @Size(min = 8, max = 100, message = "O nome deve ter entre 8 a 100 caracteres ")
    private String nome;

    @Email(message = "O formato do email é invalido")
    private String email;
    private TipoDeLead tipoDeLead;

    @ManyToMany
    private List<Produto> produtos;

    public Lead() {
    }

    public Lead(String nome, String email, TipoDeLead tipoDeLead) throws ObjectNotFoundException {
        this.nome = nome;
        this.email = email;
        this.tipoDeLead = tipoDeLead;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
