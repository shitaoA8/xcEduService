package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    //查询所有
    @Test
    public void testFindAll() {
        List<CmsPage> cmsPageList = cmsPageRepository.findAll();
        for (CmsPage cmsPage : cmsPageList) {
            System.out.println(cmsPage);
        }
    }

    //分页查询
    @Test
    public void testFindPage() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<CmsPage> cmsPageList = cmsPageRepository.findAll(pageable);
        for (CmsPage cmsPage : cmsPageList) {
            System.out.println(cmsPage);
        }
    }

    //修改
    @Test
    public void testUpdate() {
        //先查询
        Optional<CmsPage> optional = cmsPageRepository.findById("5d763e234d94f91290075397");
        /*
            关于Optional：
                Optional是jdk1.8引入的类型，Optional是一个容器对象，它包括了我们需要的对象，
            使用isPresent方法判断所包含对象是否为空，isPresent方法返回false则表示Optional包
            含对象为空，否则可以使用get()取出对象进行操作。
         */
        if (optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            //设置要修改的值
            cmsPage.setPageAliase("lalala");
            //进行保存
            cmsPageRepository.save(cmsPage);
        }
    }
}
