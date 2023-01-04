package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Dto.BranchDto;
import com.mergen.vtys.vtysdatabaseap.Service.BranchService;
import com.mergen.vtys.vtysdatabaseap.Service.Impl.BranchServiceImpl;
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

public class BranchControllerTest {
    @Mock
    BranchService branchService;
    @Mock
    Logger log;
    @InjectMocks
    BranchController branchController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBranchList() throws Exception {
        when(branchService.getBranchList()).thenReturn(List.of(new BranchDto()));

        ResponseEntity<List<BranchDto>> result = branchController.getBranchList();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetBranchById() throws Exception {
        when(branchService.getBranchById(anyLong())).thenReturn(new BranchDto());

        ResponseEntity<BranchDto> result = branchController.getBranchById(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testFindbyCompanyid() throws Exception {
        when(branchService.FindByCompanyid(anyLong())).thenReturn(List.of(new BranchDto()));

        ResponseEntity<List<BranchDto>> result = branchController.FindbyCompanyid(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testCreateBranch() throws Exception {
        when(branchService.Create(any())).thenReturn(new T());

        ResponseEntity<BranchDto> result = branchController.createBranch(new BranchDto());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testUpdateBranch() throws Exception {
        when(branchService.Update(anyLong(), any())).thenReturn("UpdateResponse");

        ResponseEntity<String> result = branchController.updateBranch(Long.valueOf(1), new BranchDto());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testDeleteBranch() throws Exception {
        when(branchService.Delete(anyLong())).thenReturn("DeleteResponse");

        ResponseEntity<String> result = branchController.deleteBranch(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testSetBranchService() throws Exception {
        branchController.setBranchService(new BranchServiceImpl(null, null));
    }

    @Test
    public void testEquals() throws Exception {
        boolean result = branchController.equals("o");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCanEqual() throws Exception {
        boolean result = branchController.canEqual("other");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHashCode() throws Exception {
        int result = branchController.hashCode();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception {
        String result = branchController.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme