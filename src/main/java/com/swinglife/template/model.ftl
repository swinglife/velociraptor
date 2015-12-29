package com.swinglife.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/***
*
* @author Swinglife
* @by auto code
*/
@Table(name="${tableName}")
@Entity
public class ${modelName} implements java.io.Serializable{
 
 <#list list as table>
 	/**${table.remark}**/
 	<#if table.name == 'id' >
 	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 	</#if>
 	@Column(name="${table.columnName}")
 	private ${table.type} ${table.name}; 
 </#list>
 
  	/**Get Set Auto Build**/
  <#list list as table>
 	public ${table.type} get${table.upName}(){
 		return ${table.name};
 	} 
 	
 	public void set${table.upName}(${table.type} ${table.name}){
 		this.${table.name} = ${table.name};
 	}
 </#list>
 
  
}
 