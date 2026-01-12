package it.ludina.bugboard26.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import it.ludina.bugboard26.dao.AuthDAO;
import it.ludina.bugboard26.data.user.GenericUser;
import jakarta.ws.rs.core.Response;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest{

    @Mock
    AuthDAO mockdao;

    @InjectMocks
    AuthController controller;


    @Test
    void testResultEqualsNotFound() throws Exception{
        GenericUser user = new GenericUser("fakeuser@testing.test", "invaliduser");
        when(mockdao.login(user)).thenReturn("invalid");
        Response result = controller.login(user);
        assertEquals(404, result.getStatus());
    }


    @Test
    void testResultEqualsOk() throws Exception{
        GenericUser user = new GenericUser("admin@testing.test", "thisisatest");
        when(mockdao.login(user)).thenReturn("admin");
        Response result = controller.login(user);
        assertEquals(result.getStatus(), 200);
    }

    @Test
    void testResultEqualsBadRequest() throws Exception {
        when(mockdao.login(null)).thenThrow(SQLException.class);
        Response result = controller.login(null);
        assertEquals(result.getStatus(), 400);
    }
}