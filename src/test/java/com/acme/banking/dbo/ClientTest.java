package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import io.qameta.allure.junit4.Tag;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @Category(SmokeTests.class)
    @Test
    public void shouldSavePropertiesWhenCreated() {
        assertAll("Should return clientId when requested",
                () -> assertEquals(clientId, client.getId()),
                () -> assertNotNull(client.getId())
        );
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Tag("RegressionPack")
    @Test
    public void shouldThrownExceptionWhenClientIdIsNull() {
        exceptionRule.expect(IllegalArgumentException.class);
        List<UUID> accountIds = new ArrayList<>();
        accountIds.add(accountId1);
        new Client(null, clientName, accountIds);
    }

    @Tag("RegressionPack")
    @Test
    public void shouldTReturnClientNameWhenRequested() {
        assertAll("Should return client name when requested",
                () -> assertEquals(clientName, client.getName()),
                () -> assertNotNull(client.getName())
        );
    }

    @Tag("RegressionPack")
    @Test
    public void shouldTReturnClientAccountIdsWhenRequested() {
        assertAll("Should return account ids when requested",
                () -> assertEquals(accountId1, client.getAccountIds().get(0)),
                () -> assertNotNull(client.getAccountIds().get(0))
        );
    }
}
