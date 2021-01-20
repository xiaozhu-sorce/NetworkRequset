package com.bignerdranch.android.networkrequest;

public class Translation {
    private int status;

    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    private content content;

    public void show(){
        System.out.println(status);
        System.out.println(content.from);
        System.out.println(content.to);
        System.out.println(content.vendor);
        System.out.println(content.out);
        System.out.println(content.errNo);
    }

}
