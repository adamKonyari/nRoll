package com.nroll.web.model;

public class Major extends AbstractModel{
    private final String name;

    public Major(int id, String name) {
        super(id);
        this.name = name;
    }
}
