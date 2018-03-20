package com.Logistics.dao;

import com.Logistics.entity.Vehicle;

import java.util.List;
import java.util.Map;

public interface VehicleDao {
	/**
	 * 返回相应的数据集合
	 * 
	 * @param map
	 * @return
	 */
	List<Vehicle> findVehicles(Map<String, Object> map);

	/**
	 * 数据数目
	 * 
	 * @param map
	 * @return
	 */
	Long getTotalVehicles(Map<String, Object> map);

	/**
	 * 添加车辆
	 * 
	 * @return
	 */
	int insertVehicle(Vehicle vehicle);

	/**
	 * 修改车辆信息
	 * 
	 * @return
	 */
	int updateVehicle(Vehicle vehicle);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delVehicle(String id);

	/**
	 * 根据id查找
	 * 
	 * @return
	 * @param id
	 */
	Vehicle getVehicleById(Integer id);

}
