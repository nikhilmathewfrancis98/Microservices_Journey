package com.kenInternational.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.*;

/**
 * Don't try to add the sensitive information to the dto
 *
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @JsonProperty("fName")
    @Column(nullable = false)
    private String fName;
    @Column(nullable = false)
    @JsonProperty("lName")
    private String lName;
    @Column(nullable = false,unique = true)
    @JsonProperty("email")
    private String email;
    private String note="This is a sample note that this is a DTO";

    public UserDto(Long id, String fName, String lName, String email) {
                this.id=id;
                this.fName=fName;
                this.lName=lName;
                this.email=email;
                this.note=this.getNote();
    }
}
