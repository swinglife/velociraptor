package com.swinglife.controller;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;



/***
* Controller 
* @author Swinglife
* @by auto code
*/
@Controller
@RequestMapping("/${modelName}")
public class ${modelName}Controller {
 
	/***
	* 分页查询列表
	* @param page
	* @return 
	*/
	public ModelAndView list(int page,HttpSession session,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("${path}/list");
		return mav;
	}
	
	/***
	* 转到添加页面
	* @param 
	* @return 
	*/
	public ModelAndView toAdd(HttpSession session,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("${path}/add");
		return mav;
	}
	
	/***
	* 添加
	* @param 
	* @return 
	*/
	public ModelAndView add(${modelName} ${path},HttpSession session,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("redirest:/${path}/list");
		return mav;
	}
	
	/***
	* 转到修改页面
	* @param id
	* @return 
	*/
	public ModelAndView toEdit(Integer id,HttpSession session,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("${path}/edit");
		return mav;
	}
	
	/***
	* 编辑
	* @param 
	* @return 
	*/
	public ModelAndView edit(${modelName} ${path},HttpSession session,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("redirest:/${path}/list");
		return mav;
	}
 
 	/***
	* 删除
	* @param id
	* @return 
	*/
 	public ModelAndView delete(Integer id,HttpSession session,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("redirest:/${path}/list");
		return mav;
	}
 
  
}
 