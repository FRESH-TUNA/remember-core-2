package com.remember.core.controllers;

import com.remember.core.auth.RememberUserDetails;
import com.remember.core.consts.Urls;
import com.remember.core.requests.QuestionRequest;
import com.remember.core.responses.common.HalPageResponse;
import com.remember.core.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping(Urls.USERS.ME_QUESTIONS)
    public HalPageResponse findAllByMe(Pageable pageable,
                                       @AuthenticationPrincipal RememberUserDetails userDetails,
                                       @ModelAttribute QuestionRequest params) {
        return HalPageResponse.ofPage("questions", questionService.findAllByMe(userDetails, pageable, params));
    }
}
