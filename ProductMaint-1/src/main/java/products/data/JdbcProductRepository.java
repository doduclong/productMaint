package products.data;

import products.Product;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

public class JdbcProductRepository implements ProductRepository{
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcProductRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public Iterable<Product> findAll() {
		return jdbc.query("select id, description, price from Product", this::mapRowToProduct);
	}

	@Override
	public Product findById(String id) {
		return jdbc.queryForObject("select id, description, price from Product where id=?", this::mapRowToProduct, id);
	}
	
	private Product mapRowToProduct(ResultSet rs, int rowNum) throws SQLException {
		return new Product(rs.getString("id"), rs.getString("name"), rs.getFloat("price"));
	}

	@Override
	public Product save(Product product) {
		jdbc.update("insert into Product (id, description, price) values (?, ?, ?)", product.getId(),
				product.getDescription(), Float.toString(product.getPrice()));
		return product;
	}

}
