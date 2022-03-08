package com.mergen.vtys.vtysdatabaseap.Model;



import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="company", schema = "public")
@Data
public class Company {
    @Id
    @SequenceGenerator(name="identifier_", sequenceName="mytable_id_seq_", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier_")
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


