package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ClientTest {
    private UUID id;
    private String name;

    @Before
    public void initClient() {
        id = UUID.randomUUID();
        name = "Client Name";
    }

    @Test
    public void shouldSavePropertiesWhenCreated() {
        Client sut = new Client(id, name);
        assertThat(sut.getId(),
                allOf(
                        equalTo(id),
                        notNullValue()
                ));
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldThrownExceptionWhenClientIdIsNull() {
        exceptionRule.expect(IllegalArgumentException.class);
        new Client(null, name);
    }

    @Test
    public void shouldTReturnClientWhenRequested() {
        Client client = new Client(id, name);
        assertThat(client.getName(),
                allOf(
                        equalTo(name),
                        notNullValue()
                ));
    }
}
