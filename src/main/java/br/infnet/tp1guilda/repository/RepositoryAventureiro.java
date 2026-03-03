package br.infnet.tp1guilda.repository;

import br.infnet.tp1guilda.dto.FilterRequestAventureiro;
import org.springframework.stereotype.Repository;
import br.infnet.tp1guilda.models.Aventureiro;
import br.infnet.tp1guilda.dto.PageResult;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Repository
public interface RepositoryAventureiro {
    List<Aventureiro> findAll();

    List<Aventureiro> findWithFilter(FilterRequestAventureiro filtro);

    PageResult<Aventureiro> findWithFilter(
            FilterRequestAventureiro filtro,
            int page,
            int size
    );

    List<Aventureiro> findWithFilter(
            FilterRequestAventureiro filtro,
            Comparator<Aventureiro> comparator
    );

    PageResult<Aventureiro> findWithFilter(
            FilterRequestAventureiro filtro,
            Comparator<Aventureiro> comparator,
            int page,
            int size
    );

    Optional<Aventureiro> findById(Long id);

    Aventureiro save(Aventureiro aventureiro);
}