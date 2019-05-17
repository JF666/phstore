package com.jf.crud.service;

import com.jf.crud.bean.Parameter;
import com.jf.crud.bean.ParameterExample;
import com.jf.crud.dao.ParameterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterService {
    @Autowired
    ParameterMapper parameterMapper;
    public List<Parameter> getAll() {
        return parameterMapper.selectByExample(null);
    }
    public Boolean insertParameter(Parameter parameter) {
        return parameterMapper.insertSelective(parameter)!=0;
    }
    public List<Parameter> getByProId(Integer proid) {
        List<Parameter> parameter = parameterMapper.selectByPrimaryKey(proid);
        return parameter;
    }
    public void UpdateParameter(Parameter parameter) {
        parameterMapper.updateByPrimaryKeySelective(parameter);
    }
    public void DeleteParameter(Integer proid) {
        parameterMapper.deleteByPrimaryKey(proid);
    }
    public void DeleteBatch(List<Integer> proids) {
        ParameterExample parameterExample = new ParameterExample();
        ParameterExample.Criteria criteria = parameterExample.createCriteria();
        criteria.andProidIn(proids);
        parameterMapper.deleteByExample(parameterExample);
    }
}
