package com.lsj.springboot.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

/**
 * Created by 10326 on 2020/2/28.
 * 全局的异常处理机制
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 用来监控Multipart上传的文件大小是否受限，当出现此异常时在前端页面给出提示。
     * @param e
     * @param redirectAttributes
     * @return
     */
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:/uploadStatus";
    }

    @ExceptionHandler(IOException.class)
    public String handleError2(IOException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:/uploadStatus";
    }

}
