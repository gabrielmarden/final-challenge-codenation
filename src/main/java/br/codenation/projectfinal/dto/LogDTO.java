package br.codenation.projectfinal.dto;

import br.codenation.projectfinal.model.Evento;
import br.codenation.projectfinal.util.Level;

public class LogDTO {

    private String log;
    private Level level;

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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
