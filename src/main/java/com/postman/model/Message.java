package com.postman.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

public class Message implements Serializable{

	private static final long serialVersionUID = 1L;

	private String code;
	
	@Valid
	private List<String> messages = new ArrayList<String>();
	
	public Message(String code, List<String> messages) {
		this.code = code;
		this.messages = messages;
	}

	public String getCode() {
		return code;
	}
	
	public List<String> getMessages() {
		return messages;
	}

	@Override
	public String toString() {
		return "Message [code=" + code + ", messages=" + messages + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((messages == null) ? 0 : messages.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (messages == null) {
			if (other.messages != null)
				return false;
		} else if (!messages.equals(other.messages))
			return false;
		return true;
	}
}
