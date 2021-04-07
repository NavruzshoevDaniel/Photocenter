package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.NoArgsConstructor;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
@NoArgsConstructor
public class Frame implements TableData {

    @Id
    private int id;
    private int printOrderId;
    private int paperSizeId;
    private int paperTypeId;
    private String frameCode;
    private int amount;

    public Frame(Mapper mapper) {
        id = mapper.getInteger("id");
        printOrderId = mapper.getInteger("print Order Id");
        paperSizeId = mapper.getInteger("paper Size Id");
        paperTypeId = mapper.getInteger("paper type Id");
        frameCode = mapper.getString("frame code");
        amount = mapper.getInteger("amount");
    }


    @Override
    public List<Object> toObjects() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(id);
        list.add(printOrderId);
        list.add(paperSizeId);
        list.add(paperTypeId);
        list.add(frameCode);
        list.add(amount);
        return list;
    }
}
