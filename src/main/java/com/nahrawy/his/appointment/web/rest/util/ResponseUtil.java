package com.nahrawy.his.appointment.web.rest.util;
 
 
import java.util.Optional;

import org.springframework.http.*;

 
public interface ResponseUtil {


    public static <X> ResponseEntity<X> wrapOrNotFound(Optional<X> maybeResponse) {
        return wrapOrNotFound(maybeResponse, null);
    }


    public static <X> ResponseEntity<X> wrapOrNotFound(Optional<X> maybeResponse, HttpHeaders header) {
        return maybeResponse.map(response -> ResponseEntity.ok().headers(header).body(response))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
