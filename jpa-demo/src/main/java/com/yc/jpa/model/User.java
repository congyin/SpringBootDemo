package com.yc.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User implements Serializable {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    @Column(name="name")
    private String name;

    /**
     * 手机号码
     */
    @Column(name="mobile")
    private String mobile;

    /**
     * 邮箱
     */
    @Column(name="email")
    private String email;
}
