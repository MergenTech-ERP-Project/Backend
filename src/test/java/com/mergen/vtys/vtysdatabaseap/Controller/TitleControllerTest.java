package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Model.Title;
import com.mergen.vtys.vtysdatabaseap.Service.TitleService;
import io.jsonwebtoken.lang.Assert;
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

public class TitleControllerTest {
    @Mock
    TitleService titleService;
    @Mock
    Logger log;
    @InjectMocks
    TitleController titleController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTitleList() throws Exception {
        when(titleService.getTitleList()).thenReturn(List.of(new Title()));

        ResponseEntity<List<Title>> result = titleController.getTitleList();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetTitleByID() throws Exception {
        when(titleService.getTitleByID(anyLong())).thenReturn(null);

        ResponseEntity<Optional<Title>> result = titleController.getTitleByID(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testCreateTitle() throws Exception {
        when(titleService.Create(any())).thenReturn(new T());

        ResponseEntity<Title> result = titleController.createTitle(new Title());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testUpdateTitle() throws Exception {
        when(titleService.Update(anyLong(), any())).thenReturn("UpdateResponse");

        ResponseEntity<String> result = titleController.updateTitle(Long.valueOf(1), new Title());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testDeleteTitle() throws Exception {
        when(titleService.Delete(anyLong())).thenReturn("DeleteResponse");

        ResponseEntity<String> result = titleController.deleteTitle(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetDepartmentId() throws Exception {
        when(titleService.getDepartmentId(anyLong())).thenReturn(List.of(null));

        ResponseEntity<List<Optional<Title>>> result = titleController.getDepartmentId(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testEquals() throws Exception {
        boolean result = titleController.equals("o");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCanEqual() throws Exception {
        boolean result = titleController.canEqual("other");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHashCode() throws Exception {
        int result = titleController.hashCode();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception {
        String result = titleController.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme