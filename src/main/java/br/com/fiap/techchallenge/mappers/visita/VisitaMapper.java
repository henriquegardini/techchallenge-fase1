package br.com.fiap.techchallenge.mappers.visita;

import br.com.fiap.techchallenge.dto.visita.VisitaRequestDTO;
import br.com.fiap.techchallenge.dto.visita.VisitaResponseDTO;
import br.com.fiap.techchallenge.entities.Visita;

public interface VisitaMapper {

    static Visita toVisitaEntity(final VisitaRequestDTO visitaDTO) {
        return new Visita(
                visitaDTO.apartamento(),
                visitaDTO.andar(),
                visitaDTO.torre(),
                visitaDTO.expiracao()
        );
    }

    static VisitaResponseDTO toVisitaResponseDTO(final Visita visita) {
        return new VisitaResponseDTO(
                visita.getId(),
                visita.getApartamento(),
                visita.getAndar(),
                visita.getTorre(),
                visita.getInclusao(),
                visita.getExpiracao()
        );
    }

}
