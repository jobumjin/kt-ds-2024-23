package com.ktdsuniversity.edu.hr;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBSupporter {
	private final String DRIVER = "";
	private final String URL = "";

	private final String username;
	private final String password;

	public DBSupporter(String username, String password) {
		this.username = username;
		this.password = password;
	}

	private Connection makeConnection() throws SQLException {

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = DriverManager.getConnection(URL, username, password);
		conn.setAutoCommit(false);

		return conn;
	}

	private void closeConnection(Connection connection, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}

	private void setParams(PreparedStatement pstmt, Object[] params) throws SQLException {
		if (params != null && params.length > 0) {
			Object param = null;
			for (int i = 0; i < params.length; i++) {
				param = params[i];
				if (param instanceof String) {
					pstmt.setString(i + 1, param.toString());
				} else if (param.getClass() == int.class || param instanceof Integer) {
					pstmt.setInt(i + 1, Integer.parseInt(param.toString()));
				} else if (param.getClass() == long.class || param instanceof Long) {
					pstmt.setLong(i + 1, Long.parseLong(param.toString()));
				} else if (param.getClass() == double.class || param instanceof Double) {
					pstmt.setDouble(i + 1, Double.parseDouble(param.toString()));
				} else if (param.getClass() == boolean.class || param instanceof Boolean) {
					pstmt.setBoolean(i + 1, Boolean.parseBoolean(param.toString()));
				}
			}
		}
	}

	private <T> void invokeSetter(T t, ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		
		String columnName = null;
		String fieldName = null;
		Field field = null;
		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			columnName = metaData.getColumnName(i);
			fieldName = convertToFieldName(columnName);
			field = ReflectUtil.getField(t, fieldName);
			
			if (field != null) {
				Class<?> fieldType = ReflectUtil.getFieldType(t, fieldName);
				if (fieldType == String.class) {
					ReflectUtil.invokeSetter(t, fieldName, rs.getString(columnName));
				} else if (fieldType == int.class || fieldType == Integer.class) {
					ReflectUtil.invokeSetter(t, fieldName, rs.getInt(columnName));
				} else if (fieldType == double.class || fieldType == Double.class) {
					ReflectUtil.invokeSetter(t, fieldName, rs.getDouble(columnName));
				} else if (fieldType == long.class || fieldType == Long.class) {
					ReflectUtil.invokeSetter(t, fieldName, rs.getDouble(columnName));
				} else if (fieldType == boolean.class || fieldType == Boolean.class) {
					ReflectUtil.invokeSetter(t, fieldName, rs.getBoolean(columnName));
				}
			}
		}
	}

	private String convertToFieldName(String columnName) {
		columnName = columnName.toLowerCase();

		for (int i = 0; i < columnName.length(); i++) {
			if (columnName.charAt(i) == '_') {
				columnName = columnName.replace("_" + columnName.charAt(i + 1),
						("_" + columnName.charAt(i + 1)).toUpperCase());
			}
		}
		
		return columnName.replace("_", "");
	}

	public int insert(String query, Object[] params) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = makeConnection();
			pstmt = conn.prepareStatement(query);
			setParams(pstmt, params);
			int result = pstmt.executeUpdate();

			conn.commit();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			closeConnection(conn, pstmt, null);
		}
		return 0;
	}

	public int update(String query, Object[] params) {
		return insert(query, params);
	}

	public int delete(String query, Object[] params) {
		return insert(query, params);
	}

	public <T> List<T> selectList(String query, Object[] params, Class<T> type) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = makeConnection();
			pstmt = conn.prepareStatement(query);
			setParams(pstmt, params);

			rs = pstmt.executeQuery();

			List<T> result = new ArrayList<>();
			while (rs.next()) {
				Constructor<T> constructor = type.getDeclaredConstructor();
				T t = constructor.newInstance();
				invokeSetter(t, rs);

				result.add(t);
			}

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}

		return null;
	}

	public <T> T selectOne(String query, Object[] params, Class<T> type) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = makeConnection();
			pstmt = conn.prepareStatement(query);
			setParams(pstmt, params);

			rs = pstmt.executeQuery();

			T t = null;
			if (rs.next()) {
				Constructor<T> constructor = type.getDeclaredConstructor();
				t = constructor.newInstance();

				invokeSetter(t, rs);
			}

			return t;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstmt, rs);
		}

		return null;
	}

}
