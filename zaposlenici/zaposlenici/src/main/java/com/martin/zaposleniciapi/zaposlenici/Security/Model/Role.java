package com.martin.zaposleniciapi.zaposlenici.Security.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by i.mihalina on 13.6.2017..
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private int id;
    @Column(name="role")
    private String role;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

}