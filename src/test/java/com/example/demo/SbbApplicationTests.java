package com.example.demo;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.answer.Answer;
import com.example.demo.answer.AnswerRepository;
import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;
import com.example.demo.question.QuestionService;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionService questionService;

	@Test
	void testJpa() {
		for (int i = 1; i <= 100; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용 없음";
			this.questionService.create(subject, content, null);
		}
	}

	/*
	 * @Transactional
	 * 
	 * @Test void contextLoads() { Question q =
	 * this.questionRepository.findBySubject("sbb가 무엇인가요?");
	 * assertEquals(1,q.getId()); Optional<Question> oq =
	 * this.questionRepository.findById(2); assertTrue(oq.isPresent()); Question q =
	 * oq.get();
	 * 
	 * List<Answer> answerList = q.getAnswerList();
	 * 
	 * assertEquals(1,answerList.size());
	 * assertEquals("네 자동으로 생성됩니다.",answerList.get(0).getContent()); Answer a = new
	 * Answer(); a.setContent("네 자동으로 생성됩니다."); a.setQuestion(q);
	 * a.setCreateDate(LocalDateTime.now()); this.answerRepository.save(a); }
	 */
}	
