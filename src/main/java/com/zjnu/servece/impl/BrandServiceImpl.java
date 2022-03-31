package com.zjnu.servece.impl;

import com.zjnu.mapper.BrandMapper;
import com.zjnu.pojo.Brand;
import com.zjnu.pojo.PageBean;
import com.zjnu.servece.BrandService;
import com.zjnu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class BrandServiceImpl implements BrandService {
    //创建工厂对象
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Brand> selectAll() {
        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取BrandMapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deletedById(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Brand> brands = mapper.selectByPage(begin, size);
        int count = mapper.selectTotalCount();
        PageBean<Brand> pageBean= new PageBean<Brand>();
        pageBean.setTotalCount(count);
        pageBean.setRows(brands);
        sqlSession.close();
        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        String brandName = brand.getBrandName();
        if(brandName != null && brandName.length() > 0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if(companyName != null && companyName.length() > 0){
            brand.setCompanyName("%"+companyName+"%");
        }
        List<Brand> brands = mapper.selectByPageAndCondition(begin,size,brand);
        int count = mapper.selectTotalCountByCondition(brand);
        PageBean<Brand> pageBean= new PageBean<Brand>();
        pageBean.setTotalCount(count);
        pageBean.setRows(brands);
        sqlSession.close();
        return pageBean;
    }


}
