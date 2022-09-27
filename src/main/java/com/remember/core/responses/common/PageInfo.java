package com.remember.core.responses.common;

import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class PageInfo {
    private Long number;
    private Long size;
    private Long totalPages;
    private Long curPageCounts;
    private Long totalCount;

    public PageInfo(Long number, Long size, Long totalPages, Long curPageCounts, Long totalCount) {
        this.number = number;
        this.size = size;
        this.totalPages = totalPages;
        this.curPageCounts = curPageCounts;
        this.totalCount = totalCount;
    }

    public static PageInfo ofPage(Page<?> page) {
        return new PageInfo(
                (long) page.getNumber(),
                (long) page.getSize(),
                (long) page.getTotalPages(),
                (long) page.getNumberOfElements(),
                page.getTotalElements());
    }
}
