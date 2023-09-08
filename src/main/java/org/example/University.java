package org.example;

import lombok.Value;

import java.util.List;

@Value
public class University {
    String id;
    String name;
    List<Course> courses;
}
