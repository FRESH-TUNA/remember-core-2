package com.remember.core.responses.common;

import org.springframework.data.domain.Page;

public class HalPageResponse extends HalCollectionResponse {
    private static final class COLLECTION_KEY {
        private static final String QUESTIONS = "questions";
    }

    private PageInfo page;

    public static HalPageResponse ofQuestionPage(Page<?> page) {
        return ofPage(COLLECTION_KEY.QUESTIONS, page);
    }

    public static HalPageResponse ofPage(String key, Page<?> page) {
        HalPageResponse response = new HalPageResponse();

        response.addCollection(key, page.getContent());
        response.page = PageInfo.ofPage(page);
        return response;
    }

    public PageInfo getPage() {
        return page;
    }
}
