package co.withyou.care.helper.confirm.onfirmcerviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import co.withyou.care.helper.confirm.service.ConfirmService;
import co.withyou.care.helper.confirm.service.ConfirmVo;

public class ConfirmServiceImpl implements ConfirmService{
	
	@Autowired
	public ConfirmService confirm;
	
	@Override
	public int ConfirmUpdate(ConfirmVo vo) throws Exception {
		// TODO Auto-generated method stub
		return confirm.ConfirmUpdate(vo);
	}

}
