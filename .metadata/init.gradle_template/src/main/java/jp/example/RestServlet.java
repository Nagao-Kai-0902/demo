package jp.example;

import java.io.IOException;
import java.util.Date;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class RestServlet extends HttpServlet {

	private final ObjectMapper json = new JsonMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		record Result(String message, Date date) {};
		var result = new Result("ハローワールド", new Date());
		res.setContentType("text/json; charset=UTF-8");
		json.writeValue(res.getWriter(), result);
	}
}
