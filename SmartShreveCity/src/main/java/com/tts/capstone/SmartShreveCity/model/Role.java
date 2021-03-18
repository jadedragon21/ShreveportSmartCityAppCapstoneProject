package com.tts.capstone.SmartShreveCity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
 *  Annotation is a quidk way of implementing the builder pattern per the following url
 *   https://www.baeldung.com/creational-design-patterns#builder
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;
    private String role;
} // end of role model