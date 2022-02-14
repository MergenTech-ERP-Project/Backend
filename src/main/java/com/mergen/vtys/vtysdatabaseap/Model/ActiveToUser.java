package com.mergen.vtys.vtysdatabaseap.Model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "activetouser", schema="public")
@Data
public class ActiveToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private  Activity activity;

    @Column
    private Long userID;

}

    