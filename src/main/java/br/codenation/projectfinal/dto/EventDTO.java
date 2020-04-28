package br.codenation.projectfinal.dto;

import br.codenation.projectfinal.model.Event;
import br.codenation.projectfinal.util.FormatAndConvertDateToString;

import java.util.ArrayList;
import java.util.List;

public class EventDTO {

    private Long id;
    private String description;
    private String level;
    private String origin;
    private String createdAt;

    public EventDTO(Event event) {
        this.id = event.getId();
        this.description = event.getDescription();
        this.level = event.getLevel();
        this.origin = event.getOrigin();
        this.createdAt = FormatAndConvertDateToString.converter(event.getCreatedAt());
    }

    public static List<EventDTO> listEventosDTO(List<Event> eventos){
        List<EventDTO> eventosDTOS = new ArrayList<EventDTO>();
        eventos.stream().forEach(e->{
            EventDTO eventDTO = new EventDTO(e);
            eventosDTOS.add(eventDTO);
        });

        return eventosDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
