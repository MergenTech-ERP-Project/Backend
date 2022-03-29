package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Model.VacationRequest;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Repository.VacationRequestRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserDetailsService;
import com.mergen.vtys.vtysdatabaseap.Service.VacationRequestService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import static java.time.temporal.ChronoUnit.DAYS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class VacationRequestServiceImpl implements VacationRequestService {
    private final VacationRequestRepository vacationRequestRepository;
    private  final UserDetailsRepository userDetailsRepository;
    @Override
    public List<VacationRequest> getVacationRequestList()  {
        return vacationRequestRepository.findAll();
    }
    @Override
    public Optional<VacationRequest> getVacationRequestById(Long id){
        Optional<VacationRequest> vacationRequestOptional = vacationRequestRepository.findById(id);
        if (vacationRequestOptional.isPresent()){
            return vacationRequestOptional;
        }
        else
            throw new IllegalArgumentException(id + " Fail" + " And Get Vacation by ID Fail!");

    }

    @Override
    public VacationRequest Create(VacationRequest model) throws ParseException {
        //   Optional<Payments> payments = paymentsRepository.findEmailAndPassword(model.getEmail(),model.getPassword());
        //vacationRequestRepository.save(model);
        EarnedVacationDays(model.getId());
       // model.setIsAuthorizedForClasifiedData(model.getVacation_request_status());

       // UserDetails userDetails = new UserDetails();
         String start_date = userDetailsRepository.findById(model.getUser_detail_id()).get().getDate_of_start();
         model.setWork_start_date(start_date);
        vacationRequestRepository.save(model);
        return model;
    }

    @Override
    public String Update(Long id,VacationRequest model){
        Optional<VacationRequest> vacationRequestOptional = vacationRequestRepository.findById(id);
        if(vacationRequestOptional.isPresent()){
            vacationRequestRepository.save(model);
            return model.toString();
        }
        else
            throw  new IllegalArgumentException(model + " Update Option Fail!");
    }
    @Override
    public String Delete(Long id){
        Optional<VacationRequest> vacationRequestOptional = vacationRequestRepository.findById(id);

        if(vacationRequestOptional.isPresent()){
            vacationRequestRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }
    @Override
    public String EarnedVacationDays(Long id) throws ParseException {
      String StringStartDate=  getVacationRequestRepository().getById(id).getWork_start_date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
             Date date = formatter.parse(StringStartDate);
             Long EarnedVacationDay= Long.valueOf(0);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateNow = LocalDate.now();
        int diff = (int) DAYS.between( localDate,  localDateNow);
        if(diff>=365){
           int vacation_numb = diff / 365;
            vacationRequestRepository.getById(id).setWorking_day_number(vacation_numb*14);
        }

        return "";
    }
    @Override
    public String GetDate_of_Start(@PathVariable() Long id){
        return vacationRequestRepository.GetDate_of_Start(id);
    }

}

    