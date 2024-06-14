package com.sivale.whatsapp.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.sivale.whatsapp.model.MessageBody;
import com.sivale.whatsapp.model.MessageText;
import com.sivale.whatsapp.model.RequestMessage;

@Service
public class WhatsappApiService {
	private static final String BASE_URL = "https://graph.facebook.com/v19.0/367667796422091/messages";
	private static final String BEARER = "Bearer ";
	private static final String TOKEN = BEARER.concat("EAAHGFuPwA3QBO1bQk27JK43tGlgFbCpRWaU3ZCq2DWZAbZCbyh8R8xxT4ZAZBPFqAdK5eZAKgz5iurr8CNyI5kZBhrBR12wxgBnl5SWx9gW6GJgvuCeeNRYPBpnVzbXJ0Cm3MJVm1PAEgvVs50bZBSj3QefbTjSn26DTdiZBNiKohcr69RdUAwHfEQNW2387FR4VX");
	private static final String LADA = "52";

	private RestClient restClient;
	private RequestMessage request;

	public WhatsappApiService() {
		this.restClient = RestClient.builder().baseUrl(BASE_URL).defaultHeader("Authorization", TOKEN).build();
	}

	public String sendMsg(MessageBody messageBody) {
		request = new RequestMessage();
		request.setMessaging_product("whatsapp");
		request.setTo(LADA.concat(messageBody.getNumberPhone()));
		request.setType("text");
		request.setText(new MessageText(messageBody.getMessage()));

		return restClient.post().contentType(MediaType.APPLICATION_JSON).body(request).retrieve().body(String.class);
	}
}
