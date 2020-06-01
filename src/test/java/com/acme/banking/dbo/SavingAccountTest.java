package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import io.qameta.allure.junit4.Tag;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SavingAccountTest {

    private String clientName = "Client Name";
    private UUID accountId1;
    private UUID clientId;
    private double amount;
    private List<UUID> accountIds;

    private Client client;
    private SavingAccount account;

    @Before
    public void initTestData() {
        accountId1 = UUID.randomUUID();
        clientId = UUID.randomUUID();
        accountIds = new ArrayList<>();
        accountIds.add(accountId1);
        amount = RandomUtils.nextDouble();

        Client.Builder clientBuilder = new Client.Builder();
        client = clientBuilder
                .setId(clientId)
                .setName(clientName)
                .setAccountIds(accountIds)
                .build();

        SavingAccount.Builder saBuilder = new SavingAccount.Builder();
        account = saBuilder
                .setId(accountId1)
                .setClient(client)
                .setAmount(amount)
                .build();
    }

    @Category(SmokeTests.class)
    @Test
    public void shouldSaveIdWhenSavingAccountCreated() {
        assertAll("Should return id when requested",
                () -> assertEquals(accountId1, account.getId()),
                () -> assertNotNull(account.getId())
        );
    }

    @Tag("RegressionPack")
    @Test
    public void shouldSaveClientWhenSavingAccountCreated() {
        assertAll("Should return client when requested",
                () -> assertEquals(client, account.getClient()),
                () -> assertNotNull(account.getClient())
        );
    }

    @Tag("RegressionPack")
    @Test
    public void shouldSaveAmountWhenSavingAccountCreated() {
        assertAll("Should return amount when requested",
                () -> assertEquals(amount, account.getAmount(), 0),
                () -> assertNotNull(account.getAmount())
        );
    }

    @Tag("RegressionPack")
    @Test
    public void shouldReturnClientIdWhenRequest() {
        assertAll("Should return clientId when requested",
                () -> assertEquals(clientId, account.getClientId()),
                () -> assertNotNull(account.getClientId())
        );
    }
}
