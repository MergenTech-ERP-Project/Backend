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
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    @Column(name = "tcno",nullable = false,updatable = false)
    private  int tcno;

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
    private HighestEducationLevel finished_max_education_level;
    @Column
    private String last_finished_school;
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
    private String country;
    @Column
    private String city;
    @Column
    private Long zip_code;
    @Column
    private String bank_name;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private BankAccountType bank_account_type;
    @Column
    private Long bank_account_number;
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
    private String quit_reason;
    @Column
    private String quit_explanation;
}

    