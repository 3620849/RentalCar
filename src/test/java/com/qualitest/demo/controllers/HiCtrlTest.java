package com.qualitest.demo.controllers;

import com.qualitest.demo.dao.UserDao;
import com.qualitest.demo.model.User;
import com.qualitest.demo.services.TokenHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
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
       // hiCtrl.getAuthToken(null);

    }
}