package copy.shallowCopy;

/**
 * @author wengyinbing
 * @data 2021/3/16 14:42
 **/
public class ConstuctorCopy {
    /*
    通过构造器实现浅拷贝
     */

    public static void main(String[] args) {
        Age age = new Age(13);
        Person p1 = new Person("wengyinbing",188,age);
        Person p2 = new Person(p1);
        System.out.println(p1);
        System.out.println(p2);

        age.setAge(23);
        p1.setAge(age);
        p1.setHeight(170);
        p1.setName("helklo");
        System.out.println(p1);
        System.out.println(p2);
    }
}
