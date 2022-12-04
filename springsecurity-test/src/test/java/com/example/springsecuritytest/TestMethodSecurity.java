package com.example.springsecuritytest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.springsecuritytest.service.UserRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class TestMethodSecurity {

    @Autowired
    UserRoleService userRoleService;

   @Test
	@WithMockUser(username = "john", roles = { "VIEWER" })
	public void givenRoleViewer_whenCallGetUsername_thenReturnUsername() {
		String userName = userRoleService.getUsername();
		assertEquals("john", userName);
	}

}
