package modules.tables.entity;

import commons.jdbc.jpa.annotations.Column;
import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.NoArgsConstructor;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
@NoArgsConstructor
public class PrintOrder implements TableData {

    @Id
    @Column(columnName = "order_id")
    private int id;
    private int discount;

    public PrintOrder(Mapper mapper) {
        id = mapper.getInteger("order id");
        discount = mapper.getInteger("discount");
    }

    @Override
    public List<Object> toObjects() {
        final ArrayList<Object> list = new ArrayList<>();
        list.add(id);
        list.add(discount);
        return list;
    }
}
