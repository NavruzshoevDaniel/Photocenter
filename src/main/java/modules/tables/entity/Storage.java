package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.NoArgsConstructor;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table(tableName = "Storage")
@NoArgsConstructor
public class Storage implements TableData {

    @Id
    private int id;
    private int outletId;
    private int itemId;
    private int balance;

    public Storage(Mapper mapper) {
        id = mapper.getInteger("id");
        outletId = mapper.getInteger("outlet id");
        itemId = mapper.getInteger("item id");
        balance = mapper.getInteger("balance");
    }

    @Override
    public List<Object> toObjects() {
        final ArrayList<Object> list = new ArrayList<>();
        list.add(id);
        list.add(outletId);
        list.add(itemId);
        list.add(balance);
        return list;
    }
}
