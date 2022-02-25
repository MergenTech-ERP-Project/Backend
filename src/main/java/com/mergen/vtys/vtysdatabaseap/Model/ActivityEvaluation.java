package com.mergen.vtys.vtysdatabaseap.Model;



import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="activityevaluation", schema="public")
@Data
public class ActivityEvaluation {
    @Id
    @SequenceGenerator(name="identifier", sequenceName="mytable_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    private Long id;

    @Column
    private Long activities_id;

    @Column
    private Long users_id;

    @Column
    private String evaluation;
}
