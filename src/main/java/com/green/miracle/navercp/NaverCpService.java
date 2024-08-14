package com.green.miracle.navercp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.miracle.navercp.dto.NaverTokenDTO;
import com.green.miracle.navercp.dto.orgunit.ResponseResultDTO;
import com.green.miracle.navercp.dto.request.OrgUnitSaveDTO;
import com.green.miracle.utils.OpenApiUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NaverCpService {
	
	private final OpenApiUtil openApiUtil;
	//private final ObjectMapper objectMapper;
	
	@Value("${naver.client.id}")
	String clientId;
	
	@Value("${naver.client.secret}")
	String clientSecret;
	
	@Value("${naver.client.domain}")
	String domainId;

	public void orgUnitRead(String code, Model model) throws Exception {
		
		//접근하기 위한 토큰 생성
		String responseResult = getAccessToken(code);
		
		//문자열을 맵핑해서 객체로 변환
		//JSON 문자열 -> T타입 객체로 변환
		NaverTokenDTO result = openApiUtil.objectMapper(responseResult, new TypeReference<NaverTokenDTO>() {});
		
		String accessToken = result.getAccess_token();
		
		//부서 정보 조회
		String apiUrl = "https://www.worksapis.com/v1.0/orgunits";
		StringBuilder urlBuilder= new StringBuilder(apiUrl);
		urlBuilder.append("?domainId="); urlBuilder.append(domainId);
		apiUrl = urlBuilder.toString();
		
		String method="GET";
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", "Bearer "+accessToken);
		
		//JSON 문자열 결과
		String orgunitsResponseResult = openApiUtil.request(apiUrl, headers, method, null);
		System.out.println("orgunitsResponseResult: "+orgunitsResponseResult);
		
		//JSON 문자열 -> 자바의 객체로 변환
		ResponseResultDTO resultOrgUnits = openApiUtil.objectMapper(orgunitsResponseResult, new TypeReference<ResponseResultDTO>() {});
		//System.out.println(resultOrgUnits.getOrgUnits());
		model.addAttribute("list", resultOrgUnits.getOrgUnits());

	}

	private String getAccessToken(String code) {
		//문자열 + 연산을 빈번하게 하는 경우 : 성능상 좋지 않음 > 그래서 쓰는게 StringBuilder, StringBuffer 이용
		//String url = "https://auth.worksmobile.com/oauth2/v2.0/token?code="+code+"&grant_type=authorization_code&client_id="+clientId+"&client_secret="+clientSecret;
		
		String apiUrl = "https://auth.worksmobile.com/oauth2/v2.0/token";
		//GET 요청할때는 이렇게 할 것
		StringBuilder urlBuilder= new StringBuilder(apiUrl);
		urlBuilder.append("?code="); urlBuilder.append(code);
		urlBuilder.append("&grant_type=authorization_code");
		urlBuilder.append("&client_id="); urlBuilder.append(clientId);
		urlBuilder.append("&client_secret="); urlBuilder.append(clientSecret);
		apiUrl = urlBuilder.toString();
		
		
		String method = "POST";
		
		//headers 부분은 Map으로 만들면 됨
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		
		/*
		Map<String, String> bodyData = new HashMap<>();
		bodyData.put("code", code);
		bodyData.put("grant_type", "authorization_code");
		bodyData.put("client_id", clientId);
		bodyData.put("client_secret", clientSecret);
		
		//Post인 경우 JSON:{key:value}
		//bodyData -> json 형식의 문자열로 변환 (보통은 Gson 라이브러리 많이 씀)
		//(json 형식으로 넘어온거 class로 매핑해줘야함)
		String requestBody = objectMapper.writeValueAsString(bodyData);
		System.out.println(requestBody);
		*/
		
		return openApiUtil.request(apiUrl, headers, method, null);
		//System.out.println("responseResult:"+responseResult); //토큰 등이 json 형식의 문자열로 리턴됨
		
	}
	
	
	//아직 덜 구현함
	public void saveDepartment(OrgUnitSaveDTO dto) {
		
		
	}
	
}
