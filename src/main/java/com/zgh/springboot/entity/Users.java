package com.zgh.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Users {
    private Integer id;

    private String userName;

    private String address;

    private Date createTime;

    private String email;

    private Integer dId;

}
