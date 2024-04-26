package com.example.demo.controller;


import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/usuario")
public class ExampleController {

    private final UsuarioRepository usuarioRepository;

    public ExampleController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String hello(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Usuario>> ListaUsuario() {

        List<Usuario> usuarios = usuarioRepository.findAll();

        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {

        usuarioRepository.save(usuario);

        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> deleteUsuario(@RequestParam Long id) {
        var usuario = usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        usuarioRepository.deleteById(id);

        return new ResponseEntity<>("Usuario deletado com sucesso", HttpStatus.OK);
    }

    @GetMapping("/getuserbyid")
    @ResponseBody
    public ResponseEntity<Usuario> buscarUsuarioPorId(@RequestParam Long id) {

        var usuario = usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
    }
}
