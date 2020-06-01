package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

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
        System.out.println("SA: " + account.toString());
    }

    @Test
    public void shouldSaveIdWhenSavingAccountCreated() {
        assertThat(account.getId(),
                allOf(
                        equalTo(accountId1),
                        notNullValue()
                ));
    }

    @Test
    public void shouldSaveClientWhenSavingAccountCreated() {
        assertThat(account.getClient(),
                allOf(
                        equalTo(client),
                        notNullValue()
                ));
    }

    @Test
    public void shouldSaveAmountWhenSavingAccountCreated() {
        assertThat(account.getAmount(),
                allOf(
                        equalTo(amount),
                        notNullValue()
                ));
    }

    @Test
    public void shouldReturnClientIdWhenRequest() {
        assertThat(account.getClientId(),
                allOf(
                        equalTo(clientId),
                        notNullValue()
                ));
    }
}
