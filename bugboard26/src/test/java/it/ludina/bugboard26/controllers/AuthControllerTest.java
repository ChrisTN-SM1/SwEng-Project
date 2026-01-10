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


    GenericUser user = new GenericUser("test@testing.test", "thisisatest");

    @Test
    void testResultEqualsNotFound() throws Exception{
        when(mockdao.login(user)).thenReturn("invalid");
        Response result = controller.login(user);
        assertEquals(404, result.getStatus());
    }


    @Test
    void testResultEqualsOk() throws Exception{
        when(mockdao.login(user)).thenReturn("admin");
        Response result = controller.login(user);
        assertEquals(result.getStatus(), 200);
    }

    @Test
    void testResultEqualsBadRequest() throws Exception {
        when(mockdao.login(user)).thenThrow(SQLException.class);
        Response result = controller.login(user);
        assertEquals(result.getStatus(), 400);
    }
}