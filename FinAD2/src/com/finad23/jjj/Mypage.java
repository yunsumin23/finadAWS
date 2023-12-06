package com.finad23.jjj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Mypage {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	
//	?占쏙옙諛섏쑀?? ?占쏙옙?占쏙옙?占쏙옙 異붿텧
	public Nomal_info nomal_user(String id) {
		Nomal_info nomal_user = new Nomal_info();
		try {
			getcon();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from nomal_user where nomalUserId = '" + id + "';");
			if(resultSet.next()) {
				nomal_user.setId(resultSet.getString("nomalUserId"));
				nomal_user.setName(resultSet.getString("name"));
				nomal_user.setEmail(resultSet.getString("eMail"));
				nomal_user.setMobilenumber(resultSet.getString("mobileNumber"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return nomal_user;
	}
	
//	?占쏙옙?占쏙옙猷⑥뼵?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 異붿텧
	public Influ_info influ(String id) {
		Influ_info influ_info = new Influ_info();
		try {
			getcon();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from user where influUserId = '" + id + "';");
			if(resultSet.next()) {
				influ_info.setNickname(resultSet.getString("nickName"));
				influ_info.setName(resultSet.getString("name"));
				influ_info.setEmail(resultSet.getString("eMail"));
				influ_info.setMobilenumber(resultSet.getString("mobileNumber"));
				influ_info.setCategory(resultSet.getString("category"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return influ_info;
	}

//	?占쏙옙?占쏙옙猷⑥뼵?占쏙옙 留덉씠?占쏙옙?占쏙옙占�? 異뷂옙? ?占쏙옙占�?
	public Mypage_influ influ_mypage(String id) {
		Mypage_influ mypage_influ = new Mypage_influ();
		try {
			getcon();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from user_mypage where influUserId = '" + id + "';");
			if(resultSet.next()) {
				mypage_influ.setImage(resultSet.getString("image"));
				mypage_influ.subscribers(resultSet.getInt("subscribers"));
				mypage_influ.setYoutuLink(resultSet.getString("youtubeLink"));
				mypage_influ.setLiveBcLink(resultSet.getString("liveBroadcastLink"));
				mypage_influ.setSnsLink(resultSet.getString("snsLink"));
				mypage_influ.setIntroduc(resultSet.getString("introduction"));
				mypage_influ.setAvgviewers(resultSet.getInt("avgviewers"));
				mypage_influ.setThravgSub(resultSet.getInt("30avgSub"));
				mypage_influ.setThravgViewer(resultSet.getInt("30avgViewer"));
				mypage_influ.setThravgHit(resultSet.getInt("30avgHits"));
				mypage_influ.setMan_ratio(resultSet.getDouble("man_ratio"));
				mypage_influ.setWoman_ratio(resultSet.getDouble("woman_ratio"));
				mypage_influ.setTenAge(resultSet.getDouble("ageAvg10"));
				mypage_influ.setTweAge(resultSet.getDouble("ageAvg20"));
				mypage_influ.setThrAge(resultSet.getDouble("ageAvg30"));
				mypage_influ.setForAge(resultSet.getDouble("ageAvg40"));
				mypage_influ.setFifAge(resultSet.getDouble("ageAvg50"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return mypage_influ;
	}
	
//	湲곗뾽?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 異붿텧
	public Company_info company(String id) {
		Company_info company_info = new Company_info();
		try {
			getcon();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from company where companyId = '" + id + "';");
			if(resultSet.next()) {
				company_info.setComname(resultSet.getString("companyName"));
				company_info.setName(resultSet.getString("name"));
				company_info.setComemail(resultSet.getString("eMail"));
				company_info.setComnumber(resultSet.getString("telephoneNumber"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return company_info;
	}
	
	
	
	
	
//	而ㅻ꽖?占쏙옙 ?占쏙옙踰덉뿉 紐⑨옙?嫄곗엫 ?占쏙옙怨좎떢?占쏙옙占�? 硫붿냼?占쏙옙 ?占쏙옙異쒗븯硫대맖.
	public void getcon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://3.34.46.245:3306/project?characterEncoding=utf-8", "ysumin", "123456");
			if(connection == null) {
//				throw?占쏙옙 ?占쏙옙?占쏙옙泥섎━占�? 媛뺤젣占�? ?占쏙옙?占쏙옙?占쏙옙嫄곌퀬
//				throws?占쏙옙 硫붿냼?占쏙옙 ?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙 硫붿냼?占쏙옙占�? ?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙占�? ?占쏙옙占�? ?占쏙옙 ?占쏙옙?占쏙옙占�?占�? ?占쏙옙?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙?占쏙옙!
				throw new Exception("?占쏙옙?占쏙옙?占쏙옙踰좎씠?占쏙옙 ?占쏙옙占�? ?占쏙옙?占쏙옙.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
//	?占쏙옙濡쒖쫰 ?占쏙옙占�? 紐⑨옙?嫄곗엫 finally ?占쏙옙 ?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙 硫붿냼?占쏙옙 ?占쏙옙異쒗븯占�? ?占쏙옙.
	public void close() {
		try {
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
