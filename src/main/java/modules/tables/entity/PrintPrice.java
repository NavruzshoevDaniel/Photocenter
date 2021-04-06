package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
public class PrintPrice implements TableData {
    @Id
    private int id;

    private int paperSizeId;
    private int paperTypeId;
    private double price;

    public PrintPrice(Mapper parameters) {
        id = parameters.getInteger("id");
        paperSizeId = parameters.getInteger("paper size id");
        paperTypeId = parameters.getInteger("paper type id");
        price = parameters.getDouble("price");
    }

    public PrintPrice() {
    }


    @Override
    public List<Object> toObjects() {
        List<Object> list = new ArrayList<>();
        list.add(id);
        list.add(paperSizeId);
        list.add(paperTypeId);
        list.add(price);
        return list;
    }
}
