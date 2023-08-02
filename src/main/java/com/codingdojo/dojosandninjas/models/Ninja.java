package com.codingdojo.dojosandninjas.models;
// Java imports
import java.util.Date;

// Jakarta validation imports
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
// Jakarta persistence imports
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.FetchType;

// Spring imports
import org.springframework.format.annotation.DateTimeFormat;
//Application imports

@Entity
@Table(name="ninjas")
public class Ninja {
    //=================== Annotations ===================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="Name cannot be blank")
    @Size(min=1, max=255, message="First name must be at least 1 character")
    private String firstName;

    @NotNull(message="Name cannot be blank")
    @Size(min=1, max=255, message="Last name must be at least 1 character")
    private String lastName;

    @NotNull(message="Age cannot be blank")
    private Integer age;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    //=================== Relationships ===================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    @NotNull(message="Dojo cannot be blank")
    private Dojo dojo;
    //=================== Constructors ===================
    public Ninja() {
    }
    //=================== Getters ===================
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() { 
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Dojo getDojo() {
        return dojo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }


    //=================== Setters ===================
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDojo(Dojo dojo) {
        this.dojo = dojo;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = new Date();
    }

    //=================== PrePersist ===================
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    //=================== PreUpdate ===================

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    //=================== Methods ===================
    @Override
    public String toString() {
        return String.format("Ninja[id=%d, firstName='%s', lastName='%s', age='%d']", id, firstName, lastName, age);
    }
    
}
