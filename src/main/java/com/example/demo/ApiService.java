package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;


@Service
public class ApiService {
	
	private final RestTemplate restTemplate = new RestTemplate();

    private final String apiUrl = "http://www.cid.or.kr/job/openApi/service/getJobOpenInfoList.do?ServiceKey=lejDGVXYMTiM8TprNWVuOvplNwqSAUO8eJImSfeZHWV7BPxaea%2BEZwThBGI7F4qoYCIoOj7joTXFFD9W3oMTYg%3D%3D&cmpnyJoSeq=K06011611030003";

    public String getApiResponse() {
        try {
            // API 호출
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
            String responseBody = response.getBody();

            // JSON 파싱
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(responseBody); 
            return root.toString();
           
//            // "cmpnyNm" 데이터 추출
//            String cmpnyNm = root.path("empmnSj").asText();
//            return cmpnyNm;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null; // 에러 발생 시 null 또는 에러 메시지 반환
        }

    }
}
