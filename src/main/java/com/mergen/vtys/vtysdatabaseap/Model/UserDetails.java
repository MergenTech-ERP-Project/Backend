package com.mergen.vtys.vtysdatabaseap.Model;

import com.mergen.vtys.vtysdatabaseap.Domain.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table(name = "userdetails",schema = "public")
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDetails {
    @Id
    @Column(name = "tc_no",nullable = false,updatable = false)
    private int tc_no;

    @Column
    private String dateofbirth;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private MaritalStatus maritalstatus;
    @Column
    private  Long numberofkids;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private DisabledDegree degree_of_disability;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private EducationalStatus education_status;
    @Column
    @Enumerated(EnumType.STRING)
    private HighestEducationLevel highest_education_level_completed;
    @Column
    private String last_completed_education_status;
    @Enumerated(EnumType.STRING)
    @Column
    private TypeOfWorking employment_type;
    @Enumerated(EnumType.STRING)
    @Column
    private MilitaryStatus military_service_status;
    @Column
    private String date_of_start;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private ContractType contract_type;
    @Column
    private String contract_end_date;
    @Email
    @Column
    private String work_email;
    @Column
    private String address;
    @Column
    private String home_telephone;
    @Column
    private String work_phone;
    @Column
    private String country;
    @Column
    private String city;
    @Column
    private String address_district;
    @Column
    private String blood_type;
    @Column
    private String zip_code;
    @Column
    private String bank_name;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private BankAccountType bank_account_type;
    @Column
    private String bank_account_number;
    @Column
    private String iban;
    @Column
    private String emergency_contact;
    @Column
    private String relationship_emergency_contact;
    @Column
    private String emergency_contact_phone;
    @Column
    private String quit_date;
    @Column
    private String quit_reason_type;
    @Column
    private String quit_explanation;



}

    