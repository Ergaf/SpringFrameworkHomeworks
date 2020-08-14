package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String getTest() throws IOException, URISyntaxException {
        System.out.println("запрос основной страницы с сервера");
        Path path = Paths.get(getClass().getResource("/templates/index.html").toURI());
        byte[] data = Files.readAllBytes(path);

        return new String(data);
    }

    @GetMapping("/js/index.js")
    @ResponseBody
    public String getJs() throws IOException, URISyntaxException {
        System.out.println("запрос за js на сервак");
        Path path = Paths.get(getClass().getResource("/templates/js/indexOld.js").toURI());
        byte[] data = Files.readAllBytes(path);

        return new String(data);
    }

    @GetMapping("/css/style.css")
    @ResponseBody
    public String getCss() throws IOException, URISyntaxException {
        System.out.println("запрос за css на сервак");
        Path path = Paths.get(getClass().getResource("/templates/css/style.css").toURI());
        byte[] data = Files.readAllBytes(path);

        return new String(data);
    }
}
