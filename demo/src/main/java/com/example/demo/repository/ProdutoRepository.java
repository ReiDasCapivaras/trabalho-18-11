package com.example.demo.repository;

import com.example.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, Integer> {

    @Query(value = "select * from `produto_trabalho` where preco < ?2 and descricao like %?1%", nativeQuery = true)
    public List<Produto> busca_descricao_preco(String descricao, int preco);

    @Query(value = "select * from `produto_trabalho` where descricao like %?1% and marca like %?2%", nativeQuery = true)
    public List<Produto> busca_descricao_marca (String descricao, String marca);


}
