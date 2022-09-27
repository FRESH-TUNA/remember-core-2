package com.remember.core.responses;

import com.remember.core.domains.Algorithm;
import com.remember.core.domains.QuestionAlgorithm;
import com.remember.core.responses.common.HalAbstractResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AlgorithmResponse extends HalAbstractResponse {
    private String name;

    /**
     * of me
     */
    public static AlgorithmResponse ofMe(QuestionAlgorithm algorithm) {
        return ofMe(algorithm.getAlgorithm());
    }

    public static AlgorithmResponse ofMe(Algorithm algorithm) {
        AlgorithmResponse algorithmResponse = new AlgorithmResponse(algorithm.getNAME());
        algorithmResponse.addSelfLink("this is links");
        return algorithmResponse;
    }

    public static List<AlgorithmResponse> ofMe(List<QuestionAlgorithm> algorithmList) {
        return algorithmList.stream().map(AlgorithmResponse::ofMe).collect(Collectors.toList());
    }
}
