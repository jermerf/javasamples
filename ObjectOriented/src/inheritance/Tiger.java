package inheritance;

public class Tiger extends Cat{
    private int stripes;

    public Tiger(int age, double weight, int stripes){
        super(age, weight);
        this.stripes = stripes;
    }

    public int getStripes() {
        return stripes;
    }

    public void setStripes(int stripes) {
        this.stripes = stripes;
    }
}
