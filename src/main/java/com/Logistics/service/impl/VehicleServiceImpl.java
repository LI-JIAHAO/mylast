package com.Logistics.service.impl;

import com.Logistics.dao.VehicleDao;
import com.Logistics.entity.Vehicle;
import com.Logistics.service.VehicleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

    @Resource
    private VehicleDao vehicleDao;

    @Override
    public List<Vehicle> findVehicles(Map<String, Object> map) {
        return vehicleDao.findVehicles(map);
    }

    @Override
    public Long getTotalVehicles(Map<String, Object> map)
    {
        return vehicleDao.getTotalVehicles(map);
    }

    @Override
    public int addVehicle(Vehicle vehicle) {
        if (vehicle.getLocation() == null || vehicle.getDes() == null ||vehicle.getDisable()==null|| getTotalVehicles(null) > 90 ) {
            return 0;
        }
        return vehicleDao.insertVehicle(vehicle);
    }

    @Override
    public int updateVehicle(Vehicle vehicle) {
        if (vehicle.getLocation() == null || vehicle.getDes() == null ||vehicle.getDisable()==null|| getTotalVehicles(null) > 90 ) {
            return 0;
        }
        return vehicleDao.updateVehicle(vehicle);
    }

    @Override
    public int deleteVehicle(String id) {
        return vehicleDao.delVehicle(id);
    }

    @Override
    public Vehicle findById(Integer id) {
        return vehicleDao.getVehicleById(id);
    }


}
