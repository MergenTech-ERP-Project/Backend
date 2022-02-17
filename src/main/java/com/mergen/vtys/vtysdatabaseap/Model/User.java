package com.mergen.vtys.vtysdatabaseap.Model;


import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user", schema = "public")
@Data
public class User{
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


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user_id",cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ActiveToUser> activeToUsers=new ArrayList<>();



//    @ManyToMany
////    @JoinTable(
////            name = "activetouser",
////            joinColumns = @JoinColumns(name="")
////    )
////}

}