package at.lecture.substitution;

public class Main {
    public static void main(String[] args) {
        Rectangle r = getInstance(10, 20);
        test(r, 10,20);
    }

    public static void test(Rectangle r, int h, int w) {
        if(r.getHeight() == h && r.getWidth() == w){
            System.out.println("method correctly executed");
        }
        System.out.println("method incorrect");
    }

    public static Rectangle getInstance(int he, int we){
        Rectangle rect = new Rectangle();
        rect.setHeight(he);
        rect.setWidth(we);
        return rect;
    }
}
