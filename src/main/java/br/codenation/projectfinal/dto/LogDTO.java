package br.codenation.projectfinal.dto;

import br.codenation.projectfinal.model.Evento;

public class LogDTO {

    private String log;
    private String level;

    public LogDTO(Evento evento){
        this.log = evento.getLogDeEvento();
        this.level = evento.getLevel();
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
