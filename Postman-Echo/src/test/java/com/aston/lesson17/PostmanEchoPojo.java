package com.aston.lesson17;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties
public class PostmanEchoPojo {
    private String foo1;
    private String foo2;

    public PostmanEchoPojo() {
    }

    public PostmanEchoPojo(String foo1, String foo2) {
        this.foo1 = foo1;
        this.foo2 = foo2;
    }

    public String getFoo1() {
        return foo1;
    }

    public String getFoo2() {
        return foo2;
    }

    public void setFoo1(String foo1) {
        this.foo1 = foo1;
    }

    public void setFoo2(String foo2) {
        this.foo2 = foo2;
    }
}



