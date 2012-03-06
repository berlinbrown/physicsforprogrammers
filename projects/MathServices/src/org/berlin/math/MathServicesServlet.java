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

	public int mathFuncFibonacci(final int n) {
		 int f0a = 0;
		 int f1b = 1;
         for (int i = 0; i < n; i++) {
             final int savePrev1 = f0a;
             f0a = f1b;
             f1b = savePrev1 + f1b;
         }
         return f0a;
	} // End of the method //
	
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		
		response.setContentType("text/plain");		
		final PrintWriter pw  = response.getWriter();		
		final String func = request.getParameter("func");
		
		String resultMessage = "invalid ; Invalid Request";
		if (func != null) {	
			if ("plus".equalsIgnoreCase(func)) {
				final String a = request.getParameter("arg1");
				final String b = request.getParameter("arg2");
				if (a == null || b == null) {
					resultMessage = "Invalid Parameters";
				} else {
					try { 							
						final int ai = Integer.parseInt(a);
						final int bi = Integer.parseInt(b);
						final int plus = ai + bi;
						resultMessage = String.valueOf(plus);
					} catch(final Throwable t) {
						resultMessage = "error ; Error at function";
					} // End of the try - catch //
				} // End of the if //					
				
			} else if ("range".equalsIgnoreCase(func)) {
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
					if (ni >= 30) {
						resultMessage = "error ; Error at function (invalid value for n=" + n + ")";
					} else {
						final int fib = mathFuncFibonacci(ni);					
						resultMessage = String.valueOf(fib);
					}
				} catch(final Throwable t) {
					resultMessage = "error ; Error at function";
				} // End of the try - catch //
				
			} else if ("fib2".equalsIgnoreCase(func)) {
				
				final String n = request.getParameter("n");
				try { 			
					final int ni = Integer.parseInt(n);
					if (ni >= 30) {
						resultMessage = "error ; Error at function (invalid value for n=" + n + ")";
					} else {					
						final StringBuffer buf = new StringBuffer();
						for (int i = 0; i <= ni; i++) {
							buf.append(mathFuncFibonacci(i) + ", ");
						}								
						resultMessage = buf.toString();
					}
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
				
			} else if ("numbers".equalsIgnoreCase(func)) {				
				final StringBuffer buf = new StringBuffer();
				for(int i = 0; i < databaseNumbers.length; i++) {
					buf.append(databaseNumbers[i][0] + " = " + databaseNumbers[i][1]);
					buf.append("\n");
				}
				resultMessage = buf.toString();
				
			} else if ("dates".equalsIgnoreCase(func)) {
				
				final StringBuffer buf = new StringBuffer();
				for(int i = 0; i < databaseTimes.length; i++) {
					buf.append(databaseTimes[i][0] + " = " + databaseTimes[i][1]);
					buf.append("\n");
				}
				resultMessage = buf.toString();
				
			} else {				
				resultMessage = "invalid ; Invalid Request"; 
			} // End of the if //
		} else {
			resultMessage = "invalid ; Invalid Request";
		} // End of the if //
		
		pw.println(resultMessage);
		
	} // End of the method //
	
	private final String databaseNumbers [][] = {
			{ "Math - Pi", ""+Math.PI },
			{ "Math - E(base of natural logarithms)", ""+Math.E },
			{ "Physics - Avogadro constant (related to mols)", "6.0221415 x 10^23" },
			{ "Physics - Speed of Light", "299,792,458 m/s" },
			{ "Physics - Age of Earth" , "4.6 billion years" },
			{ "Physics - Age of Universe" , "13.7 billion years" },
			
			{ "Sociology - United States Population (Jul2011)", "311,591,917" },
			{ "Sociology - World population (2010)", "6,997,342,509" },
			
			{ "Medicine - Number of neurons in human brain", "100 billion (100,000,000,000) " },
			{ "Medicine - Number of cells in body", "10^14" },						
	};
	
	private final String databaseTimes [][] = {
			{ "Math - Alonzo Church, born in : ", "1903" },			
			{ "Math - Alan Turing, born in : ", "1912" },
	};
	
} // End of the class //
