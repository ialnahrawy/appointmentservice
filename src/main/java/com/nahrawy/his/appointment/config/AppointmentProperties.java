package com.nahrawy.his.appointment.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
 
 



/**
 * Properties specific to AppointmentService.
 * <p> Properties are configured in the application.yml file. </p>
 */
@Configuration
@ConfigurationProperties(prefix = "appointment", ignoreUnknownFields = false)
@PropertySource(value = "classpath:appointment.properties", ignoreResourceNotFound = true)
public class AppointmentProperties {
	
    private final Mail mail = new Mail();
    private final Swagger swagger = new Swagger();
    
    
    public Mail getMail() {
        return mail;
    }
    
    public Swagger getSwagger() {
		return swagger;
	}


	public static class Mail {

		private boolean enabled = AppointmentsDefaults.Mail.enabled;

		private String from = AppointmentsDefaults.Mail.from;

		private String baseUrl = AppointmentsDefaults.Mail.baseUrl;

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public String getBaseUrl() {
			return baseUrl;
		}

		public void setBaseUrl(String baseUrl) {
			this.baseUrl = baseUrl;
		}
	}

	public static class Swagger {

		private String title = AppointmentsDefaults.Swagger.title;

		private String description = AppointmentsDefaults.Swagger.description;

		private String version = AppointmentsDefaults.Swagger.version;

		private String termsOfServiceUrl = AppointmentsDefaults.Swagger.termsOfServiceUrl;

		private String contactName = AppointmentsDefaults.Swagger.contactName;

		private String contactUrl = AppointmentsDefaults.Swagger.contactUrl;

		private String contactEmail = AppointmentsDefaults.Swagger.contactEmail;

		private String license = AppointmentsDefaults.Swagger.license;

		private String licenseUrl = AppointmentsDefaults.Swagger.licenseUrl;

		private String defaultIncludePattern = AppointmentsDefaults.Swagger.defaultIncludePattern;

		private String host = AppointmentsDefaults.Swagger.host;

		private String[] protocols = AppointmentsDefaults.Swagger.protocols;

		private boolean useDefaultResponseMessages = AppointmentsDefaults.Swagger.useDefaultResponseMessages;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getTermsOfServiceUrl() {
			return termsOfServiceUrl;
		}

		public void setTermsOfServiceUrl(String termsOfServiceUrl) {
			this.termsOfServiceUrl = termsOfServiceUrl;
		}

		public String getContactName() {
			return contactName;
		}

		public void setContactName(String contactName) {
			this.contactName = contactName;
		}

		public String getContactUrl() {
			return contactUrl;
		}

		public void setContactUrl(String contactUrl) {
			this.contactUrl = contactUrl;
		}

		public String getContactEmail() {
			return contactEmail;
		}

		public void setContactEmail(String contactEmail) {
			this.contactEmail = contactEmail;
		}

		public String getLicense() {
			return license;
		}

		public void setLicense(String license) {
			this.license = license;
		}

		public String getLicenseUrl() {
			return licenseUrl;
		}

		public void setLicenseUrl(String licenseUrl) {
			this.licenseUrl = licenseUrl;
		}

		public String getDefaultIncludePattern() {
			return defaultIncludePattern;
		}

		public void setDefaultIncludePattern(String defaultIncludePattern) {
			this.defaultIncludePattern = defaultIncludePattern;
		}

		public String getHost() {
			return host;
		}

		public void setHost(final String host) {
			this.host = host;
		}

		public String[] getProtocols() {
			return protocols;
		}

		public void setProtocols(final String[] protocols) {
			this.protocols = protocols;
		}

		public boolean isUseDefaultResponseMessages() {
			return useDefaultResponseMessages;
		}

		public void setUseDefaultResponseMessages(final boolean useDefaultResponseMessages) {
			this.useDefaultResponseMessages = useDefaultResponseMessages;
		}
	}
  
}
