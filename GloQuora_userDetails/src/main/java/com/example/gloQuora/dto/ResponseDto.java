package com.example.gloQuora.dto;

public class ResponseDto<T> {
	
	private T data;
	private String code;
	private String description;

	public ResponseDto() {
		super();
	}

	public ResponseDto(T data, String code) {
		super();
		this.data = data;
		this.code = code;
	}

	public ResponseDto(T data, String code, String description) {
		super();
		this.data = data;
		this.code = code;
		this.description = description;
	}
	public ResponseDto(String code, String description, T data) {
		super();
		this.data = data;
		this.code = code;
		this.description = description;
	}

	public ResponseDto(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ResponseDto [data=" + data + ", code=" + code + ", description=" + description + "]";
	}

	
}
