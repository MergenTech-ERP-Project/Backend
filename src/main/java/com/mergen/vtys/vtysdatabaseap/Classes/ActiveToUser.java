package com.mergen.vtys.vtysdatabaseap.Classes;


import javax.persistence.*;

@Entity
@Table(name= "ActiveToUser", schema="public")
public class ActiveToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long activityId;

    @Column
    private Long userID;

    public ActiveToUser() {
    }

    public ActiveToUser(Long activityId, Long userID) {
        this.activityId = activityId;
        this.userID = userID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}

    