# OAuth2ResourceServerDemo

### Spring Web
### Spring OAuth2 Resource Server
### Spring Configuration Processor

## Version 1
#### InMemoryUserDetailsManager
#### formLogin

## Version 2
#### JdbcUserDetailsManager
#### EmbeddedDatabase
#### BCryptPasswordEncoder
#### h2-console
http://localhost:8080/h2-console<br>
JDBC URL: jdbc:h2:mem:demo

## Version 3
### Postman: POST http://localhost:8080/token
HTML Body - JSON - username/password
### Postman: GET http://localhost:8080/
Authorization - Bearer Token
### Project VueClient - Visual Studio Code
npm run dev
Browser - http://localhost:5173/

#### @ConfigurationProperties
    New record(class) RsaKeyProperties
    In RsaKeyProperties class - @ConfigurationProperties(prefix = "rsa") 
    In Application class - @EnableConfigurationProperties(RsaKeyProperties.class)
#### AuthenticationManager/UsernamePasswordAuthenticationToken
#### DaoAuthenticationProvider
#### JwtDecoder/JwtEecoder
#### JwtClaimsSet/JwtEncoderParameters
#### CorsConfigurationSource
