package com.mergen.vtys.vtysdatabaseap.Model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="user", schema = "public")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String title;

    @Column
    private String password;

}
