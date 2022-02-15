package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DButility;
import entities.Acc;

public class AccDAOimp implements AccDAO{

	@Override
	public List<Acc> getAll() {
		Connection conn = null;
		PreparedStatement callSt = null;
		List<Acc> list = new ArrayList<Acc>();
		
		try {
			conn = DButility.connectionsql();
			callSt = conn.prepareStatement("select * from Account");
			ResultSet res = callSt.executeQuery();
			while(res.next()) {
				Acc acc = new Acc();
				acc.setId(res.getInt("id"));
				acc.setPassword(res.getString("password"));
				acc.setFullName(res.getString("fullName"));
				acc.setGender(res.getBoolean("gender"));
				acc.setBirthday(res.getDate("birthday"));
				acc.setAddress(res.getString("address"));
				acc.setEmail(res.getString("email"));
				acc.setPhone(res.getString("phone"));
				list.add(acc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButility.closeConnection(conn);
		}
		return list;
	}

	@Override
	public boolean add(Acc acc) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement callSt = null;
		boolean check = false;
		
		try {
			conn = DButility.connectionsql();
			callSt = conn.prepareStatement("insert into Account values(?,?,?,?,?,?,?)");
			// set gia tri cho tham so dau vao
			callSt.setString(1, acc.getPassword());
			callSt.setString(2, acc.getFullName());
			callSt.setBoolean(3, acc.getGender());
			callSt.setDate(4,new Date(acc.getBirthday().getTime()));
			callSt.setString(5, acc.getAddress());
			callSt.setString(6, acc.getEmail());
			callSt.setString(7, acc.getPhone());
			// thuc thi proc
			int i = callSt.executeUpdate();
			if(i>0) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButility.closeConnection(conn);
		}
		
		return check;
	}

	@Override
	public boolean update(Acc acc) {
		Connection conn = null;
		PreparedStatement callSt = null;
		boolean check = false;
		
		try {
			conn = DButility.connectionsql();
			callSt = conn.prepareStatement("update Account set fullName = ?, password=?, gender= ?, birthday = ?, address = ?, email = ?,phone = ? where id = ?");
			// set gia tri cho tham so dau vao
			callSt.setString(1, acc.getFullName());
			callSt.setString(2, acc.getPassword());
			callSt.setBoolean(3, acc.getGender());
			callSt.setDate(4,new Date(acc.getBirthday().getTime()));
			callSt.setString(5, acc.getAddress());
			callSt.setString(6, acc.getEmail());
			callSt.setString(7, acc.getPhone());
			callSt.setInt(8, acc.getId());
			// thuc thi proc
			int i = callSt.executeUpdate();
			if(i>0) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButility.closeConnection(conn);
		}
		
		return check;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement callSt = null;
		boolean check = false;
		
		try {
			conn = DButility.connectionsql();
			callSt = conn.prepareStatement("delete from Account where id = ?");
			// set gia tri cho tham so dau vao
			callSt.setInt(1, id);
			// thuc thi proc
			int i = callSt.executeUpdate();
			if(i>0) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButility.closeConnection(conn);
		}
		
		return check;
	}

	@Override
	public Acc getById(int id) {
		Connection conn = null;
		PreparedStatement callSt = null;
		Acc acc = new Acc();
		acc=null;
		
		try {
			conn = DButility.connectionsql();
			callSt = conn.prepareStatement("select * from Account where id=?");
			callSt.setInt(1, id);
			ResultSet res = callSt.executeQuery();
			if(res.next()) {
				acc = new Acc();
				acc.setId(res.getInt("id"));
				acc.setPassword(res.getString("password"));
				acc.setFullName(res.getString("fullName"));
				acc.setGender(res.getBoolean("gender"));
				acc.setBirthday(res.getDate("birthday"));
				acc.setAddress(res.getString("address"));
				acc.setEmail(res.getString("email"));
				acc.setPhone(res.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButility.closeConnection(conn);
		}
		return acc;
	}

}
