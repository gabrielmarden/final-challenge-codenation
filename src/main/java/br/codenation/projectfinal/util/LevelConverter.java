package br.codenation.projectfinal.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

//@Converter(autoApply = true)
public class LevelConverter implements AttributeConverter<Level,String> {
    @Override
    public String convertToDatabaseColumn(Level level) {
        if(level==null){
            return null;
        }
        return level.getCode();
    }

    @Override
    public Level convertToEntityAttribute(String code) {
        if(code==null) return null;

        return Stream.of(Level.values())
                .filter(l->l.getCode().equals(code)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
