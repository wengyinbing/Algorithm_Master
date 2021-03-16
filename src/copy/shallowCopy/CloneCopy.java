package copy.shallowCopy;

/**
 * @author wengyinbing
 * @data 2021/3/16 14:42
 **/
public class CloneCopy {
    /*
    通过object父类的clone方法实现copy
    简单实现浅拷贝
     */

    public static void main(String[] args) {
        Age age = new Age(13);
        Person p1 = new Person("wengyinbing",188,age);
        Person p2 = (Person) p1.clone();
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
