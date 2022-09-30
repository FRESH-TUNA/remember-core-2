package com.remember.core.consts;

public final class Urls {
    public static class USERS {
        public final static String ROOT = "/users";

        public static class ME {
            public final static String ROOT = USERS.ROOT + "/me";
            public final static String QUESTIONS = ROOT + "/questions";
        }
    }

    public static class QUESTIONS {
        public final static String ROOT = "/questions";
        public final static String ID = ROOT + "/{id}";
    }
}
