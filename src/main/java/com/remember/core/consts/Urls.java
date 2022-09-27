package com.remember.core.consts;

public final class Urls {
    public static class USERS {
        public final static String ROOT = "/users";
        public final static String ME_QUESTIONS = ROOT + "/me/questions";
    }

    public static class QUESTIONS {
        public final static String ROOT = "/questions";
        public final static String ID = ROOT + "/{id}";
    }
}
