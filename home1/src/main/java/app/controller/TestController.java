package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.Attribute;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestController {

    @GetMapping("/111")
//    @ResponseBody
    public String getTest() {
//        Path path = Paths.get(getClass().getResource("/templates/upload.html").toURI());
//        byte[] data = Files.readAllBytes(path);
//
//        return new String(data);

        return "upload";
    }

    @PostMapping("/upload111")
//    @ResponseBody
    public String upload(HttpServletRequest request) throws IOException, ServletException {
        System.out.println("upload");
        //создаем лист партсов из реквеста(файлов которые передает клиент)
        List<Part> part = (List<Part>) request.getParts();

        List<String> filesName = new ArrayList<>();
        //в цикле вызываем функцию записи куда-либо
        for(Part partThis: part){
            String name = save(partThis);
            filesName.add(name);
        }
        return "redirect:/uploadS111";
    }

    @GetMapping("/uploadS111")
    public String uploadS(){
        return "uploadS";
    }

    //максимальный размер загружаемого файла выставляеться в файле
    //application.properties
    //строчками:
    //spring.servlet.multipart.max-file-size=100MB
    //spring.servlet.multipart.max-request-size=100MB

    String save(Part part){
        //папка Temp на винде и ее аналоги на других системах, получение на джаве
        String tempDir = System.getProperty("java.io.tmpdir");
        //трай виз ресурс. создаю стрим читающий байты из файла
        try(InputStream in = part.getInputStream()){
            //создаю стрим записи байт в файл
            OutputStream out = new FileOutputStream(new File(tempDir, part.getSubmittedFileName()));
            //создаю массив байт. все которые возможно прочитать
            byte[] data = new byte[in.available()];
            //говорю считать стримом данные в массив байт
            in.read(data);
            //говорю записать данные стримом в файл из массива байт
            out.write(data);
            //закрываю стрим чтоб файл был доступен для изменения другими программами
            out.close();
            System.out.println("загрузило!");
            return part.getSubmittedFileName();
        } catch (Exception ex){
            ex.printStackTrace();
            return ex.toString();
        }
    }
}
