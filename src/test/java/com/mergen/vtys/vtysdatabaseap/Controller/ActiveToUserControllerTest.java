package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import com.mergen.vtys.vtysdatabaseap.Service.ActiveToUserService;
import com.mergen.vtys.vtysdatabaseap.Service.Impl.ActiveToUserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ActiveToUserControllerTest {
    @Mock
    ActiveToUserService activeToUserService;
    @Mock
    Logger log;
    @InjectMocks
    ActiveToUserController activeToUserController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetActivityList() throws Exception {
        when(activeToUserService.getActivityList()).thenReturn(List.of(new ActiveToUser()));

        ResponseEntity<List<ActiveToUser>> result = activeToUserController.getActivityList();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetActivityById() throws Exception {
        when(activeToUserService.getActivityById(anyLong())).thenReturn(null);

        ResponseEntity<Optional<ActiveToUser>> result = activeToUserController.getActivityById(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetUsersEnrolled() throws Exception {
        when(activeToUserService.getUsersEnrolled(anyLong())).thenReturn(List.of("getUsersEnrolledResponse"));

        ResponseEntity<List<Object>> result = activeToUserController.getUsersEnrolled(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetUsersEnrolledIDs() throws Exception {
        when(activeToUserService.getUsersEnrolledIDs(anyLong())).thenReturn(List.of(Long.valueOf(1)));

        ResponseEntity<List<Long>> result = activeToUserController.getUsersEnrolledIDs(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testCreateActiveoUser() throws Exception {
        when(activeToUserService.Create(any())).thenReturn(new T());

        ResponseEntity<ActiveToUser> result = activeToUserController.CreateActiveoUser(new ActiveToUser());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testUpdateActiveToUser() throws Exception {
        when(activeToUserService.Update(anyLong(), any())).thenReturn("UpdateResponse");

        ResponseEntity<String> result = activeToUserController.updateActiveToUser(Long.valueOf(1), new ActiveToUser());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testDeleteActivityToUser() throws Exception {
        when(activeToUserService.Delete(anyLong())).thenReturn("DeleteResponse");

        ResponseEntity<String> result = activeToUserController.deleteActivityToUser(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testSetActiveToUserService() throws Exception {
        activeToUserController.setActiveToUserService(new ActiveToUserServiceImpl(null));
    }

    @Test
    public void testEquals() throws Exception {
        boolean result = activeToUserController.equals("o");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCanEqual() throws Exception {
        boolean result = activeToUserController.canEqual("other");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHashCode() throws Exception {
        int result = activeToUserController.hashCode();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception {
        String result = activeToUserController.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme