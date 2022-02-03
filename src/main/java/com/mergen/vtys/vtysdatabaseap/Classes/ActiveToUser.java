package com.mergen.vtys.vtysdatabaseap.Classes;


import javax.persistence.*;

@Entity
@Table(name= "activetouser", schema="public")
public class ActiveToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private  Activity activity;

    @Column
    private Long userID;

    public ActiveToUser() {
    }

    public ActiveToUser(Activity activity, Long userID) {
        this.activity = activity;
        this.userID = userID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}

    