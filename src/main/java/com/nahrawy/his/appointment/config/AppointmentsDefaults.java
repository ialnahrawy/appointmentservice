package com.nahrawy.his.appointment.config;

public interface AppointmentsDefaults {
	
	interface Mail {
        boolean enabled = false;
        String from = "etabeb.noreply@gmail.com";
        String baseUrl = "";
    }
	
	interface Swagger {

        String title = "Appointment API";
        String description = "Appointment API documentation";
        String version = "0.0.1";
        String termsOfServiceUrl = null;
        String contactName = null;
        String contactUrl = null;
        String contactEmail = null;
        String license = null;
        String licenseUrl = null;
        String defaultIncludePattern = "/api/.*";
        String host = null;
        String[] protocols = {};
        boolean useDefaultResponseMessages = true;
    }

}
