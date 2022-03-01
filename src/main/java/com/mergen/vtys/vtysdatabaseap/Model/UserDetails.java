package com.mergen.vtys.vtysdatabaseap.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

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
    private String maritalstatus;
    @Column
    private  Long numberofkids;
    @Column
    private  String degree_of_disability;
    @Column
    private String gender;
    @Column
    private String education_status;
    @Column
    private String finished_max_education_level;
    @Column
    private String last_finished_school;
    @Column
    private String employment_type;
    @Column
    private String military_service_status;
    @Column
    private String date_of_start;
    @Column
    private String contract_type;
    @Column
    private String contract_end_date;
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
    private String bank_account_type;
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

    