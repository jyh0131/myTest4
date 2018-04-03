package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerUsingURI extends HttpServlet {
	private HashMap<String, CommandHandler> commandHandlerMap = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");//properties
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		
		try(FileReader fis = new FileReader(configFilePath)){
			prop.load(fis);
		}catch (Exception e) {
			throw new ServletException();
		}
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()){
			String command = (String)keyIter.next(); // /simple.do
			String handlerClassName = prop.getProperty(command); // mvc.simple.SimpleHandler
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				CommandHandler handlerInstance = (CommandHandler)handlerClass.newInstance();
				commandHandlerMap.put(command, handlerInstance);
			} catch (Exception e) {
				// TODO: handle exception
				throw new ServletException();
			}
		}		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse responce)  throws ServletException, IOException{
		String command = request.getRequestURI();
		String contextPath = request.getContextPath();
		if(command.indexOf(contextPath) == 0){
			command = command.substring(contextPath.length());
		}
		
		CommandHandler handler = commandHandlerMap.get(command);
		if(handler == null){
			handler = new NullHandler();
		}
		
		String viewPage = null;
		try {
			viewPage = handler.process(request, responce);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
		if(viewPage != null){
			RequestDispatcher dis = request.getRequestDispatcher(viewPage);
			dis.forward(request, responce);
		}
	}
}










