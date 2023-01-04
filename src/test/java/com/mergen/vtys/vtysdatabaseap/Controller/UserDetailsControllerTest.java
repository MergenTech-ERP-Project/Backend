package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Service.UserDetailsService;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class UserDetailsControllerTest {
    @Mock
    UserDetailsService userDetailsService;
    @Mock
    Logger log;
    @InjectMocks
    UserDetailsController userDetailsController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserDetailsList() throws Exception {
        when(userDetailsService.getUserDetailsList()).thenReturn(List.of(new UserDetails()));

        ResponseEntity<List<UserDetails>> result = userDetailsController.getUserDetailsList();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetUserDetailsById() throws Exception {
        when(userDetailsService.getUserDetailsById(anyLong())).thenReturn(null);

        ResponseEntity<Optional<UserDetails>> result = userDetailsController.getUserDetailsById(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testCreateUserDetails() throws Exception {
        when(userDetailsService.Create(any())).thenReturn(new T());

        ResponseEntity<UserDetails> result = userDetailsController.createUserDetails(new UserDetails());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testUpdateUserDetails() throws Exception {
        when(userDetailsService.Update(anyLong(), any())).thenReturn("UpdateResponse");

        ResponseEntity<String> result = userDetailsController.updateUserDetails(Long.valueOf(1), new UserDetails());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testDeleteUserDetails() throws Exception {
        when(userDetailsService.Delete(anyLong())).thenReturn("DeleteResponse");

        ResponseEntity<String> result = userDetailsController.deleteUserDetails(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testFindByTcNo() throws Exception {
        when(userDetailsService.findTcNo(anyString())).thenReturn(null);

        ResponseEntity<Optional<UserDetails>> result = userDetailsController.findByTcNo("tc_no");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testFindbyUserId() throws Exception {
        when(userDetailsService.FindByUserid(anyLong())).thenReturn(null);

        ResponseEntity<Optional<UserDetails>> result = userDetailsController.findbyUserId(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testEquals() throws Exception {
        boolean result = userDetailsController.equals("o");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCanEqual() throws Exception {
        boolean result = userDetailsController.canEqual("other");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHashCode() throws Exception {
        int result = userDetailsController.hashCode();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception {
        String result = userDetailsController.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme