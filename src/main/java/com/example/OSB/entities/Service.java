package com.example.OSB.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Service {
    @Id @GeneratedValue
    private Long id;
    private String Name;
    private String description;
    private boolean isBindable;
    @ManyToOne
    @JoinColumn
    private Catalog catalog;
    @OneToMany(mappedBy = "service")
    private Set<Binding> bindings;

    public Service() {}

    public Service(String name, Catalog catalog) {
        Name = name;
        this.catalog = catalog;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return Name; }

    public Catalog getCatalog() { return catalog; }

    public Set<Binding> getBindings() { return bindings; }

    public Long getId() { return id; }

    /*
        different setter return type to slightly use the fluent API model
    */
    public Service setName(String name) { Name = name; return this; }

    public Service setCatalog(Catalog catalog) { this.catalog = catalog; return this; }

    public Service setBindings(Set<Binding> bindings) { this.bindings = bindings; return this; }
}
