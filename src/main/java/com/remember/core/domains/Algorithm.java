package com.remember.core.domains;

import java.util.List;

public enum Algorithm {
    /*
     * datas
     */
    GREDDY("그리디"),
    BFS("너비 우선 탐색"),
    DFS("깊이 우선 탐색"),
    TREE("트리");

    private static List<Algorithm> allList = List.of(Algorithm.values());

    private final String NAME;

    /*
     * constructor
     */
    Algorithm(String NAME) {
        this.NAME = NAME;
    }

    public static List<Algorithm> findAll() {
        return allList;
    }

    public String getNAME() {
        return NAME;
    }
}
