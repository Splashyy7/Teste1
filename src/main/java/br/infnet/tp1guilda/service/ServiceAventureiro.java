package br.infnet.tp1guilda.service;

import br.infnet.tp1guilda.models.Aventureiro;
import br.infnet.tp1guilda.repository.RepositoryAventureiro;
import br.infnet.tp1guilda.exceptions.AventureiroNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.infnet.tp1guilda.dto.AtualizarAventureiro;

@Service
@RequiredArgsConstructor
public class ServiceAventureiro {

    private final RepositoryAventureiro repositoryAventureiro;

    public Aventureiro criar(Aventureiro aventureiro) {
        return repositoryAventureiro.save(aventureiro);
    }

    public Aventureiro buscarPorId(Long id) {
        return repositoryAventureiro.findById(id)
                .orElseThrow(() -> new AventureiroNotFoundException(id));
    }

    public Aventureiro atualizar(Long id, AtualizarAventureiro update) {

        Aventureiro aventureiro = buscarPorId(id);

        if (update.nome() != null)
            aventureiro.alterarNome(update.nome());

        if (update.classe() != null)
            aventureiro.alterarClasse(update.classe());

        if (update.nivel() != null)
            aventureiro.alterarNivel(update.nivel());

        return repositoryAventureiro.save(aventureiro);
    }
}