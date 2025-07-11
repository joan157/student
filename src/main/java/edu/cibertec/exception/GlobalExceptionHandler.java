package edu.cibertec.exception;

import edu.cibertec.dto.ErrorDto;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//Es una anotación de Spring que
// captura automáticamente las excepciones lanzadas en cualquier @RestController de tu aplicación.
@RestControllerAdvice
public class GlobalExceptionHandler {



    //Sin personalizar el ErrorDto
   /*  @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex){
                Map<String, String> errores = new HashMap<>();
                ex.getBindingResult().getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage()));
                //new ResponseEntity<Map<String, String>>(errores, HttpStatus.BAD_REQUEST)
                return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST); // los parentesis es su constructor
    } */
    //Con ErrorDto
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request){
        String mensaje = ex.getBindingResult().getFieldErrors().stream()
                .map(error ->error.getField()+": "+error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        ErrorDto error = new ErrorDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                mensaje,
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Excepciones personalizadas
    @ExceptionHandler(EstudianteNoEncontradoException.class)
    public ResponseEntity<ErrorDto> handleNotFound(EstudianteNoEncontradoException ex, HttpServletRequest request) {
        ErrorDto error =  new ErrorDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    // Excepciones generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneral(Exception ex) {
        return new ResponseEntity<>("Error interno del servidor!!!!!!!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
