package com.vdcalc.calculator.model;

import jakarta.persistence.*;

@Entity
@Table(name="vehicle_dynamics")
public class VehicleDynamics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String vehicleType;
    private double horsepower;
    private double weight;
    private double tireFrictionCoefficient;

    // New fields for acceleration and deceleration
    private double acceleration;
    private double deceleration;

    private double speed;

    // Getters and Setters for all fields

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(double horsePower) {
        this.horsepower = horsePower;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTireFrictionCoefficient() {
        return tireFrictionCoefficient;
    }

    public void setTireFrictionCoefficient(double tireFrictionCoefficient) {
        this.tireFrictionCoefficient = tireFrictionCoefficient;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getDeceleration() {
        return deceleration;
    }

    public void setDeceleration(double deceleration) {
        this.deceleration = deceleration;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

}
