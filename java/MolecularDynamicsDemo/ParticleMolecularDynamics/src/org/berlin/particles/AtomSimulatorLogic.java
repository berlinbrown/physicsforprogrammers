package org.berlin.particles;

public class AtomSimulatorLogic {
    
    private final MoleculeSimulation simulation = new MoleculeSimulation(); 
    
    /**
     * Core molecule simulation data.
     * 
     * @author bbrown
     *
     */
    public class MoleculeSimulation {
    
        /** Number of pixels in one distance unit. */
        private int pixelsPerUnit;
        
        /** box width in natural units. */
        private double boxWidth; 
        
        /** Maximum number of molecules. */
        private int maxNumberMolecules = 1000;
        
        /** Current number of molecules. */
        private int N = 0;
        
        /** Clock time in natural units. */
        private double t = 0; 
        private double dt = 0.02;
        
        /** "Spring constant" for bouncing off walls. */
        private double wallStiffness = 50;         
        
        /** Distance beyond which we don't bother to compute the force. */
        private double forceCutoff = 3;        
        private double forceCutoff2 = forceCutoff * forceCutoff;
        
        private double pEatCutoff = 4 * (Math.pow(forceCutoff, -12) - Math.pow(forceCutoff, -6));
        
        /*
         * Kinetic, potential, gravitational, and total energy.
         */
        private double kEnergy = 0;
        private double pEnergy = 0;
        
        private double tempPEnergy = 0;
        private double gEnergy = 0;
        private double totalEnergy = 0;
        
        /*
         * Cm coordinates, momentum, angular momentum, moment of inertia
         */
        private double xcm;
        private double ycm;
        private double px;
        private double py;
        private double Lcm;
        private double Icm; 
        
        private double pressure;
        
        /** accumulated temperature and pressure. */
        private double totalTemperature, totalPressue;
        
        /** number of values accumulated in totalT and totalP. */
        private long sampleCount; 
        
        /** local gravitational constant in natural units */
        private double gravity = 0;
        
    } // End of the class //
    
    /**
     * Molecule class has fields, position, velocity and acceleration.
     * 
     * @author bbrown
     *
     */
    public class Molecule {
        private double x = 0;
        private double y = 0;
        
        private double vx = 0;
        private double vy = 0;
        
        private double ax = 0;
        private double ay = 0;
    } // End of the class //

    /**
     * Initialize the simulator parameters.
     */
    public void logicInit() {
        
        simulation.pixelsPerUnit = (int) Math.round(sizeScroll.getValue());
        simulation.boxWidth = canvasWidth * 1.0 / pixelsPerUnit;
        int n = (int) Math.round(nScroll.getValue());
        simulation.N = 0;
        for (int i = 0; i < n; i++) {
            addMolecule();
        }        
        simulation.dt = 0.02;
    }
    
    
} // End of the Class //
