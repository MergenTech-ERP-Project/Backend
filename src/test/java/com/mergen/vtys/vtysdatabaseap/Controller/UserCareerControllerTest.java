package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Dto.UserCareerDto;
import com.mergen.vtys.vtysdatabaseap.Service.UserCareerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;

class UserCareerControllerTest {
    @Mock
    UserCareerService userCareerService;
    @Mock
    Logger log;
    @InjectMocks
    UserCareerController userCareerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserCareerList() {
        when(userCareerService.getUserCareerList()).thenReturn(List.of(new UserCareerDto()));

        ResponseEntity<List<UserCareerDto>> result = userCareerController.getUserCareerList();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetUserCareerByID() {
        when(userCareerService.getUserCareerByID(anyLong())).thenReturn(new UserCareerDto());

        ResponseEntity<UserCareerDto> result = userCareerController.getUserCareerByID(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCreateUserCareer() {
        when(userCareerService.Create(any())).thenReturn(new T());

        ResponseEntity<UserCareerDto> result = userCareerController.createUserCareer(new UserCareerDto());
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateUserCareer() {
        when(userCareerService.Update(anyLong(), any())).thenReturn("UpdateResponse");

        ResponseEntity<String> result = userCareerController.updateUserCareer(Long.valueOf(1), new UserCareerDto());
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteTitle() {
        when(userCareerService.Delete(anyLong())).thenReturn("DeleteResponse");

        ResponseEntity<String> result = userCareerController.deleteTitle(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testEquals() {
        boolean result = userCareerController.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = userCareerController.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = userCareerController.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = userCareerController.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme