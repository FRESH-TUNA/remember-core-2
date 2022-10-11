package com.remember.core.representationHandlers;

import com.remember.core.consts.Urls;
import com.remember.core.domains.Question;
import com.remember.core.responses.QuestionResponse;
import com.remember.core.responses.common.HalAbstractResponse;
import com.remember.core.responses.common.HalPageResponse;
import com.remember.core.utils.UrlBuilder;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

public class QuestionRepresentationHandler {
    public static HalAbstractResponse question(String selfUrl, Question question) {
        QuestionResponse response = QuestionResponse.ofMe(question);
        response.addSelfLink(selfUrl);
        return response;
    }

    public static HalAbstractResponse usersMeQuestions(String root,
                                                       String selfUrl,
                                                       Page<Question> page) {
        Map<String, String> args = new HashMap<>();

        Page<HalAbstractResponse> collection = page.map(question -> {
            args.put("id", question.getId().toString());
            return question(UrlBuilder.builder().ofRoot(root).ofPath(Urls.QUESTIONS.ID, args).build(), question);
        });

        HalPageResponse response = HalPageResponse.ofPage("questions", collection);
        response.addSelfLink(selfUrl);
        return response;
    }
}
