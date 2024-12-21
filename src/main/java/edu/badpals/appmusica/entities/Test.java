package edu.badpals.appmusica.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "string", nullable = false)
    private String test_string;

    public Test() {}

    public Test(String test_string) {
        this.test_string = test_string;
    }

    public Integer getId() {
        return id;
    }

    public String getTest_string() {
        return test_string;
    }

    public void setTest_string(String test_string) {}
}
