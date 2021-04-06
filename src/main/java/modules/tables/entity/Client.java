package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.Data;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;


@Data
@Table
public class Client implements TableData {
    @Id
    private int id;
    private String secondName;
    private String firstName;
    private String middleName;
    private boolean isProfessional;
    private boolean discount;

    public Client() {

    }

    public Client(Mapper parameters) {
        id = parameters.getInteger("id");
        secondName = parameters.getString("second name");
        firstName = parameters.getString("first name");
        middleName = parameters.getString("middle name");
        isProfessional = parameters.getBoolean("is professional");
        discount = parameters.getBoolean("discount");
    }

    public List<Object> toObjects() {
        List<Object> list = new ArrayList<>();
        list.add(id);
        list.add(secondName);
        list.add(firstName);
        list.add(middleName);
        list.add(isProfessional);
        list.add(discount);
        return list;
    }
}
