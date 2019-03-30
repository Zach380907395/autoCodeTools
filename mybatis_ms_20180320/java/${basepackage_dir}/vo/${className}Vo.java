<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.vo;

import java.io.Serializable;

import javax.persistence.*;
import ${basepackage}.common.PaginatedHelper;



public class ${className}Vo extends PaginatedHelper implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//属性
	<@generateFields/>
	
	//getter setter方法
	<@genGetSetProperties/>
		
}