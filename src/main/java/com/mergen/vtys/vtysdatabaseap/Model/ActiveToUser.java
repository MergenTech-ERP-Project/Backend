package com.mergen.vtys.vtysdatabaseap.Model;


import lombok.Data;
import org.springframework.ui.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "activetouser", schema="public")
@Data
public class ActiveToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long user_id;

    @Column
    private Long activity_id;

}

    