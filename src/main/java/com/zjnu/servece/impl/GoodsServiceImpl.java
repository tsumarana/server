package com.zjnu.servece.impl;

import com.zjnu.mapper.GoodsMapper;
import com.zjnu.pojo.Goods;
import com.zjnu.pojo.PageBean;
import com.zjnu.servece.GoodsService;
import com.zjnu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    //创建工厂对象
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    //查询信息
    @Override
    public Goods selectInfo(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        Goods good = mapper.selectInfo(id);
        sqlSession.close();
        return good;
    }
    //分页查询
    @Override
    public PageBean<Goods> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Goods> goods = mapper.selectByPage(begin, size);
        int count = mapper.selectTotalCount();
        PageBean<Goods> pageBean= new PageBean<Goods>();
        pageBean.setTotalCount(count);
        pageBean.setRows(goods);
        sqlSession.close();
        return pageBean;
    }
    //根据条件分页查询
    @Override
    public PageBean<Goods> selectByPageAndCondition(int currentPage, int pageSize, Goods _goods) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        String title = _goods.getTitle();
        if(title != null && title.length() > 0){
            _goods.setTitle("%"+title+"%");
        }
        String type = _goods.getType();
        if(type != null && type.length() > 0){
            _goods.setType("%"+type+"%");
        }
        String seller = _goods.getSeller();
        if(seller != null && seller.length()>0){
            _goods.setSeller("%"+seller+"%");
        }
        List<Goods> goods = mapper.selectByPageAndCondition(begin,size,_goods);
        int count = mapper.selectTotalCountByCondition(_goods);
        PageBean<Goods> pageBean= new PageBean<Goods>();
        pageBean.setTotalCount(count);
        pageBean.setRows(goods);
        sqlSession.close();
        return pageBean;
    }
    //根据id查询
    @Override
    public Goods selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        Goods goods = mapper.selectById(id);
        sqlSession.close();
        return goods;
    }
    //新增商品
    @Override
    public void addGoods(Goods goods) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        mapper.addGoods(goods);
        sqlSession.commit();
        sqlSession.close();
    }
    //删除商品
    @Override
    public void deleteById(Goods goods) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        mapper.deleteById(goods);
        sqlSession.commit();
        sqlSession.close();
    }


}
