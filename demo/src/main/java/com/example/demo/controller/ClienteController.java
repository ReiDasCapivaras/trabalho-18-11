package com.example.demo.controller;

import com.example.demo.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value="/apiCliente")
public class    ClienteController {


    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping(value = "/findAll")
    public List<Cliente> todos(){
        return clienteRepository.findAll();
    }

    @PostMapping("/inserirCliente")
    public void addCliente(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }

    //1

    @GetMapping ("/id/{id}")
    public Optional<Cliente> buscarPorId
            (@PathVariable(value="id") int id)
    {
        return clienteRepository.findById(id);
    }

    @GetMapping ("/nome/{nome}")
    public List<Cliente> listaPorNome(@PathVariable(value="nome") String nome)
    {
        return clienteRepository.findByNome(nome);
    }

    @GetMapping ("/email/{email}")
    public List<Cliente> listaPorEmail(@PathVariable(value="email") String email)
    {
        return clienteRepository.findByEmail(email);
    }

    //2

    @GetMapping("/listainicial/{letra}")
    public List<Cliente> listarPorInicial (@PathVariable(value="letra") String letra)
    {
        return clienteRepository.findByComecaCom(letra);
    }

    @GetMapping("/idmaior/{num}")
    public List<Cliente> porIdMaior (@PathVariable(value = "num") int num)
    {
        return clienteRepository.findByIdMaior(num);
    }




}
