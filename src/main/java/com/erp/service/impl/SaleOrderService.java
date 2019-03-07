package com.erp.service.impl;

import com.erp.dao.ISaleOrderDao;
import com.erp.entity.*;
import com.erp.service.ISaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SaleOrderService implements ISaleOrderService {
    @Autowired
    private ISaleOrderDao saleOrderDao;
    @Override
    public List<SaleOrder> queryAllSaleOrder(Goods goods, SaleOrder s_order, Employee employee, Repository repo, Customer customer, PageEntity pageEntity) {
        List<SaleOrder> list = new ArrayList<SaleOrder>();
        try {
            list = saleOrderDao.queryAllSaleOrder(goods, s_order, employee, repo, customer, pageEntity);
        }catch (Exception e) {
            list.clear();
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int countAllSaleOrder(Goods goods, SaleOrder s_order, Employee employee, Repository repo, Customer customer, PageEntity pageEntity) {
        int count = 0;
        try {
            count = saleOrderDao.countAllSaleOrder(goods, s_order, employee, repo, customer, pageEntity);
        }catch (Exception e) {
            count = 0;
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<SaleOrder> queryAllSOrderByCon(String[] queryTimeStr) {
        List<SaleOrder> list = new ArrayList<SaleOrder>();
        try {
            list = saleOrderDao.queryAllSOrderByCon(queryTimeStr);
        }catch (Exception e) {
            list.clear();
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int countAllOrderByCon(String[] queryTimeStr) {
        int count = 0;
        try {
            count = saleOrderDao.countAllOrderByCon(queryTimeStr);
        }catch (Exception e) {
            count = 0;
            e.printStackTrace();
        }
        return count;
    }
}
