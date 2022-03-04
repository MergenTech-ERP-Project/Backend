package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Model.Payments;
import com.mergen.vtys.vtysdatabaseap.Service.PaymentsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentsController {
    @Autowired
    private PaymentsService paymentsService;

    @GetMapping(value = "list")
    public ResponseEntity<List<Payments>> getPaymentList(){
        List<Payments> paymentsList = paymentsService.getPaymentsList();
        log.info("All Payments Returned - {}",paymentsList);
        return ResponseEntity.ok(paymentsList);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<Payments> getPaymentsById(@PathVariable Long id){
        Payments status = paymentsService.getPaymentsById(id);
        log.info("Payments Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "post")
    public ResponseEntity<Payments> createPayments(@RequestBody Payments payments){
        Payments status = paymentsService.Create(payments);
        log.info("Branch Added Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(payments);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePayments(@PathVariable Long id){
        String status = paymentsService.Delete(id);
        log.info("Payments Deleted Status - {}",status);
        return ResponseEntity.ok(id + "th Payments Deleted");
    }



}

    