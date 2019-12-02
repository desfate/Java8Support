package com.defate.java8support;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.defate.j8s.J8s;
import com.defate.j8s.interfaces.BiConsumer;
import com.defate.j8s.interfaces.Predicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import java9.util.function.Consumer;
import java9.util.function.Function;
import java9.util.stream.Stream;
import java9.util.stream.StreamSupport;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> list = new ArrayList<>();
        list.add("10");
        list.add("5");
        list.add("9");
        J8s.filter(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        });

        HashMap<String, String> map = new HashMap<>();
        map.put("aaa", "bbb");
        map.put("ccc", "ddd");

        //这个库可以向下兼容Stream库
        StreamSupport.stream(list).map(Integer::valueOf).forEach(System.out::println);
    }
}
