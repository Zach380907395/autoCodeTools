<#include "/java_copyright.include"> 
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import java.util.List;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ${basepackage}.vo.${className}Vo;
import ${basepackage}.dao.${className}Mapper;
import ${basepackage}.service.${className}Service;


@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements ${className}Service{
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private ${className}Mapper ${classNameLower}Mapper;
	
	 /**
     * 总数
     * @param ${classNameLower}Vo
     * @return
     */
    public int get${className}Count(${className}Vo ${classNameLower}Vo){
    	return ${classNameLower}Mapper.get${className}Count(${classNameLower}Vo);
    }
    
    /**
     * 分页列表
     * @param ${classNameLower}Vo
     * @return
     */
	 public List<${className}Vo> get${className}Page(${className}Vo ${classNameLower}Vo){
		 return ${classNameLower}Mapper.get${className}Page(${classNameLower}Vo);
	 }

    /**
     * 列表
     * @param ${classNameLower}Vo
     * @return
     */
    public List<${className}Vo> get${className}List(${className}Vo ${classNameLower}Vo){
    	return ${classNameLower}Mapper.get${className}List(${classNameLower}Vo);
    }
    
    /**
     * 根据主键查询
     * @param primaryKey
     * @return
     */
	 public ${className}Vo get${className}ByPrimaryKey(String primaryKey){
		 return ${classNameLower}Mapper.get${className}ByPrimaryKey(primaryKey);
	 }
	
    /**
	 * 保存
	 * @param ${classNameLower}Vo
	 */
    public int save(${className}Vo ${classNameLower}Vo){
    	
    	return ${classNameLower}Mapper.save(${classNameLower}Vo);
    }
    
    /**
	 * 更新
	 * @param ${classNameLower}Vo
	 */
    public int update(${className}Vo ${classNameLower}Vo){
    	return ${classNameLower}Mapper.update(${classNameLower}Vo);
    }
    
    /**
	 * 删除
	 * @param ${classNameLower}Vo
	 */
    public int delete(${className}Vo ${classNameLower}Vo){
    	return ${classNameLower}Mapper.delete(${classNameLower}Vo);
    }
	
	
}

