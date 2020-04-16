package br.com.nestpets.loja.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


/**
 * @author jp
 *
 * @param <T>
 */
@Data
public class Response<T> {

	private T data;

	private List<String> errors;

	public Response() {

	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}

		return this.errors;
	}

}
