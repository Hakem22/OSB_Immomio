package com.example.OSB.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Catalog {
    @Id @GeneratedValue
    private Long id;
    private String Name;
    private String description;
    private boolean isFree;

    @OneToMany(mappedBy = "catalog")
    private Set<Service> services;

    public Catalog() {}

    public Catalog(String name) {
        Name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return Name; }

    public Set<Service> getServices() { return services; }

    public Long getId() { return id; }

    public void setName(String name) { Name = name; }

    public void setServices(Set<Service> services) { this.services = services; }
}
