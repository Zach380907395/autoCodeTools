<#include "/java_copyright.include"> 
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ${basepackage}.vo.${className}Vo;
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.service.${className}Service;


@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements ${className}Service{
	
	@Autowired
	private ${className}Dao ${classNameLower}Dao;
	
	 /**
     * 总数
     * @param ${classNameLower}Vo
     * @return
     */
    public int get${className}Count(${className}Vo ${classNameLower}Vo){
    	return ${classNameLower}Dao.get${className}Count(${classNameLower}Vo);
    }
    
    /**
     * 分页列表
     * @param ${classNameLower}Vo
     * @return
     */
	 public List<${className}Vo> get${className}Page(${className}Vo ${classNameLower}Vo){
		 return ${classNameLower}Dao.get${className}Page(${classNameLower}Vo);
	 }

    /**
     * 列表
     * @param ${classNameLower}Vo
     * @return
     */
    public List<${className}Vo> get${className}List(${className}Vo ${classNameLower}Vo){
    	return ${classNameLower}Dao.get${className}List(${classNameLower}Vo);
    }
    
    /**
     * 根据条件查询一条信息
     * @param ${classNameLower}Vo
     * @return
     */
	 public ${className}Vo get${className}BySelective(${className}Vo ${classNameLower}Vo){
		 return ${classNameLower}Dao.get${className}BySelective(${classNameLower}Vo);
	 }
	
    /**
	 * 保存
	 * @param ${classNameLower}Vo
	 */
    public int save(${className}Vo ${classNameLower}Vo){
    	
    	return ${classNameLower}Dao.save(${classNameLower}Vo);
    }
    
    /**
	 * 更新
	 * @param ${classNameLower}Vo
	 */
    public int update(${className}Vo ${classNameLower}Vo){
    	return ${classNameLower}Dao.update(${classNameLower}Vo);
    }
    
    /**
	 * 删除
	 * @param ${classNameLower}Vo
	 */
    public int delete(${className}Vo ${classNameLower}Vo){
    	return ${classNameLower}Dao.delete(${classNameLower}Vo);
    }
	
	
}

