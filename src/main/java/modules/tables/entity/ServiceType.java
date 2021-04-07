package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.NoArgsConstructor;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
@NoArgsConstructor
public class ServiceType implements TableData {

    @Id
    private int id;
    private String name;
    private double price;

    public ServiceType(Mapper mapper) {
        id = mapper.getInteger("id");
        name = mapper.getString("name");
        price = mapper.getDouble("price");
    }

    @Override
    public List<Object> toObjects() {
        final ArrayList<Object> objects = new ArrayList<>();
        objects.add(id);
        objects.add(name);
        objects.add(price);
        return objects;
    }
}
