package com.mergen.vtys.vtysdatabaseap.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "activity", schema="public")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_one_generator")
    @SequenceGenerator(name = "sequence_one_generator", sequenceName = "sequence_one_id", allocationSize = 1)
            private Long id;

    @Column
    private String name;

    @Column
    private String place;

    @Column
    private String datetime;

    @Column
    private String organizator;

//    public List<ActiveToUser> getActiveToUsers() {
//        return activeToUsers;
//    }
//    public void setActiveToUsers(List<ActiveToUser> activeToUsers) {
//        this.activeToUsers = activeToUsers;
//    }


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "activity_ids",cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
 //   @JsonManagedReference(value = "activity_json")
    private List<ActiveToUser> activity_enrolled=new ArrayList<>();

    public Activity(Long id, String name, String place, String datetime, String organizator) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.datetime = datetime;
        this.organizator = organizator;
    }

    public Activity(Long id) {
        this.id = id;
    }


//
//    @JoinTable
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<User> users=new ArrayList<>();

}
