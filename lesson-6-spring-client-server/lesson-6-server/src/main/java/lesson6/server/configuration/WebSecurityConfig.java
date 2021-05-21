
package lesson6.server.configuration;

import lesson6.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;
import java.util.LinkedList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	@Autowired
	UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
					.authorizeRequests()
					.antMatchers("/admins","/admin_page","/users","/registration_new_admin","/admins/investment","/admins/add_news").hasRole("ADMIN")
					.antMatchers("/users_page","/top_up_balance","/withdraw_money","/change").hasRole("USER")
					.antMatchers("/", "/home","/registration").permitAll()
					.anyRequest().authenticated()
				.and()
					.formLogin()
					.loginPage("/login")
					.permitAll()
				.and()
					.logout()
					.permitAll();
	}





	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception

	{
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(NoOpPasswordEncoder.getInstance()).usersByUsernameQuery("select login, password, 'true' from allroles where login=?").authoritiesByUsernameQuery("select login, type from allroles where login=?");

	}
	/*@Bean
	@Override
	public UserDetailsService userDetailsService() {
		List<lesson6.server.model.User> user= userRepository.findAll();
		List<UserDetails> users= new LinkedList<>();
		for(int i=0;i<user.size();i++)
		{
			users.add(User.withDefaultPasswordEncoder()
					.username(user.get(i).name)
					.password(user.get(i).password)
					.roles("ADMIN").build());
		}

		UserDetails user2 =User.withDefaultPasswordEncoder()
				.username("1")
				.password("2")
				.roles("ADMIN").build();
		UserDetails user3 =User.withDefaultPasswordEncoder()
				.username("4")
				.password("5")
				.roles("ADMIN").build();
		return new InMemoryUserDetailsManager(users);
	}*/
}
