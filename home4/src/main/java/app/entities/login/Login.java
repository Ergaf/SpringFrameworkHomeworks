package app.entities.login;

public class Login {
    String login;
    String pass;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Login{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
