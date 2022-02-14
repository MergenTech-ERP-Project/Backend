package com.mergen.vtys.vtysdatabaseap.Model;



import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="company", schema = "public")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String company_name;

    @Column
    private String company_phone;

    @Column
    private String domain_name;

    @Column
    private String mersis_no;

    @Column
    private String sgk_company_no;

}


