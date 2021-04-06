package modules.tables.entity;

import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.NoArgsConstructor;
import modules.tables.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Table
@NoArgsConstructor
public class Profession implements TableData{
    @Id
    private int id;
    private String profession;

    public Profession(Mapper mapper) {
        id=mapper.getInteger("id");
        profession=mapper.getString("profession");
    }


    @Override
    public List<Object> toObjects() {
        List<Object> list= new ArrayList<>();
        list.add(id);
        list.add(profession);
        return list;
    }
}
