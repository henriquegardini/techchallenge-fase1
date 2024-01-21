package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.entities.Visita;
import br.com.fiap.techchallenge.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitaService {

    @Autowired
    public VisitaRepository visitaRepository;

    public void saveVisitas(List<Visita> visitas) {
        visitaRepository.saveAll(visitas);
    }



}
