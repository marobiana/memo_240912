package com.memo.post.bo;

import com.memo.common.FileManagerService;
import com.memo.post.domain.Post;
import com.memo.post.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor  // DI, 생성자 주입
@Service
public class PostBO {

    private final PostMapper postMapper;
    private final FileManagerService fileManager;
    //private Logger log = LoggerFactory.getLogger(PostBO.class);
    //private Logger log = LoggerFactory.getLogger(this.getClass());

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

    // i: postId, userId
    // o: Post or null
    public Post getPostByPostIdUserId(int postId, int userId) {
        return postMapper.selectPostByPostIdUserId(postId, userId);
    }

    // i: userId, userLoginId, subject, content, file
    // o: int(성공 행 개수)
    public int addPost(int userId, String userLoginId,
                       String subject, String content, MultipartFile file) {

        String imagePath = null;

        // 파일 존재시 업로드
        if (file != null) {
            imagePath = fileManager.uploadFile(file, userLoginId);
        }

        return postMapper.insertPost(userId, subject, content, imagePath);
    }

    public void updatePostByPostIdUserId(int userId, String userLoginId,
                                         int postId, String subject, String content,
                                         MultipartFile file) {

        // 기존글 가져오기 - 1. 이미지 교체시 기존 이미지 제거 위해   2. 대상 존재 확인(생략 가능)
        Post post = postMapper.selectPostByPostIdUserId(postId, userId);
        if (post == null) {
            log.warn("[### 글 수정] post is null. postId:{}, userId:{}", postId, userId);
            return;
        }

        // 파일 존재 시 이미지 업로드
        String imagePath = null;
        if (file != null) {

        }

        // DB update
    }
}
