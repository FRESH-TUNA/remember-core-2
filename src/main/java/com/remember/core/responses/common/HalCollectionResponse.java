package com.remember.core.responses.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HalCollectionResponse extends HalAbstractResponse {
    private Map<String, Object> _embedded;

    protected HalCollectionResponse() {
        super();
        _embedded = new HashMap<>();
    }

    public void addCollection(String key, Collection<?> collection) {
        _embedded.put(key, collection);
    }

    public Map<String, Object> get_embedded() {
        return _embedded;
    }
}
