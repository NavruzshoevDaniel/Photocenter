package modules.clients.entity;

import lombok.Data;

@Data
public class Client {
    private int id;
    private String secondName;
    private String firstName;
    private String middleName;
    private boolean isProfessional;
    private int discount;
}
