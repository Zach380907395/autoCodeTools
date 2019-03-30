<#include "/java_copyright.include"> 
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import ${basepackage}.vo.${className}Vo;
import ${basepackage}.service.${className}Service;


@Controller
public class ${className}Controller {
	@Autowired
	private ${className}Service ${classNameLower}Service;
	
	
	/**
	 * 进入主页面
	 * @param filterMask
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/${classNameLower}/main", method = RequestMethod.GET)
	String mainPage(${className}Vo filterMask,Model model,HttpServletRequest request, HttpServletResponse response)
	{ 
		model.addAttribute("filterMask", filterMask);
		return "${className}/main";
	}
	
	/**
	 * table 列表
	 * @param request
	 * @param response
	 * @param ${className}Vo
	 * @throws Exception
	 */
	@RequestMapping(value = "/${classNameLower}/query")
    public void getJsonDataGrid(HttpServletRequest request,
	    HttpServletResponse response,${className}Vo filterMask) throws Exception {
	List<${className}Vo> list = new ArrayList<${className}Vo>();
	int total = ${classNameLower}Service.get${className}Count(filterMask);
	list = ${classNameLower}Service.get${className}List(filterMask);
	PrintWriter write = response.getWriter();
	
	Map map=new HashMap();
	map.put("total", total);
	map.put("rows",  list);

	write.write(JSONObject.toJSONString(map));
	write.flush();
	write.close();
    }

	/**
	 * 进入新增页面
	 * @param filterMask
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/${classNameLower}/newPage", method = RequestMethod.POST)
	String NewPage(${className}Vo filterMask,Model model)
	{
		model.addAttribute("filterMask", filterMask);
		return "${className}/new";
	}
	
	/**
	 * 新增
	 * @param country
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/${classNameLower}/save")
	@Transactional
	public String save(HttpServletRequest request,Model model,
			    HttpServletResponse response,${className}Vo filterMask) throws Exception {
			//保存
		    ${classNameLower}Service.save(filterMask);
		    model.addAttribute("filterMask", new ${className}Vo());
			return "${className}/main";

	}
	
	/**
	 * 进入修改页面
	 * @param filterMask
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/${classNameLower}/editPage", method = RequestMethod.POST)	
    public String  editPage(${className}Vo filterMask,Model model) throws Exception{
	model.addAttribute("filterMask", filterMask);
	return "${className}/edit";
    }
	
	
	/**
	 * 修改
	 * @param country
	 * @param result
	 * @return
	 */
	 @RequestMapping(value = "/${classNameLower}/edit")
	    @Transactional
	    public String edit(HttpServletRequest request,Model model,
		    HttpServletResponse response,${className}Vo filterMask) throws Exception {
		
		 ${classNameLower}Service.update(filterMask);
		 model.addAttribute("filterMask", new ${className}Vo());
		 return "${className}/main";
	    }
	
	 
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(value = "/${classNameLower}/delete")
	@Transactional
	public void delete(${className}Vo filterMask,HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		${classNameLower}Service.delete(filterMask);
		PrintWriter write = response.getWriter();
		write.write("SUCC");
		write.flush();
		write.close();
	}
}
	