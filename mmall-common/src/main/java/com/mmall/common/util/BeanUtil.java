package com.mmall.common.util;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author gg
 * @version BeanUtil.java, v 0.1 2019-04-30 16:41 gg
 */
public class BeanUtil {

    public BeanUtil() {
    }

    public static <T> T map(Object source, Class<T> target) {
        if (null == source) {
            return null;
        } else {
            T t = BeanUtils.instantiateClass(target);
            BeanUtils.copyProperties(source, t);
            return t;
        }
    }

    public static <T> List<T> mapList(Collection sourceList, Class<T> target) {
        if (sourceList == null) {
            return null;
        } else {
            List<T> destinationList = Lists.newArrayList();
            Iterator var3 = sourceList.iterator();

            while(var3.hasNext()) {
                Object sourceObject = var3.next();
                T newObj = map(sourceObject, target);
                destinationList.add(newObj);
            }

            return destinationList;
        }
    }

    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
        if (null != source && null != target) {
            BeanUtils.copyProperties(source, target, ignoreProperties);
        }
    }
}