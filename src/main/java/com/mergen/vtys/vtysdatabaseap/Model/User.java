package com.mergen.vtys.vtysdatabaseap.Model;

import com.mergen.vtys.vtysdatabaseap.C.Security.Role;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user", schema = "public")
@Data
@RequiredArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column
    private  String username;
    @Email
    @Column
    private String email ;
    @Column
    private String title;
    @Column
    private String cellphone;
    @Column
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user_ids")
    @Fetch(value = FetchMode.SUBSELECT)
    //@JsonManagedReference(value = "user_json_managed")
    private List<ActiveToUser> activeToUsers=new ArrayList<>();


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user_id")
    @Fetch(value = FetchMode.SUBSELECT)
    //@JsonManagedReference(value = "user_json_managed")
    private List<UserDetails> userDetails=new ArrayList<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

//    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
//    //@PrimaryKeyJoinColumn
//    @JoinColumn(name = "userDetails_id", referencedColumnName = "id")
//    private UserDetails userDetails;

    //    @OneToOne(fetch = FetchType.LAZY,
//            cascade =  CascadeType.ALL,
//            mappedBy = "tc_no")
//    private UserDetails userDetails;

}
