package com.unicesumar.adsis4s.Projeto.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RegistroNaoExiste extends RuntimeException {

}
