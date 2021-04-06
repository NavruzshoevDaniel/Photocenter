package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
public class PrintDiscount implements TableData {
    @Id
    private int id;
    private int photoAmount;
    private int discount;

    public PrintDiscount(Mapper mapper) {
        id = mapper.getInteger("id");
        photoAmount = mapper.getInteger("photo amount");
        discount = mapper.getInteger("discount");
    }

    public PrintDiscount() {

    }

    @Override
    public List<Object> toObjects() {
        List<Object> list = new ArrayList<>();
        list.add(id);
        list.add(photoAmount);
        list.add(discount);
        return list;
    }
}
