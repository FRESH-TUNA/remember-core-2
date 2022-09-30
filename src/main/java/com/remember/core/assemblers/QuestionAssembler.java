package com.remember.core.assemblers;

import com.remember.core.consts.Urls;
import com.remember.core.domains.Question;
import com.remember.core.responses.QuestionResponse;
import com.remember.core.responses.common.HalAbstractResponse;
import com.remember.core.responses.common.HalPageResponse;
import com.remember.core.utils.LinkBuilder;
import com.remember.core.utils.ServletContextUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class QuestionAssembler {
    public HalAbstractResponse question(Question question) {
        QuestionResponse response = QuestionResponse.ofMe(question);

        Map<String, String> args = new HashMap<>();
        args.put("id", question.getId().toString());

        String selfLink = LinkBuilder.buildLink(ServletContextUtil.currentContext(), Urls.QUESTIONS.ID, args);
        response.addSelfLink(selfLink);
        return response;
    }

    public HalAbstractResponse usersMeQuestions(Page<Question> page) {
        Page<HalAbstractResponse> collection = page.map(question -> question(question));
        HalPageResponse response = HalPageResponse.ofPage("questions", collection);
        String selfLink = ServletContextUtil.currentRequestContext();
        response.addSelfLink(selfLink);
        return response;
    }
}
