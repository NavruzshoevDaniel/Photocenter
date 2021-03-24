package modules.commons.sessions;


public class ConfigureOracle extends AbstractSessionConfigure {

    @Override
    protected String createUrl(String ip, String port) {
        return "jdbc:oracle:thin:@" + ip + ":" + port + ":XE";
    }
}
