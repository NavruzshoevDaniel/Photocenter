package modules.auth.controller;

public interface IAuthController {
    void login(String ip, String port, String password, String user);
}
