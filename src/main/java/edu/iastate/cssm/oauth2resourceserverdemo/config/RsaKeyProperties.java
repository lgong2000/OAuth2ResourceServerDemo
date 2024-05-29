package edu.iastate.cssm.oauth2resourceserverdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties(prefix = "rsa")    // Need @EnableConfigurationProperties(RsaKeyProperties.class) in Application class
public record RsaKeyProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
}
