package com.product.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.comm.DBConnPool;

public class ProductDAO extends DBConnPool{
	//추가
	public void productInsert(ProductDTO product) {
		String sql = "insert into products(pnum,name,unitprice,description,ofile,sfile)"
				+ " values(products_seq.nextval,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setInt(2, product.getUnitPrice());
			ps.setString(3, product.getDescription());
			ps.setString(4, product.getOfile());
			ps.setString(5, product.getSfile());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//전체보기
	public ArrayList<ProductDTO>productList(){
		ArrayList<ProductDTO> plist = new ArrayList<ProductDTO>();
		String sql = "select * from products";
		
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setDescription(rs.getString("description"));
				p.setName(rs.getString("name"));
				p.setOfile(rs.getString("Ofile"));
				p.setPnum(rs.getInt("pnum"));
				p.setSfile(rs.getString("sfile"));
				p.setUnitPrice(rs.getInt("unitPrice"));
				plist.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plist;
		
	}
}
