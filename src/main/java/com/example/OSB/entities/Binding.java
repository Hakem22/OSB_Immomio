package com.example.OSB.entities;

import javax.persistence.*;

@Entity
public class Binding {
    @Id @GeneratedValue
    private Long id;
    private String application;
    @ManyToOne
    @JoinColumn
    private Service service;

    public Binding() {}

    public Binding(String application, Service service) {
        this.application = application;
        this.service = service;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplication() { return application; }

    public Service getService() { return service; }

    public Long getId() { return id; }

    public void setApplication(String application) { this.application = application; }

    public void setService(Service service) { this.service = service; }
}
