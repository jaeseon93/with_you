package co.withyou.care.admin.adminhelper.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import co.withyou.care.admin.adminhelper.service.AdminHelperVo;

@MapperScan
public interface AdminHelperMapper {
	List<AdminHelperVo> HelperselectAll() throws Exception;

	AdminHelperVo selectHp(AdminHelperVo vo) throws Exception;

	int HelperDelete(AdminHelperVo vo) throws Exception;
}
