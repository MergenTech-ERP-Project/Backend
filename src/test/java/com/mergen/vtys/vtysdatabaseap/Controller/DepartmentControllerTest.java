package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Dto.DepartmentDto;
import com.mergen.vtys.vtysdatabaseap.Service.DepartmentService;
import liquibase.pro.packaged.T;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

import static org.mockito.Mockito.*;

class DepartmentControllerTest {
    @Mock
    DepartmentService departmentService;
    @Mock
    Logger log;
    @InjectMocks
    DepartmentController departmentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDepartmentList() {
        when(departmentService.getDepartmentList()).thenReturn(List.of(new DepartmentDto()));

        ResponseEntity<List<DepartmentDto>> result = departmentController.getDepartmentList();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetDepartmentByID() {
        when(departmentService.getDepartmentByID(anyLong())).thenReturn(new DepartmentDto());

        ResponseEntity<DepartmentDto> result = departmentController.getDepartmentByID(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCreateDepartment() throws ParseException {
        when(departmentService.Create(any())).thenReturn(new T());

        ResponseEntity<DepartmentDto> result = departmentController.createDepartment(new DepartmentDto());
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateDepartment() {
        when(departmentService.Update(anyLong(), any())).thenReturn("UpdateResponse");

        ResponseEntity<String> result = departmentController.updateDepartment(Long.valueOf(1), new DepartmentDto());
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteDeparment() {
        when(departmentService.Delete(anyLong())).thenReturn("DeleteResponse");

        ResponseEntity<String> result = departmentController.deleteDeparment(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetBranchId() {
        when(departmentService.getDepartmentsByBranchId(anyLong())).thenReturn(List.of(new DepartmentDto()));

        ResponseEntity<List<DepartmentDto>> result = departmentController.getBranchId(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testEquals() {
        boolean result = departmentController.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = departmentController.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = departmentController.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = departmentController.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme