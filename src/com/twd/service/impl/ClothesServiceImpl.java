package com.twd.service.impl;

import com.twd.bean.Clothes;
import com.twd.service.ClothesService;
import com.twd.utils.BusinessException;
import com.twd.utils.ProductsXmlUtils;

import java.util.List;

/**
 * @Classname ClothesServiceImpl
 * @Date 2019/4/22 20:28
 * @Created by Administrator
 */
public class ClothesServiceImpl implements ClothesService {
    @Override
    public List<Clothes> list() throws BusinessException {

        List<Clothes> clothes = ProductsXmlUtils.parserProductFormXml();
        return clothes;
    }
}
