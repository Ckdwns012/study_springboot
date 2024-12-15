package com.example.demo.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer>{
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
	Page<Question> findBySubjectContainingIgnoreCase( String subject, Pageable pageable);
	Page<Question> findAll(Pageable pageable);
	Page<Question> findAll(Specification<Question> spec, Pageable pageable);
	
    // 키워드 검색을 위한 쿼리
    @Query("select distinct q " +
            "from Question q " +
            "left join SiteUser U1 on q.author = U1 " +
            "left join Answer a on a.question = q " +
            "left join SiteUser u2 on a.author = u2 " +
            "where " +
            "q.subject like %:kw% " +
            "or q.content like %:kw% " +
            "or U1.username like %:kw% " +
            "or a.content like %:kw% " +
            "or u2.username like %:kw% ")
    Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}
