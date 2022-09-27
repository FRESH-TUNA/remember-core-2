package com.remember.core.repositories;

import com.remember.core.domains.Question;
import com.remember.core.requests.QuestionRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionSearchRepository {
    Page<Question> findAllByUserId(Long userId, Pageable pageable, QuestionRequest params);
}
