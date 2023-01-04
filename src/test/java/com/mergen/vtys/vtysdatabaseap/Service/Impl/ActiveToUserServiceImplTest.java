package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import com.mergen.vtys.vtysdatabaseap.Repository.ActiveToUserRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ActiveToUserServiceImplTest {
    @Mock
    ActiveToUserRepository activeToUserRepository;
    @InjectMocks
    ActiveToUserServiceImpl activeToUserServiceImpl;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetActivityList() {
        List<ActiveToUser> result = activeToUserServiceImpl.getActivityList();
        Assert.assertEquals(result, List.of(new ActiveToUser()));
    }

    @Test
    public void testGetActivityById() {
        Optional<ActiveToUser> result = activeToUserServiceImpl.getActivityById(Long.valueOf(1));
        Assert.assertEquals(result, null);
    }

    @Test
    public void testCreate() {
        ActiveToUser result = activeToUserServiceImpl.Create(new ActiveToUser());
        Assert.assertEquals(result, new ActiveToUser());
    }

    @Test
    public void testUpdate() {
        String result = activeToUserServiceImpl.Update(Long.valueOf(1), new ActiveToUser());
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testDelete() {
        String result = activeToUserServiceImpl.Delete(Long.valueOf(1));
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetUsersEnrolled() {
        when(activeToUserRepository.getUsersEnrolled(anyLong())).thenReturn(List.of("getUsersEnrolledResponse"));

        List<Object> result = activeToUserServiceImpl.getUsersEnrolled(Long.valueOf(1));
        Assert.assertEquals(result, List.of("replaceMeWithExpectedResult"));
    }

    @Test
    public void testGetUsersEnrolledIDs() {
        when(activeToUserRepository.getUsersEnrolledIDs(anyLong())).thenReturn(List.of(Long.valueOf(1)));

        List<Long> result = activeToUserServiceImpl.getUsersEnrolledIDs(Long.valueOf(1));
        Assert.assertEquals(result, List.of(Long.valueOf(1)));
    }

    @Test
    public void testEquals() {
        boolean result = activeToUserServiceImpl.equals("o");
        Assert.assertEquals(result, true);
    }

    @Test
    public void testCanEqual() {
        boolean result = activeToUserServiceImpl.canEqual("other");
        Assert.assertEquals(result, true);
    }

    @Test
    public void testHashCode() {
        int result = activeToUserServiceImpl.hashCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testToString() {
        String result = activeToUserServiceImpl.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme