package app.controller;

import app.entities.login.Login;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public Login login(@RequestBody Login login){
        System.out.println(login);
        return login;
    }
}
