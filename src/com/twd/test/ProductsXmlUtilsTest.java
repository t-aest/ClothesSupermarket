package com.twd.test;

import com.twd.bean.Clothes;
import com.twd.utils.ProductsXmlUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ProductsXmlUtilsTest
 * @Date 2019/4/21 20:14
 * @Created by Administrator
 */
public class ProductsXmlUtilsTest {
    @Test
    public void test(){
        List<Clothes> clothes = ProductsXmlUtils.parserProductFormXml();
        System.out.println(Arrays.toString(clothes.toArray()));
    }
}
