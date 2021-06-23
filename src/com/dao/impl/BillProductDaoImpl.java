package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BillProductDao;
import com.dao.UserDao;
import com.model.Bill;
import com.model.BillProduct;
import com.model.Product;
import com.model.User;
import com.service.BillService;
import com.service.ProductService;
import com.service.impl.BillServiceImpl;
import com.service.impl.ProductServiceImpl;

import JDBC.JDBCConnection;

public class BillProductDaoImpl extends JDBCConnection implements BillProductDao {
	BillService billService = new BillServiceImpl();
	ProductService productService = new ProductServiceImpl();
	UserDao userDao = new UserDaoImpl();

	@Override
	public void insert(BillProduct billProduct) {
		String sql = "INSERT INTO projectweb.billproduct(unit_price,quantity,bill_id,product_id) VALUES (?,?,?,?)";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setLong(1, billProduct.getUnitPrice());
			ps.setInt(2, billProduct.getQuantity());
			ps.setLong(3, billProduct.getBill().getId());
			ps.setLong(4, billProduct.getProduct().getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("them loi: " + e);
		}
	}

	@Override
	public void edit(BillProduct billProduct) {
		String sql = "UPDATE billproduct SET unit_price = ?, quantity = ?, bill_id ?, product_id? WHERE id = ?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setLong(1, billProduct.getUnitPrice());
			ps.setInt(2, billProduct.getQuantity());
			ps.setInt(3, billProduct.getBill().getId());
			ps.setInt(4, billProduct.getProduct().getId());
			ps.setInt(5, billProduct.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM billproduct WHERE id = ?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BillProduct get(int id) {
		String sql = "SELECT bp.*, product.name, product.image, product.id as 'p_id'"
				+ "FROM billproduct bp INNER JOIN product ON bp.product_id = product.id WHERE bp.id=?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BillProduct billProduct = new BillProduct();
				billProduct.setId(rs.getInt("id"));
				billProduct.setUnitPrice(rs.getLong("unit_price"));
				billProduct.setQuantity(rs.getInt("quantity"));

				Product product = new Product();
				product.setName(rs.getString("product.name"));
				product.setId(rs.getInt("p_id"));
				product.setImage(rs.getString("image"));

				billProduct.setProduct(product);

				return billProduct;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<BillProduct> search(int billId) {
		List<BillProduct> billList = new ArrayList<BillProduct>();
		Connection con = super.getConnection();
		try {
			// lay tat cot cua billproduct va vai cot cua product
			String sql = "SELECT bp.*, product.name, product.image, product.id as 'p_id'"
					+ "FROM billproduct bp INNER JOIN product ON bp.product_id = product.id WHERE bp.bill_id=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, billId);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				BillProduct billProduct = new BillProduct();
				billProduct.setId(rs.getInt("id"));
				billProduct.setUnitPrice(rs.getLong("unit_price"));
				billProduct.setQuantity(rs.getInt("quantity"));

				Product product = new Product();
				product.setName(rs.getString("product.name"));
				product.setId(rs.getInt("p_id"));
				product.setImage(rs.getString("image"));

				billProduct.setProduct(product);

				billList.add(billProduct);
			}
		} catch (Exception ex) {
			System.out.println("search loi :" + ex);
		}

		return billList;
	}
}