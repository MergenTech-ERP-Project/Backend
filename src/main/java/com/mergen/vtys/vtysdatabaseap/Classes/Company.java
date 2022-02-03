package com.mergen.vtys.vtysdatabaseap.Classes;



import javax.persistence.*;

@Entity
@Table(name="company", schema = "public")
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

    public Company(){

    }
    public Company(Long id, String company_name, String company_phone, String domain_name, String mersis_no, String sgk_company_no) {
        this.id = id;
        this.company_name = company_name;
        this.company_phone = company_phone;
        this.domain_name = domain_name;
        this.mersis_no = mersis_no;
        this.sgk_company_no = sgk_company_no;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_phone() {
        return company_phone;
    }

    public void setCompany_phone(String company_phone) {
        this.company_phone = company_phone;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    public String getMersis_no() {
        return mersis_no;
    }

    public void setMersis_no(String mersis_no) {
        this.mersis_no = mersis_no;
    }

    public String getSgk_company_no() {
        return sgk_company_no;
    }

    public void setSgk_company_no(String sgk_company_no) {
        this.sgk_company_no = sgk_company_no;
    }

}


