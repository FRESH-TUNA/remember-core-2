package com.remember.core.repositories;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.remember.core.domains.Algorithm;
import com.remember.core.domains.QQuestion;
import com.remember.core.domains.Question;
import com.remember.core.domains.SolveResult;
import com.remember.core.requests.QuestionRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class QuestionSearchRepositoryQueryDSLImpl
        extends QuerydslRepositorySupport
        implements QuestionSearchRepository{

    private final JPAQueryFactory queryFactory;

    public QuestionSearchRepositoryQueryDSLImpl(JPAQueryFactory queryFactory) {
        super(Question.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<Question> findAllByUserId(Long userId, Pageable pageable, QuestionRequest params) {
        Predicate predicate = QuestionPredicateFactory.generate(params);
        QQuestion question = QQuestion.question;

        Long totalCounts = queryFactory
                .select(question.count())
                .from(question)
                .leftJoin(question.algorithms)
                .on(predicate).on(question.userId.eq(userId)).fetchJoin()
                .fetchOne();

        JPAQuery<Question> query = queryFactory
                .selectDistinct(question)
                .from(question)
                .leftJoin(question.algorithms)
                .on(predicate).on(question.userId.eq(userId)).fetchJoin();

        List<Question> questions = getQuerydsl().applyPagination(pageable, query).fetch();
        return new PageImpl<>(questions, pageable, totalCounts);
    }

    /**
     * Predicate factory
     */
    private static class QuestionPredicateFactory {
        public static Predicate generate(QuestionRequest params){
            System.out.println("hohohohohoho");
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            booleanBuilder.and(titleEq(params.getTitle()));
            booleanBuilder.and(solveResultEq(params.getSolveResult()));
            booleanBuilder.and(algorithmIdsIn(params.getAlgorithms()));

            return booleanBuilder;
        }

        private static BooleanExpression titleEq(String title) {
            return title == null ? null: QQuestion.question.title.contains(title);
        }

        private static BooleanExpression solveResultEq(String status) {
            if(Objects.isNull(status)) return null;
            else return QQuestion.question.solveResult.eq(SolveResult.valueOf(status));
        }

        private static BooleanExpression algorithmIdsIn(List<String> algorithms) {
            if(Objects.isNull(algorithms) || algorithms.isEmpty()) return null;
            else return QQuestion.question.algorithms.any().algorithm
                    .in(algorithms.stream().map(Algorithm::valueOf).collect(Collectors.toList()));
        }
    }
}
