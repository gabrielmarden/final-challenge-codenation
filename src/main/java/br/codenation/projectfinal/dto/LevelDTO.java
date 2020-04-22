package br.codenation.projectfinal.dto;


import br.codenation.projectfinal.model.Evento;

import java.util.List;

public class LevelDTO {

    private String level;
    private Integer quantity;
    private List<EventoDTO> eventos;

    public LevelDTO(List<Evento> eventos, String level, Integer quantity){
        this.level = level;
        this.quantity=quantity;
        this.eventos = EventoDTO.listEventosDTO(eventos);
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

    public List<EventoDTO> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoDTO> eventos) {
        this.eventos = eventos;
    }
}
