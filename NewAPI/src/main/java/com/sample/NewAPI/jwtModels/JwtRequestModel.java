package com.sample.NewAPI.jwtModels;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequestModel implements Serializable{
	
	private static final long serialVersionUID = 2636936156391265891L;
	
	private String username;
	private String password;	

}
