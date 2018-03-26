package com.example.demo.domain.mysql;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ds on 2018-03-26.
 */

@Entity
@Data
public class USER {

    @Id
    private int id;
    private String std_id;
    private String password;
    private String name;
    private int type;
}
