insert into  ccs_cred_params values (1,'test',10,10,10,10,10,10);

insert into question (category_question, is_multi_answer, question) values ('JAVA_SR', false, '¿qué es java?');
insert into question (category_question, is_multi_answer, question) values ('JAVA_SR', true, '¿por qué java?');

insert into option_question (id_question, answer, is_a_response) values (1, 'porque sí', false);
insert into option_question (id_question, answer, is_a_response) values (1, 'porque se me da la gana', false);
insert into option_question (id_question, answer, is_a_response) values (1, 'porque es mejor', true);

insert into option_question (id_question, answer, is_a_response) values (2, 'no me se otra cosa', false);
insert into option_question (id_question, answer, is_a_response) values (2, 'ya que', true);
insert into option_question (id_question, answer, is_a_response) values (2, 'ok ok pruebo suerte', false);