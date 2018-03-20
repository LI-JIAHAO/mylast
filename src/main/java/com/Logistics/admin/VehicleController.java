package com.Logistics.admin;

import com.Logistics.entity.PageBean;
import com.Logistics.entity.Vehicle;
import com.Logistics.service.VehicleService;
import com.Logistics.util.ResponseUtil;
import com.Logistics.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/vehicle")
public class VehicleController {
	@Resource
	private VehicleService vehicleService;
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(VehicleController.class);// 日志文件

	/**
	 * 查找相应的数据集合
	 * 
	 * @param page
	 * @param rows
	 * @param vehicle
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Vehicle vehicle, HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (page != null && rows != null) {
			PageBean pageBean = new PageBean(Integer.parseInt(page),
					Integer.parseInt(rows));
			map.put("start", pageBean.getStart());
			map.put("size", pageBean.getPageSize());
		}
		if (vehicle != null) {
			map.put("location",
					StringUtil.formatLike(vehicle.getLocation()));
		}
		List<Vehicle> vehicleList = vehicleService.findVehicles(map);
		Long total = vehicleService.getTotalVehicles(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(vehicleList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		log.info("request: vehicle/list , map: " + map.toString());
		return null;
	}

	/**
	 * 保存或修改
	 * 
	 * @param vehicle
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Vehicle vehicle, HttpServletResponse response)
			throws Exception {
		int resultTotal = 0;
		if (vehicle.getId() == null) {
			resultTotal = vehicleService.addVehicle(vehicle);
		} else {
			resultTotal = vehicleService.updateVehicle(vehicle);
		}
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		log.info("request: vehicle/save , " + vehicle.toString());
		return null;
	}

	/**
	 * 删除
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids") String ids,
			HttpServletResponse response) throws Exception {
		JSONObject result = new JSONObject();
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			vehicleService.deleteVehicle(idsStr[i]);
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
		log.info("request: vehicle/delete , ids: " + ids);
		return null;
	}

	/**
	 * 根据id查找
	 *
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public Integer findById(@RequestParam(value = "id") Integer id,
						   HttpServletResponse response) throws Exception {
		Vehicle vehicle = vehicleService.findById(id);
		JSONObject jsonObject = JSONObject.fromObject(vehicle);
		ResponseUtil.write(response, jsonObject);
		log.info("request: vehicle/findById");
		return null;
	}

}