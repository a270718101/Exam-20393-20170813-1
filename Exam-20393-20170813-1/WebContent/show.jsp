<%@ page pageEncoding="GB18030"%>
<%@ page import="java.sql.*, Bean.*, java.util.*"%>
<%!private void show(List<Film> films, Connection conn) {
		String sql = "SELECT film_id,title,description,language.name from film,language where film.language_id=language.language_id";
		Statement stmt = DB.createStmt(conn);
		ResultSet rs = DB.executeQuery(stmt, sql);
		try {
			while (rs.next()) {
				Film f = new Film();
				f.setFilm_id(rs.getInt("film_id"));
				f.setTitle(rs.getString("title"));
				f.setDescription(rs.getString("description"));
				f.setLanguage(rs.getString("language.name"));
				films.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
		}
	}%>
<%
	List<Film> films = new ArrayList<Film>();
	Connection conn = DB.getConn();
	show(films, conn);
	DB.close(conn);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>œ‘ æ“≥√Ê</title>
</head>

<body>
	<table>
		<thead>
			<tr>
				<th>film_id</th>
				<th>title</th>
				<th>description</th>
				<th>language</th>
				<th>delete</th>
				<th>edit</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Iterator<Film> it = films.iterator(); it.hasNext();) {
					Film f = it.next();
			%>
			<tr>
				<td><%=f.getFilm_id()%></td>
				<td><%=f.getTitle()%></td>
				<td><%=f.getDescription()%></td>
				<td><%=f.getLanguage()%></td>
				<td><a href="delete.jsp?title=<%=f.getTitle()%>">delete</a></td>
				<th><a
					href="edit.jsp?film_id=<%=f.getFilm_id()%>&title=<%=f.getTitle()%>&description=<%=f.getDescription()%>&language=<%=f.getLanguage()%>">edit</a>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>