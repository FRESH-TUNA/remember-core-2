package com.remember.core.utils;

import com.remember.core.domains.Algorithm;
import com.remember.core.domains.Platform;
import com.remember.core.domains.Question;
import com.remember.core.domains.SolveResult;
import com.remember.core.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class Initalizer {
    private final QuestionRepository questionRepository;

    @PostConstruct
    public void initQuestions() {
        int count = 5;
        long userId = 1L;

        String[] titles = new String[] {
                "문제1", "문제1", "문제1", "문제1", "문제1"
        };

        String[] urls = new String[] {
                "링크1", "링크2", "링크3", "링크4", "링크5"
        };

        Platform[] platforms = new Platform[] {
                Platform.BEAKJOON, Platform.PROGRAMMERS, Platform.BEAKJOON, Platform.PROGRAMMERS, Platform.BEAKJOON
        };

        SolveResult[] solveResults = new SolveResult[] {
                SolveResult.FAIL, SolveResult.GOOD, SolveResult.GREAT, SolveResult.PERFECT, SolveResult.GOOD
        };

        Algorithm[][] algorithms =  new Algorithm[][] {
            {Algorithm.BFS}, {Algorithm.DFS}, {Algorithm.TREE}, {Algorithm.GREDDY}, {Algorithm.DFS, Algorithm.BFS}
        };

        for (int i = 0; i < count; ++i) {
            Question question = Question.builder()
                    .title(titles[i])
                    .url(urls[i])
                    .platform(platforms[i])
                    .solveResult(solveResults[i])
                    .userId(userId)
                    .build();

            question.updateAlgorithms(Arrays.stream(algorithms[i]).toList());
            createQuestion(question);
        }
    }

    @Transactional
    public void createQuestion(Question question) {
        questionRepository.save(question);
    }
}
