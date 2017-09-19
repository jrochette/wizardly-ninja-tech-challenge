package io.ninja.jrochette.resources.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestModel<T> {
	private T input;

	public RequestModel() {
	}

	@JsonProperty
	public T getInput() {
		return input;
	}

	public void setInput(T input) {
		this.input = input;
	}

	public RequestModel<T> withInput(T input) {
		this.setInput(input);
		return this;
	}

}
