package ecommerce.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ecommerce.modelo.Produto;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProdutoEjb {

	@PersistenceContext(unitName = "ecommerce")
	private EntityManager em;
	
	public Produto add(Produto produto) {
		em.persist(produto);
		em.flush();
		return produto;
	}
	
	
}
