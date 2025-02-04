package com.api.pay.enums;

public enum AccountType {
    CLIENT(1,"USUARIO"),
    MERCHANT(2, "MERCADOR");

    private final Integer value;
    private final String description;

    AccountType(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public AccountType getAccountType(Integer value) {
        for (AccountType accountType : AccountType.values()) {
            if (accountType.value.equals(value)) {
                return accountType;
            }
        }
        return null;
    }
}
