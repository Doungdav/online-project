package com.path.online_store.models.dao.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    /*@ManyToMany(mappedBy = "roles")
    private Set<User> users;
    @ManyToMany
    private Set<Authority> authorities;*/
}
