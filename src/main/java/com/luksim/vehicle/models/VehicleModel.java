package com.luksim.vehicle.models;

import jakarta.persistence.*;

@Entity
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private VehicleBodyType bodyType;

    @ManyToOne
    private VehicleMake make;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleBodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(VehicleBodyType bodyType) {
        this.bodyType = bodyType;
    }

    public VehicleMake getMake() {
        return make;
    }

    public void setMake(VehicleMake make) {
        this.make = make;
    }
}
