package com.sivale.whatsapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageBody {
	private String numberPhone;
	private String message;
}
