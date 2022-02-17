package com.mergen.vtys.vtysdatabaseap.Model;


import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "activity_id",cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ActiveToUser> activeToUsers=new ArrayList<>();

}
