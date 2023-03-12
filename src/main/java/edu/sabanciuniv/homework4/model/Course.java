package edu.sabanciuniv.homework4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String code;


    @JsonBackReference
    @JsonIgnore
    @ManyToMany (mappedBy = "courseList" )
    private Set<Student> studentList = new HashSet<>();

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Course(int id, String name, String code, Set<Student> studentList) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.studentList = studentList;
    }


    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;

        if (id != course.id) return false;
        if (!Objects.equals(name, course.name)) return false;
        return Objects.equals(code, course.code);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

}
