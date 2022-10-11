package com.remember.core.controllers;

import com.remember.core.auth.RememberUserDetails;
import com.remember.core.consts.Urls;
import com.remember.core.domains.Question;
import com.remember.core.requests.QuestionRequest;
import com.remember.core.representationHandlers.QuestionRepresentationHandler;
import com.remember.core.responses.common.HalAbstractResponse;
import com.remember.core.services.QuestionService;
import com.remember.core.utils.RequestInfoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    private final RequestInfoUtil requestInfoUtil;

    @GetMapping(Urls.USERS.ME.QUESTIONS)
    public HalAbstractResponse findAllByMe(Pageable pageable,
                                           @AuthenticationPrincipal RememberUserDetails userDetails,
                                           @ModelAttribute QuestionRequest params) {

        Page<Question> page = questionService.findAllByMe(userDetails, pageable, params);
        return QuestionRepresentationHandler.usersMeQuestions(requestInfoUtil.currentRoot(),
                                                              requestInfoUtil.currentRequest(),
                                                              page);
    }
}
