<#include "/java_copyright.include"> 
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ${basepackage}.common.Constants;
import ${basepackage}.common.Result;
import ${basepackage}.common.DataResult;
import ${basepackage}.common.PageResult;
import ${basepackage}.vo.${className}Vo;
import ${basepackage}.service.${className}Service;


@Controller
public class ${className}Controller {
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private ${className}Service ${classNameLower}Service;
	
	
	/**
	 * 分页 列表
	 * @param request
	 * @param filterMask
	 * @throws Exception
	 */
	@RequestMapping(value = "/${classNameLower}/query_page")
	@ResponseBody
    public PageResult getPageData(HttpServletRequest request,${className}Vo filterMask) throws Exception {
		PageResult result=PageResult.initResult();
		
		int pageNum = Integer.valueOf(request.getParameter(Constants.PAGE_NUM));
		int pageSize = Integer.valueOf(request
				.getParameter(Constants.PAGE_SIZE));
		filterMask.setPage(pageNum);
		filterMask.setPageSize(pageSize);
		try{
			int total = ${classNameLower}Service.get${className}Count(filterMask);
			List<${className}Vo> list = ${classNameLower}Service.get${className}Page(filterMask);
			
			result.setAllCount(total);
			result.setPageNum(pageNum);
			result.setPageSize(pageSize);
			result.setData(list);
		}catch (RuntimeException e){
			result.setCode(Constants.FAILURE);
			result.setMsg(e.getMessage());
			logger.error("系统异常,"+e.getMessage(),e);
		}catch (Exception e){
			result.setCode(Constants.FAILURE);
			result.setMsg("系统异常,请稍后重试");
			logger.error("系统异常,请稍后重试",e);
		}
		return result;
    }
	
	/**
	 * 查询所有列表
	 * @param request
	 * @param filterMask
	 * @throws Exception
	 */
	@RequestMapping(value = "/${classNameLower}/query_list", method = RequestMethod.POST)
	@ResponseBody
    public DataResult getList(HttpServletRequest request,@RequestBody ${className}Vo filterMask) throws Exception {
		DataResult result=DataResult.initResult();
		try{
			List<${className}Vo> list = ${classNameLower}Service.get${className}List(filterMask);
			
			result.setData(list);
		}catch (RuntimeException e){
			result.setCode(Constants.FAILURE);
			result.setMsg(e.getMessage());
			logger.error("系统异常,"+e.getMessage(),e);
		}catch (Exception e){
			result.setCode(Constants.FAILURE);
			result.setMsg("系统异常,请稍后重试");
			logger.error("系统异常,请稍后重试",e);
		}
		return result;
    }
	
	/**
	 * 查询单条信息
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/${classNameLower}/queryById")
	@ResponseBody
    public DataResult queryById(HttpServletRequest request) throws Exception {
		DataResult result=DataResult.initResult();
		String id=request.getParameter("id");
		try {
			${className}Vo bean = ${classNameLower}Service.get${className}ByPrimaryKey(id);
		
			result.setData(bean);
		}catch (RuntimeException e){
			result.setCode(Constants.FAILURE);
			result.setMsg(e.getMessage());
			logger.error("系统异常,"+e.getMessage(),e);
		}catch (Exception e){
			result.setCode(Constants.FAILURE);
			result.setMsg("系统异常,请稍后重试");
			logger.error("系统异常,请稍后重试",e);
		}
		return result;
    }

	
	/**
	 * 保存
	 * @param filterMask
	 * @return
	 */
	@RequestMapping(value = "/${classNameLower}/save", method = RequestMethod.POST)
	@ResponseBody
	public Result save(HttpServletRequest request,@RequestBody ${className}Vo filterMask) throws Exception {
		Result result=Result.initResult();
		try {
			//保存
		    ${classNameLower}Service.save(filterMask);
		}catch (RuntimeException e){
			result.setCode(Constants.FAILURE);
			result.setMsg(e.getMessage());
			logger.error("系统异常,"+e.getMessage(),e);
		}catch (Exception e){
			result.setCode(Constants.FAILURE);
			result.setMsg("系统异常,请稍后重试");
			logger.error("系统异常,请稍后重试",e);
		}
		return result;
	}
	
	/**
	 * 修改
	 * @param filterMask
	 * @return
	 */
	@RequestMapping(value = "/${classNameLower}/update", method = RequestMethod.POST)
	@ResponseBody
    public Result update(HttpServletRequest request,@RequestBody ${className}Vo filterMask) throws Exception {
		Result result=Result.initResult();
		try {
			${classNameLower}Service.update(filterMask);
		}catch (RuntimeException e){
			result.setCode(Constants.FAILURE);
			result.setMsg(e.getMessage());
			logger.error("系统异常,"+e.getMessage(),e);
		}catch (Exception e){
			result.setCode(Constants.FAILURE);
			result.setMsg("系统异常,请稍后重试");
			logger.error("系统异常,请稍后重试",e);
		}
		return result;
	 }
	
	 
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(value = "/${classNameLower}/delete")
	@ResponseBody
	public Result delete(HttpServletRequest request,${className}Vo filterMask)throws Exception{
		Result result=Result.initResult();
		try {
			String id=request.getParameter("id");
			filterMask.setId(id);
			${classNameLower}Service.delete(filterMask);
		}catch (RuntimeException e){
			result.setCode(Constants.FAILURE);
			result.setMsg(e.getMessage());
			logger.error("系统异常,"+e.getMessage(),e);
		}catch (Exception e){
			result.setCode(Constants.FAILURE);
			result.setMsg("系统异常,请稍后重试");
			logger.error("系统异常,请稍后重试",e);
		}
		return result;
	}
}
	