/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator.bean.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.anzen.app.examinator.bean.jpa.OptionQuestion;
import mx.com.anzen.app.examinator.bean.jpa.OptionQuestionPk;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
@Repository
public interface OptionQuestionRepository extends CrudRepository<OptionQuestion, OptionQuestionPk> {

	/**
	 * <p></p>
	 * 
	 * @param idQuestion
	 * @return
	 */
	List<OptionQuestion> findByIdIdQuestion(Integer idQuestion);
}
