package com.address.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisManager {
	public static SqlSessionFactory sqlSessionFactory;
	static {
		try {
				String resource = "com/address/config/configuration.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource);
				 sqlSessionFactory =
				  new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSessionFactory() {
		return sqlSessionFactory;
	}

}
