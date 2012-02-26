/**
 * For source:
 * 
 * https://github.com/berlinbrown/physicsforprogrammers/tree/master/projects/MathServices
 * 
 * Also see:
 * 
 * https://github.com/berlinbrown
 * http://berlinbrown.github.com/
 * http://berlinbrown.github.com/applets.html
 */
package org.berlin.math;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Basic math utilities for google app engine.
 * 
 * @author bbrown (berlin.brown at gmail.com)
 *
 */
public class MathServicesServlet extends HttpServlet {
	 
	/**
	 * Serial version id. 
	 */
	private static final long serialVersionUID = 1L;

	protected int mathFuncFibonacci(final int n) {
		 int f0a = 0;
		 int f1b = 1;
         for (int i = 0; i < n; i++) {
             final int savePrev1 = f0a;
             f0a = f1b;
             f1b = savePrev1 + f1b;
         }
         return f0a;
	}
	
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		
		response.setContentType("text/plain");		
		final PrintWriter pw  = response.getWriter();
		
		final String func = request.getParameter("func");
		
		String resultMessage = "invalid ; Invalid Request";
		if (func != null) {		
			if ("range".equalsIgnoreCase(func)) {
				final String from = request.getParameter("from");
				final String to = request.getParameter("to");
				if (from == null || to == null) {
					resultMessage = "Invalid Parameters";
				} else {
					try { 	
						final StringBuffer buf = new StringBuffer();
						final int fromi = Integer.parseInt(from);
						final int toi = Integer.parseInt(to);
						for (int i = fromi; i < toi; i++) {
							buf.append(i + ",");
						}					
						resultMessage = buf.toString();
					} catch(final Throwable t) {
						resultMessage = "error ; Error at function";
					} // End of the try - catch //
				} // End of the if //					
				
			} else if ("fib".equalsIgnoreCase(func)) {
				
				final String n = request.getParameter("n");
				try { 			
					final int ni = Integer.parseInt(n);
					final int fib = mathFuncFibonacci(ni);
					resultMessage = String.valueOf(fib);
				} catch(final Throwable t) {
					resultMessage = "error ; Error at function";
				} // End of the try - catch //
				
			} else if ("fib2".equalsIgnoreCase(func)) {
				
				final String n = request.getParameter("n");
				try { 			
					final int ni = Integer.parseInt(n);
					
					final StringBuffer buf = new StringBuffer();
					for (int i = 0; i <= ni; i++) {
						buf.append(mathFuncFibonacci(i) + ", ");
					}								
					resultMessage = buf.toString();
				} catch(final Throwable t) {
					resultMessage = "error ; Error at function";
				} // End of the try - catch //
				
			} else if ("sum".equalsIgnoreCase(func)) {				
				final String n = request.getParameter("n");
				try { 						
					final int ni = Integer.parseInt(n);
					int sum = 0;
					for (int i = 1; i <= ni; i++) {
						sum += i;
					} // End of the for //					
					resultMessage = String.valueOf(sum);
				} catch(final Throwable t) {
					resultMessage = "error ; Error at function";
				} // End of the try - catch //
			} else {				
				resultMessage = "invalid ; Invalid Request"; 
			} // End of the if //
		} else {
			resultMessage = "invalid ; Invalid Request";
		} // End of the if //
		
		pw.println(resultMessage);
		
	} // End of the method //
	
} // End of the class //
