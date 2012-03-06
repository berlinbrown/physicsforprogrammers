package ar.com.hjg.pngj.test;

import java.io.File;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.ImageLine;
import ar.com.hjg.pngj.PngWriter;
import ar.com.hjg.pngj.nosandbox.FileHelper;

/**
 */
public class PngCreateSin {
	private static void makeTestImage(final PngWriter png,double t1){
		int t1i = (int)(t1+0.5);
		int cols = png.imgInfo.cols;
		int rows = png.imgInfo.rows;
		ImageLine iline = new ImageLine(png.imgInfo);		
		for (int i=0;i<rows;i++) {
			double fase = Math.PI*(i%t1i)/t1; // 0:2pi
			iline.setRown(i);
			png.writeRow(iline);
		}
	}

	

	private static double clamp(double d, double d0, double d1) {
		return d > d1 ? d1 : (d < d0 ? d0 : d);
	}

	public static void createTestSin(String name, int cols, int rows, double t1)
  {
		PngWriter i2 = FileHelper.createPngWriter(new File(name), 
				new ImageInfo(cols, rows, 8, false,true,false),true);
		makeTestImage(i2,t1);
		System.out.println("Done: " + i2.getFilename());
	}

	public static void main(String[] args) throws Exception {				
		int cols = Integer.parseInt("800");
		int rows = Integer.parseInt("600");
		double t1 = Double.parseDouble("40.0");
		createTestSin("test1.png", cols, rows, t1);
	}
}
