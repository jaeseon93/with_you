package co.withyou.care.admin.adminfamily.service;

import java.util.List;


public interface AdminFamilyService { 
	
	List<AdminFamilyVo> selectAll() throws Exception;
	AdminFamilyVo selectfm(AdminFamilyVo vo) throws Exception;
	int FamilyDelete(AdminFamilyVo vo) throws Exception;
	
	
}
