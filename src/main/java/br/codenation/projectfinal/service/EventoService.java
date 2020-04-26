package br.codenation.projectfinal.service;


import br.codenation.projectfinal.model.Evento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventoService {

    Evento save(Evento evento);

    List<Evento> findAll();

    List<Evento> findAll(Integer page, Integer size,String sortBy);

    List<Evento> findAll(String attribute);

    Optional<Evento> findById(Long id);

    List<Evento> findByLevel(String level);

}
