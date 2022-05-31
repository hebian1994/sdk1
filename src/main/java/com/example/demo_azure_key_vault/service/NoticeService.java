package com.example.demo_azure_key_vault.service;

import com.example.demo_azure_key_vault.domain.Notice;
import com.example.demo_azure_key_vault.mapper.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.*;

/**
 * 公告Service
 * Created by wmm on 2019/4/24.
 */
@Service
public class NoticeService {

    @Autowired
    NoticeRepository noticeRepository;

    /**
     * 分页查询
     *
     * @param nameParam 查询条件
     * @param pageNum   页数
     * @param pageSize  每页显示条数
     * @return
     */
    public Page findList(String nameParam, int pageNum, int pageSize) {

//        Sort sort = null;
//        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
//        Page<Notice> bookPage = noticeRepository.findAll((root, query, criteriaBuilder) -> {
//            List<Predicate> list = new ArrayList();
//            if (!StringUtils.isEmpty(nameParam)) {
//                list.add(criteriaBuilder.like(root.get("title").as(String.class), "%" + nameParam + "%"));
//            }
//            list.add(criteriaBuilder.equal(root.get("delFlag").as(Boolean.class), false));
//            Predicate[] p = new Predicate[list.size()];
//            list.toArray(p);
//            return criteriaBuilder.and(p);
//        }, pageable);
//        return bookPage;

        return null;
    }


    /**
     * 根据ID查询对象
     *
     * @param id
     * @return
     */
    public Notice findById(String id) {
        Notice notice = noticeRepository.findByIdAndDelFlag(id, false);
        //查询操作人是否是工厂人员
//        Boolean bool = true;
//        if (bool) {
//            notice.setFactoryView(true);
//            noticeRepository.save(notice);
//        }
        return notice;
    }

    /**
     * 新增或编辑点击保存
     *
     * @param bean
     * @return
     */
    @Transactional
    public Map edit(Notice bean) {
        Map map = new HashMap();
//        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
//        if (null == bean.getId() || "".equals(bean.getId())) {//新增
//            bean.setId(IdUtil.getId());
//        }
        Notice idBean = noticeRepository.findByIdAndDelFlag(bean.getId(), false);
        if (null == idBean) {//新增
            idBean = noticeRepository.findByTitleAndDelFlag(bean.getTitle(), false);
            if (null != idBean) {
                map.put("code", 0);
                map.put("msg", "标题不能重复");
                return map;
            }
        } else {//修改
            Notice nameBean = noticeRepository.findByTitleAndDelFlag(bean.getTitle(), false);
            if (null != nameBean && !nameBean.getId().equals(bean.getId())) {
                map.put("code", 0);
                map.put("msg", "标题不能重复");
                return map;
            }
        }
//        bean.setCreateUser(sysUser.getUserId());
//        bean.setCreateTime(System.currentTimeMillis());
        bean.setDelFlag(false);
        bean = noticeRepository.save(bean);
        map.put("bean", bean);
        map.put("code", 1);
        map.put("msg", "成功");
        return map;
    }

    /**
     * 点击删除
     *
     * @param id
     * @return
     */
    @Transactional
    public Map deleteById(String id) {
        Map map = new HashMap();
        try {
            Notice bean = noticeRepository.findByIdAndDelFlag(id, false);
            bean.setDelFlag(true);
            noticeRepository.save(bean);
            map.put("code", 1);
            map.put("msg", "成功");
        } catch (Exception e) {
            map.put("code", 0);
            map.put("msg", "失败");
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 查询工厂人员未查看公告数量
     *
     * @return
     */
    public Integer listCount() {
        return noticeRepository.countAllByFactoryViewAndStatusAndDelFlag(false, 1, false);
    }
}
