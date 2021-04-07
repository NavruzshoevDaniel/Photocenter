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
public class DeveloperOrder implements TableData {
    @Id
    @Column(columnName = "order_id")
    private int id;
    private int filmReceiptId;

    public DeveloperOrder(Mapper mapper) {
        id= mapper.getInteger("order id");
        //TODO::filmReceiptId can be nullable
        filmReceiptId=mapper.getInteger("Film receipt id");
    }

    @Override
    public List<Object> toObjects() {
        final ArrayList<Object> list = new ArrayList<>();
        list.add(id);
        list.add(filmReceiptId);
        return list;
    }
}
