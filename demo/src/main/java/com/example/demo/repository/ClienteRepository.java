package com.example.demo.repository;

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

}
