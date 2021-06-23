package com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BillDao;
import com.model.Bill;
import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import JDBC.JDBCConnection;

public class BillDaoImpl extends JDBCConnection implements BillDao {
	UserService userS = new UserServiceImpl();

	@Override
	public void insert(Bill bill) {
		String sql = "INSERT into projectweb.bill (buyer_id, buy_date, total_price) values(?,?,?)";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, bill.getBuyer().getId());
			ps.setString(2, bill.getDate());
			ps.setLong(3, bill.getTotalBill());
			ps.executeUpdate();

			/// tra ve ID gen ra, de luu sang billproduct
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				bill.setId(generatedKeys.getInt(1));// id cua bill
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Bill bill) {
		String sql = "UPDATE projectweb.bill SET buyer_id = ?, buy_date = ?, total_price = ? WHERE id = ?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bill.getBuyer().getId());
			ps.setString(2, bill.getDate());
			ps.setLong(3, bill.getTotalBill());
			ps.setInt(4, bill.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("loi" + e);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM bill WHERE id = ?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("loi" + e);
		}
	}

	@Override
	public Bill get(int id) {
		String sql = "SELECT bill.id, bill.buy_date,bill.total_price, user.username FROM bill INNER JOIN user ON bill.buyer_id = user.id WHERE bill.id=?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int pid = rs.getInt("id");
				String buyerName = rs.getString("username");
				String date = rs.getString("buy_date");
				Long totalBill = rs.getLong("total_price");

				Bill bill = new Bill();
				bill.setId(pid);
				bill.setDate(date);
				bill.setTotalBill(totalBill);

				User user = new User();
				user.setUsername(buyerName);
				bill.setBuyer(user);

				return bill;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("loi" + e);
		}
		return null;
	}

	@Override
	public List<Bill> getAll() {
		List<Bill> billList = new ArrayList<Bill>();
		String sql = "SELECT bill.id, buy_date,total_price, user.username FROM bill INNER JOIN user ON bill.buyer_id = user.id";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Bill bill = new Bill();
				bill.setId(rs.getInt("id"));
				bill.setDate(rs.getString("buy_date"));
				bill.setTotalBill(rs.getLong("total_price"));

				User customer = new User();

				customer.setUsername(rs.getString("username"));

				bill.setBuyer(customer);

				billList.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("loi" + e);
		}
		return billList;
	}

	public List<Bill> search(int userId) {
		List<Bill> billList = new ArrayList<Bill>();
		String sql = "SELECT bill.id, bill.buy_date,bill.total_price, user.username FROM bill INNER JOIN user ON bill.buyer_id = user.id WHERE user.id = ?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Bill bill = new Bill();
				bill.setId(rs.getInt("id"));
				bill.setDate(rs.getString("buy_date"));
				bill.setTotalBill(rs.getLong("total_price"));

				User customer = new User();
				customer.setUsername(rs.getString("username"));
				bill.setBuyer(customer);

				billList.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("search bill loi" + e);
		}
		return billList;
	}

	@Override
	public Bill get(String name) {
		return null;
	}
}
