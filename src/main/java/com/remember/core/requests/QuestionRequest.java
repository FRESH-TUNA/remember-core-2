package com.remember.core.requests;

import com.remember.core.domains.Platform;
import com.remember.core.domains.Question;
import com.remember.core.domains.SolveResult;
import lombok.Data;

import java.util.List;

@Data
public class QuestionRequest {

    private String id;

    private String title;

    private String url;

    private String platform;

    private String solveResult;

    private List<String> algorithms;

    public Question toEntity() {
        return Question.builder()
                .id(Long.valueOf(id))
                .title(title)
                .url(url)
                .platform(Platform.valueOf(platform))
                .solveResult(SolveResult.valueOf(solveResult))
                .build();
    }
}
