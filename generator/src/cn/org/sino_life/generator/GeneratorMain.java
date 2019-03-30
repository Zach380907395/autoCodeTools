package cn.org.sino_life.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sino-life
 */

public class GeneratorMain {

	/**
	 * 通过数据库表生成文件,sf_new_20110928为模板的根目录
	 * 
	 * @throws Exception
	 */
	public static void generateByTable(GeneratorFacade g, String template) throws Exception {
		for (String string : initList()) {
			g.generateByTable(string, template); // 通过数据库表生成文件,template为模板的根目录

		}
	}

	public static void generateByProcedure(GeneratorFacade g, String procedureName, String template) throws Exception {
		g.generateByProcedure(procedureName, template);// 通过存储过程生成文件
	}

	/**
	 * 需要生成的表加如list中,可以批量生成，也可以单表生成
	 * 
	 * @return
	 */
	public static List<String> initList() {
		List<String> list = new ArrayList<String>();
		// list.add("t_trade");
		// list.add("t_card_bag");
		// list.add("t_card_wall");
		// list.add("t_sys_parameter");
		// list.add("t_sys_resource");
		// list.add("t_task");
		// list.add("t_task_challenge");
		// list.add("t_task_challenge_record");
		// list.add("t_ticket");
		// list.add("t_ticket_exchange_record");
		// list.add("t_user");
		// list.add("t_user_advise");
		// list.add("t_user_summary");
		// list.add("t_user_vip");
		// list.add("t_user_vip_record");
		// list.add("prj_login_recard");
		// list.add("prj_use_control");
		// list.add("prj_user_operate");
		// list.add("prj_user_contact");
		// list.add("upgrad_version");
		// list.add("user");
		// list.add("t_company");
		// list.add("t_equip_monitor_record");
		// list.add("v_code_area");
		// list.add("v_data_type");
		// list.add("v_verify_account_item");
		// list.add("v_verify_area_item");
		// list.add("t_Param_Relation");
		// list.add("t_region_infomation");
		// list.add("t_role");

		list.add("customer_base_info");
		list.add("call_record");
		list.add("user_info");
		list.add("app_registry");

		// list.add("admin_user");
		// list.add("customer_user");
		// list.add("delivery_location_history");
		// list.add("delivery_user");
		// list.add("order_delivery_record");
		// list.add("order_finance_statistics");
		// list.add("order_info");
		// list.add("product");
		return list;
	}

	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
		/**
		 * 有三点需要引起特别的注意 (1)数据库连接等一些配置在generator.xml中进行配置 (2)表无主键，无法生成 (3)外键关联的表无读权限，无法生成
		 */
		GeneratorFacade g = new GeneratorFacade();
		// mybatis_20170214,mybatis_ms_20180320,mybatis_springboot_20180118
		generateByTable(g, "mybatis_springboot_20180118");// 新框架下的模板
		// 打开文件夹
		Runtime.getRuntime().exec("cmd.exe /c start " + GeneratorProperties.getRequiredProperty("outRoot"));
	}
}
