package com.mergen.vtys.vtysdatabaseap.Model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "activity", schema="public")
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String place;

    @Column
    private String datetime;

    @Column
    private String organizator;

}
