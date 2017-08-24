package com.qualitest.demo.controllers;

import com.qualitest.demo.dao.UserDao;
import com.qualitest.demo.model.User;
import com.qualitest.demo.services.TokenHandler;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by UA C on 23.08.2017.
 */
//add mokito
@RunWith(MockitoJUnitRunner.class)
public class HiCtrlTest {
    @InjectMocks
    private HiCtrl hiCtrl;
    @Mock
    private UserDao userDao;
    @Mock
    private TokenHandler tokenHandler;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testHello() throws Exception {
        //rules to mock object
        // when(userDao.findUserByName("123")).thenReturn(new User());
        User hello = hiCtrl.hello();
        //check if we call findUserByName("123");
        verify(userDao).findUserByName("123");
    }

    @Test
    public void getAuthToken() throws Exception {
       //if token handler called
        hiCtrl.getAuthToken(new User());
        verify(tokenHandler).checkMatchesPasswords(anyObject(),anyObject());
    }

    @Test
    public void testGetAuthToken1() throws Exception {
        //if getAuthToken accep not null if nulltoken -1
        thrown.expect(NullPointerException.class);
        hiCtrl.getAuthToken(null);
        //if 2 users different return -1
    }
    @Test
    public void testGetAuthToken2() throws Exception {
        //if 2users are same return some token
        User user123 = new User();
        user123.setUsername("123");
        user123.setPassword("123");
        when(userDao.findUserByName("123")).thenReturn(user123);
        when(tokenHandler.checkMatchesPasswords(user123,user123)).thenReturn(true);
        when(tokenHandler.generateTokenId(anyInt(),anyObject())).thenReturn("someToken");
        String res = hiCtrl.getAuthToken(user123);
        assertEquals("someToken",res);
    }
}