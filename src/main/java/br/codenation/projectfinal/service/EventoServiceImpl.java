package br.codenation.projectfinal.service;

import br.codenation.projectfinal.model.Evento;
import br.codenation.projectfinal.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    public EventoRepository eventoRepository;

    @Override
    public Evento save(Evento evento) {
        Evento eventoSaved =  eventoRepository.save(evento);
        eventoSaved.setCreatedAt(Calendar.getInstance().getTime());

        return eventoSaved;
    }

    @Override
    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    @Override
    public List<Evento> findAll(String attribute) {
        return eventoRepository.findAll(Sort.by(Sort.Direction.ASC,attribute));
    }

    @Override
    public List<Evento> findAll(Integer page,Integer size,String sortBy) {
        Pageable paging = PageRequest.of(page,size,Sort.by(sortBy));
        Page<Evento> pageResult = eventoRepository.findAll(paging);

        if(pageResult.hasContent()) return pageResult.getContent();
        else return new ArrayList<Evento>();

    }

    @Override
    public Optional<Evento> findById(Long id) {
        return eventoRepository.findById(id);
    }

    @Override
    public List<Evento> findByLevel(String level) {
        return eventoRepository.findEventoByLevel(level);
    }
}
