package com.memo.post;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/post")
@RestController
public class PostRestController {

    @PostMapping("/create")
    public Map<String, Object> create(
            @RequestParam("subject") String subject,
            @RequestParam("content") String content,
            HttpSession session
    ) {
        // 글쓴이 번호 꺼내기
        int userId = (int)session.getAttribute("userId");

        // db insert
        
        // 응답값
    }
}
