package com.vdcalc.calculator.service;

import com.vdcalc.calculator.model.VehicleDynamics;
import com.vdcalc.calculator.repository.VehicleDynamicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleDynamicsServiceImpl implements VehicleDynamicsService {

    @Autowired
    private VehicleDynamicsRepository repository;

    private static final double GRAVITY = 9.81; // Acceleration due to gravity in m/s^2

    @Override
    public VehicleDynamics calculateDynamics(VehicleDynamics dynamics) {
        // Perform calculations
        dynamics = calculateAcceleration(dynamics);
        dynamics = calculateDeceleration(dynamics);
        return repository.save(dynamics);
    }

    private VehicleDynamics calculateAcceleration(VehicleDynamics dynamics) {
        double force = (dynamics.getHorsepower() * 745.7) / dynamics.getSpeed();
        double acceleration = force / dynamics.getWeight();
        double maxAcceleration = dynamics.getTireFrictionCoefficient() * GRAVITY;
        dynamics.setAcceleration(Math.min(acceleration, maxAcceleration));
        return dynamics;
    }

    private VehicleDynamics calculateDeceleration(VehicleDynamics dynamics) {
        // Assuming deceleration is primarily limited by tire grip
        double deceleration = dynamics.getTireFrictionCoefficient() * GRAVITY;
        dynamics.setDeceleration(deceleration);
        return dynamics;
    }
}
