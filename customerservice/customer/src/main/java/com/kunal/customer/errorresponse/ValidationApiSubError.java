package com.kunal.customer.errorresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

public class ValidationApiSubError {
	@Data
	@EqualsAndHashCode(callSuper = false)
	@AllArgsConstructor
	class ApiValidationError extends AbstractApiSubError {
		@SuppressWarnings("unused")
		private String object;
		private String field;
		private Object rejectedValue;
		private String message;

		ApiValidationError(String object, String message) {
			this.object = object;
			this.message = message;
		}
	}
}
