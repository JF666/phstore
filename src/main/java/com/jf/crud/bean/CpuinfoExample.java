package com.jf.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class CpuinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CpuinfoExample() {
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

        public Criteria andCpunameIsNull() {
            addCriterion("cpuName is null");
            return (Criteria) this;
        }

        public Criteria andCpunameIsNotNull() {
            addCriterion("cpuName is not null");
            return (Criteria) this;
        }

        public Criteria andCpunameEqualTo(String value) {
            addCriterion("cpuName =", value, "cpuname");
            return (Criteria) this;
        }

        public Criteria andCpunameNotEqualTo(String value) {
            addCriterion("cpuName <>", value, "cpuname");
            return (Criteria) this;
        }

        public Criteria andCpunameGreaterThan(String value) {
            addCriterion("cpuName >", value, "cpuname");
            return (Criteria) this;
        }

        public Criteria andCpunameGreaterThanOrEqualTo(String value) {
            addCriterion("cpuName >=", value, "cpuname");
            return (Criteria) this;
        }

        public Criteria andCpunameLessThan(String value) {
            addCriterion("cpuName <", value, "cpuname");
            return (Criteria) this;
        }

        public Criteria andCpunameLessThanOrEqualTo(String value) {
            addCriterion("cpuName <=", value, "cpuname");
            return (Criteria) this;
        }

        public Criteria andCpunameLike(String value) {
            addCriterion("cpuName like", value, "cpuname");
            return (Criteria) this;
        }

        public Criteria andCpunameNotLike(String value) {
            addCriterion("cpuName not like", value, "cpuname");
            return (Criteria) this;
        }

        public Criteria andCpunameIn(List<String> values) {
            addCriterion("cpuName in", values, "cpuname");
            return (Criteria) this;
        }

        public Criteria andCpunameNotIn(List<String> values) {
            addCriterion("cpuName not in", values, "cpuname");
            return (Criteria) this;
        }

        public Criteria andCpunameBetween(String value1, String value2) {
            addCriterion("cpuName between", value1, value2, "cpuname");
            return (Criteria) this;
        }

        public Criteria andCpunameNotBetween(String value1, String value2) {
            addCriterion("cpuName not between", value1, value2, "cpuname");
            return (Criteria) this;
        }

        public Criteria andCputechIsNull() {
            addCriterion("cpuTech is null");
            return (Criteria) this;
        }

        public Criteria andCputechIsNotNull() {
            addCriterion("cpuTech is not null");
            return (Criteria) this;
        }

        public Criteria andCputechEqualTo(String value) {
            addCriterion("cpuTech =", value, "cputech");
            return (Criteria) this;
        }

        public Criteria andCputechNotEqualTo(String value) {
            addCriterion("cpuTech <>", value, "cputech");
            return (Criteria) this;
        }

        public Criteria andCputechGreaterThan(String value) {
            addCriterion("cpuTech >", value, "cputech");
            return (Criteria) this;
        }

        public Criteria andCputechGreaterThanOrEqualTo(String value) {
            addCriterion("cpuTech >=", value, "cputech");
            return (Criteria) this;
        }

        public Criteria andCputechLessThan(String value) {
            addCriterion("cpuTech <", value, "cputech");
            return (Criteria) this;
        }

        public Criteria andCputechLessThanOrEqualTo(String value) {
            addCriterion("cpuTech <=", value, "cputech");
            return (Criteria) this;
        }

        public Criteria andCputechLike(String value) {
            addCriterion("cpuTech like", value, "cputech");
            return (Criteria) this;
        }

        public Criteria andCputechNotLike(String value) {
            addCriterion("cpuTech not like", value, "cputech");
            return (Criteria) this;
        }

        public Criteria andCputechIn(List<String> values) {
            addCriterion("cpuTech in", values, "cputech");
            return (Criteria) this;
        }

        public Criteria andCputechNotIn(List<String> values) {
            addCriterion("cpuTech not in", values, "cputech");
            return (Criteria) this;
        }

        public Criteria andCputechBetween(String value1, String value2) {
            addCriterion("cpuTech between", value1, value2, "cputech");
            return (Criteria) this;
        }

        public Criteria andCputechNotBetween(String value1, String value2) {
            addCriterion("cpuTech not between", value1, value2, "cputech");
            return (Criteria) this;
        }

        public Criteria andCpufquIsNull() {
            addCriterion("cpuFqu is null");
            return (Criteria) this;
        }

        public Criteria andCpufquIsNotNull() {
            addCriterion("cpuFqu is not null");
            return (Criteria) this;
        }

        public Criteria andCpufquEqualTo(String value) {
            addCriterion("cpuFqu =", value, "cpufqu");
            return (Criteria) this;
        }

        public Criteria andCpufquNotEqualTo(String value) {
            addCriterion("cpuFqu <>", value, "cpufqu");
            return (Criteria) this;
        }

        public Criteria andCpufquGreaterThan(String value) {
            addCriterion("cpuFqu >", value, "cpufqu");
            return (Criteria) this;
        }

        public Criteria andCpufquGreaterThanOrEqualTo(String value) {
            addCriterion("cpuFqu >=", value, "cpufqu");
            return (Criteria) this;
        }

        public Criteria andCpufquLessThan(String value) {
            addCriterion("cpuFqu <", value, "cpufqu");
            return (Criteria) this;
        }

        public Criteria andCpufquLessThanOrEqualTo(String value) {
            addCriterion("cpuFqu <=", value, "cpufqu");
            return (Criteria) this;
        }

        public Criteria andCpufquLike(String value) {
            addCriterion("cpuFqu like", value, "cpufqu");
            return (Criteria) this;
        }

        public Criteria andCpufquNotLike(String value) {
            addCriterion("cpuFqu not like", value, "cpufqu");
            return (Criteria) this;
        }

        public Criteria andCpufquIn(List<String> values) {
            addCriterion("cpuFqu in", values, "cpufqu");
            return (Criteria) this;
        }

        public Criteria andCpufquNotIn(List<String> values) {
            addCriterion("cpuFqu not in", values, "cpufqu");
            return (Criteria) this;
        }

        public Criteria andCpufquBetween(String value1, String value2) {
            addCriterion("cpuFqu between", value1, value2, "cpufqu");
            return (Criteria) this;
        }

        public Criteria andCpufquNotBetween(String value1, String value2) {
            addCriterion("cpuFqu not between", value1, value2, "cpufqu");
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