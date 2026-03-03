package br.infnet.tp1guilda.service;

import br.infnet.tp1guilda.models.Aventureiro;
import br.infnet.tp1guilda.repository.RepositoryAventureiro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceAventureiro {

    private final RepositoryAventureiro repositoryAventureiro;

    public Aventureiro criar(Aventureiro aventureiro) {
        return repositoryAventureiro.save(aventureiro);
    }
}