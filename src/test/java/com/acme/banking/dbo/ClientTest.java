package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ClientTest {

    private Client client;
    private String clientName = "Client Name";
    private UUID accountId1;
    private UUID clientId;

    @Before
    public void initClient() {
        accountId1 = UUID.randomUUID();
        clientId = UUID.randomUUID();
        List<UUID> accountIds = new ArrayList<>();
        accountIds.add(accountId1);

        Client.Builder clientBuilder = new Client.Builder();
        client = clientBuilder
                .setId(clientId)
                .setName(clientName)
                .setAccountIds(accountIds)
                .build();
    }

    @Test
    public void shouldSavePropertiesWhenCreated() {
        assertThat(client.getId(),
                allOf(
                        equalTo(clientId),
                        notNullValue()
                ));
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldThrownExceptionWhenClientIdIsNull() {
        exceptionRule.expect(IllegalArgumentException.class);
        List<UUID> accountIds = new ArrayList<>();
        accountIds.add(accountId1);
        new Client(null, clientName, accountIds);
    }

    @Test
    public void shouldTReturnClientNameWhenRequested() {
        assertThat(client.getName(),
                allOf(
                        equalTo(clientName),
                        notNullValue()
                ));
    }

    @Test
    public void shouldTReturnClientAccountIdsWhenRequested() {
        assertThat(client.getAccountIds().get(0),
                allOf(
                        equalTo(accountId1),
                        notNullValue()
                ));
    }
}
