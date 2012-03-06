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
package org.berlin.math.demo;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.ImageLine;
import ar.com.hjg.pngj.ImageLineHelper;
import ar.com.hjg.pngj.PngFilterType;
import ar.com.hjg.pngj.PngWriter;

/**
 * Basic math utilities for google app engine.
 * 
 * @author bbrown (berlin.brown at gmail.com)
 *
 */
public class ImageDemoServlet extends HttpServlet {
	 
	/**
	 * Serial version id. 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {	
		doPost(request, response);
	} // End of the class //
	
	public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException {				
		response.setContentType("image/png");		
				
		final int cols = 800;
		final int rows = 600;
		
		final OutputStream os = response.getOutputStream();
		final PngWriter png = new PngWriter(os, new ImageInfo(cols, rows, 8, false));
		png.setFilterType(PngFilterType.FILTER_NONE);
		final ImageLine iline1 = new ImageLine(png.imgInfo);
		final ImageLine iline2 = new ImageLine(png.imgInfo);
		ImageLine iline = iline1;
		for (int j = 0; j < cols; j++) {			
			ImageLineHelper.setPixelRGB8(iline1, j, 
					((j & 0xFF) << 16) | (((j * 3) & 0xFF) << 8) | (j * 2) & 0xFF);
			ImageLineHelper.setPixelRGB8(iline2, j, (j * 13) & 0xFFFFFF);
		}
		long t0 = System.currentTimeMillis();
		for (int row = 0; row < rows; row++) {
			iline = row % 4 == 0 ? iline2 : iline1;
			iline.setRown(row);
			png.writeRow(iline);
		}
		png.end();
		long t1 = System.currentTimeMillis();
	} // End of the class //

} // End of the class //