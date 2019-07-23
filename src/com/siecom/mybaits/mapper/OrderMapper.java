package com.siecom.mybaits.mapper;

import java.util.List;

import com.siecom.mybaits.po.OrderUser;
import com.siecom.mybaits.po.Orders;
import com.siecom.mybaits.po.User;

public interface OrderMapper {
	List<Orders> getOrderList();
	List<Orders> getOrderListResultMap();
	List<OrderUser> getOrderUserListResultType();
	List<Orders> getOrderUserListResultMap();
	List<User> getUserOrdersResultMap();
}
