package com.acme.banking.dbo.domain;

import java.util.UUID;

public class SavingAccount implements Account {
    private UUID id;
    private Client client;
    private double amount;

    public SavingAccount(UUID id, Client client, double amount) {
        if (id == null || id.toString().isEmpty()) throw new IllegalArgumentException("Id can't be null or empty");
        if (client == null) throw new IllegalArgumentException("Client can't be null");

        this.id = id;
        this.client = client;
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public UUID getClientId() {
        return client.getId();
    }

    @Override
    public void withdraw(double amount) {
        //TODO
    }

    @Override
    public void deposit(double amount) {
        //TODO
    }

    @Override
    public String toString() {
        return String.format("SavingAccount: id = %s, client = %s, amount = %s", id, client, amount);
    }

    public static class Builder {

        private UUID id;
        private Client client;
        private double amount;

        public Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder setClient(Client client) {
            this.client = client;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public SavingAccount build() {
            return new SavingAccount(id, client, amount);
        }
    }
}
