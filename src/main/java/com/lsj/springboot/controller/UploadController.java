package com.lsj.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Administrator on 2019/3/24.
 * @RestController: 返回值是JSON串;@Controller默认转发
 * ### 转发与重定向的区别:
    forward:一次请求、共用request/response、只能转发到项目内的资源、地址不变
    redirect:两次请求、不共用request/response、可以重定向到项目外的资源、地址可变   (redirect:/uploadStatus)
    使用RedirectAttributes在两次请求间共享参数。
 */
// @RestController
@Controller
public class UploadController {

    static final String FILE_INITPATH = "D:/ys/FileUpload/";

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    /**
     * MultipartFile是Spring上传文件的封装类
       在配置文件中也可对相关属性进行配置，基本的配置信息如下：
       spring.http.multipart.max-file-size=1Mb # 最大支持文件大小
       spring.http.multipart.max-request-size=10Mb # 最大支持请求大小
       限制文件上传大小，上传时超过大小会抛出异常：
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws Exception{
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/uploadStatus";
        }
        // ### NIO
        byte[] bytes = file.getBytes();
        Path path = Paths.get(FILE_INITPATH + file.getOriginalFilename());
        Files.write(path, bytes);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded '" + file.getOriginalFilename() + "'");

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
