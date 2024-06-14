package com.sivale.whatsapp.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.sivale.whatsapp.model.Language;
import com.sivale.whatsapp.model.MessageBody;
import com.sivale.whatsapp.model.MessageTemplate;
import com.sivale.whatsapp.model.RequestMessage;

@Service
public class WhatsappApiService {
	private static final String BASE_URL = "https://graph.facebook.com/v19.0/345371665325786/messages";
	private static final String BEARER = "Bearer ";
	private static final String TOKEN = BEARER.concat("EAAHGFuPwA3QBO38l2w6PScUCx6c1kFXEr3IxzHVObiRAxcGoqYcjkQA8P337FA0J2hUUGZC7ZBpbrgqFVc3umInDzE7ULSYjzN9yxXCWtgekBSgLj4XIlbOaWAHjyRf59zsTvqtnAoOnhIgSddYd67mkZAXHlnOfeJCq0pzxIYaOOV5erl7nCUMARLEuBnCVKE4HfKmaNk70rxUXswZD");
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
		request.setType("template");
		request.setTemplate(new MessageTemplate(messageBody.getNameTemplate(), new Language("es_MX")));

		return restClient.post().contentType(MediaType.APPLICATION_JSON).body(request).retrieve().body(String.class);
	}
}
