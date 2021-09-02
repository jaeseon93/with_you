package co.withyou.care.hospital.GwangMyeong.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.withyou.care.hospital.GwangMyeong.service.GwangMyeongService;
import co.withyou.care.hospital.GwangMyeong.service.GwangMyeongVo;
import co.withyou.care.hospital.GwangMyeong.service.HospitalVo;
import co.withyou.care.hospital.GwangMyeong.service.SeoulVo;

@Controller
public class GwangmyeongController {

	@Autowired
	//private HospitalMap map;
	
	private GwangMyeongService insert;
	
	@RequestMapping("/gwnamyeong.do")
	public Object GwangMyeong(GwangMyeongVo vo, Model model) throws JsonProcessingException, IOException{
		String url = "https://data.gm.go.kr/openapi/RecuperationHospital";

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();		
		HttpEntity<?> entity = new HttpEntity<String>(headers);
		ObjectMapper mapper = new ObjectMapper();
		final JsonFactory  factory = mapper.getFactory();
		
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("KEY", "bb57b95562164f2496e2d3a710b19454").queryParam("Type", "json")
				.queryParam("pIndex", 1).queryParam("pSize", 100).build(false);
		// 자동으로 encode해주는것을 막기위해false		
				
		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				String.class);
		//String api = mapper.writeValueAsString(response);
		//JsonNode myJsonNode = mapper.readTree(response);
		System.out.println(response.getBody());

		JsonNode myJsonNode = mapper.readTree(response.getBody());
		System.out.println("광명 myJsonNode :"+myJsonNode);
		System.out.println("myJson :"+myJsonNode.get("RecuperationHospital").get(1).get("row"));
		JsonNode Gwang =myJsonNode.get("RecuperationHospital").get(1).get("row"); 
		//ArrayList<Map> Gwang = (ArrayList<Map>)
		System.out.println("gwang :"+Gwang);
		for(JsonNode obj : Gwang) { 
			System.out.println("병원이름 :"+obj.get("BIZPLC_NM"));
			vo = new GwangMyeongVo();
				vo.setBIZPLC_NM(obj.get("BIZPLC_NM").toString());
				vo.setREFINE_WGS84_LOGT(obj.get("REFINE_WGS84_LOGT").toString());
				vo.setREFINE_WGS84_LAT(obj.get("REFINE_WGS84_LAT").toString());
				vo.setREFINE_ROADNM_ADDR(obj.get("REFINE_ROADNM_ADDR").toString());
				vo.setHOSPTLRM_CNT(obj.get("HOSPTLRM_CNT").toString());
				vo.setMEDSTAF_CNT(obj.get("MEDSTAF_CNT").toString());
				vo.setSICKBD_CNT(obj.get("SICKBD_CNT").toString());
			System.out.println("vo : "+vo);
			try {
				insert.gwangmyeonginsert(vo);
			} catch (Exception e) {
				e.printStackTrace();
			} 
				
			
		}
		model.addAttribute("gwangmyeong",Gwang);
		
		return response;
	}	
	
	@RequestMapping("/seoul.do")
	public Object Seoul(SeoulVo vo, Model model) throws JsonProcessingException, IOException{
		String url = "http://openapi.seoul.go.kr:8088/51565841706a736836327769544459/json/nursingHospitalInfo/1/20";

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();		
		HttpEntity<?> entity = new HttpEntity<String>(headers);
		ObjectMapper mapper = new ObjectMapper();
		final JsonFactory  factory = mapper.getFactory();
		
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
//				.queryParam("KEY", "51565841706a736836327769544459").queryParam("Type", "json")
//				.queryParam("SERVICE", "nursingHospitalInfo").queryParam("START_INDEX", 1).queryParam("END_INDEX", 20)
				.build(false);
		// 자동으로 encode해주는것을 막기위해false		
				
		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				String.class);
		//String api = mapper.writeValueAsString(response);
		//JsonNode myJsonNode = mapper.readTree(response);
		System.out.println(response.getBody());

		JsonNode myJsonNode = mapper.readTree(response.getBody());
		System.out.println("서울 myjosn"+myJsonNode);
		//System.out.println("myJson :"+myJsonNode.get("nursingHospitalInfo").get(0).get("row"));
		System.out.println("myJson :"+myJsonNode.get("nursingHospitalInfo").get("row"));

		JsonNode Seoul =myJsonNode.get("nursingHospitalInfo").get("row"); 
		//ArrayList<Map> Gwang = (ArrayList<Map>)
		System.out.println("서울병원 :"+Seoul);
		for(JsonNode obj : Seoul) { 
			vo = new SeoulVo();
			vo.setNM(obj.get("NM").toString());
			vo.setADDR(obj.get("ADDR").toString());
			vo.setBED_NUM(obj.get("BED_NUM").toString());
			vo.setTEL(obj.get("TEL").toString());
			vo.setMEDICAL_STAFF_NUM(obj.get("MEDICAL_STAFF_NUM").toString());
			vo.setHOSPITAL_ROOM_NUM(obj.get("HOSPITAL_ROOM_NUM").toString());
			vo.setXCODE(obj.get("XCODE").toString());
			vo.setYCODE(obj.get("YCODE").toString());
			System.out.println("vo : "+vo);
			try {
				insert.SeoulInsert(vo);
			} catch (Exception e) {
				e.printStackTrace();
			} 
				
			
		}
		model.addAttribute("Seoul",Seoul);
		
		return response;
	}
	
	@RequestMapping("/hospital.do")
	public String Hospital(HospitalVo vo,Model model) throws Exception {
		
		List<Map> list = insert.selectList(vo);
		System.out.println("요양병원리스트 :"+list);
		model.addAttribute("selectList",list);
		
		return "family/hospital/Hospital";
		
	}
}
