package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.NoArgsConstructor;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
@NoArgsConstructor
public class DeveloperPrice implements TableData {

    @Id
    private int id;
    private String priceName;
    private double price;

    public DeveloperPrice(Mapper mapper) {
        id = mapper.getInteger("id");
        priceName = mapper.getString("Price name");
        price = mapper.getDouble("Price");
    }

    @Override
    public List<Object> toObjects() {
        final ArrayList<Object> list = new ArrayList<>();
        list.add(id);
        list.add(priceName);
        list.add(price);
        return list;
    }
}
