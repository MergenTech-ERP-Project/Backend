package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Dto.PaymentsDto;
import com.mergen.vtys.vtysdatabaseap.Service.Impl.PaymentsServiceImpl;
import com.mergen.vtys.vtysdatabaseap.Service.PaymentsService;
import io.jsonwebtoken.lang.Assert;
import org.aspectj.lang.annotation.Before;
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

import static org.mockito.Mockito.*;

public class PaymentsControllerTest {
    @Mock
    PaymentsService paymentsService;
    @Mock
    Logger log;
    @InjectMocks
    PaymentsController paymentsController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPaymentList() throws Exception {
        when(paymentsService.getPaymentsList()).thenReturn(List.of(new PaymentsDto()));

        ResponseEntity<List<PaymentsDto>> result = paymentsController.getPaymentList();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetPaymentsById() throws Exception {
        when(paymentsService.getPaymentsById(anyLong())).thenReturn(new PaymentsDto());

        ResponseEntity<PaymentsDto> result = paymentsController.getPaymentsById(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testCreatePayments() throws Exception {
        when(paymentsService.Create(any())).thenReturn(new T());

        ResponseEntity<PaymentsDto> result = paymentsController.createPayments(new PaymentsDto());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testUpdatePayments() throws Exception {
        when(paymentsService.Update(anyLong(), any())).thenReturn("UpdateResponse");

        ResponseEntity<String> result = paymentsController.updatePayments(Long.valueOf(1), new PaymentsDto());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testDeletePayments() throws Exception {
        when(paymentsService.Delete(anyLong())).thenReturn("DeleteResponse");

        ResponseEntity<String> result = paymentsController.deletePayments(Long.valueOf(1));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testSetPaymentsService() throws Exception {
        paymentsController.setPaymentsService(new PaymentsServiceImpl(null, null));
    }

    @Test
    public void testEquals() throws Exception {
        boolean result = paymentsController.equals("o");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCanEqual() throws Exception {
        boolean result = paymentsController.canEqual("other");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHashCode() throws Exception {
        int result = paymentsController.hashCode();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testToString() throws Exception {
        String result = paymentsController.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme