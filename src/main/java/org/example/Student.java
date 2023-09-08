package org.example;

import lombok.*;

@Data
@Builder
public class Student {
    String id;
    String name;
    String address;
    @With
    int grade;

}
