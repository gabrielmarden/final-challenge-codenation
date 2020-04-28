package br.codenation.projectfinal.dto;


import br.codenation.projectfinal.model.Event;

import java.util.List;

public class LevelDTO {

    private String level;
    private Integer quantity;
    private List<EventDTO> events;

    public LevelDTO(List<Event> events, String level, Integer quantity){
        this.level = level;
        this.quantity=quantity;
        this.events = EventDTO.listEventosDTO(events);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantityOfLevel) {
        this.quantity = quantityOfLevel;
    }

    public List<EventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<EventDTO> events) {
        this.events = events;
    }
}
