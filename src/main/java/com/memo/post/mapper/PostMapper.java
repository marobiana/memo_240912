package com.memo.post.mapper;

import com.memo.post.domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostMapper {
    public List<Map<String, Object>> selectPostListTest();
    public List<Post> selectPostListByUserId(int userId);
}
