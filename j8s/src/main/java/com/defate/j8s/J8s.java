package com.defate.j8s;

import com.defate.j8s.interfaces.BiConsumer;
import com.defate.j8s.interfaces.Consumer;
import com.defate.j8s.interfaces.Function;
import com.defate.j8s.interfaces.Predicate;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 这里是用于处理非基本对象
 */
public class J8s {



    /**************************** 筛选 filter start ****************************/
    /**
     * 筛选器通过map的value进行筛选
     * filter map with value
     * @param datas
     * @param filter
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> filterMapByValue(Map<K, V> datas, Predicate<V> filter){
        if (datas == null) return null;
        Map<K, V> results = new Hashtable<K, V>();  //为了线程安全
        for (K key : datas.keySet()) {
            V value = datas.get(key);
            if(filter.test(value)){
                results.put(key, value);
            }
        }
        return results;
    }

    /**
     * 筛选器通过map的key进行筛选
     *  filter map with key
     * @param datas
     * @param filter
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> filterMapByKey(Map<K, V> datas, Predicate<K> filter){
        if (datas == null) return null;
        Map<K, V> results = new Hashtable<K, V>();  //为了线程安全
        for (K key : datas.keySet()) {
            V value = datas.get(key);
            if(filter.test(key)){
                results.put(key, value);
            }
        }
        return results;
    }

    /**
     * 筛选器对对象数组进行筛选
     * filter with object array
     * @param datas
     * @param filter
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(T[] datas, Predicate<T> filter) {
        List<T> results = new ArrayList<>();
        if (datas == null) return results;
        for (T item : datas) {
            if (filter.test(item)) {
                results.add(item);
            }
        }
        return results;
    }

    /**
     * 筛选器对列表进行筛选
     * filter with list
     * @param datas
     * @param filter
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(Iterable<T> datas, Predicate<T> filter) {
        List<T> results = new ArrayList<>();
        if (datas == null) return results;
        for (T item : datas) {
            if (filter.test(item)) {
                results.add(item);
            }
        }
        return results;
    }

    /**************************** filter end ****************************/


    /**************************** foreach start ****************************/
    /**
     * 遍历列表
     * foreach with list
     * @param datas
     * @param consumer
     * @param <T>
     */
    public static <T> void forEach(Iterable<T> datas, Consumer<T> consumer){
        if(datas == null) return;
        for (T item : datas){
            consumer.accept(item);
        }
    }

    /**
     * 遍历map
     * foreach with map
     * @param datas
     * @param consumer
     * @param <K>
     * @param <V>
     */
    public static <K, V> void forEach(Map<K, V> datas, BiConsumer<K, V> consumer) {
        if(datas == null) return ;
        for (K key : datas.keySet()) {
            V value = datas.get(key);
            consumer.accept(key, value);
        }
    }

    /**
     * 遍历对象数组
     * foreach with object array
     * @param datas
     * @param consumer
     * @param <T>
     */
    public static <T> void forEach(T[] datas, Consumer<T> consumer){
        if (datas == null) return;
        for (T item : datas) {
            consumer.accept(item);
        }
    }
    /**************************** foreach end ****************************/

    /************************** map start ****************************/
    /**
     * 转换对象数组
     * @param datas
     * @param map
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> map(T[] datas, Function<T, R> map) {
        List<R> results = new ArrayList<>();
        if (datas == null) return results;
        for (T item : datas) {
            results.add(map.apply(item));
        }
        return results;
    }

    /**
     * 转换列表
     * @param datas
     * @param map
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> map(Iterable<T> datas, Function<T, R> map) {
        List<R> results = new ArrayList<>();
        if (datas == null) return results;
        for (T item : datas) {
            results.add(map.apply(item));
        }
        return results;
    }

    /**
     * 转换map的value
     * @param datas
     * @param map
     * @param <K>
     * @param <V>
     * @param <R>
     * @return
     */
    public static <K, V, R> Map<K, R> mapValue(Map<K, V> datas, Function<V, R> map){
        if(datas == null) return null;
        Map<K, R> results = new Hashtable<K, R>();  //为了线程安全
        for (K key : datas.keySet()) {
            V value = datas.get(key);
            results.put(key, map.apply(value));
        }
        return results;
    }
    /**************************** map end ****************************/


    /**************************** 排序 sort start ****************************/
    public static <T> void sort(T[] datas, Comparator<T> comparator) {
        Arrays.sort(datas, comparator);
    }

    public static <T> void sort(List<T> datas, Comparator<T> comparator) {
        Collections.sort(datas, comparator);
    }
    /**************************** sort end ****************************/

    /**************************** find start ****************************/
    /**
     * 找到满足条件的对象并返回  只返回最后最开始找到的那个
     * @param datas
     * @param filter
     * @param <T>
     * @return
     */
    public static <T> T find(Iterable<T> datas, Predicate<T> filter) {
        if (datas == null) return null;
        for (T item : datas) {
            if (filter.test(item)) {
                return item;
            }
        }
        return null;
    }

    public static <T> T find(T[] datas, Predicate<T> filter) {
        if (datas == null) return null;
        for (T item : datas) {
            if (filter.test(item)) {
                return item;
            }
        }
        return null;
    }
    /**************************** find end ****************************/
}
