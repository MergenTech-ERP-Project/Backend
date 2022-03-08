package com.mergen.vtys.vtysdatabaseap.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mergen.vtys.vtysdatabaseap.Domain.MaritalStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.JoinColumnsOrFormulas;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column
    private  String name;
    @Email
    @Column
    private String email ;
    @Column
    private String title;
    @Column
    private String cellphone;
    @Column
    private String password;



    //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user_ids")
    @Fetch(value = FetchMode.SUBSELECT)
    //@JsonManagedReference(value = "user_json_managed")
    private List<ActiveToUser> activeToUsers=new ArrayList<>();


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user_id")
    @Fetch(value = FetchMode.SUBSELECT)
    //@JsonManagedReference(value = "user_json_managed")
    private List<UserDetails> userDetails=new ArrayList<>();



//    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
//    //@PrimaryKeyJoinColumn
//    @JoinColumn(name = "userDetails_id", referencedColumnName = "id")
//    private UserDetails userDetails;

    //    @OneToOne(fetch = FetchType.LAZY,
//            cascade =  CascadeType.ALL,
//            mappedBy = "tc_no")
//    private UserDetails userDetails;

}
