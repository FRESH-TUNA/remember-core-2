package com.remember.core.responses;

import com.remember.core.domains.Platform;
import com.remember.core.responses.common.HalAbstractResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PlatformResponse extends HalAbstractResponse {

    private String name;
    private String url;

    public static PlatformResponse ofMe(Platform platform) {
        PlatformResponse res = new PlatformResponse(platform.getNAME(), platform.getURL());
        res.addSelfLink("this is link");
        return res;
    }
}
