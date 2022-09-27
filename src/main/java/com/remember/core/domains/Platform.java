package com.remember.core.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

public enum Platform {
    /*
     * datas
     */
    PROGRAMMERS("프로그래머스", "url"),
    BEAKJOON("백준", "url2");

    private static List<Platform> allList = List.of(Platform.values());

    private final String NAME;
    private final String URL;

    /*
     * constructor
     */
    Platform(String NAME, String URL) {
        this.NAME = NAME;
        this.URL = URL;
    }

    public String getNAME() {
        return NAME;
    }

    public String getURL() {
        return URL;
    }

    public static List<Platform> findAll() {
        return allList;
    }
}
