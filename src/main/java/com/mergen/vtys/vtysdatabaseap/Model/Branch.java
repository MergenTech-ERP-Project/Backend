package com.mergen.vtys.vtysdatabaseap.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="branch", schema="public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    @Id
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    @Column(name = "id",nullable = false,updatable = false)
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

    