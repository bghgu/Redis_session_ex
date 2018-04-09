package com.example.demo.domain.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ds on 2018-03-26.
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class USER implements Serializable{

    private static final long serialVersionUID = 1062898914988042848L;

    //객체의 키 값, 이 값을 통해 객체를 얻어 온다.
    @Id
    private int id;
    private String std_id;
    private String password;
    private String name;
    private int type;
    private String sessionId;
}
