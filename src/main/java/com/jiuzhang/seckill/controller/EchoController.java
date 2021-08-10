package com.jiuzhang.seckill.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("echo")
public class EchoController {

    @GetMapping("{text}")
    public String echo(
            @PathVariable("text") String text
    ) {
        return text;
    }


}
