package edu.neu.csye6200.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class Rule2Thread implements Runnable {

    public static boolean growthEnd = false; // flag to see growth is completed
    public static ArrayList<Stem> stemList = new ArrayList<Stem>(); //list of stems is stored here
    public static ArrayList<RotatedStem> rotatedStems = new ArrayList<>(); //list of stems after rotation is stored here
    private static Thread worker; //main thread of the simulation
    private static final AtomicBoolean running = new AtomicBoolean(false); //current state of thread is stored here
    private static boolean stop = false; //used for stopping the simulation
    GraphicThread graphicThread = new GraphicThread();
    /**
     * constructor for rule 2, creates a new stem and adds it to the stemList
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @param category
     * @param angle
     * @param parent
     */
    public Rule2Thread(int startX, int startY,int endX,int endY,int category,int angle, int parent){
        growthEnd = false;
        MyAppUI.canvas.removeAll();
        MyAppUI.canvas.revalidate();
        MyAppUI.canvas.repaint();
        MyAppUI.canvas.updateUI();
        stemList.add(new Stem(1, startX, startY, endX, endY, category, angle, parent, 0));
    }

    /**
     * start the thread
     */
    public void start() {
        worker = new Thread(this);
        running.set(true);
        stop = false;
        worker.start();
    }

    /**
     * stop the thread
     */
    public void stop() {
        stop = true;
        running.set(false);
        graphicThread.stop();
    }

    /**
     * put thread in infinite sleep - wakes up when the pause button is pressed again
     */
    public void sleep() {
        running.set(false);
    }

    /**
     * resume the thread when pause pause button is pressed again
     */
    public void resume(){
        running.set(true);
    }


    @Override
    public void run() {
        while (running.get()){
            try {
                worker.sleep(2000);
                graphicThread.start();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println(
                        "Thread was interrupted, Failed to complete operation");
            }

            try {
                /**
                 * this function invokes growth in stems
                 */
                growStem();
                /**
                 * stops the graphic thread
                 */
                graphicThread.stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * invoke growth in stem
     * @throws InterruptedException
     */
    public static void growStem() throws InterruptedException {
        while (running.get()){
            outerWhileLoop:
            while(!checkGrowthEnd()){
                //increments length of each branch
                while (running.get()){
                    if(stop){
                        stemList.clear();
                        rotatedStems.clear();
                        break outerWhileLoop;
                    }
                    growBranches();
                    //timeout
                    Thread.sleep(50);
                    //create branches from main tree
                    createBranches();
                    //create leaves from branches
                    createLeaves();

                    if(checkGrowthEnd()){
                        break;
                    }
                }
            }
            System.out.println("Simulation Stopped");
            //Start rotation
            sendForRotation();
            outerLoop:
            for(int j =0; j<20; j++){
                Thread.sleep(500);
                for (RotatedStem rotatedStem : rotatedStems) {
                    if (rotatedStem.direction != 0) {
                        if(stop){
                            stemList.clear();
                            rotatedStems.clear();
                            break outerLoop;
                        }
                        rotatedStem.rotateAboutSuperParent(5);

                    }

                }
            }
            running.set(false);
            stop = true;
        }
    }





    //Creates branches from main branch
    public static Stem[] parentStem = {null};
    public static void createBranches(){
        Arrays.fill(parentStem, null);
        stemList.forEach(n -> {if(n.parent == 0) parentStem[0] = (n);});
        if(parentStem[0].mainStemPoint1Length()){
            System.out.println("New threads added");
            Stem tempStem = parentStem[0];
            Stem[] returnedStems = createBranches(tempStem.currX, tempStem.currY, tempStem.angle);
            stemList.add(returnedStems[0]);
            stemList.add(returnedStems[1]);
            stemList.add(returnedStems[2]);
            stemList.add(returnedStems[3]);
        }
        if(parentStem[0].mainStemPoint2Length()){
            System.out.println("New threads added");
            Stem tempStem = parentStem[0];
            Stem[] returnedStems = createBranches(tempStem.currX, tempStem.currY, tempStem.angle);
            stemList.add(returnedStems[0]);
            stemList.add(returnedStems[1]);
            stemList.add(returnedStems[2]);
            stemList.add(returnedStems[3]);
        }
        if(parentStem[0].maxLengthAchieved() && parentStem[0].stopGrowth == false){

            System.out.println("New threads added");
            Stem tempStem = parentStem[0];
            Stem[] returnedStems = createBranches(tempStem.currX, tempStem.currY, tempStem.angle);
            stemList.add(returnedStems[0]);
            stemList.add(returnedStems[1]);
            stemList.add(returnedStems[2]);
            stemList.add(returnedStems[3]);
            parentStem[0].stopGrowth = true;
        }
    }
    /**
     * create branches from the main stem
     * @param startX
     * @param startY
     * @param angle
     * @return
     */
    public static Stem[] createBranches(int startX, int startY, int angle){
        Stem[] returnStem = new Stem[4];
        if(angle == 0){
            returnStem[0] = new Stem(stemList.size() + 1, startX, startY, startX+50, startY-50, 2, 45, 1,2);
            returnStem[1] = new Stem(stemList.size() + 2, startX, startY, startX+50, startY+50, 2, 315, 1,1);
        }
        if(angle == 45){
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX+50, startY, 2, 0, 1,1);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX, startY-50, 2, 90, 1,2);
        }
        if(angle == 90){
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX-100, startY+100, 2, 225, 2,2);
            returnStem[1] = new Stem(stemList.size() + 2, startX, startY, startX+100, startY+100, 2, 315, 1,1);

            returnStem[2] = new Stem(stemList.size() + 3,startX, startY, startX+100, startY-100, 2, 45, 1,1);
            returnStem[3] = new Stem(stemList.size() + 4,startX, startY, startX-100, startY-100, 2, 135, 1, 2);
        }
        if(angle == 135){
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX, startY-50, 2, 90, 1, 1);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX-50, startY, 2, 180, 1, 2);
        }
        if(angle == 180){
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX-50, startY-50, 2, 135, 1, 1);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX-50, startY+50, 2, 225, 1, 2);
        }
        if(angle == 225){
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX-50, startY, 2, 180, 1, 1);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX, startY+50, 2, 270, 1, 2);
        }
        if(angle == 270){
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX-50, startY+50, 2, 225, 1,1);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX+50, startY+50, 2, 315, 1, 2);
        }
        if(angle == 315){
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX+50, startY, 2, 0, 1, 2);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX, startY+50, 2, 270, 1, 1);
        }

        return returnStem;

    }

    //Creates branches from sub branches of main branch
    public static ArrayList<Stem> branchStem = new ArrayList<Stem>();
    public static void createLeaves(){
        branchStem.clear();
        stemList.forEach(n -> {if(n.category == 2) branchStem.add(n);});
        for(Stem stem: branchStem){
            if(stem.quarterLengthAchieved()){
                Stem[] returnedStems = createLeaves(stem.currX, stem.currY, stem.angle, 50, stem.id);
                stemList.add(returnedStems[0]);
                stemList.add(returnedStems[1]);
                stemList.add(returnedStems[2]);
                stemList.add(returnedStems[3]);
            }
            if(stem.halfLengthAchieved()){
                Stem[] returnedStems = createLeaves(stem.currX, stem.currY, stem.angle, 50, stem.id);
                stemList.add(returnedStems[0]);
                stemList.add(returnedStems[1]);
                stemList.add(returnedStems[2]);
                stemList.add(returnedStems[3]);
            }
            if(stem.threeQuarterLengthAchieved()){
                Stem[] returnedStems = createLeaves(stem.currX, stem.currY, stem.angle, 50, stem.id);
                stemList.add(returnedStems[0]);
                stemList.add(returnedStems[1]);
                stemList.add(returnedStems[2]);
                stemList.add(returnedStems[3]);
            }
        }
    }
    //Create leaves from category 2 branches
    public static Stem[] createLeaves(int startX, int startY, int angle, int length, int parent){
        Stem[] returnStem = new Stem[4];
        if(angle == 0){
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX+length, startY-length, 4, 45, parent, 2);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX+length, startY+length, 3, 315, parent, 1);
        }
        if(angle == 45)
        {
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX + length-30, startY, 3, 0, parent, 1);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX, startY-length+30, 4, 90, parent, 2);
            returnStem[2] = new Stem(stemList.size() + 3,startX, startY, startX-length+30, startY, 4, 180, parent, 2);
            returnStem[3] = new Stem(stemList.size() + 4,startX, startY, startX, startY+length -30, 3, 270, parent, 1);
        }
        if(angle == 90)
        {
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX+length, startY-length, 3, 45, parent, 1);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX-length, startY-length, 3, 135, parent, 2);


        }
        if(angle == 135){
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX, startY-length+30, 4, 90, parent, 1);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX-length+30, startY, 3, 180, parent, 2);
            returnStem[2] = new Stem(stemList.size() + 3,startX, startY,startX + length -30, startY,3, 0, parent,2);
            returnStem[3] = new Stem(stemList.size() + 4,startX, startY, startX, startY+length -30, 3, 270, parent, 2);
        }
        if(angle == 180){
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX-length, startY-length, 4, 135, parent, 1);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX-length, startY+length, 3, 225, parent, 2);
        }
        if(angle == 225){
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX-length+30, startY, 4, 180, parent, 1);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX, startY+length -30, 3, 270, parent, 2);
            returnStem[2] = new Stem(stemList.size() + 3,startX, startY,startX + length -30, startY,3, 0, parent,2);
            returnStem[3] = new Stem(stemList.size() + 4,startX, startY, startX, startY-length + 30, 4, 90, parent, 1);
        }
        if(angle == 270)
        {
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX-length, startY+length, 4, 225, parent, 1);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX+length, startY+length, 3, 315, parent, 2);
        }
        if(angle == 315){
            returnStem[0] = new Stem(stemList.size() + 1,startX, startY, startX + length -30, startY, 4, 0, parent, 2);
            returnStem[1] = new Stem(stemList.size() + 2,startX, startY, startX, startY+length -30, 3, 270, parent, 1);
            returnStem[2] = new Stem(stemList.size() + 3,startX, startY, startX-length +30, startY, 3, 180, parent, 1);
            returnStem[3] = new Stem(stemList.size()+4,startX, startY, startX, startY-length +30, 4, 90, parent, 2);
        }


        return returnStem;
    }



    /**
     * changing coordinates of the end point of all stems
     */
    public static void growBranches() {
        for (Stem stem : stemList) {
            if (!stem.maxLengthAchieved()) {
                if (stem.angle == 90) {
                    stem.currY -= 1;
                }
                if (stem.angle == 45) {
                    stem.currX += 1;
                    stem.currY -= 1;
                }
                if (stem.angle == 135) {
                    stem.currX -= 1;
                    stem.currY -= 1;
                }
                if(stem.angle == 0){
                    stem.currX += 1;
                }
                if(stem.angle == 180){
                    stem.currX -= 1;
                }
                if(stem.angle == 225){
                    stem.currX -= 1;
                    stem.currY += 1;
                }
                if(stem.angle == 270){
                    stem.currY += 1;
                }
                if(stem.angle == 315){
                    stem.currX += 1;
                    stem.currY += 1;
                }
            }

            System.out.println(stem.category + " : " + stem.currX + "," + stem.currY);
        }
    }
    /**
     * check if growth is completed
     * @return
     */
    public static boolean checkGrowthEnd() {
        for(Stem stem: stemList){
            if(!stem.maxLengthAchieved()){
                return false;
            }
        }
        growthEnd = true;
        return true;
    }
    /**
     * convert stem to rotated stem
     */
    public static void sendForRotation(){


        for(Stem stem: stemList){
            if(stem.category == 1){
                rotatedStems.add(new RotatedStem(stem.id,stem.endX,stem.endY,stem.startX,stem.startY,stem.startX,stem.startY,1,0,0));
            }
            if(stem.category == 2){
                rotatedStems.add(new RotatedStem(stem.id,stem.endX,stem.endY,stem.startX,stem.startY,stem.startX,stem.startY,2,stem.direction,stem.parent));
            }
            if(stem.category == 3){
                rotatedStems.add(new RotatedStem(stem.id,stem.endX,stem.endY,stem.startX,stem.startY,getParentX(stem.parent),getParentY(stem.parent),stem.category,stem.direction,stem.parent));
            }
            if(stem.category == 4){
                rotatedStems.add(new RotatedStem(stem.id,stem.endX,stem.endY,stem.startX,stem.startY,getParentX(stem.parent),getParentY(stem.parent),stem.category,stem.direction,stem.parent));
            }
            if(stem.category == 5){
                rotatedStems.add(new RotatedStem(stem.id,stem.endX,stem.endY,stem.startX,stem.startY,stem.startX,stem.startY,2,stem.direction,stem.parent));
            }
            if(stem.category == 6){
                rotatedStems.add(new RotatedStem(stem.id,stem.endX,stem.endY,getParentX(stem.parent),getParentY(stem.parent),getParentX(stem.parent),getParentY(stem.parent),2,getCat6Direction(stem.angle),stem.parent));
            }
        }
    }
    /**
     * for category 6 branches find direction of rotation
     * @param angle
     * @return
     */
    public static int getCat6Direction(int angle){
        return switch (angle) {
            case 0 -> 1;
            case 45 -> 1;
            case 90 -> 0;
            case 135 -> 2;
            case 180 -> 2;
            case 215 -> 2;
            case 270 -> 0;
            case 315 -> 1;
            default -> 0;
        };
    }
    /**
     * return parent stem's x coordinate
     * @param child
     * @return
     */
    public static double getParentX(int child){
        for(Stem stem:stemList){
            if(child == stem.id){
                return stem.startX;
            }
        }
        return 0;
    }
    /**
     * return parent stem's y coordinate
     * @param child
     * @return
     */
    public static double getParentY(int child){
        for(Stem stem:stemList){
            if(child == stem.id){
                return stem.startY;
            }
        }
        return 0;
    }
}
