package br.codenation.projectfinal.service;

import br.codenation.projectfinal.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventService {

    Event save(Event evento);

    List<Event> findAll();

    List<Event> findAll(Integer page, Integer size,String sortBy);

    List<Event> findAll(String attribute);

    Optional<Event> findById(Long id);

    List<Event> findByLevel(String level);

}
