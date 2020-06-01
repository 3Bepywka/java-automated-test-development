package com.acme.banking.dbo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private List<UUID> accountIds;

    public Client(UUID id, String name, List<UUID> accountIds) {
        if (id == null) throw new IllegalArgumentException();

        this.id = id;
        this.name = name;
        this.accountIds = accountIds;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<UUID> getAccountIds() {
        return accountIds;
    }

    @Override
    public String toString() {
        return String.format("Client: id = %s, name = %s, accountIds = %s", id, name, accountIds.get(0));
    }

    public static class Builder {

        private UUID id;
        private String name;
        private List<UUID> accountIds;

        public Client.Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Client.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Client.Builder setAccountIds(List<UUID> accountIds) {
            this.accountIds = accountIds;
            return this;
        }

        public Client build() {
            return new Client(id, name, accountIds);
        }
    }
}
