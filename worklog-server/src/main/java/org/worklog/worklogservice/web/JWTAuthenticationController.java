package org.worklog.worklogservice.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.worklog.worklogservice.bean.JwtRequest;
import org.worklog.worklogservice.bean.JwtResponse;
import org.worklog.worklogservice.bean.StaffDTO;
import org.worklog.worklogservice.config.JwtTokenConfig;
import org.worklog.worklogservice.service.JwtUserDetailsService;
import org.worklog.worklogservice.service.StaffService;

/**
 * 
 * @author ir07
 * @version 0.1
 */

@RestController
@CrossOrigin
public class JWTAuthenticationController {
	/*
	 * Controller for handling Authentication and User Registration.
	 */
	private static final Logger LOGGER = Logger.getLogger(JWTAuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenConfig jwtTokenConfig;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private StaffService staffService;

	/**
	 * @param authenticationRequest
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {
		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenConfig.generateToken(userDetails);
			LOGGER.info(String.format("Success Authentication for username [%s] and password [%s] -> Generated Token [%s]",
					authenticationRequest.getUsername(), authenticationRequest.getPassword(), token));
			return ResponseEntity.ok(new JwtResponse(token, "Authenticated Successfully!", userDetails));
		} catch (Exception e) {
			LOGGER.error(String.format("Failed Authentication for username [%s] and password [%s].",
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			return new ResponseEntity<JwtResponse>(new JwtResponse(null, e.getMessage(), null), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @param registrationBean
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody StaffDTO registrationBean) {
		if (staffService.register(registrationBean) != null) {
			LOGGER.info(String.format("Registration process success for user [%s]!", registrationBean.getUsername()));
			return new ResponseEntity<String>("Registration Done Successfully!", HttpStatus.OK);
		}
		LOGGER.info(String.format("Registration failed for user [%s]", registrationBean.getUsername()));
		return new ResponseEntity<String>("Cannot Perform the Registration!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("BAD CREDENTIALS", e);
		}
	}
}
