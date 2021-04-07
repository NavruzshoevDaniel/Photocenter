package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.NoArgsConstructor;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
@NoArgsConstructor
public class Order implements TableData {

    @Id
    private int id;
    private int receiptId;
    private boolean isUrgent;

    public Order(Mapper mapper) {
        id = mapper.getInteger("id");
        receiptId = mapper.getInteger("receipt id");
        isUrgent = mapper.getBoolean("Is urgent");
    }

    @Override
    public List<Object> toObjects() {
        final ArrayList<Object> list = new ArrayList<>();
        list.add(id);
        list.add(receiptId);
        list.add(isUrgent);
        return list;
    }
}
