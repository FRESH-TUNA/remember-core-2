package com.remember.core.responses.common;

import java.util.HashMap;
import java.util.Map;

public abstract class HalAbstractResponse {
    private final static String SELF_RELATION = "self";

    private Map<String, String> _links;

    protected HalAbstractResponse() {
        this._links = new HashMap<>();
    }

    public void addLink(String relation, String url) {
        this._links.put(relation, url);
    }

    public void addSelfLink(String url) {
        addLink(SELF_RELATION, url);
    }

    public Map<String, String> get_links() {
        return _links;
    }
}
