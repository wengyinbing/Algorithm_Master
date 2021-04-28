package compareTest;

import java.util.Comparator;

/**
 * @author wengyinbing
 * @data 2021/4/4 19:05
 **/
public class comparator implements Comparator<compare1> {

    @Override
    public int compare(compare1 o1, compare1 o2) {
        if(o1.width == o2.width){
            return 0;
        }
        else if(o1.width > o2.width){
            return 1;
        }
        else{
            return -1;
        }
    }
}
