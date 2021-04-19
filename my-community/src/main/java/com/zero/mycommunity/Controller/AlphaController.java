package com.zero.mycommunity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class AlphaController {

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response)
    {
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        //响应数据
        response.setContentType("text/html;charset=utf-8");
        try(//java7在try后面添加()就能自动实现流的关闭
                PrintWriter writer=response.getWriter();
        ) {
            writer.write("<h1>hahahah</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
