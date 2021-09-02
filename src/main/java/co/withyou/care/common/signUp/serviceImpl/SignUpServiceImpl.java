package co.withyou.care.common.signUp.serviceImpl;

import java.util.Random;

import org.apache.ibatis.executor.ReuseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.common.signUp.mapper.SignUpMapper;
import co.withyou.care.common.signUp.service.FamilyVO;
import co.withyou.care.common.signUp.service.HelperVO;
import co.withyou.care.common.signUp.service.PatientVO;
import co.withyou.care.common.signUp.service.SignUpService;

@Service("signUpService")
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	public SignUpMapper map;
	
	@Override
	public int checkEmailFamily(FamilyVO vo) throws Exception {
		return map.checkEmailFamily(vo);
	}

	@Override
	public int checkEmailHelper(HelperVO vo) throws Exception {
		return map.checkEmailHelper(vo);
	}

	/**
	 * 환자와 보호자 정보를 넣고, 환자코드를 리턴합니다.
	 */
	@Override
	public String insertFamilyAndPatient(FamilyVO fVO, PatientVO pVO) throws Exception {

		//보호자 insert
		map.insertFamily(fVO);
		//보호자 번호 조회, 환자 VO에 삽입
		pVO.setFamilyNo(map.selectFamilyNo(fVO));
		//환자 코드 생성
		String code = createPatientVCode();
		pVO.setPatientVcode(code);
		//환자 insert
		map.insertPatient(pVO);
		return code;
	}

	@Override
	public void insertHelper(HelperVO vo) throws Exception {
		map.insertHelper(vo);
	}

	@Override
	public String createPatientVCode() throws Exception {
		int n = 5; // n자리 쿠폰 
		char[] chs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
				'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		Random rd = new Random();
		while (true) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				char ch = chs[rd.nextInt(chs.length)];
				sb.append(ch);
			}
			String code = sb.toString();
			//System.out.println(code);
			int result = map.checkPatientVCode(code);
			if(result == 0) {
				return code;
			}
		}
	}

}
