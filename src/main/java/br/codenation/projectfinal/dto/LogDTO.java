package br.codenation.projectfinal.dto;

import br.codenation.projectfinal.model.Event;

public class LogDTO {

    private String log;
    private String level;

    public LogDTO(Event evento){
        this.log = evento.getLog();
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
