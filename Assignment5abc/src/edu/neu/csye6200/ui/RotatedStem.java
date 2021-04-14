package edu.neu.csye6200.ui;

public class RotatedStem {
    int id;
    double xi, yi, xc1, yc1, xc2, yc2;
    int category, direction, connection;

    /**
     * constructor for rotated stem class
     * @param id
     * @param xi - end point x
     * @param yi - end point y
     * @param xc1 - start point x
     * @param yc1 - start point y
     * @param xc2 - start point x - parent
     * @param yc2 - start point y - parent
     * @param category - 1 -> main stem, 2 -> branches from main stem, 3 and above -> branches from category 2 branches
     * @param direction - 1 -> anticlockwise, 2 -> clockwise
     * @param connection - immediate parent
     */
    public RotatedStem(int id, double xi, double yi, double xc1, double yc1, double xc2, double yc2, int category, int direction, int connection){
        this.id = id;
        this.xi = xi;
        this.yi = yi;
        this.xc1 = xc1;
        this.yc1 = yc1;
        this.xc2 = xc2;
        this.yc2 = yc2;
        this.category = category;
        this.direction = direction;
        this.connection = connection;
    }

    /**
     * rotating end point point about immediate parent as center of the circle
     * @param angle
     */

    private void rotateAboutImmediateParentDriver(int angle){
        double xRot = (int)this.xc1 + Math.cos(Math.toRadians(angle)) * (this.xi - this.xc1)
                - Math.sin(Math.toRadians(angle)) * (this.yi - this.yc1);
        double yRot = (int)this.yc1 + Math.sin(Math.toRadians(angle))*(this.xi-this.xc1)
                + Math.cos(Math.toRadians(angle)) * (this.yi - this.yc1);
        this.xi = xRot;
        this.yi = yRot;
    }

    /**
     * rotating about the parent branch
     * @param angle
     */
    public void rotateAboutSuperParent(int angle){

        if(this.category == 2){
            if(this.direction == 1){
                angle *= -1;
                rotateAboutSuperParentDriver(angle);
            }
            else if(direction == 2){
                rotateAboutSuperParentDriver(angle);
            }
        }
        if(this.category == 3){
            if(this.direction == 1){
                angle *= -1;
                rotateAboutSuperParentDriver(angle);
                rotateImmediateParentAboutSuperParent(angle);
                rotateAboutImmediateParentDriver(angle);
            }
            else if(this.direction == 2){
                rotateAboutSuperParentDriver(angle);
                rotateImmediateParentAboutSuperParent(angle);
                rotateAboutImmediateParentDriver(angle);
            }
        }
        if(this.category == 4){
            if(this.direction == 1){
                rotateAboutSuperParentDriver(angle);
                rotateImmediateParentAboutSuperParent(angle);
                angle *= -1;
                rotateAboutImmediateParentDriver(angle);
            }
            if(this.direction == 2){
                angle *= -1;
                rotateAboutSuperParentDriver(angle);
                rotateImmediateParentAboutSuperParent(angle);
                angle *= -1;
                rotateAboutImmediateParentDriver(angle);
            }
        }


    }

    /**
     * rotate about parent branch's parent as center
     * @param angle
     */
    private void rotateAboutSuperParentDriver(int angle){
        double xRot = (int)this.xc2 + Math.cos(Math.toRadians(angle)) * (this.xi - this.xc2)
                - Math.sin(Math.toRadians(angle)) * (this.yi - this.yc2);
        double yRot = (int)this.yc2 + Math.sin(Math.toRadians(angle)) * (this.xi - this.xc2)
                + Math.cos(Math.toRadians(angle)) * (this.yi - this.yc2);
        this.xi = xRot;
        this.yi = yRot;
    }

    /**
     * rotate parent branch about its parent
     * @param angle
     */
    private void rotateImmediateParentAboutSuperParent(int angle){
        double xRot = (int)this.xc2 + Math.cos(Math.toRadians(angle)) * (this.xc1 - this.xc2)
                - Math.sin(Math.toRadians(angle)) * (this.yc1 - this.yc2);
        double yRot = (int)this.yc2 + Math.sin(Math.toRadians(angle)) * (this.xc1 - this.xc2)
                + Math.cos(Math.toRadians(angle)) * (this.yc1 - this.yc2);
        this.xc1 = xRot;
        this.yc1 = yRot;
    }
}
