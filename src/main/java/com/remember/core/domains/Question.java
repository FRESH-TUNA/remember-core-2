package com.remember.core.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
public class Question extends RememberAbstractDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 255, nullable = false)
    private String url;

    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Enumerated(EnumType.STRING)
    private SolveResult solveResult;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuestionAlgorithm> algorithms = new ArrayList<>();

    /*
     * user
     */
    @Column
    private Long userId;

    /*
     * methods
     */
    public void partial_update(Question updated) {
        if(updated.solveResult != null)
            this.solveResult = updated.solveResult;
    }

    public void updateAlgorithms(List<Algorithm> algorithms) {
        this.algorithms = algorithms.stream()
                .map(a -> QuestionAlgorithm.builder().algorithm(a).question(this).build())
                .collect(Collectors.toList());
    }

    /*
     * contructors
     */
    @Builder
    private Question(
            Long id,
            String title,
            String url,
            Platform platform,
            SolveResult solveResult,
            Long userId,
            List<QuestionAlgorithm> algorithms) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.platform = platform;
        this.solveResult = solveResult;
        this.userId = userId;
        this.algorithms = algorithms;
    }
}
