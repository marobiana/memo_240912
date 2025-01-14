package com.memo.post.bo;

import com.memo.post.domain.Post;
import com.memo.post.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor  // DI, 생성자 주입
@Service
public class PostBO {

    private final PostMapper postMapper;
//    private final UserBO userBO;
//
//    public PostBO(PostMapper postMapper, UserBO userBO) {
//        this.postMapper = postMapper;
//        this.userBO = userBO;
//    }

    // i: userId
    // o: List<Post>
    public List<Post> getPostListByUserId(int userId) {
        return postMapper.selectPostListByUserId(userId);
    }
}
