package modules.querymenu.entity;

import lombok.Getter;

@Getter
public class QuiresProperty {
    private final String keyProperty;
    private final String valueProperty;

    public QuiresProperty(String keyProperty, String valueProperty) {
        this.keyProperty = keyProperty;
        this.valueProperty = valueProperty;
    }
}
