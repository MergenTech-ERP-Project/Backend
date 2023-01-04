package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Model.Image;
import com.mergen.vtys.vtysdatabaseap.Repository.ImageRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

public class ImageControllerTest {
    @Mock
    ImageRepository imageRepository;
    @Mock
    Logger log;
    @InjectMocks
    ImageController ımageController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUplaodImage() throws Exception {
        ResponseEntity<String> result = ımageController.uplaodImage(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetImageDetails() throws Exception {
        when(imageRepository.findByName(anyString())).thenReturn(null);

        Image result = ımageController.getImageDetails("name");
        Assert.assertEquals(new Image(Long.valueOf(1), "name", "type", new byte[]{(byte) 0}), result);
    }

    @Test
    public void testGetImage() throws Exception {
        when(imageRepository.findByName(anyString())).thenReturn(null);

        ResponseEntity<byte> result = ımageController.getImage("name");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testSetImageRepository() throws Exception {
        ımageController.setImageRepository(null);
    }

    @Test
    public void testEquals() throws Exception {
        boolean result = ımageController.equals("o");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCanEqual() throws Exception {
        boolean result = ımageController.canEqual("other");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHashCode() throws Exception {
        int result = ımageController.hashCode();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception {
        String result = ımageController.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme