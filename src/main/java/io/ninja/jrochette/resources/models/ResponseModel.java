package io.ninja.jrochette.resources.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseModel<T> {
	private T value;
	
	public ResponseModel() {}

	@JsonProperty
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public ResponseModel<T> withValue (T value){
		this.setValue(value);
		return this;
	}
}
