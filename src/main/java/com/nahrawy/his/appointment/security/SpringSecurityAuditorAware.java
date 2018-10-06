package com.nahrawy.his.appointment.security;

 
import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;


@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(getCurrentUserLogin().orElse("system"));
    }

	private Optional<String> getCurrentUserLogin() {
 		return  Optional.of("user");
	}
}
