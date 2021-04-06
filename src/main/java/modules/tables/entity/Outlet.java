package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
public class Outlet implements TableData {
    @Id
    private int id;
    private int typeId;
    private int relatedOutletId;
    private String address;

    public Outlet(Mapper mapper) {
        id = mapper.getInteger("id");
        typeId = mapper.getInteger("type id");
        relatedOutletId = mapper.getInteger("related outlet id");
        address = mapper.getString("address");
    }

    public Outlet() {
    }

    @Override
    public List<Object> toObjects() {
        List<Object> list = new ArrayList<>();
        list.add(id);
        list.add(typeId);
        list.add(relatedOutletId);
        list.add(address);
        return list;
    }
}
