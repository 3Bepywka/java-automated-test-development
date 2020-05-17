package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SavingAccountTest {

    private UUID accountId;
    private UUID clientId;
    private double amount;
    private String clientName;
    private Client client;

    @Before
    public void initTestData() {
        accountId = UUID.randomUUID();
        clientId = UUID.randomUUID();
        amount = RandomUtils.nextDouble();
        clientName = "Test Name";
        client = new Client(clientId, clientName);
    }

    @Test
    public void shouldSaveIdWhenSavingAccountCreated() {
        SavingAccount savingAccount = new SavingAccount(accountId, client, amount);

        assertThat(savingAccount.getId(),
                allOf(
                        equalTo(accountId),
                        notNullValue()
                ));
    }

    @Test
    public void shouldSaveClientWhenSavingAccountCreated() {

        SavingAccount savingAccount = new SavingAccount(accountId, client, amount);

        assertThat(savingAccount.getClient(),
                allOf(
                        equalTo(client),
                        notNullValue()
                ));
    }

    @Test
    public void shouldSaveAmountWhenSavingAccountCreated() {

        SavingAccount savingAccount = new SavingAccount(accountId, client, amount);

        assertThat(savingAccount.getAmount(),
                allOf(
                        equalTo(amount),
                        notNullValue()
                ));
    }

    @Test
    public void shouldReturnClientIdWhenRequest() {

        SavingAccount savingAccount = new SavingAccount(accountId, client, amount);

        assertThat(savingAccount.getClientId(),
                allOf(
                        equalTo(clientId),
                        notNullValue()
                ));
    }
}
