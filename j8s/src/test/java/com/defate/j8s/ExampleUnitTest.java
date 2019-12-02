package com.defate.j8s;

import com.defate.j8s.interfaces.Consumer;
import com.defate.j8s.interfaces.Predicate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);


        System.out.println("--------------  Test -------------");
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        String [] list = new String[]{"aaa", "bbb", "ccc"};
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");

        hashMap.put("a","aaa");
        hashMap.put("b", "bbb");
        hashMap.put("c", "ccc");
        System.out.println("--------------  init success -------------");
        //test filter
        J8s.forEach(J8s.filter(arrayList, s -> {
//                return s.equals("aaa");
            return s.length() == 3;
        }), System.out::println);





    }
}