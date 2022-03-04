package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.Payments;
import com.mergen.vtys.vtysdatabaseap.Repository.PaymentsRepository;
import com.mergen.vtys.vtysdatabaseap.Service.PaymentsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class PaymentsServiceImpl  implements PaymentsService {
    private final PaymentsRepository paymentsRepository;

    @Override
    public List<Payments> getPaymentsList()  {
        return (List<Payments>) paymentsRepository.findAll();
    }
    @Override
    public Payments getPaymentsById(Long id){
        Payments payments = paymentsRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Find by Id Internal Error"));
     return payments;
    }

    @Override
    public Payments Create(Payments model){
        Payments payments = paymentsRepository.save(model);
        return payments;
    }

    @Override
    public String Update(Long id,Payments model){
        Optional<Payments> payments_ = paymentsRepository.findById(id);
        if(payments_.isPresent()){
            paymentsRepository.save(model);
            return model.toString();
        }
        else
            throw  new IllegalArgumentException(model + " Update Option Fail!");
    }
    @Override
    public String Delete(Long id){
         Payments payments = paymentsRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Find by Id Internal Error"));
         paymentsRepository.deleteById(id);
         return (id + "succesfuly deleted");
    }

}

    