package br.infnet.tp1guilda.controllers;

import br.infnet.tp1guilda.service.ServiceAventureiro;
import br.infnet.tp1guilda.dto.*;
import br.infnet.tp1guilda.mapper.*;
import br.infnet.tp1guilda.models.Aventureiro;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
public class AventureiroController {

    private final MapperAventureiro mapperAventureiro;
    private final ServiceAventureiro serviceAventureiro;

    @PostMapping(value = "")
    public ResponseEntity<ResponseAventureiro> registrarAventureiro(@RequestBody @Valid CriarAventureiro dto) {
        Aventureiro aventureiro = mapperAventureiro.toEntity(dto);
        Aventureiro salvo = serviceAventureiro.criar(aventureiro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapperAventureiro.toResponse(salvo));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aventureiro> buscarPorId(@PathVariable Long id) {
        Aventureiro aventureiro = serviceAventureiro.buscarPorId(id);
        return ResponseEntity.ok(aventureiro);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ResponseAventureiro> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody AtualizarAventureiro update
    ) {
        Aventureiro atualizado = serviceAventureiro.atualizar(id, update);
        return ResponseEntity.ok(mapperAventureiro.toResponse(atualizado));
    }
}