package com.meta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloViewController {
    private static long visitCount = 0;

    @GetMapping("/static-hello")
    public String hello() {
        return "hello.html";
        // 정적 파일이므로 static 폴더가 root
    }

    @GetMapping("html/redirect")
    public String htmlRedirect(){
        return "redirect:/static-hello";
    }

    @GetMapping("html/templates")
    public String htmlTemplates() {
        return "hello-template";
        // prefix로 컨텍스트 경로가 붙는다.
        // surfix로 .html 처럼 정적 페이지 확장자가 자동으로 붙는다.
    }

    @GetMapping("html/dynamic")
    public String htmlDynamic(Model model) {
        visitCount++;
        model.addAttribute("visits", visitCount);
        return "hello-dynamic";
    }
}
