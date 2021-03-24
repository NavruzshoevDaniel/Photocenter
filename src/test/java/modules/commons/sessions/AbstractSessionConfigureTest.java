package modules.commons.sessions;


import java.io.IOException;

class AbstractSessionConfigureTest {

    @org.junit.jupiter.api.Test
    void configure() throws IOException {

        AbstractSessionConfigure configure = new ConfigureOracle();
        configure.configure("84.237.50.81", "1521", "18204_Navruzshoev", "oracle");

    }
}