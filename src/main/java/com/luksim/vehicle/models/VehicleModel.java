package com.luksim.vehicle.models;

import jakarta.persistence.*;

@Entity
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private VehicleBodyType bodyType;
    private Long makeId;

    @ManyToOne
    @JoinColumn(name = "makeId", insertable = false, updatable = false)
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

    public Long getMakeId() {
        return makeId;
    }

    public void setMakeId(Long makeId) {
        this.makeId = makeId;
    }

    public VehicleMake getMake() {
        return make;
    }

    public void setMake(VehicleMake make) {
        this.make = make;
    }
}
