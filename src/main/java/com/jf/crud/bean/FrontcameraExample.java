package com.jf.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class FrontcameraExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FrontcameraExample() {
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

        public Criteria andFcnameIsNull() {
            addCriterion("fcName is null");
            return (Criteria) this;
        }

        public Criteria andFcnameIsNotNull() {
            addCriterion("fcName is not null");
            return (Criteria) this;
        }

        public Criteria andFcnameEqualTo(String value) {
            addCriterion("fcName =", value, "fcname");
            return (Criteria) this;
        }

        public Criteria andFcnameNotEqualTo(String value) {
            addCriterion("fcName <>", value, "fcname");
            return (Criteria) this;
        }

        public Criteria andFcnameGreaterThan(String value) {
            addCriterion("fcName >", value, "fcname");
            return (Criteria) this;
        }

        public Criteria andFcnameGreaterThanOrEqualTo(String value) {
            addCriterion("fcName >=", value, "fcname");
            return (Criteria) this;
        }

        public Criteria andFcnameLessThan(String value) {
            addCriterion("fcName <", value, "fcname");
            return (Criteria) this;
        }

        public Criteria andFcnameLessThanOrEqualTo(String value) {
            addCriterion("fcName <=", value, "fcname");
            return (Criteria) this;
        }

        public Criteria andFcnameLike(String value) {
            addCriterion("fcName like", value, "fcname");
            return (Criteria) this;
        }

        public Criteria andFcnameNotLike(String value) {
            addCriterion("fcName not like", value, "fcname");
            return (Criteria) this;
        }

        public Criteria andFcnameIn(List<String> values) {
            addCriterion("fcName in", values, "fcname");
            return (Criteria) this;
        }

        public Criteria andFcnameNotIn(List<String> values) {
            addCriterion("fcName not in", values, "fcname");
            return (Criteria) this;
        }

        public Criteria andFcnameBetween(String value1, String value2) {
            addCriterion("fcName between", value1, value2, "fcname");
            return (Criteria) this;
        }

        public Criteria andFcnameNotBetween(String value1, String value2) {
            addCriterion("fcName not between", value1, value2, "fcname");
            return (Criteria) this;
        }

        public Criteria andFcpixelIsNull() {
            addCriterion("fcPixel is null");
            return (Criteria) this;
        }

        public Criteria andFcpixelIsNotNull() {
            addCriterion("fcPixel is not null");
            return (Criteria) this;
        }

        public Criteria andFcpixelEqualTo(String value) {
            addCriterion("fcPixel =", value, "fcpixel");
            return (Criteria) this;
        }

        public Criteria andFcpixelNotEqualTo(String value) {
            addCriterion("fcPixel <>", value, "fcpixel");
            return (Criteria) this;
        }

        public Criteria andFcpixelGreaterThan(String value) {
            addCriterion("fcPixel >", value, "fcpixel");
            return (Criteria) this;
        }

        public Criteria andFcpixelGreaterThanOrEqualTo(String value) {
            addCriterion("fcPixel >=", value, "fcpixel");
            return (Criteria) this;
        }

        public Criteria andFcpixelLessThan(String value) {
            addCriterion("fcPixel <", value, "fcpixel");
            return (Criteria) this;
        }

        public Criteria andFcpixelLessThanOrEqualTo(String value) {
            addCriterion("fcPixel <=", value, "fcpixel");
            return (Criteria) this;
        }

        public Criteria andFcpixelLike(String value) {
            addCriterion("fcPixel like", value, "fcpixel");
            return (Criteria) this;
        }

        public Criteria andFcpixelNotLike(String value) {
            addCriterion("fcPixel not like", value, "fcpixel");
            return (Criteria) this;
        }

        public Criteria andFcpixelIn(List<String> values) {
            addCriterion("fcPixel in", values, "fcpixel");
            return (Criteria) this;
        }

        public Criteria andFcpixelNotIn(List<String> values) {
            addCriterion("fcPixel not in", values, "fcpixel");
            return (Criteria) this;
        }

        public Criteria andFcpixelBetween(String value1, String value2) {
            addCriterion("fcPixel between", value1, value2, "fcpixel");
            return (Criteria) this;
        }

        public Criteria andFcpixelNotBetween(String value1, String value2) {
            addCriterion("fcPixel not between", value1, value2, "fcpixel");
            return (Criteria) this;
        }

        public Criteria andFcversionIsNull() {
            addCriterion("fcVersion is null");
            return (Criteria) this;
        }

        public Criteria andFcversionIsNotNull() {
            addCriterion("fcVersion is not null");
            return (Criteria) this;
        }

        public Criteria andFcversionEqualTo(String value) {
            addCriterion("fcVersion =", value, "fcversion");
            return (Criteria) this;
        }

        public Criteria andFcversionNotEqualTo(String value) {
            addCriterion("fcVersion <>", value, "fcversion");
            return (Criteria) this;
        }

        public Criteria andFcversionGreaterThan(String value) {
            addCriterion("fcVersion >", value, "fcversion");
            return (Criteria) this;
        }

        public Criteria andFcversionGreaterThanOrEqualTo(String value) {
            addCriterion("fcVersion >=", value, "fcversion");
            return (Criteria) this;
        }

        public Criteria andFcversionLessThan(String value) {
            addCriterion("fcVersion <", value, "fcversion");
            return (Criteria) this;
        }

        public Criteria andFcversionLessThanOrEqualTo(String value) {
            addCriterion("fcVersion <=", value, "fcversion");
            return (Criteria) this;
        }

        public Criteria andFcversionLike(String value) {
            addCriterion("fcVersion like", value, "fcversion");
            return (Criteria) this;
        }

        public Criteria andFcversionNotLike(String value) {
            addCriterion("fcVersion not like", value, "fcversion");
            return (Criteria) this;
        }

        public Criteria andFcversionIn(List<String> values) {
            addCriterion("fcVersion in", values, "fcversion");
            return (Criteria) this;
        }

        public Criteria andFcversionNotIn(List<String> values) {
            addCriterion("fcVersion not in", values, "fcversion");
            return (Criteria) this;
        }

        public Criteria andFcversionBetween(String value1, String value2) {
            addCriterion("fcVersion between", value1, value2, "fcversion");
            return (Criteria) this;
        }

        public Criteria andFcversionNotBetween(String value1, String value2) {
            addCriterion("fcVersion not between", value1, value2, "fcversion");
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