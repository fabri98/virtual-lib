package com.VirtualLibWeb.VirtualLib.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.VirtualLibWeb.VirtualLib.auth.service.usuario_security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/css/**", "/js/**").permitAll() // permitimos acceso público a login y recursos estáticos
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login") // muestra plantilla de login
                .defaultSuccessUrl("/", true) // redirige tras login exitoso
                .failureUrl("/login?error=true") // si falla, vuelve a login con ?error
                .permitAll()
            )
            // Ejemplo de config para usar OAuth2
            // .oauth2Client(Customizer.withDefaults())
            // .oauth2Login(oauth2 -> oauth2
            //     .loginPage("/login")
            //     .defaultSuccessUrl("/", true)
            // )

            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            );

        return http.build();
    }

     // Bean para configurar el AuthenticationManager, el cual delega la lógica de autenticación a los AuthenticationProviders.
    // Aquí se utiliza la configuración predeterminada proporcionada por Spring Security.
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    // Configuración de un AuthenticationProvider.
    // En este caso, se utiliza DaoAuthenticationProvider, que realiza la autenticación basándose en datos de usuario
    // obtenidos mediante un UserDetailsService y compara las contraseñas utilizando un PasswordEncoder.
    @Bean
    AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }
    // metodo para hashear contraseñas
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); 
    }
}
