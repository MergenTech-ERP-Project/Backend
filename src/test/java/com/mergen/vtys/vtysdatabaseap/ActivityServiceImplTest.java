package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mergen.vtys.vtysdatabaseap.Controller.ActivityController;
import com.mergen.vtys.vtysdatabaseap.Model.Activity;
import com.mergen.vtys.vtysdatabaseap.Model.UserM;
import com.mergen.vtys.vtysdatabaseap.Repository.ActivityRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActivityService;
import org.aspectj.lang.annotation.Before;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Stream.builder;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@ExtendWith(MockitoExtension.class)
class ActivityServiceImplTest {

    @Mock
    ActivityRepository activityRepository;
    @InjectMocks
    ActivityServiceImpl activityService;
    @InjectMocks
    ActivityController activityController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    void getActivityList() {
        List<Activity> activityList = new ArrayList<Activity>();
        activityList.add(new Activity(1L, "activityTest", "samplePlace", "12.2.2022", "sampleOrganizator"));
        activityList.add(new Activity(2L, "activityTest", "samplePlace", "12.2.2022", "sampleOrganizator"));
        activityList.add(new Activity(3L, "activityTest", "samplePlace", "12.2.2022", "sampleOrganizator"));

        when(activityRepository.findAll()).thenReturn(activityList);

        List<Activity> activityList1 = activityService.getActivityList();
        assertEquals(3, activityList1.size());


    }


    @Test
    void testGetActivityById() {
        Activity activity = new Activity(1L, "activityTest", "samplePlace", "12.2.2022", "sampleOrganizator");
        when(activityRepository.findById(1L)).thenReturn(Optional.of(activity));
        Optional<Activity> resultActivity = activityService.getActivityById(1L);
        Activity result = resultActivity.get();
        assertEquals(1, result.getId());
        assertEquals("activityTest", result.getName());
        assertEquals("12.2.2022", result.getDatetime());
        assertEquals("sampleOrganizator", result.getOrganizator());
        assertEquals("samplePlace", result.getPlace());
    }


    @Test
    void getActivityByName() {
        Activity activity = new Activity(1L, "activityTest", "samplePlace", "12.2.2022", "sampleOrganizator");
        when(activityRepository.findByName("activityTest")).thenReturn(Optional.of(activity));
        Optional<Activity> resultActivity = activityService.getActivityByName("activityTest");
        Activity result = resultActivity.get();
        assertEquals(1, result.getId());
        assertEquals("activityTest", result.getName());
        assertEquals("12.2.2022", result.getDatetime());
        assertEquals("sampleOrganizator", result.getOrganizator());
        assertEquals("samplePlace", result.getPlace());
    }

    @Test
    void createTest() {
        Activity expected = new Activity();
        expected.setId(25L);
        expected.setName("TestUser");
        expected.setPlace("@TestPlace");
        expected.setOrganizator("Kalite");

        Activity request = new Activity();

        when(activityRepository.save(expected)).thenReturn(expected);
        Activity result = activityService.Create(expected);
        // then
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(expected, result),
                () -> assertEquals(expected.getName(), result.getName()),
                () -> assertEquals(expected.getId(), result.getId())
        );
    }


    @Test
    void update() throws Exception {
        // given - precondition or setup
        Activity activity = new Activity(1L, "activityTest", "samplePlace", "12.2.2022", "sampleOrganizator");

        given(activityRepository.save(activity)).willReturn(activity);
        activity.setPlace("ram@gmail.com");
        activity.setName("exampleName");
        // when -  action or the behaviour that we are going test
        activityService.Update(activity.getId(),activity);
        Activity updatedActivity;
        updatedActivity = activity;

        // then - verify the output


        assertAll(
                () -> assertEquals(updatedActivity.getPlace(), "ram@gmail.com")
        );
    }

    @Test
    void delete() throws Exception {
        long id = 1L;
        // prepare data and mock's behaviour
        Mockito.when(activityService.Delete(id)).thenReturn(String.valueOf(id));
        mockMvc.perform(MockMvcRequestBuilders.delete("/activity/remove/{id}", id))
                .andExpect(status().isOk());
    }

}




