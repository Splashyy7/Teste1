package br.infnet.tp1guilda.dto;

import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.Range;
import java.util.List;

public record PageResult<T> (
        @Min(value = 0, message = "A página deve iniciar em 0")
        int page,
        @Range(min = 1, max = 50, message = "Size deve ser entre 1 e 50")
        int size,
        int total,
        int totalPages,
        List<T> content
){
    public PageResult(int page, int size, int total, List<T> content) {
        this(
                page,
                Math.max(size, 1),
                total,
                (int) Math.ceil((double) total / Math.max(size, 1)),
                content
        );
}
}
