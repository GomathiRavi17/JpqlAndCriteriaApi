package com.jpqlandcriteria.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpqlandcriteria.model.Post;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class PostDaoService {

	@PersistenceContext
	EntityManager em;

	public List<Post> getPostByTitleName(String title) {

		if (title == null || title.isEmpty()) {
			return List.of(); 
		}

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Post> cq = cb.createQuery(Post.class);

		Root<Post> post = cq.from(Post.class);
		Predicate titlePredicate = cb.like(post.get("title"), "%" + title + "%");
		cq.where(titlePredicate);

		TypedQuery<Post> query = em.createQuery(cq);
		return query.getResultList();
	}
}
