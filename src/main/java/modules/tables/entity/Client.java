package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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

    public Client(Map<String, Object> parameters) {
        id = (int) parameters.get("id");
        secondName = (String) parameters.get("second name");
        firstName = (String) parameters.get("first name");
        middleName = (String) parameters.get("middle name");
        isProfessional = (boolean) parameters.get("is professional");
        discount = (boolean) parameters.get("discount");
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
