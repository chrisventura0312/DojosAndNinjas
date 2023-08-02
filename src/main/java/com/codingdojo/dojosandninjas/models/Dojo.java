package com.codingdojo.dojosandninjas.models;

// Java imports
import java.util.Date;
import java.util.List;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

// Spring imports
import org.springframework.format.annotation.DateTimeFormat;
//Application imports


@Entity
@Table(name="dojos")
public class Dojo {
    //=================== Annotations ===================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="Name cannot be blank")
    @Size(min = 2, max = 30, message="Name must be between 2 and 30 characters")
    private String name;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    //=================== Relationships ===================
    @OneToMany(mappedBy="dojo", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Ninja> ninjas;
    //=================== Constructors ===================
    public Dojo() {
    }
    //=================== Getters ===================
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public List<Ninja> getNinjas() {
        return ninjas;
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

    public void setName(String name) {
        this.name = name;
    }

    
    //=================== Methods ===================\
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
