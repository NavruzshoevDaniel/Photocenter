package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.NoArgsConstructor;
import modules.tables.mapper.Mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Table(tableName = "Deliveries")
@NoArgsConstructor
public class Delivery implements TableData {
    @Id
    private int id;
    private int outletId;
    private int itemId;
    private int vendorId;
    private int amount;
    private Date deliveryDate;
    private double purchasePrice;

    public Delivery(Mapper mapper) {
        id = mapper.getInteger("id");
        outletId = mapper.getInteger("outlet id");
        itemId = mapper.getInteger("item id");
        vendorId = mapper.getInteger("vendor id");
        amount = mapper.getInteger("amount");
        deliveryDate = mapper.getDate("delivery Date");
        purchasePrice = mapper.getDouble("purchase Price");
    }

    @Override
    public List<Object> toObjects() {
        final ArrayList<Object> list = new ArrayList<>();
        list.add(id);
        list.add(outletId);
        list.add(itemId);
        list.add(vendorId);
        list.add(amount);
        list.add(deliveryDate);
        list.add(purchasePrice);
        return list;
    }
}
