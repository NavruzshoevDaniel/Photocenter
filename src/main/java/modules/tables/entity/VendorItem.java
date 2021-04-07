package modules.tables.entity;

import commons.jdbc.jpa.annotations.Column;
import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.NoArgsConstructor;
import lombok.ToString;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
@NoArgsConstructor
@ToString
public class VendorItem implements TableData {
    @Id
    @Column(columnName = "vendor_id")
    private int id;
    @Id
    private int itemId;

    public VendorItem(Mapper mapper) {
        id=mapper.getInteger("vendor id");
        itemId=mapper.getInteger("item id");
    }

    @Override
    public List<Object> toObjects() {
        final ArrayList<Object> list = new ArrayList<>();
        list.add(id);
        list.add(itemId);
        return list;
    }
}
