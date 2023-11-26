package com.kenInternational.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
//    public User(User user) {
//        this.user = this;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This will create the user table with the identity auto increment
    private  Long id;

    @Column(nullable = false)
    @JsonProperty("fName")
    private  String fName;
    @Column(nullable = false)
    @JsonProperty("lName")
    private String lName;
    @Column(nullable = false,unique = true)
    @JsonProperty("email")
    private String email;

//    @JsonIgnore
//    private  User user;
}
//
////@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
////@GenericGenerator(name = "native", strategy = "native")