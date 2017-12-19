package com.aq.school.service;

import com.aq.school.SupperMapper;
import com.aq.school.model.BasePojo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

public class BaseService<T extends BasePojo> {

    @Autowired
   private SupperMapper<T> supperMapper;

    public Integer deleteById(Long id) {

        return supperMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteByIds(Class<?> clazz, List<Object> values) {
        Example example = new Example(clazz);
        example.createCriteria().andIn("id", values);
        return this.supperMapper.deleteByExample(example);
    }

    public Integer save(T t) {
        if (t.getCreated() == null) {
            t.setCreated(new Date());
            t.setUpdated(t.getCreated());
        } else if (t.getUpdated() == null) {
            t.setUpdated(t.getCreated());
        }
        return this.supperMapper.insert(t);
    }

    public Integer saveSelective(T t) {
        if (t.getCreated() == null) {
            t.setCreated(new Date());
            t.setUpdated(t.getCreated());
        } else if (t.getUpdated() == null) {
            t.setUpdated(t.getCreated());
        }
        return this.supperMapper.insertSelective(t);
    }

    public Integer updateById(T t) {
        t.setUpdated(new Date());
        return this.supperMapper.updateByPrimaryKey(t);
    }

    public Integer updateSelectiveById(T t) {
        t.setUpdated(new Date());
        return this.supperMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value = "T")
    public List<T> queryAll() {
        return this.supperMapper.selectAll();
    }

    @Cacheable(value = "T")
    public T queryById(Long id) {
        return this.supperMapper.selectByPrimaryKey(id);
    }

    public Integer queryCount(T t) {
        return this.supperMapper.selectCount(t);
    }

    public Integer queryCount() {
        return queryCount(null);
    }

    public List<T> queryListByWhere(T t) {

        return this.supperMapper.select(t);
    }

    @Cacheable(value = "T")
    public T queryOne(T t){

        return this.supperMapper.selectOne(t);
    }
    /**
     * 分页查询
     *
     * @param param
     *            查询条件
     * @param page
     *            当前页
     * @param rows
     *            页面大小
     * @return
     */
    public PageInfo<T> queryPageListByWhere(T param, Integer page, Integer rows) {
        // 设置分页参数
        PageHelper.startPage(page, rows);
        List<T> list = this.queryListByWhere(param);
        return new PageInfo<T>(list);
    }

}
