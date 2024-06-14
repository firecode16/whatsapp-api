package com.sivale.whatsapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequestMessage {
	private String messaging_product;
	private String to;
	private String type;
	private MessageTemplate template;
}
