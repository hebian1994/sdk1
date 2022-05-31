package com.example.demo_azure_key_vault.mapper;


import com.example.demo_azure_key_vault.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 公告 DAO
 * Created by wmm on 2019/4/24.
 */
public interface NoticeRepository extends JpaRepository<Notice, Integer>, JpaSpecificationExecutor<Notice> {

    Notice findByIdAndDelFlag(String id, Boolean delFlag);

    Notice findByTitleAndDelFlag(String title, Boolean delFlag);

    Integer countAllByFactoryViewAndStatusAndDelFlag(Boolean factoryView, int status, Boolean delFlag);

}
