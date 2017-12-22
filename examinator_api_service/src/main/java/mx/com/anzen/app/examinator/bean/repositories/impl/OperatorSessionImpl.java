/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.bean.repositories.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import mx.com.anzen.app.examinator.bean.repositories.OperatorSession;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
@Repository
public class OperatorSessionImpl implements OperatorSession {
	
	private static final Integer TO_GENERATE_ID = 1000;
	private static final String USER_SESSION_KEY = "UserSession";
	
	@Autowired
	private RedisTemplate<String, mx.com.anzen.app.examinator.bean.jpa.OperatorSession> redisTemplate;
	private HashOperations<String, Integer, mx.com.anzen.app.examinator.bean.jpa.OperatorSession> hashOperations;
	
	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public Integer saveUserSession(String userLogin) {
		Integer id = (int) (Math.random() * TO_GENERATE_ID + 1);
		
		mx.com.anzen.app.examinator.bean.jpa.OperatorSession operatorSession = new mx.com.anzen.app.examinator.bean.jpa.OperatorSession();
		operatorSession.setSessionId(id);
		operatorSession.setUserName(userLogin);
		
		hashOperations.put(USER_SESSION_KEY, id, operatorSession);
		
		return id;
	}

	@Override
	public Boolean deleteUserSession(Integer id) {
		return hashOperations.delete(USER_SESSION_KEY, id) != null;
	}
}
