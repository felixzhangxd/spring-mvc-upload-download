package biz.ezcom.spring.mvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = { "/upload" })
public class UploadController {
    @RequestMapping(value = { "/input" })
    public String input() {
        return "/upload/input";
    }

    @RequestMapping(value = { "/submit" }, method = { RequestMethod.POST })
    public String submit(HttpServletRequest req, @RequestParam MultipartFile image) throws IOException {
        String realPath = req.getSession().getServletContext().getRealPath("/upload");
        FileUtils.copyInputStreamToFile(image.getInputStream(), new File(realPath, image.getOriginalFilename()));
        return "/upload/submit";
    }
    
    @RequestMapping(value = { "/submits" }, method = { RequestMethod.POST })
    public String submits(HttpServletRequest req, @RequestParam MultipartFile[] images) throws IOException {
        String realPath = req.getSession().getServletContext().getRealPath("/upload");
        for(MultipartFile image : images) {
            FileUtils.copyInputStreamToFile(image.getInputStream(), new File(realPath, image.getOriginalFilename()));
        }
        return "/upload/submits";
    }
}
