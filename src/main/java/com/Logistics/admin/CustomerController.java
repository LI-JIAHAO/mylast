package com.Logistics.admin;

import com.Logistics.entity.Customer;
import com.Logistics.entity.PageBean;
import com.Logistics.service.CustomerService;
import com.Logistics.util.MD5Util;
import com.Logistics.util.ResponseUtil;
import com.Logistics.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;
    private static final Logger log = Logger.getLogger(CustomerController.class);// 日志文件

    /**
     * 登录
     *
     * @param customer
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String login(Customer customer, HttpServletRequest request) {
        try {
            String MD5pwd = MD5Util.MD5Encode(customer.getPassword(), "UTF-8");
            customer.setPassword(MD5pwd);
        } catch (Exception e) {
            customer.setPassword("");
        }
        Customer resultCustomer = customerService.login(customer);
        log.info("request: customer/login , customer: " + customer.toString());
        if (resultCustomer == null) {
            request.setAttribute("customer", customer);
            request.setAttribute("errorMsg", "请认真核对账号、密码！");
            return "login";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", resultCustomer);
            MDC.put("userName", customer.getUserName());
            return "redirect:/home.jsp";
        }
    }


    /**
     * 修改密码
     *
     * @param customer
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/modifyPassword")
    public String modifyPassword(Customer customer, HttpServletResponse response) throws Exception {
        String MD5pwd = MD5Util.MD5Encode(customer.getPassword(), "UTF-8");
        customer.setPassword(MD5pwd);
        int resultTotal = customerService.updateCustomer(customer);
        JSONObject result = new JSONObject();
        if (resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        log.info("request: customer/modifyPassword , customer: " + customer.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 退出系统
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        log.info("request: customer/logout");
        return "redirect:/login.jsp";
    }

    /**
     * @param page
     * @param rows
     * @param s_user
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows, Customer s_user, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        map.put("userName", StringUtil.formatLike(s_user.getUserName()));
        List<Customer> customerList = customerService.findCustomers(map);
        Long total = customerService.getTotalCustomer(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(customerList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: customer/list , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 添加或修改管理员
     *
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(Customer customer, HttpServletResponse response) throws Exception {
        int resultTotal = 0;
        String MD5pwd = MD5Util.MD5Encode(customer.getPassword(), "UTF-8");
        customer.setPassword(MD5pwd);
        if (customer.getId() == null) {
            resultTotal = customerService.addCustomer(customer);
        } else {
            resultTotal = customerService.updateCustomer(customer);
        }
        JSONObject result = new JSONObject();
        if (resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        log.info("request: customer/save , customer: " + customer.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 删除管理员
     *
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            customerService.deleteCustomer(Integer.parseInt(idsStr[i]));
        }
        result.put("success", true);
        log.info("request: customer/delete , ids: " + ids);
        ResponseUtil.write(response, result);
        return null;
    }
}
