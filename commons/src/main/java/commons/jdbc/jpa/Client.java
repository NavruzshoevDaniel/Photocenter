package commons.jdbc.jpa;

import commons.jdbc.jpa.annotations.Column;
import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import lombok.Setter;
import lombok.ToString;

@Table
@ToString
@Setter
public class Client {
    @Id(name = "id")
    private int id;
    @Column(columnName = "second_name")
    private String secondName;
    private String firstName;
    private String middleName;
    private boolean isProfessional;
    private boolean discount;
}
