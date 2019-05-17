package com.jf.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class BatteryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BatteryExample() {
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

        public Criteria andCapacityIsNull() {
            addCriterion("capacity is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(String value) {
            addCriterion("capacity =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(String value) {
            addCriterion("capacity <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(String value) {
            addCriterion("capacity >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("capacity >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(String value) {
            addCriterion("capacity <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(String value) {
            addCriterion("capacity <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLike(String value) {
            addCriterion("capacity like", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotLike(String value) {
            addCriterion("capacity not like", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<String> values) {
            addCriterion("capacity in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<String> values) {
            addCriterion("capacity not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(String value1, String value2) {
            addCriterion("capacity between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(String value1, String value2) {
            addCriterion("capacity not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCharinterIsNull() {
            addCriterion("charInter is null");
            return (Criteria) this;
        }

        public Criteria andCharinterIsNotNull() {
            addCriterion("charInter is not null");
            return (Criteria) this;
        }

        public Criteria andCharinterEqualTo(String value) {
            addCriterion("charInter =", value, "charinter");
            return (Criteria) this;
        }

        public Criteria andCharinterNotEqualTo(String value) {
            addCriterion("charInter <>", value, "charinter");
            return (Criteria) this;
        }

        public Criteria andCharinterGreaterThan(String value) {
            addCriterion("charInter >", value, "charinter");
            return (Criteria) this;
        }

        public Criteria andCharinterGreaterThanOrEqualTo(String value) {
            addCriterion("charInter >=", value, "charinter");
            return (Criteria) this;
        }

        public Criteria andCharinterLessThan(String value) {
            addCriterion("charInter <", value, "charinter");
            return (Criteria) this;
        }

        public Criteria andCharinterLessThanOrEqualTo(String value) {
            addCriterion("charInter <=", value, "charinter");
            return (Criteria) this;
        }

        public Criteria andCharinterLike(String value) {
            addCriterion("charInter like", value, "charinter");
            return (Criteria) this;
        }

        public Criteria andCharinterNotLike(String value) {
            addCriterion("charInter not like", value, "charinter");
            return (Criteria) this;
        }

        public Criteria andCharinterIn(List<String> values) {
            addCriterion("charInter in", values, "charinter");
            return (Criteria) this;
        }

        public Criteria andCharinterNotIn(List<String> values) {
            addCriterion("charInter not in", values, "charinter");
            return (Criteria) this;
        }

        public Criteria andCharinterBetween(String value1, String value2) {
            addCriterion("charInter between", value1, value2, "charinter");
            return (Criteria) this;
        }

        public Criteria andCharinterNotBetween(String value1, String value2) {
            addCriterion("charInter not between", value1, value2, "charinter");
            return (Criteria) this;
        }

        public Criteria andCharpowerIsNull() {
            addCriterion("charPower is null");
            return (Criteria) this;
        }

        public Criteria andCharpowerIsNotNull() {
            addCriterion("charPower is not null");
            return (Criteria) this;
        }

        public Criteria andCharpowerEqualTo(String value) {
            addCriterion("charPower =", value, "charpower");
            return (Criteria) this;
        }

        public Criteria andCharpowerNotEqualTo(String value) {
            addCriterion("charPower <>", value, "charpower");
            return (Criteria) this;
        }

        public Criteria andCharpowerGreaterThan(String value) {
            addCriterion("charPower >", value, "charpower");
            return (Criteria) this;
        }

        public Criteria andCharpowerGreaterThanOrEqualTo(String value) {
            addCriterion("charPower >=", value, "charpower");
            return (Criteria) this;
        }

        public Criteria andCharpowerLessThan(String value) {
            addCriterion("charPower <", value, "charpower");
            return (Criteria) this;
        }

        public Criteria andCharpowerLessThanOrEqualTo(String value) {
            addCriterion("charPower <=", value, "charpower");
            return (Criteria) this;
        }

        public Criteria andCharpowerLike(String value) {
            addCriterion("charPower like", value, "charpower");
            return (Criteria) this;
        }

        public Criteria andCharpowerNotLike(String value) {
            addCriterion("charPower not like", value, "charpower");
            return (Criteria) this;
        }

        public Criteria andCharpowerIn(List<String> values) {
            addCriterion("charPower in", values, "charpower");
            return (Criteria) this;
        }

        public Criteria andCharpowerNotIn(List<String> values) {
            addCriterion("charPower not in", values, "charpower");
            return (Criteria) this;
        }

        public Criteria andCharpowerBetween(String value1, String value2) {
            addCriterion("charPower between", value1, value2, "charpower");
            return (Criteria) this;
        }

        public Criteria andCharpowerNotBetween(String value1, String value2) {
            addCriterion("charPower not between", value1, value2, "charpower");
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