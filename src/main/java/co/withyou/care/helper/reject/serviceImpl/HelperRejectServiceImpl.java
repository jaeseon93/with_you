package co.withyou.care.helper.reject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import co.withyou.care.helper.reject.service.HelperRejectService;
import co.withyou.care.helper.reject.service.RejectVo;

public class HelperRejectServiceImpl implements HelperRejectService{

	@Autowired
	public HelperRejectService reject;
	@Override
	public int RejectUpdate(RejectVo vo) throws Exception {
		// TODO Auto-generated method stub
		return reject.RejectUpdate(vo);
	}

}
