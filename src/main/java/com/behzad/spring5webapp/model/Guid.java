package com.behzad.spring5webapp.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Guid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String guidDescription;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "guid")
    private Set<Student> students = new HashSet<Student>();

    public String getGuidDescription() {
        return guidDescription;
    }

    public void setGuidDescription(String guidDescription) {
        this.guidDescription = guidDescription;
    }

    @Override
    public String toString() {
        return "Guid{" +
                "id=" + id +
                ", guidDescription='" + guidDescription + '\'' +
                ", students=" + students +
                '}';
    }

    public Set<Student> getStudents() {
        return students;
    }
}
