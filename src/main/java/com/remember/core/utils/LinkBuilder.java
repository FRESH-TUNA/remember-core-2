package com.remember.core.utils;

import java.util.Map;

public class LinkBuilder {
    private static final Object[] BLANK_ARGS = new Object[0];

    private static String mapFormat(String template, Map<String, String> mapSet) {
        String res = template;
        for (String key : mapSet.keySet()) {
            res = template.replace(String.format("{%s}", key), mapSet.get(key));
        }
        return res;
    }

    public static String buildLink(String context, String template) {
        return context + template;
    }

    public static String buildLink(String context, String template, Map<String, String> args) {
        return context + mapFormat(template, args);
    }
}
