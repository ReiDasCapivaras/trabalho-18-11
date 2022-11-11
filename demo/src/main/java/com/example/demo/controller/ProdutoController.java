package com.example.demo.controller;


import com.example.demo.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/apiProduto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/findAll")
    public List<Produto> findAllProduto()
    {
        return produtoRepository.findAll();
    }

    @PostMapping("/insereProduto")
    public void insereProduto(@RequestBody Produto produto)
    {
        produtoRepository.save(produto);
    }


    @GetMapping("/produto/{id}")
    public Optional<Produto> buscarPorId
            (@PathVariable(value="id") int id)
    {
        return produtoRepository.findById(id);
    }

    @GetMapping("/buscadp/{descricao}/{preco}")
    public List<Produto> busca_descricao_preco (@PathVariable(value = "descricao") String descricao, @PathVariable(value = "preco") int preco)
    {
        return produtoRepository.busca_descricao_preco(descricao, preco);
    }


}
