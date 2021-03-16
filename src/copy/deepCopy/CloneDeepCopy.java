package copy.deepCopy;

/**
 * @author wengyinbing
 * @data 2021/3/16 15:03
 **/
public class CloneDeepCopy {
    public static void main(String[] args) {
        Age age = new Age(10);
        Person p1 = new Person("wengyinbing",188,age);
        Person p2 = (Person) p1.clone();
        System.out.println(p1);
        System.out.println(p2);

        age.setAge(19);
        p1.setAge(age);
        p1.setName("hellop");
        p1.setHeight(190);
        System.out.println(p1);
        System.out.println(p2);

    }
}
