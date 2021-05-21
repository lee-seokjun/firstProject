package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.PostsReposytory;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsReposytory postsReposytory;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsReposytory.save(requestDto.toEntity()).getId();
    }
}
