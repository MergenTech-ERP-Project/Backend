package com.mergen.vtys.vtysdatabaseap.Classes;


import javax.persistence.*;

@Entity
@Table(name="branch", schema="public")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String branch_name;

    @Column
    private String branch_upper;

    @Column
    private String rules;

    @Column
    private String vacation_dates;


    public Branch(Long id, String branch_name, String branch_upper, String rules, String vacation_dates) {
        this.id = id;
        this.branch_name = branch_name;
        this.branch_upper = branch_upper;
        this.rules = rules;
        this.vacation_dates = vacation_dates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_upper() {
        return branch_upper;
    }

    public void setBranch_upper(String branch_upper) {
        this.branch_upper = branch_upper;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getVacation_dates() {
        return vacation_dates;
    }

    public void setVacation_dates(String vacation_dates) {
        this.vacation_dates = vacation_dates;
    }

    public Branch(){

    }
}

    