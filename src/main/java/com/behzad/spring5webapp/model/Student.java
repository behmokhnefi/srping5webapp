package com.behzad.spring5webapp.model;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name ;

    private String family;

    public Student(String name , String family){
        this.name=name;
        this.family=family;
    }
    public Student(){

    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guid_id")
    private Guid guid;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", guid=" + guid.getGuidDescription()  +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }
}
