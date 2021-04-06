package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public Job(Map<String, Object> parameters) {
        id = (int) parameters.get("id");
        outletId = Integer.parseInt(String.valueOf(parameters.get("outlet id")));
        professionId =Integer.parseInt(String.valueOf(parameters.get("profession Id")));
        amount = Integer.parseInt(String.valueOf(parameters.get("amount")));
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
