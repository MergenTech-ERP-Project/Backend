package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Dto.CareerDto;
import com.mergen.vtys.vtysdatabaseap.Service.CareerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;

public class CareerControllerTest {
    @Mock
    CareerService careerService;
    @Mock
    Logger log;
    @InjectMocks
    CareerController careerController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCareersList() throws Exception {
        when(careerService.getCareerList()).thenReturn(List.of(new CareerDto()));

        ResponseEntity<List<CareerDto>> result = careerController.getCareersList();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetCareersById() throws Exception {
        when(careerService.getCareerById(anyLong())).thenReturn(new CareerDto());

        ResponseEntity<CareerDto> result = careerController.getCareersById(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testCreateCareer() throws Exception {
        when(careerService.Create(any())).thenReturn(new T());

        ResponseEntity<CareerDto> result = careerController.createCareer(new CareerDto());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testUpdateCareer() throws Exception {
        when(careerService.Update(anyLong(), any())).thenReturn("UpdateResponse");

        ResponseEntity<String> result = careerController.updateCareer(Long.valueOf(1), new CareerDto());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testDeleteCareer() throws Exception {
        when(careerService.Delete(anyLong())).thenReturn("DeleteResponse");

        ResponseEntity<String> result = careerController.deleteCareer(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testEquals() throws Exception {
        boolean result = careerController.equals("o");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCanEqual() throws Exception {
        boolean result = careerController.canEqual("other");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHashCode() throws Exception {
        int result = careerController.hashCode();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception {
        String result = careerController.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme