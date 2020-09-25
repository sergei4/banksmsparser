package com.skmmobile.banksmsparser;

public class BankItem {
    private String id;
    private String name;

    public BankItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
