package com.remember.core.responses.common;

import java.util.List;

/**
 * for page response
 */
public class PageResponse<T>  {
    private List<T> elements;
    private PageInfo page;
}
