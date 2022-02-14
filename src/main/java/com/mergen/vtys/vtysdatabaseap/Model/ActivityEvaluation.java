package com.mergen.vtys.vtysdatabaseap.Model;



import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="activityevaluation", schema="public")
@Data
public class ActivityEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long activityId;

    @Column
    private Long userId;

    @Column
    private String evaluation;
}
