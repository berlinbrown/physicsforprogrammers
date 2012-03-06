package org.berlin.math.euler;

import java.util.ArrayList;
import java.util.List;

public class Euler28 {

	public static void main(final String [] args) {
		
		System.out.println("Running Euler 28");

		final int leftWidth = 2;
		final int rightWidth = 2;
		
		final int size = leftWidth + rightWidth + 1;
		
		final int data [][] = new int [size][size];		
		int x = leftWidth;
		int y = leftWidth;						
		final int maxElements = size * size;
		final int pathRight1 = 0;
		final int pathDown2  = 1;
		final int pathLeft3  = 2;
		final int pathUp4    = 3;
		final int pathRight5 = 4;								
		int spiralWidth = 1;
		int lastVal = 1;
		data[x][y] = lastVal;
		lastVal = 2;		
		boolean done = false;
		final int initialSpanInDir [] = {
			2, 2, 3, 3, 3	
		};
		while(!done) {			
			final List<Integer[]> poss = new ArrayList<Integer[]>();
			for (int curDirCode = 0; curDirCode < 5; curDirCode++) {				
				if (curDirCode == pathRight1) {					
				} else if (curDirCode == pathDown2) {					
				} else if (curDirCode == pathLeft3) {				
				} else if (curDirCode == pathUp4) {
				} else if (curDirCode == pathRight5) {					
				} // End of the if - else ///				
				
				/*
				final int xx = chkPos[z][0];
				final int yy = chkPos[z][1];				
				for (int ii = 0; ii < distance; ii++) {
					for (int jj = 0; jj < distance; jj++) {
						final Integer [] tpos = {
							(ii+(distance*xx))+leftWidth, (jj+(distance*yy))+leftWidth	
						};						
						System.out.println(tpos[0] + " // " + tpos[1]);
						poss.add(tpos);
					}
				}
				*/
			} // End of build list /						
			
			/*
			for (final Integer [] pos : poss) {
				x = pos[0]; y = pos[1];
				data[x][y] = lastVal;
				lastVal++;
				ptr++;
				if (ptr == maxElements) {
					done = true;
				}
			}
			distance++;
			*/		
			break;
		} // End of the for //
		done: {			
			// Print
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					System.out.print(data[j][i] + "  ");
				}
				System.out.println();
			}
		}
		System.out.println("Done");
		
	}
	
} // End of the class //
