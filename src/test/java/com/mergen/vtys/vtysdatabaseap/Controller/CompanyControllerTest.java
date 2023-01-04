package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Dto.CompanyDto;
import com.mergen.vtys.vtysdatabaseap.Service.CompanyService;
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

class CompanyControllerTest {
    @Mock
    CompanyService companyService;
    @Mock
    Logger log;
    @InjectMocks
    CompanyController companyController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCompanyList() {
        when(companyService.getCompanyList()).thenReturn(List.of(new CompanyDto()));

        ResponseEntity<List<CompanyDto>> result = companyController.getCompanyList();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetCompanyByID() {
        when(companyService.getCompanyByID(anyLong())).thenReturn(new CompanyDto());

        ResponseEntity<CompanyDto> result = companyController.getCompanyByID(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testCreateCompany() {
        when(companyService.Create(any())).thenReturn(new T());

        ResponseEntity<CompanyDto> result = companyController.createCompany(new CompanyDto());
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdateCompany() {
        when(companyService.Update(anyLong(), any())).thenReturn("UpdateResponse");

        ResponseEntity<String> result = companyController.updateCompany(Long.valueOf(1), new CompanyDto());
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteCompany() {
        when(companyService.Delete(anyLong())).thenReturn("DeleteResponse");

        ResponseEntity<String> result = companyController.deleteCompany(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testEquals() {
        boolean result = companyController.equals("o");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testCanEqual() {
        boolean result = companyController.canEqual("other");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testHashCode() {
        int result = companyController.hashCode();
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = companyController.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme