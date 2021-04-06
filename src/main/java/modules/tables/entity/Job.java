package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.Data;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
@Data
public class Job implements TableData {
    @Id
    private int id;
    private int outletId;
    private int professionId;
    private int amount;

    public Job() {

    }

    public Job(Mapper parameters) {
        id = parameters.getInteger("id");
        outletId = parameters.getInteger("outlet id");
        professionId = parameters.getInteger("profession Id");
        amount = parameters.getInteger("amount");
    }

    @Override
    public List<Object> toObjects() {
        List<Object> list = new ArrayList<>();
        list.add(id);
        list.add(outletId);
        list.add(professionId);
        list.add(amount);
        return list;
    }
}
