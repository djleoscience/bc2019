package bc19;
import java.lang.Math;

public class Node {
    private int x;
    private int y;
    private Node pastNode;
    private int count;
    private int f;
    private int finalX;
    private int finalY;



    public Node(){
        setX(-1);
        setY(-1);
        setCount(-1);
    }

    public Node(int ex, int why, int fx, int fy){
        setX(ex);
        setY(why);
        setCount(0);
        setFinalX(fx);
        setFinalY(fy);
        pastNode = null;
    }

    public Node(int ex, int why, Node n, int fx, int fy){
        setX(ex);
        setY(why);
        setPastNode(n);
        setCount(n.getCount()+1);
        setFinalX(fx);
        setFinalY(fy);
        setF(getFValue(fx, fy));
    }

    public void setX(int ex){
        x = ex;
    }

    public void setY(int why){
        y = why;
    }

    public void setPastNode(Node pNode){
        pastNode = pNode;
    }

    public void setCount(int c){
        count = c;
    }

    public void setF(int ef){
        f = ef;
    }

    public void setFinalX(int finalX) {
        this.finalX = finalX;
    }

    public void setFinalY(int finalY) {
        this.finalY = finalY;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getF() {
        return f;
    }

    public int getFinalX() {
        return finalX;
    }

    public int getFinalY() {
        return finalY;
    }

    public Node getPastNode(){
        return pastNode;
    }

    public int getCount(){
        return count;
    }

    public int getDistanceSq(int otherX, int otherY){
        int dx = Math.abs(this.getX() - otherX);
        int dy = Math.abs(this.getY() - otherY);

        return (dx * dx) + (dy * dy);
    }

    public int getFValue(int finalX, int finalY){
        int g = getCount();
        int h = getDistanceSq(finalX, finalY);
        return g + h;
    }

    public int compareTo(Node other){
        if(this.getF() < other.getF()){
            return -1;
        }
        else if(this.getF() > other.getF()){
            return 1;
        }
        else{
            return 0;
        }
    }

    public boolean equals(int x, int y){
        return (this.getX() == x && this.getY() == y);
    }

}
