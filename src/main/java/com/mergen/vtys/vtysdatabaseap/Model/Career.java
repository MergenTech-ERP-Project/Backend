package com.mergen.vtys.vtysdatabaseap.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="career", schema = "public")
@Data
public class Career {

        @Id
        @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
        @Column(name ="id",nullable = false,updatable = false)
        private Long id;

        @Column
        private String admin_tc_no;

        @Column
        private String admin_name;

        @Column
        private String unit_company;

        @Column
        private String unit_branch;

        @Column
        private String unit_department;

        @Column
        private String unit_title;

}
