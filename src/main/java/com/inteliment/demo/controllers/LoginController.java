/*package com.inteliment.demo.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.http.HttpException;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.inteliment.demo.dto.SignUpDTO;
import com.inteliment.demo.models.User;
import com.inteliment.demo.services.UserSericeImp;
import com.inteliment.demo.util.CustomErrorType;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class LoginController {

	HashMap<String, Object> result;
	@Autowired
	private com.inteliment.demo.util.MyResponse response;

	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserSericeImp userService;


	// --------------------- Sign-Up User controller -------------------------

	@RequestMapping(value = "/signup/", method = RequestMethod.POST)
	public ResponseEntity<?> signUpUser(@RequestBody SignUpDTO signUp, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", signUp);
		response = new com.inteliment.demo.util.MyResponse();
		result = new HashMap<String, Object>();
		// find out existing user or not, if exist then return user is exist
		// else user is register and return with access token.
		if (userService.findUserByEmail(signUp.getEmailId())) {
			logger.error("Unable to create. A User with name {} already exist", signUp.getEmailId());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A User with name " + signUp.getEmailId() + " already exist."),
					HttpStatus.CONFLICT);
		} else {
			// pass user details for sign up
			User user = userService.signUpUser(signUp);
			// send OTP message
			
			String emailId = user.getEmailId();
			String password = user.getPassword();
			response.setResponseCode(200);
			response.setComment("signUp User successfully. ");
			response.setResponseMessage("FETCH");
			response.setResult(result);
			return new ResponseEntity<MyResponse>(response, HttpStatus.OK);

		}
	}

	// --------------------- Sign-In User controller -------------------------
	@RequestMapping(value = "/signin/", method = RequestMethod.POST)
	public ResponseEntity<?> signInUser(@RequestBody SignInDTO signIn, UriComponentsBuilder ucBuilder) {
		logger.info("verify User : {}", signIn.getUserName());
		logger.info("verify password : {}", signIn.getPassword());
	
		String emailId = signIn.getUserName();
		String password = signIn.getPassword();
		result = new HashMap<String, Object>();
		// Varify 
		
			// get access token for Fairscore Apis
			AccessTokenLocalDto accesstokenLocalDto = loginService.getAccessTokenLocal(emailId, password);
			accesstokenLocalDto.setId(user.get().getId());

			result.put("user", accesstokenLocalDto);
			response.setResponseCode(200);
			response.setComment("user login successfully");
			response.setResponseMessage("FETCH");
			response.setResult(result);
			return new ResponseEntity<MyResponse>(response, HttpStatus.OK);
		} else {
			 
			if(userService.findUserByEmail(emailId))
			{
				logger.error("Your User Name or password is incorrect.");
				return new ResponseEntity(new CustomErrorType("Your User Name or password is incorrect."),
						HttpStatus.CONFLICT);
				
			}else
			{		
			logger.error("User is deleted already or User not found.");
			return new ResponseEntity(new CustomErrorType("User is deleted already or User not found."),
					HttpStatus.CONFLICT);
			}
		}
		
	}
	// get refresh token from fairscore 
	@RequestMapping(value = "/refreshtoken", method = RequestMethod.GET)
	public ResponseEntity<?> getRefreshToken(
			@RequestParam(value = "refresh_token", required = false) String refreshToken,
			RedirectAttributes redirectAttributes)
			throws UnsupportedOperationException, IOException, ParseException, URISyntaxException, HttpException {
		try {
			response = new MyResponse();
			result = new HashMap<String, Object>();
			System.out.println("refreshToken=="+refreshToken);
			// get refresh token
			AccessTokenLocalDto refreshTokenLocalDto=loginService.getRefreshTokenLocal(refreshToken);
			 //  if refresh token is wrong else returns access token 
			if (refreshTokenLocalDto == null) {
				logger.error("refresh token is invalid");
				//result.put("user", null);
				return new ResponseEntity(new CustomErrorType("refresh token is invalid"),
						HttpStatus.NOT_FOUND);
			}
			result.put("refreshToken", refreshTokenLocalDto);
			response.setResponseCode(200);
			response.setComment("Refresh Token successfully.");
			response.setResponseMessage("FETCH");
			response.setResult(result);
			return new ResponseEntity<MyResponse>(response, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}

	}
	
	
	// --------------------- testing url without access token
	// -------------------------
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String privateMethod() {
		return "hello";
	}

}
*/