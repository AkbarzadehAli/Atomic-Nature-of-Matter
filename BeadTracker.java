import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class BeadTracker {
    public BeadTracker(int minPixel, double delta,BeadFinder A1, BeadFinder A2){
        ArrayList<Blob> beads1 = A1.getBeads(minPixel);
        ArrayList<Blob> beads2 = A2.getBeads(minPixel);
        for (int i = 0; i < beads1.size(); i++) {
            for (int j = 0; j < beads2.size(); j++) {
                double distance = beads1.get(i).distanceTo(beads2.get(j));
                if (distance <= delta) {
                    System.out.format("%7.4f\n",distance);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        int minPixel= Integer.parseInt(args[0]);
        double tau= Double.parseDouble(args[1]);
        double delta= Double.parseDouble(args[2]);
        String folder=args[3];
        //read folder
        String[] frames = new String[200];
        //list frames
        File filename = new File(folder);
        String[] list = filename.list();
        //distance 2 bead
            for (int i = 0; i < 199; i++) {
                Picture a1 = new Picture(folder+"/"+list[i]);
                Picture a2 = new Picture(folder+"/"+list[i+1]);
                BeadFinder b1 = new BeadFinder(a1, tau);
                BeadFinder b2 = new BeadFinder(a2, tau);
                BeadTracker A = new BeadTracker(minPixel, delta, b1, b2);
//                System.out.println();
            }
    }//end main

}//end class


