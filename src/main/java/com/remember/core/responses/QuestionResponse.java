package com.remember.core.responses;

import com.remember.core.domains.Question;
import com.remember.core.responses.common.HalAbstractResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class QuestionResponse extends HalAbstractResponse {
    private Long id;

    private String title;

    private String url;

    private PlatformResponse platform;

    private SolveResultResponse solveResult;

    private List<AlgorithmResponse> algorithms;

    public static QuestionResponse of(Question question,
                                      PlatformResponse platformResponse,
                                      SolveResultResponse solveResultResponse,
                                      List<AlgorithmResponse> algorithmResponses) {
        return new QuestionResponse(
                question.getId(),
                question.getTitle(),
                question.getUrl(),
                platformResponse,
                solveResultResponse,
                algorithmResponses);
    }

    public static QuestionResponse ofMe(Question question) {
        PlatformResponse platformResponse = PlatformResponse.ofMe(question.getPlatform());
        SolveResultResponse solveResultResponse = SolveResultResponse.ofMe(question.getSolveResult());
        List<AlgorithmResponse> algorithms = AlgorithmResponse.ofMe(question.getAlgorithms());
        return of(question, platformResponse, solveResultResponse, algorithms);
    }
}
