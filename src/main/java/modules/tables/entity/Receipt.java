package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.NoArgsConstructor;
import modules.tables.mapper.Mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Table
@NoArgsConstructor
public class Receipt implements TableData {

    @Id
    private int id;
    private int clientId;
    private int outletId;
    private Date currentDate;
    private double total;

    public Receipt(Mapper mapper) {
        id = mapper.getInteger("id");
        clientId = mapper.getInteger("client id");
        outletId = mapper.getInteger("outlet id");
        currentDate = mapper.getDate("current date");
        total = mapper.getDouble("total");
    }

    @Override
    public List<Object> toObjects() {
        final ArrayList<Object> list = new ArrayList<>();
        list.add(id);
        list.add(clientId);
        list.add(outletId);
        list.add(currentDate);
        list.add(total);
        return list;
    }
}
