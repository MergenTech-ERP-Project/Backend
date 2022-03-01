package com.mergen.vtys.vtysdatabaseap.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @Id
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;



    @Column
    private  String name;

    @Column
    private String email ;

    @Column
    private String title;
    @Column
    private Long cellphonenumber;
    @Column
    private Long workphone;
    @Column
    private String password;


    //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user_ids")
    @Fetch(value = FetchMode.SUBSELECT)
    //@JsonManagedReference(value = "user_json_managed")
    private List<ActiveToUser> activeToUsers=new ArrayList<>();


//


//    @ManyToMany
////    @JoinTable(
////            name = "activetouser",
////            joinColumns = @JoinColumns(name="")
////    )private List<ActiveToUser> users=new ArrayList<>();
////}


}