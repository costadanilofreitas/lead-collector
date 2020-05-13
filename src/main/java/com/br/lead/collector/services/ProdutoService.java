package com.br.lead.collector.services;

import com.br.lead.collector.models.Produto;
import com.br.lead.collector.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Optional<Produto> buscarPorId(int id){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        return produtoOptional;
    }

    public Produto salvarProduto(Produto produto){
        Produto produtoObjeto = produtoRepository.save(produto);
        return produtoObjeto;
    }

    public Iterable<Produto> buscarTodosProdutos(){
        Iterable<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    public Produto atualizarProduto(Produto produto){
        Optional<Produto> produtoOptional = buscarPorId(produto.getId());
        if (produtoOptional.isPresent()){
            Produto produtoData = produtoOptional.get();

            if(produto.getNome() == null){
                produto.setNome(produtoData.getNome());
            }
            if(produto.getDescricao() == null){
                produto.setDescricao(produtoData.getDescricao());
            }
            if(produto.getPreco() == null){
                produto.setPreco(produtoData.getPreco());
            }
        }
        Produto produtoObjeto = produtoRepository.save(produto);
        return produtoObjeto;
    }

    public void deletarProduto(Produto produto){
        produtoRepository.delete(produto);
    }
}
