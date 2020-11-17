package com.redhat.poc;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.redhat.poc.dao.HatDAO;
import com.redhat.poc.model.Hat;

@DataJpaTest
class SpringRestPocJpaTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private HatDAO hatDAO;

	@Test
	public void testFindByLastName() {
		Hat hat = new Hat();
		hat.setColor("Red");
		hat.setType("Fedora");
		entityManager.persist(hat);

		hatDAO.findAll().forEach(h -> {
			Assert.assertEquals(h.getColor(), "Red");
			Assert.assertEquals(h.getType(), "Fedora");
		});
	}
}
