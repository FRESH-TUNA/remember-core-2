package com.remember.core.services;

import com.remember.core.auth.RememberUserDetails;
import com.remember.core.domains.Question;
import com.remember.core.repositories.QuestionRepository;
import com.remember.core.requests.QuestionRequest;
import com.remember.core.responses.QuestionResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Page<Question> findAllByMe(RememberUserDetails userDetail,
                                      Pageable pageable,
                                      QuestionRequest params) {

//        return questionRepository.findAllByUserId(1L, pageable, params)
//                .map(QuestionResponse::ofMe);
        return questionRepository.findAll(pageable);
    }
}
