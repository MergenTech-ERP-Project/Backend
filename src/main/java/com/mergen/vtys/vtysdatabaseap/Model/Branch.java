package com.mergen.vtys.vtysdatabaseap.Model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="branch", schema="public")
@Data
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

}

    