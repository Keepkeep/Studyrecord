package com.studysecurity.VerifyCode.controller;

import com.studysecurity.VerifyCode.until.VerifyCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/vercode")
public class VerifyCodeController {
    @RequestMapping("/get")
    public void  getcode(HttpServletRequest rq, HttpServletResponse resp) throws IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        String text = verifyCode.getText();
        HttpSession session = rq.getSession();
        session.setAttribute("index_code",text);
        VerifyCode.output(image,resp.getOutputStream());
    }
}
