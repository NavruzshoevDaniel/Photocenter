package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.NoArgsConstructor;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
@NoArgsConstructor
public class Item implements TableData {
    @Id
    private int id;
    private int firmId;
    private String productName;
    private double price;

    public Item(Mapper mapper) {
        id = mapper.getInteger("id");
        firmId = mapper.getInteger("firm id");
        productName = mapper.getString("product name");
        price = mapper.getDouble("price");
    }

    @Override
    public List<Object> toObjects() {
        final ArrayList<Object> list = new ArrayList<>();
        list.add(id);
        list.add(firmId);
        list.add(productName);
        list.add(price);
        return list;
    }
}
