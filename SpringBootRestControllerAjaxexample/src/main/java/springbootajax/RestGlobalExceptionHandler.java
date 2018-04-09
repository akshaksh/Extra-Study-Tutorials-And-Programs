package springbootajax;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.multipart.MultipartException;
@ControllerAdvice
public class RestGlobalExceptionHandler extends ResponseEntityExceptionHandler{
	// Catch file size exceeded exception!
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {

        HttpStatus status = getStatus(request);
        System.out.println("start"+ex.getMessage().toString());
        System.out.println(status+" end");
        return new ResponseEntity("Exception is here", status);
        // example
        //return new ResponseEntity("success", responseHeaders, HttpStatus.OK);

    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
