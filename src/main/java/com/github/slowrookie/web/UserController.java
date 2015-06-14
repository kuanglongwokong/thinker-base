package com.github.slowrookie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.slowrookie.persistence.entity.User;
import com.github.slowrookie.persistence.entity.query.UserQuery;
import com.github.slowrookie.service.UserService;

/**
 * 用户管理
 * 
 * @author 刘佳兴
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 根据主键id查询
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	public User getUser(@PathVariable("id") Long id) {
		return userService.findOne(id);
	}

	/**
	 * 查询获取users支持全属性条件查询
	 * 
	 * @param userQuery
	 * 		用户查询对象，通过JSON传递
	 * @param pageParamater
	 * 		分页查询条件对象
	 * @return Page<User>
	 * 		返回分页数据
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody public Page<User> findAll(PageParamater pageParamater, UserQuery userQuery) {
		return userService.findAll(userQuery, pageParamater.getPageRequest());
	}
	
	
	/**
	 * 保存或者更新
	 * 
	 * @param user
	 * 		序列化的User对象
	 * @return User
	 * 		返回更新完成后的User
	 */
	@RequestMapping(value = "/users", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody public User persist(@RequestBody User user){
		return userService.persist(user);
	}
	
	/**
	 * 删除用户信息
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable("id") Long id){
		userService.remove(id);
	}
	
	
}
