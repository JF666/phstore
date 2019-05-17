package com.jf.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class RearcameraExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RearcameraExample() {
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

        public Criteria andRcnameIsNull() {
            addCriterion("rcName is null");
            return (Criteria) this;
        }

        public Criteria andRcnameIsNotNull() {
            addCriterion("rcName is not null");
            return (Criteria) this;
        }

        public Criteria andRcnameEqualTo(String value) {
            addCriterion("rcName =", value, "rcname");
            return (Criteria) this;
        }

        public Criteria andRcnameNotEqualTo(String value) {
            addCriterion("rcName <>", value, "rcname");
            return (Criteria) this;
        }

        public Criteria andRcnameGreaterThan(String value) {
            addCriterion("rcName >", value, "rcname");
            return (Criteria) this;
        }

        public Criteria andRcnameGreaterThanOrEqualTo(String value) {
            addCriterion("rcName >=", value, "rcname");
            return (Criteria) this;
        }

        public Criteria andRcnameLessThan(String value) {
            addCriterion("rcName <", value, "rcname");
            return (Criteria) this;
        }

        public Criteria andRcnameLessThanOrEqualTo(String value) {
            addCriterion("rcName <=", value, "rcname");
            return (Criteria) this;
        }

        public Criteria andRcnameLike(String value) {
            addCriterion("rcName like", value, "rcname");
            return (Criteria) this;
        }

        public Criteria andRcnameNotLike(String value) {
            addCriterion("rcName not like", value, "rcname");
            return (Criteria) this;
        }

        public Criteria andRcnameIn(List<String> values) {
            addCriterion("rcName in", values, "rcname");
            return (Criteria) this;
        }

        public Criteria andRcnameNotIn(List<String> values) {
            addCriterion("rcName not in", values, "rcname");
            return (Criteria) this;
        }

        public Criteria andRcnameBetween(String value1, String value2) {
            addCriterion("rcName between", value1, value2, "rcname");
            return (Criteria) this;
        }

        public Criteria andRcnameNotBetween(String value1, String value2) {
            addCriterion("rcName not between", value1, value2, "rcname");
            return (Criteria) this;
        }

        public Criteria andRcpixelIsNull() {
            addCriterion("rcPixel is null");
            return (Criteria) this;
        }

        public Criteria andRcpixelIsNotNull() {
            addCriterion("rcPixel is not null");
            return (Criteria) this;
        }

        public Criteria andRcpixelEqualTo(String value) {
            addCriterion("rcPixel =", value, "rcpixel");
            return (Criteria) this;
        }

        public Criteria andRcpixelNotEqualTo(String value) {
            addCriterion("rcPixel <>", value, "rcpixel");
            return (Criteria) this;
        }

        public Criteria andRcpixelGreaterThan(String value) {
            addCriterion("rcPixel >", value, "rcpixel");
            return (Criteria) this;
        }

        public Criteria andRcpixelGreaterThanOrEqualTo(String value) {
            addCriterion("rcPixel >=", value, "rcpixel");
            return (Criteria) this;
        }

        public Criteria andRcpixelLessThan(String value) {
            addCriterion("rcPixel <", value, "rcpixel");
            return (Criteria) this;
        }

        public Criteria andRcpixelLessThanOrEqualTo(String value) {
            addCriterion("rcPixel <=", value, "rcpixel");
            return (Criteria) this;
        }

        public Criteria andRcpixelLike(String value) {
            addCriterion("rcPixel like", value, "rcpixel");
            return (Criteria) this;
        }

        public Criteria andRcpixelNotLike(String value) {
            addCriterion("rcPixel not like", value, "rcpixel");
            return (Criteria) this;
        }

        public Criteria andRcpixelIn(List<String> values) {
            addCriterion("rcPixel in", values, "rcpixel");
            return (Criteria) this;
        }

        public Criteria andRcpixelNotIn(List<String> values) {
            addCriterion("rcPixel not in", values, "rcpixel");
            return (Criteria) this;
        }

        public Criteria andRcpixelBetween(String value1, String value2) {
            addCriterion("rcPixel between", value1, value2, "rcpixel");
            return (Criteria) this;
        }

        public Criteria andRcpixelNotBetween(String value1, String value2) {
            addCriterion("rcPixel not between", value1, value2, "rcpixel");
            return (Criteria) this;
        }

        public Criteria andRcversionIsNull() {
            addCriterion("rcVersion is null");
            return (Criteria) this;
        }

        public Criteria andRcversionIsNotNull() {
            addCriterion("rcVersion is not null");
            return (Criteria) this;
        }

        public Criteria andRcversionEqualTo(String value) {
            addCriterion("rcVersion =", value, "rcversion");
            return (Criteria) this;
        }

        public Criteria andRcversionNotEqualTo(String value) {
            addCriterion("rcVersion <>", value, "rcversion");
            return (Criteria) this;
        }

        public Criteria andRcversionGreaterThan(String value) {
            addCriterion("rcVersion >", value, "rcversion");
            return (Criteria) this;
        }

        public Criteria andRcversionGreaterThanOrEqualTo(String value) {
            addCriterion("rcVersion >=", value, "rcversion");
            return (Criteria) this;
        }

        public Criteria andRcversionLessThan(String value) {
            addCriterion("rcVersion <", value, "rcversion");
            return (Criteria) this;
        }

        public Criteria andRcversionLessThanOrEqualTo(String value) {
            addCriterion("rcVersion <=", value, "rcversion");
            return (Criteria) this;
        }

        public Criteria andRcversionLike(String value) {
            addCriterion("rcVersion like", value, "rcversion");
            return (Criteria) this;
        }

        public Criteria andRcversionNotLike(String value) {
            addCriterion("rcVersion not like", value, "rcversion");
            return (Criteria) this;
        }

        public Criteria andRcversionIn(List<String> values) {
            addCriterion("rcVersion in", values, "rcversion");
            return (Criteria) this;
        }

        public Criteria andRcversionNotIn(List<String> values) {
            addCriterion("rcVersion not in", values, "rcversion");
            return (Criteria) this;
        }

        public Criteria andRcversionBetween(String value1, String value2) {
            addCriterion("rcVersion between", value1, value2, "rcversion");
            return (Criteria) this;
        }

        public Criteria andRcversionNotBetween(String value1, String value2) {
            addCriterion("rcVersion not between", value1, value2, "rcversion");
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