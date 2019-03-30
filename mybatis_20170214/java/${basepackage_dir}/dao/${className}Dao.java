<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import ${basepackage}.vo.${className}Vo;

@Repository("${classNameLower}Dao")
public interface ${className}Dao {
	
	 /**
     * 总数
     * @param ${classNameLower}Vo
     * @return
     */
	 public int get${className}Count(${className}Vo ${classNameLower}Vo);
	 
	 /**
     * 分页列表
     * @param ${classNameLower}Vo
     * @return
     */
	 public List<${className}Vo> get${className}Page(${className}Vo ${classNameLower}Vo);
	 
	 /**
     * 列表
     * @param ${classNameLower}Vo
     * @return
     */
	 public List<${className}Vo> get${className}List(${className}Vo ${classNameLower}Vo);
	 
	 /**
     * 根据条件查询一条信息
     * @param ${classNameLower}Vo
     * @return
     */
	 public ${className}Vo get${className}BySelective(${className}Vo ${classNameLower}Vo);
	 
	 /**
	 * 保存
	 * @param ${classNameLower}Vo
	 */
    public int save(${className}Vo ${classNameLower}Vo);
    
    /**
	 * 更新
	 * @param ${classNameLower}Vo
	 */
    public int update(${className}Vo ${classNameLower}Vo);
    
    /**
	 * 删除
	 * @param ${classNameLower}Vo
	 */
    public int delete(${className}Vo ${classNameLower}Vo);

}
