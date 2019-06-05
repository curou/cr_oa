package com.curou.oa.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lxr
 * @version v0.01
 * @date ${date}
 * @email 200890949@qq.com
 */
public final class ListUtils {

	/**
	 * 判断列表是否为 空指针 或者为 空列表
	 * @param list
	 * @return
	 */
	public static <T> boolean isNullOrEmpty(List<T> list) {
		
		if (list == null || list.size() == 0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 判断列表不为 空指针 或者不为 空列表
	 * @param list
	 * @return
	 */
	public static <T> boolean isNotNullOrEmpty(List<T> list) {
		return !isNullOrEmpty(list);
	}
	
	/**
	 * 
	 * @return
	 */
	public static <T> List<T> newArrayList() {
		
		return new ArrayList<T>();
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> newArrayList(T... items) {
		List<T> arr = new ArrayList<T>();
		for (T item : items) {
			arr.add(item);
		}
		return arr;
	}

	/**
	 * 根据List中的对象的某个属性的值归类，将List拆分成多个List，再放入一个总的List
	 *
	 */
	public static<T> List<List<T>> splitToMultipleListByFiled(String filed, List<T> list){
		List<List<T>> resultList = new ArrayList<>();
		Map<String, List<T>> map = new LinkedHashMap<>();
		List<String> keyList = new ArrayList<>();
		for (int i=0;i<list.size();i++) {
			T t = list.get(i);
			String key = getFieldValueByFieldName(filed, t);
			if (map.get(key) == null) {
				keyList.add(key);
				List<T> temp = new ArrayList<>();
				temp.add(t);
				map.put(key, temp);
			}else{
				List<T> temp = map.get(key);
				temp.add(t);
			}
		}
		for (int i = 0; i < keyList.size(); i++) {
			List<T> temp = map.get(keyList.get(i));
			resultList.add(temp);
		}
		return resultList;
	}

	/**
	 * 根据属性名获取属性值
	 *
	 */
	public static String getFieldValueByFieldName(String fieldName, Object object) {
		try {
			Field field = object.getClass().getDeclaredField(fieldName);
			//设置对象的访问权限，保证对private的属性的访问
			field.setAccessible(true);
			return  field.get(object).toString();
		} catch (Exception e) {

			return null;
		}
	}
	
	
}
