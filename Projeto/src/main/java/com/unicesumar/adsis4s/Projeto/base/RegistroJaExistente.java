package com.unicesumar.adsis4s.Projeto.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RegistroJaExistente extends RuntimeException {

}
