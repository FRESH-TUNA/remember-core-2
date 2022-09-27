package com.remember.core.responses;

import com.remember.core.domains.SolveResult;
import com.remember.core.responses.common.HalAbstractResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class SolveResultResponse extends HalAbstractResponse {

    private String status;
    private String color;

    public static SolveResultResponse ofMe(SolveResult solveResult) {
        SolveResultResponse res = new SolveResultResponse(solveResult.getStatus(), solveResult.getColor());
        res.addSelfLink("this is link");
        return res;
    }
}
