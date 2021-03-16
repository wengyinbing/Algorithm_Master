package copy.shallowCopy;

/**
 * @author wengyinbing
 * @data 2021/3/16 14:41
 **/
public class Age {
    private int age;

    public Age(int age){
        this.age = age;
    }
    public  Age(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Age{" +
                "age=" + age +
                '}';
    }
}
