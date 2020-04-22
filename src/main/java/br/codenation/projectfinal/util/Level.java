package br.codenation.projectfinal.util;

public enum Level {
    ERROR("error"), WARNING("warning"),INFO("info");

    private String code;

    Level(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
