package br.codenation.projectfinal.service;

import br.codenation.projectfinal.model.Event;
import br.codenation.projectfinal.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    public EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        Event eventSaved =  eventRepository.save(event);
        eventSaved.setCreatedAt(Calendar.getInstance().getTime());

        return eventSaved;
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> findAll(String attribute) {
        return eventRepository.findAll(Sort.by(Sort.Direction.ASC,attribute));
    }

    @Override
    public List<Event> findAll(Integer page,Integer size,String sortBy) {
        Pageable paging = PageRequest.of(page,size,Sort.by(sortBy));
        Page<Event> pageResult = eventRepository.findAll(paging);

        if(pageResult.hasContent()) return pageResult.getContent();
        else return new ArrayList<Event>();

    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<Event> findByLevel(String level) {
        return eventRepository.findEventByLevel(level);
    }
}
