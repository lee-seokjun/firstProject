package com.jojoldu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsReposytory postsReposytory;

    @After
    public void cleanup(){
        postsReposytory.deleteAll();
    }
    @Test
    public void 게시글저장_불러오기(){
        String title= "테스트 게시글";
        String content= "테스트 본문";
        postsReposytory.save(Posts.builder().title(title).content(content).author("jojoldu@gmail.com").build());

        List<Posts> postslist = postsReposytory.findAll();

        Posts posts= postslist.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }


}
