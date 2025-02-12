package com.br.sistema_teste.controller;


import com.br.sistema_teste.domain.Usuario;
import com.br.sistema_teste.dto.UsuarioCreateDto;
import com.br.sistema_teste.dto.UsuarioResponseDto;
import com.br.sistema_teste.dto.UsuarioSenhaDto;
import com.br.sistema_teste.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Usuarios",description = "Descrição da sua Api")
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Cadastro de clientes",description = "Cadastro de clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "cadastrado com sucesso")
    })
    @PostMapping
    public ResponseEntity<UsuarioResponseDto>create(@Valid @RequestBody UsuarioCreateDto createDto){
       UsuarioResponseDto responseDto=usuarioService.salvar(createDto);
       return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
   }
    @Operation(summary = "Busca de cliente",description = "Busca de Cliente por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Busca do usuario com sucesso")
    })
   @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto>findById(@PathVariable Long id){
       UsuarioResponseDto responseDto=usuarioService.buscarPorId(id);
       return ResponseEntity.ok(responseDto);
   }
    @Operation(summary = "Lista de  clientes",description = "Listar todos os clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista de clientes ok")
    })
   @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>>findAll(){
       List<UsuarioResponseDto>responseDtos=usuarioService.buscarTodos();
       return ResponseEntity.ok(responseDtos);
   }
    @Operation(summary = "Deletar usuario",description = "Deletar usuario por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",description = "Deletado com sucesso")
    })
   @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletar(@PathVariable Long id){
       usuarioService.delete(id);
       return ResponseEntity.noContent().build();
   }
    @Operation(summary = "Editar senha de um usuario",description = "Editar senha de um usuario por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",description = "Senha alterado com sucesso")
    })
   @PutMapping("/{id}/password")
    public ResponseEntity<Void>editarSenha(@PathVariable Long id, @RequestBody UsuarioSenhaDto senhaDto){
       usuarioService.editarSenha(id,senhaDto);
       return ResponseEntity.noContent().build();
   }
}
