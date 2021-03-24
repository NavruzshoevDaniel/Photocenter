package modules.auth.view.formaterrs;

import javax.swing.text.DefaultFormatter;
import java.text.ParseException;

public class PortFormatter extends DefaultFormatter {
    private static final int MAX_PORT_VALUE = 65535;
    private static final int MIN_PORT_VALUE = 1;

    @Override
    public Object stringToValue(String string) throws ParseException {
        int port;
        try {
            port = Integer.parseInt(string);
            if (!isValidPort(port)) {
                throw new ParseException("The port must fall in the following range: 1 <= value <= 65 535", 0);
            }
        } catch (NumberFormatException e) {
            throw new ParseException(e.getMessage(), 0);
        }
        return port;
    }

    private boolean isValidPort(int port) {
        return MIN_PORT_VALUE <= port && port <= MAX_PORT_VALUE;
    }

    @Override
    public String valueToString(Object port) throws ParseException {
        if (!(port instanceof Integer)) {
            throw new ParseException("Port must be integer value", 0);
        }
        int portValue = (Integer) port;
        return String.valueOf(portValue);
    }
}
