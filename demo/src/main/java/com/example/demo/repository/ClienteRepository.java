package com.example.demo.repository;

import ch.qos.logback.core.net.server.Client;
import com.example.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
    public List<Cliente> findByNome(String nome);
    public List<Cliente> findByEmail(String email);

    @Query(value="select * from `cliente_trabalho`  where nome like ?1%", nativeQuery = true)
    public List<Cliente> findByComecaCom (String letra
    );

    @Query(value="select * from `cliente_trabalho` where id > ?1", nativeQuery = true)
    public List<Cliente> findByIdMaior (int id);

    @Query(value = "select * from `cliente_trabalho` where nome like ?1% and email like ?2%", nativeQuery = true)
    public List<Cliente> findNomeEmail (String nome, String email);

    @Query(value = "select * from `cliente_trabalho` where email like ?1%", nativeQuery = true)
    public List<Cliente> findEmail(String email);

    @Query(value = "select * from `cliente_trabalho` where id > ?1", nativeQuery = true)
    public List<Cliente> codigomaior(int codigo);

}
