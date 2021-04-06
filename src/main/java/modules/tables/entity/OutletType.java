package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
public class OutletType implements TableData {

    @Id
    private int id;
    private String name;

    public OutletType(Mapper mapper) {
        id = mapper.getInteger("id");
        name = mapper.getString("name");
    }

    public OutletType() {
    }


    @Override
    public List<Object> toObjects() {
        List<Object> list = new ArrayList<>();
        list.add(id);
        list.add(name);
        return list;
    }
}
