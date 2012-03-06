package org.berlin.math.literate;

public class LiterateFib {
	/**
	 * The Fibonacci sequence is named after Leonardo of Pisa.
	 * 
	 * 0, 1, 1, 2, 3, 5, 8, 13, 21 	 
	 * 
	 * @param n
	 * @return
	 */
	protected int mathFuncFibonacci(final int n) {
		 int f0a = 0;
		 int f1b = 1;
        for (int i = 0; i < n; i++) {
            final int savePrev1 = f0a;
            f0a = f1b;
            f1b = savePrev1 + f1b;
        }
        return f0a;
	} // End of the method //
}
