package copy.deepCopy;

import org.junit.Test;

import java.awt.event.PaintEvent;
import java.io.*;
import java.util.zip.InflaterOutputStream;

/**
 * @author wengyinbing
 * @data 2021/3/16 15:03
 **/
public class SerializableDeepCopy {
    /*
    通过序列化实现深拷贝
     */
    @Test
    public void t1() throws IOException, ClassNotFoundException {
        Age age = new Age(10);
        Person p1 = new Person("wengyinbing",188,age);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(p1);
        oos.flush();//数据IO可能保存在内存中，清空缓存区数据


        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Person p2 = (Person)ois.readObject();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println();
        //
        age.setAge(100);
        p1.setAge(age);
        p1.setName("hello");
        System.out.println(p1);
        System.out.println(p2);

    }
}
