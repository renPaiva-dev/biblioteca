package br.edu.exemplo.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class TratadorGlobalDeErros {
@ExceptionHandler(RuntimeException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ErroResponse tratarRuntimeException(RuntimeException ex) {
return new ErroResponse(ex.getMessage());
}
@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ErroResponse tratarErroValidacao(MethodArgumentNotValidException ex) {
String mensagem = ex.getBindingResult()
.getFieldErrors()
.get(0)
.getDefaultMessage();
return new ErroResponse(mensagem);
}
}
