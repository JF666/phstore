package com.jf.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class ParameterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParameterExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andParaidIsNull() {
            addCriterion("paraId is null");
            return (Criteria) this;
        }

        public Criteria andParaidIsNotNull() {
            addCriterion("paraId is not null");
            return (Criteria) this;
        }

        public Criteria andParaidEqualTo(Integer value) {
            addCriterion("paraId =", value, "paraid");
            return (Criteria) this;
        }

        public Criteria andParaidNotEqualTo(Integer value) {
            addCriterion("paraId <>", value, "paraid");
            return (Criteria) this;
        }

        public Criteria andParaidGreaterThan(Integer value) {
            addCriterion("paraId >", value, "paraid");
            return (Criteria) this;
        }

        public Criteria andParaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("paraId >=", value, "paraid");
            return (Criteria) this;
        }

        public Criteria andParaidLessThan(Integer value) {
            addCriterion("paraId <", value, "paraid");
            return (Criteria) this;
        }

        public Criteria andParaidLessThanOrEqualTo(Integer value) {
            addCriterion("paraId <=", value, "paraid");
            return (Criteria) this;
        }

        public Criteria andParaidIn(List<Integer> values) {
            addCriterion("paraId in", values, "paraid");
            return (Criteria) this;
        }

        public Criteria andParaidNotIn(List<Integer> values) {
            addCriterion("paraId not in", values, "paraid");
            return (Criteria) this;
        }

        public Criteria andParaidBetween(Integer value1, Integer value2) {
            addCriterion("paraId between", value1, value2, "paraid");
            return (Criteria) this;
        }

        public Criteria andParaidNotBetween(Integer value1, Integer value2) {
            addCriterion("paraId not between", value1, value2, "paraid");
            return (Criteria) this;
        }

        public Criteria andProidIsNull() {
            addCriterion("proId is null");
            return (Criteria) this;
        }

        public Criteria andProidIsNotNull() {
            addCriterion("proId is not null");
            return (Criteria) this;
        }

        public Criteria andProidEqualTo(Integer value) {
            addCriterion("proId =", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotEqualTo(Integer value) {
            addCriterion("proId <>", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThan(Integer value) {
            addCriterion("proId >", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThanOrEqualTo(Integer value) {
            addCriterion("proId >=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThan(Integer value) {
            addCriterion("proId <", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThanOrEqualTo(Integer value) {
            addCriterion("proId <=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidIn(List<Integer> values) {
            addCriterion("proId in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotIn(List<Integer> values) {
            addCriterion("proId not in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidBetween(Integer value1, Integer value2) {
            addCriterion("proId between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotBetween(Integer value1, Integer value2) {
            addCriterion("proId not between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andCpuidIsNull() {
            addCriterion("cpuId is null");
            return (Criteria) this;
        }

        public Criteria andCpuidIsNotNull() {
            addCriterion("cpuId is not null");
            return (Criteria) this;
        }

        public Criteria andCpuidEqualTo(Integer value) {
            addCriterion("cpuId =", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidNotEqualTo(Integer value) {
            addCriterion("cpuId <>", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidGreaterThan(Integer value) {
            addCriterion("cpuId >", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cpuId >=", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidLessThan(Integer value) {
            addCriterion("cpuId <", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidLessThanOrEqualTo(Integer value) {
            addCriterion("cpuId <=", value, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidIn(List<Integer> values) {
            addCriterion("cpuId in", values, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidNotIn(List<Integer> values) {
            addCriterion("cpuId not in", values, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidBetween(Integer value1, Integer value2) {
            addCriterion("cpuId between", value1, value2, "cpuid");
            return (Criteria) this;
        }

        public Criteria andCpuidNotBetween(Integer value1, Integer value2) {
            addCriterion("cpuId not between", value1, value2, "cpuid");
            return (Criteria) this;
        }

        public Criteria andOsidIsNull() {
            addCriterion("osId is null");
            return (Criteria) this;
        }

        public Criteria andOsidIsNotNull() {
            addCriterion("osId is not null");
            return (Criteria) this;
        }

        public Criteria andOsidEqualTo(Integer value) {
            addCriterion("osId =", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidNotEqualTo(Integer value) {
            addCriterion("osId <>", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidGreaterThan(Integer value) {
            addCriterion("osId >", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("osId >=", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidLessThan(Integer value) {
            addCriterion("osId <", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidLessThanOrEqualTo(Integer value) {
            addCriterion("osId <=", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidIn(List<Integer> values) {
            addCriterion("osId in", values, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidNotIn(List<Integer> values) {
            addCriterion("osId not in", values, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidBetween(Integer value1, Integer value2) {
            addCriterion("osId between", value1, value2, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidNotBetween(Integer value1, Integer value2) {
            addCriterion("osId not between", value1, value2, "osid");
            return (Criteria) this;
        }

        public Criteria andRmidIsNull() {
            addCriterion("rmId is null");
            return (Criteria) this;
        }

        public Criteria andRmidIsNotNull() {
            addCriterion("rmId is not null");
            return (Criteria) this;
        }

        public Criteria andRmidEqualTo(Integer value) {
            addCriterion("rmId =", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotEqualTo(Integer value) {
            addCriterion("rmId <>", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidGreaterThan(Integer value) {
            addCriterion("rmId >", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rmId >=", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidLessThan(Integer value) {
            addCriterion("rmId <", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidLessThanOrEqualTo(Integer value) {
            addCriterion("rmId <=", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidIn(List<Integer> values) {
            addCriterion("rmId in", values, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotIn(List<Integer> values) {
            addCriterion("rmId not in", values, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidBetween(Integer value1, Integer value2) {
            addCriterion("rmId between", value1, value2, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotBetween(Integer value1, Integer value2) {
            addCriterion("rmId not between", value1, value2, "rmid");
            return (Criteria) this;
        }

        public Criteria andScreenidIsNull() {
            addCriterion("screenId is null");
            return (Criteria) this;
        }

        public Criteria andScreenidIsNotNull() {
            addCriterion("screenId is not null");
            return (Criteria) this;
        }

        public Criteria andScreenidEqualTo(Integer value) {
            addCriterion("screenId =", value, "screenid");
            return (Criteria) this;
        }

        public Criteria andScreenidNotEqualTo(Integer value) {
            addCriterion("screenId <>", value, "screenid");
            return (Criteria) this;
        }

        public Criteria andScreenidGreaterThan(Integer value) {
            addCriterion("screenId >", value, "screenid");
            return (Criteria) this;
        }

        public Criteria andScreenidGreaterThanOrEqualTo(Integer value) {
            addCriterion("screenId >=", value, "screenid");
            return (Criteria) this;
        }

        public Criteria andScreenidLessThan(Integer value) {
            addCriterion("screenId <", value, "screenid");
            return (Criteria) this;
        }

        public Criteria andScreenidLessThanOrEqualTo(Integer value) {
            addCriterion("screenId <=", value, "screenid");
            return (Criteria) this;
        }

        public Criteria andScreenidIn(List<Integer> values) {
            addCriterion("screenId in", values, "screenid");
            return (Criteria) this;
        }

        public Criteria andScreenidNotIn(List<Integer> values) {
            addCriterion("screenId not in", values, "screenid");
            return (Criteria) this;
        }

        public Criteria andScreenidBetween(Integer value1, Integer value2) {
            addCriterion("screenId between", value1, value2, "screenid");
            return (Criteria) this;
        }

        public Criteria andScreenidNotBetween(Integer value1, Integer value2) {
            addCriterion("screenId not between", value1, value2, "screenid");
            return (Criteria) this;
        }

        public Criteria andRcidIsNull() {
            addCriterion("rcId is null");
            return (Criteria) this;
        }

        public Criteria andRcidIsNotNull() {
            addCriterion("rcId is not null");
            return (Criteria) this;
        }

        public Criteria andRcidEqualTo(Integer value) {
            addCriterion("rcId =", value, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidNotEqualTo(Integer value) {
            addCriterion("rcId <>", value, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidGreaterThan(Integer value) {
            addCriterion("rcId >", value, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rcId >=", value, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidLessThan(Integer value) {
            addCriterion("rcId <", value, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidLessThanOrEqualTo(Integer value) {
            addCriterion("rcId <=", value, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidIn(List<Integer> values) {
            addCriterion("rcId in", values, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidNotIn(List<Integer> values) {
            addCriterion("rcId not in", values, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidBetween(Integer value1, Integer value2) {
            addCriterion("rcId between", value1, value2, "rcid");
            return (Criteria) this;
        }

        public Criteria andRcidNotBetween(Integer value1, Integer value2) {
            addCriterion("rcId not between", value1, value2, "rcid");
            return (Criteria) this;
        }

        public Criteria andFcidIsNull() {
            addCriterion("fcId is null");
            return (Criteria) this;
        }

        public Criteria andFcidIsNotNull() {
            addCriterion("fcId is not null");
            return (Criteria) this;
        }

        public Criteria andFcidEqualTo(Integer value) {
            addCriterion("fcId =", value, "fcid");
            return (Criteria) this;
        }

        public Criteria andFcidNotEqualTo(Integer value) {
            addCriterion("fcId <>", value, "fcid");
            return (Criteria) this;
        }

        public Criteria andFcidGreaterThan(Integer value) {
            addCriterion("fcId >", value, "fcid");
            return (Criteria) this;
        }

        public Criteria andFcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fcId >=", value, "fcid");
            return (Criteria) this;
        }

        public Criteria andFcidLessThan(Integer value) {
            addCriterion("fcId <", value, "fcid");
            return (Criteria) this;
        }

        public Criteria andFcidLessThanOrEqualTo(Integer value) {
            addCriterion("fcId <=", value, "fcid");
            return (Criteria) this;
        }

        public Criteria andFcidIn(List<Integer> values) {
            addCriterion("fcId in", values, "fcid");
            return (Criteria) this;
        }

        public Criteria andFcidNotIn(List<Integer> values) {
            addCriterion("fcId not in", values, "fcid");
            return (Criteria) this;
        }

        public Criteria andFcidBetween(Integer value1, Integer value2) {
            addCriterion("fcId between", value1, value2, "fcid");
            return (Criteria) this;
        }

        public Criteria andFcidNotBetween(Integer value1, Integer value2) {
            addCriterion("fcId not between", value1, value2, "fcid");
            return (Criteria) this;
        }

        public Criteria andRecidIsNull() {
            addCriterion("recId is null");
            return (Criteria) this;
        }

        public Criteria andRecidIsNotNull() {
            addCriterion("recId is not null");
            return (Criteria) this;
        }

        public Criteria andRecidEqualTo(Integer value) {
            addCriterion("recId =", value, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidNotEqualTo(Integer value) {
            addCriterion("recId <>", value, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidGreaterThan(Integer value) {
            addCriterion("recId >", value, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidGreaterThanOrEqualTo(Integer value) {
            addCriterion("recId >=", value, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidLessThan(Integer value) {
            addCriterion("recId <", value, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidLessThanOrEqualTo(Integer value) {
            addCriterion("recId <=", value, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidIn(List<Integer> values) {
            addCriterion("recId in", values, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidNotIn(List<Integer> values) {
            addCriterion("recId not in", values, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidBetween(Integer value1, Integer value2) {
            addCriterion("recId between", value1, value2, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidNotBetween(Integer value1, Integer value2) {
            addCriterion("recId not between", value1, value2, "recid");
            return (Criteria) this;
        }

        public Criteria andCharbattidIsNull() {
            addCriterion("charbattId is null");
            return (Criteria) this;
        }

        public Criteria andCharbattidIsNotNull() {
            addCriterion("charbattId is not null");
            return (Criteria) this;
        }

        public Criteria andCharbattidEqualTo(Integer value) {
            addCriterion("charbattId =", value, "charbattid");
            return (Criteria) this;
        }

        public Criteria andCharbattidNotEqualTo(Integer value) {
            addCriterion("charbattId <>", value, "charbattid");
            return (Criteria) this;
        }

        public Criteria andCharbattidGreaterThan(Integer value) {
            addCriterion("charbattId >", value, "charbattid");
            return (Criteria) this;
        }

        public Criteria andCharbattidGreaterThanOrEqualTo(Integer value) {
            addCriterion("charbattId >=", value, "charbattid");
            return (Criteria) this;
        }

        public Criteria andCharbattidLessThan(Integer value) {
            addCriterion("charbattId <", value, "charbattid");
            return (Criteria) this;
        }

        public Criteria andCharbattidLessThanOrEqualTo(Integer value) {
            addCriterion("charbattId <=", value, "charbattid");
            return (Criteria) this;
        }

        public Criteria andCharbattidIn(List<Integer> values) {
            addCriterion("charbattId in", values, "charbattid");
            return (Criteria) this;
        }

        public Criteria andCharbattidNotIn(List<Integer> values) {
            addCriterion("charbattId not in", values, "charbattid");
            return (Criteria) this;
        }

        public Criteria andCharbattidBetween(Integer value1, Integer value2) {
            addCriterion("charbattId between", value1, value2, "charbattid");
            return (Criteria) this;
        }

        public Criteria andCharbattidNotBetween(Integer value1, Integer value2) {
            addCriterion("charbattId not between", value1, value2, "charbattid");
            return (Criteria) this;
        }

        public Criteria andSizeidIsNull() {
            addCriterion("sizeId is null");
            return (Criteria) this;
        }

        public Criteria andSizeidIsNotNull() {
            addCriterion("sizeId is not null");
            return (Criteria) this;
        }

        public Criteria andSizeidEqualTo(Integer value) {
            addCriterion("sizeId =", value, "sizeid");
            return (Criteria) this;
        }

        public Criteria andSizeidNotEqualTo(Integer value) {
            addCriterion("sizeId <>", value, "sizeid");
            return (Criteria) this;
        }

        public Criteria andSizeidGreaterThan(Integer value) {
            addCriterion("sizeId >", value, "sizeid");
            return (Criteria) this;
        }

        public Criteria andSizeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sizeId >=", value, "sizeid");
            return (Criteria) this;
        }

        public Criteria andSizeidLessThan(Integer value) {
            addCriterion("sizeId <", value, "sizeid");
            return (Criteria) this;
        }

        public Criteria andSizeidLessThanOrEqualTo(Integer value) {
            addCriterion("sizeId <=", value, "sizeid");
            return (Criteria) this;
        }

        public Criteria andSizeidIn(List<Integer> values) {
            addCriterion("sizeId in", values, "sizeid");
            return (Criteria) this;
        }

        public Criteria andSizeidNotIn(List<Integer> values) {
            addCriterion("sizeId not in", values, "sizeid");
            return (Criteria) this;
        }

        public Criteria andSizeidBetween(Integer value1, Integer value2) {
            addCriterion("sizeId between", value1, value2, "sizeid");
            return (Criteria) this;
        }

        public Criteria andSizeidNotBetween(Integer value1, Integer value2) {
            addCriterion("sizeId not between", value1, value2, "sizeid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}