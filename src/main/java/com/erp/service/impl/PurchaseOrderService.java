package com.erp.service.impl;

import com.erp.dao.IPurchaseOrderDao;
import com.erp.entity.Goods;
import com.erp.entity.PurchaseOrder;
import com.erp.service.IPurchaseOrderService;
import com.erp.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseOrderService implements IPurchaseOrderService {
    @Autowired
    private IPurchaseOrderDao purchaseOrderDao;
    @Override
    public List<PurchaseOrder> queryAllPOrderByCon(String[] queryTimeStr) {
        List<PurchaseOrder> list = new ArrayList<PurchaseOrder>();
        try {
            list = purchaseOrderDao.queryAllPOrderByCon(queryTimeStr);
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
            count = purchaseOrderDao.countAllOrderByCon(queryTimeStr);
        } catch (Exception e) {
            count = 0;
            e.printStackTrace();
        }
        return count;
    }

    @Override
    @Transactional
    public int addPurchaseOrder(Goods goods, PurchaseOrder purchaseOrder, String supId, String repoId, String count) {
        int flag = 0;
        try {
            flag = purchaseOrderDao.addPurchaseOrder(goods, purchaseOrder, supId, repoId, count);
        } catch (RuntimeException e) {
            flag = 0;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    @Transactional
    public int editPOrder(PurchaseOrder purchaseOrder, String supId, String repoId, String count, boolean onlyEditPOType) {
        int flag = 0;
        try {
            flag = purchaseOrderDao.editPOrder(purchaseOrder, supId, repoId, count, onlyEditPOType);
        } catch (Exception e) {
            flag = 0;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    @Transactional
    public int approveOrder(PurchaseOrder purchaseOrder) {
        int flag = 0;
        try {
            flag = purchaseOrderDao.approveOrder(purchaseOrder);
        } catch (Exception e) {
            flag = 0;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public PurchaseOrder getPOrderByOrder(String order) {
        PurchaseOrder purchaseOrder = null;
        try {
            purchaseOrder = purchaseOrderDao.getPOrderByOrder(order);
        } catch (RuntimeException e) {
            purchaseOrder = new PurchaseOrder();
            e.printStackTrace();
        }
        return purchaseOrder;
    }

}
