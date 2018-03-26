package com.example.demo.domain.mysql;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ds on 2018-03-26.
 */

@Entity
@Data
public class USER implements Serializable{

    private static final long serialVersionUID = 1062898914988042848L;

    @Id
    private int id;
    private String std_id;
    private String password;
    private String name;
    private int type;
}
