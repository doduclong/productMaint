package products.data;

import products.Product;

public interface ProductRepository {
	Iterable<Product> findAll();
	Product findById(String id);
	Product save(Product ingredient);
}
