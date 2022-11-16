package com.example.demo.repository;

import com.example.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, Integer> {

    @Query(value = "select * from `produto_trabalho` where preco < ?2 and descricao like %?1%", nativeQuery = true)
    public List<Produto> busca_descricao_preco(String descricao, int preco);


    //ainda não testada
    @Query(value = "select * from `produto_trabalho` where descricao like %?1% and marca like %?2%", nativeQuery = true)
    public List<Produto> busca_descricao_marca (String descricao, String marca);

    @Query(value = "select * from `produto_trabalho` where preco < ?1", nativeQuery = true)
    public List<Produto> precomenor(int preco);

    @Query(value = "select * from `produto_trabalho` where preco > ?1", nativeQuery = true)
    public List<Produto> precomaior(int preco);

    @Query(value = "select * from `produto_trabalho` where marca like ?1%", nativeQuery = true)
    public List<Produto> buscaInMarca(String inicial);

    @Query(value = "select * from `produto_trabalho` where descricao like ?1%", nativeQuery = true)
    public List<Produto> buscaInDescricao(String incial);

    @Query(value = "select * from `produto_trabalho` where id = ?1 and descricao like %?2% and marca like %?3% and preco = ?4", nativeQuery = true)
    public List<Produto> tdsAtributos (int id, String descricao, String marca, int preco);

}
