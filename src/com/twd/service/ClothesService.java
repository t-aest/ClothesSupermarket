package com.twd.service;

import com.twd.bean.Clothes;
import com.twd.utils.BusinessException;

import java.util.List;

/**
 * @Classname ClothesService
 * @Date 2019/4/22 20:27
 * @Created by Administrator
 */
public interface ClothesService {
    public List<Clothes> list()throws BusinessException;
}
