package modules.auth.controller;

import lombok.extern.slf4j.Slf4j;
import modules.auth.router.AuthRouter;
import modules.auth.router.IAuthRouter;
import modules.auth.service.AuthService;
import modules.auth.service.IAuthService;
import modules.auth.view.IAuthView;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class AuthController implements IAuthController {
    private final IAuthRouter router;
    private final IAuthService authService = new AuthService();
    private IAuthView view;

    public AuthController(IAuthView view) {
        router = new AuthRouter();
        this.view = view;
    }

    @Override
    public void login(String ip, String port, String password, String user) {
        try {
            Connection connection = authService.login(ip, port, user, password);
            connection.close();
            router.routeToMenu(view.getJFrame());
        } catch (SQLException throwable) {
            log.warn("", throwable);
            view.showErrorConnectMessage(throwable.getMessage());
        }
    }

    public void setView(IAuthView view) {
        this.view = view;
    }
}
