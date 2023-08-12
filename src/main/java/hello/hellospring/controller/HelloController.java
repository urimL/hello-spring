package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /*정적 컨텐츠*/
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello";
    }

    /*mvc와 템플릿 엔진*/
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }

    /*API*/
    //문자 전달
    @GetMapping("hello-string")
    @ResponseBody //http에서 헤더부, 바디부 중 바디부에 데이터를 직접 넣는다.
    public String helloSting(@RequestParam("name") String name) {
        return "hello " + name;
    }

    //문자가 아닌 데이터를 전달
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
