package com.kenInternational.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class StudentModal {
    private int id;
    private String fName;
    private String LName;
}
