package Model.user;

public class Info {

    private String id;
    private String password;
    private boolean isLogin;

    public Info(String loginId, String password, boolean isLogin) {
        this.id = loginId;
        this.password = password;
        this.isLogin = isLogin;
    }

    public String getId() {
        return id;
    }

    public void setId(String loginId) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
