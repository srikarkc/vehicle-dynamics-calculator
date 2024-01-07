package com.vdcalc.calculator.controller;

import com.vdcalc.calculator.model.VehicleDynamics;
import com.vdcalc.calculator.service.VehicleDynamicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dynamics")
public class VehicleDynamicsController {

    @Autowired
    private VehicleDynamicsService service;

    @PostMapping("/calculate")
    public ResponseEntity<VehicleDynamics> calculateDynamics(@RequestBody VehicleDynamics dynamics) {
        VehicleDynamics calculatedDynamics = service.calculateDynamics(dynamics);
        return dynamics != null ? ResponseEntity.ok(dynamics) : ResponseEntity.notFound().build();
    }
}
