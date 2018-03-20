package com.Logistics.service;

import com.Logistics.entity.Vehicle;

import java.util.List;
import java.util.Map;


public interface VehicleService {
	/**
	 * 返回相应的数据集合
	 *
	 * @param map
	 * @return
	 */
	public List<Vehicle> findVehicles(Map<String, Object> map);

	/**
	 * 数据数目
	 *
	 * @param map
	 * @return
	 */
	public Long getTotalVehicles(Map<String, Object> map);

	/**
	 * 添加车辆
	 *
	 * @return
	 */
	public int addVehicle(Vehicle vehicle);

	/**
	 * 修改车辆信息
	 *
	 * @return
	 */
	public int updateVehicle(Vehicle vehicle);

	/**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	public int deleteVehicle(String id);

	/**
	 * 根据id查找
	 *
	 * @param id
	 * @return
	 */
	public Vehicle findById(Integer id);
}
