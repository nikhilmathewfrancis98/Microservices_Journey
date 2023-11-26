//package com.kenInternational.Entity;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "users")
//public class UserDemo {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // This will create the user table with the identity auto increment
//    private  Long id;
//
//    @Column(nullable = false)
//    @JsonProperty("fName")
//    private  String fName;
//    @Column(nullable = false)
//    @JsonProperty("lName")
//    private String lName;
//    @Column(nullable = false,unique = true)
//    private String email;
//}
