package copy.deepCopy;

import javax.naming.spi.ObjectFactoryBuilder;
import java.io.Serializable;

/**
 * @author wengyinbing
 * @data 2021/3/16 15:01
 **/
public class Age implements  Cloneable, Serializable {
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

    @Override
    public  Object clone() {
        Object obj = null;
        try{
            obj = super.clone();
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return obj;
    }
}
