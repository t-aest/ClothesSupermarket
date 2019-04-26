package com.twd.service.impl;

import com.twd.bean.Clothes;
import com.twd.service.ClothesService;
import com.twd.utils.BusinessException;
import com.twd.utils.ClothesIo;

import java.util.List;

/**
 * @Classname ClothesServiceImpl
 * @Date 2019/4/22 20:28
 * @Created by Administrator
 */
public class ClothesServiceImpl implements ClothesService {
    private ClothesIo clothesIo = new ClothesIo();
    @Override
    public List<Clothes> list() throws BusinessException {

        return clothesIo.list();
    }

    @Override
    public Clothes findById(String cid) throws BusinessException {

        return clothesIo.findById(cid);
    }
    @Override
    public void update()throws BusinessException{
        clothesIo.update();
    }
}
