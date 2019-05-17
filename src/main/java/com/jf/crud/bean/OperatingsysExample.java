package com.jf.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class OperatingsysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperatingsysExample() {
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

        public Criteria andOsnameIsNull() {
            addCriterion("osName is null");
            return (Criteria) this;
        }

        public Criteria andOsnameIsNotNull() {
            addCriterion("osName is not null");
            return (Criteria) this;
        }

        public Criteria andOsnameEqualTo(String value) {
            addCriterion("osName =", value, "osname");
            return (Criteria) this;
        }

        public Criteria andOsnameNotEqualTo(String value) {
            addCriterion("osName <>", value, "osname");
            return (Criteria) this;
        }

        public Criteria andOsnameGreaterThan(String value) {
            addCriterion("osName >", value, "osname");
            return (Criteria) this;
        }

        public Criteria andOsnameGreaterThanOrEqualTo(String value) {
            addCriterion("osName >=", value, "osname");
            return (Criteria) this;
        }

        public Criteria andOsnameLessThan(String value) {
            addCriterion("osName <", value, "osname");
            return (Criteria) this;
        }

        public Criteria andOsnameLessThanOrEqualTo(String value) {
            addCriterion("osName <=", value, "osname");
            return (Criteria) this;
        }

        public Criteria andOsnameLike(String value) {
            addCriterion("osName like", value, "osname");
            return (Criteria) this;
        }

        public Criteria andOsnameNotLike(String value) {
            addCriterion("osName not like", value, "osname");
            return (Criteria) this;
        }

        public Criteria andOsnameIn(List<String> values) {
            addCriterion("osName in", values, "osname");
            return (Criteria) this;
        }

        public Criteria andOsnameNotIn(List<String> values) {
            addCriterion("osName not in", values, "osname");
            return (Criteria) this;
        }

        public Criteria andOsnameBetween(String value1, String value2) {
            addCriterion("osName between", value1, value2, "osname");
            return (Criteria) this;
        }

        public Criteria andOsnameNotBetween(String value1, String value2) {
            addCriterion("osName not between", value1, value2, "osname");
            return (Criteria) this;
        }

        public Criteria andOsversionIsNull() {
            addCriterion("osVersion is null");
            return (Criteria) this;
        }

        public Criteria andOsversionIsNotNull() {
            addCriterion("osVersion is not null");
            return (Criteria) this;
        }

        public Criteria andOsversionEqualTo(String value) {
            addCriterion("osVersion =", value, "osversion");
            return (Criteria) this;
        }

        public Criteria andOsversionNotEqualTo(String value) {
            addCriterion("osVersion <>", value, "osversion");
            return (Criteria) this;
        }

        public Criteria andOsversionGreaterThan(String value) {
            addCriterion("osVersion >", value, "osversion");
            return (Criteria) this;
        }

        public Criteria andOsversionGreaterThanOrEqualTo(String value) {
            addCriterion("osVersion >=", value, "osversion");
            return (Criteria) this;
        }

        public Criteria andOsversionLessThan(String value) {
            addCriterion("osVersion <", value, "osversion");
            return (Criteria) this;
        }

        public Criteria andOsversionLessThanOrEqualTo(String value) {
            addCriterion("osVersion <=", value, "osversion");
            return (Criteria) this;
        }

        public Criteria andOsversionLike(String value) {
            addCriterion("osVersion like", value, "osversion");
            return (Criteria) this;
        }

        public Criteria andOsversionNotLike(String value) {
            addCriterion("osVersion not like", value, "osversion");
            return (Criteria) this;
        }

        public Criteria andOsversionIn(List<String> values) {
            addCriterion("osVersion in", values, "osversion");
            return (Criteria) this;
        }

        public Criteria andOsversionNotIn(List<String> values) {
            addCriterion("osVersion not in", values, "osversion");
            return (Criteria) this;
        }

        public Criteria andOsversionBetween(String value1, String value2) {
            addCriterion("osVersion between", value1, value2, "osversion");
            return (Criteria) this;
        }

        public Criteria andOsversionNotBetween(String value1, String value2) {
            addCriterion("osVersion not between", value1, value2, "osversion");
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