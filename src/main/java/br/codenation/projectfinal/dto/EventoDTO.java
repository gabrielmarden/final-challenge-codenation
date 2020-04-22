package br.codenation.projectfinal.dto;

import br.codenation.projectfinal.model.Evento;
import br.codenation.projectfinal.util.FormatAndConvertDateToString;

import java.util.ArrayList;
import java.util.List;


public class EventoDTO{

    private Long id;
    private String descricao;
    private String level;
    private String origem;
    private String dataDeCriacao;

    public EventoDTO(Evento evento) {
        this.id = evento.getId();
        this.descricao = evento.getDescricao();
        this.level = evento.getLevel();
        this.origem = evento.getOrigem();
        this.dataDeCriacao = FormatAndConvertDateToString.converter(evento.getCreatedAt());
    }

    public static List<EventoDTO> listEventosDTO(List<Evento> eventos){
        List<EventoDTO> eventosDTOS = new ArrayList<EventoDTO>();
        eventos.stream().forEach(e->{
            EventoDTO eventoDTO = new EventoDTO(e);
            eventosDTOS.add(eventoDTO);
        });

        return eventosDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(String dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }
}
