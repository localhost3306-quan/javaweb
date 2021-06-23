package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ProductDao;
import com.model.Category;
import com.model.Product;
import com.service.CategoryService;
import com.service.impl.CategoryServiceImpl;

import JDBC.JDBCConnection;

public class ProductDaoImpl extends JDBCConnection implements ProductDao {

	CategoryService categortService = new CategoryServiceImpl();

	@Override
	public void insert(Product product) {
		String sql = "INSERT INTO product(name, price, image, category_id, description) VALUES (?,?,?,?,?)";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setLong(2, product.getPrice());
			ps.setString(3, product.getImage());
			ps.setInt(4, product.getCategory().getId());
			ps.setString(5, product.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println("loi them moi" + ex);
		}
	}

	@Override
	public void edit(Product product) {
		String sql = "UPDATE product SET product.name = ? , price = ?, image = ?,category_id=?, description=?  WHERE id = ?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getImage());
			ps.setInt(4, product.getCategory().getId());
			ps.setString(5, product.getDescription());
			ps.setInt(6, product.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM product WHERE id=?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Product get(int id) {
		String sql = "SELECT product.id, product.name AS p_name, product.price, product.image,product.description, category.category_name AS c_name, category.category_id AS c_id "
				+ "FROM product INNER JOIN category "
				+ "ON product.category_id = category.category_id WHERE product.id=?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("c_id"));
				category.setName(rs.getString("c_name"));
				
				
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("p_name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));
				product.setDescription(rs.getString("description"));
				product.setCategory(category);

				product.setCategory(category);
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("loi" +e);
		}
		return null;
	}

	@Override
	public List<Product> getAll() {

		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.description , category.category_name AS c_name, category.category_id AS c_id  "
				+ "FROM product INNER JOIN category " + "ON product.category_id = category.category_id";
		Connection conn = super.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categortService.get(rs.getInt("c_id"));
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("p_name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));
				product.setDescription(rs.getString("description"));
				product.setCategory(category);

				product.setCategory(category);
				productList.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	@Override
	public List<Product> search(String name) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT p.id as 'product_id',p.name,p.price,p.image,p.description,c.category_id,c.category_name"
				+ "FROM product p INNER JOIN category c ON p.category_id = c.category_id WHERE p.name LIKE ? ";
		// String sql = "SELECT * FROM product WHERE name LIKE ? ";
		Connection conn = super.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("product_id"));
				product.setName(rs.getString("p.name"));
				product.setPrice(rs.getLong("p.price"));
				product.setImage(rs.getString("p.image"));
				product.setDescription(rs.getString("p.description"));

				Category category = new Category();
				category.setId(rs.getInt("c.category_id"));
				category.setName(rs.getString("c.category_name"));

				product.setCategory(category);
				productList.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	@Override
	public List<Product> seachByCategory(int cate_id) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.description , category.category_name AS c_name, category.category_id AS c_id  FROM product , category WHERE product.category_id = category.category_id and category.category_id=?";
		Connection conn = super.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cate_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categortService.get(rs.getInt("c_id"));
				category = categortService.get(rs.getString("c_name"));
				
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("p_name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));
				product.setDescription(rs.getString("description"));
				product.setCategory(category);

				product.setCategory(category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

	@Override
	public List<Product> seachByName(String productName) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.description , category.category_name AS c_name, category.category_id AS c_id 				"
				+ " FROM Product , Category   where product.category_id = category.category_id and Product.name like ? ";
		Connection conn = super.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + productName + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = categortService.get(rs.getInt("c_id"));
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("p_name"));
				product.setPrice(rs.getLong("price"));
				product.setImage(rs.getString("image"));
				product.setDescription(rs.getString("description"));
				product.setCategory(category);

				product.setCategory(category);
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

}
