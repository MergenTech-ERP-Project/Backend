package com.mergen.vtys.vtysdatabaseap.Dto;

import com.mergen.vtys.vtysdatabaseap.Domain.*;
import com.mergen.vtys.vtysdatabaseap.Model.Career;
import com.mergen.vtys.vtysdatabaseap.Model.Payments;
import lombok.Data;

import java.util.List;

@Data
public class UserDetailsDto {

    private Long id;
    private String tc_no;
    private String dateofbirth;
    private MaritalStatus maritalstatus;
    private  Long numberofkids;
    private DisabledDegree degree_of_disability;
    private Gender gender;
    private EducationalStatus education_status;
    private HighestEducationLevel highest_education_level_completed;
    private String last_completed_education_status;
    private TypeOfWorking employment_type;
    private MilitaryStatus military_service_status;
    private String date_of_start;
    private ContractType contract_type;
    private String contract_end_date;
    private String work_email;
    private String address;
    private String home_telephone;
    private String work_phone;
    private String country;
    private String city;
    private String address_district;
    private String blood_type;
    private String zip_code;
    private String bank_name;
    private BankAccountType bank_account_type;
    private String bank_account_number;
    private String iban;
    private String emergency_contact;
    private String relationship_emergency_contact;
    private String emergency_contact_phone;
    private String quit_date;
    private String quit_reason_type;
    private String quit_explanation;
    private Long user_id;
    private List<Career> careers;
    private List<Payments> payments;
}
