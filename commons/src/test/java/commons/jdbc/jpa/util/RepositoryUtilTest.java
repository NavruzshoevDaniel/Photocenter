package commons.jdbc.jpa.util;

import commons.jdbc.jpa.Client;
import commons.sessions.SessionFactory;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

class RepositoryUtilTest {
    private static final String DEFAULT_BD_IP = "84.237.50.81";
    private static final String DEFAULT_BD_PORT = "1521";
    private static final String DEFAULT_BD_USERNAME = "18204_Navruzshoev";
    private static final String DEFAULT_BD_PASSWORD = "oracle";

    @Test
    void selectQuery() throws SQLException, IllegalAccessException {
        String url = "jdbc:oracle:thin:@" + DEFAULT_BD_IP + ":" + DEFAULT_BD_PORT + ":XE";
        SessionFactory.registerConnection(DriverManager
                .getConnection(url,
                        DEFAULT_BD_USERNAME, DEFAULT_BD_PASSWORD));
       /* final List<Client> clients = RepositoryUtil.getAll(Client.class);
        System.out.println(clients);
        System.out.println(RepositoryUtil.getColumns(Client.class));*/

        Client client = new Client();
        client.setId(11);
        client.setFirstName("Дэниэль");
        client.setMiddleName("Артурович");
        client.setProfessional(true);
        client.setSecondName("Наврузшоев");
        client.setDiscount(false);
        RepositoryUtil.update(client);
    }
}