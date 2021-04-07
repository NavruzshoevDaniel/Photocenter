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
public class ServiceOrder implements TableData {

    @Id
    @Column(columnName = "Order_ID")
    private int id;
    private int serviceTypeId;

    public ServiceOrder(Mapper mapper) {
        id = mapper.getInteger("order id");
        serviceTypeId = mapper.getInteger("service type id");
    }

    @Override
    public List<Object> toObjects() {
        final ArrayList<Object> list = new ArrayList<>();
        list.add(id);
        list.add(serviceTypeId);
        return list;
    }
}
