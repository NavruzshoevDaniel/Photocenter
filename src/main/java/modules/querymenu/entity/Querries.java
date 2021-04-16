package modules.querymenu.entity;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Getter
public class Querries implements IQuarries {
    private static final Path QUARRIES_NAMES = Paths.get("queries", "queriesNames.properties");
    private final List<QuiresProperty> quiresProperties = new ArrayList<>();

    public Querries() throws IOException {
        Properties quarriesNamesProperties = new Properties();
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(QUARRIES_NAMES.toString());
        Objects.requireNonNull(resourceAsStream, "Cant found " + QUARRIES_NAMES);
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8);
        quarriesNamesProperties.load(inputStreamReader);
        quiresProperties.addAll(
                quarriesNamesProperties.stringPropertyNames()
                        .stream()
                        .map(key -> new QuiresProperty(key, quarriesNamesProperties.getProperty(key)))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public String getPropertyKeyBy(String value) {
        return quiresProperties.stream()
                .filter(quiresProperty -> quiresProperty.getValueProperty().equals(value))
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                .getKeyProperty();
    }

    @Override
    public List<String> getQuarriesNames() {
        return quiresProperties.stream()
                .map(QuiresProperty::getValueProperty)
                .collect(Collectors.toList());
    }
}
