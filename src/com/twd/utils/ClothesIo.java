package com.twd.utils;

import com.twd.bean.Clothes;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ClothesIo
 * @Date 2019/4/24 21:25
 * @Created by Administrator
 */
public class ClothesIo {
    private static List<Clothes> list = new ArrayList<>();
    public Clothes findById(String cid)throws BusinessException{
        for(Clothes c:list){
            if(c.getId().equals(cid)){
                return c;
            }

        }
        return null;
    }
    public List<Clothes> list()throws BusinessException{
        if(list.size()==0){
            list = ProductsXmlUtils.parserProductFormXml();
        }
        return list;
    }
    //更新XML文件
    public void update()throws BusinessException{
        ProductsXmlUtils.writeProductToXml(list);
    }
}
