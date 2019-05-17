package com.jf.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class RamromExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RamromExample() {
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

        public Criteria andRamIsNull() {
            addCriterion("ram is null");
            return (Criteria) this;
        }

        public Criteria andRamIsNotNull() {
            addCriterion("ram is not null");
            return (Criteria) this;
        }

        public Criteria andRamEqualTo(String value) {
            addCriterion("ram =", value, "ram");
            return (Criteria) this;
        }

        public Criteria andRamNotEqualTo(String value) {
            addCriterion("ram <>", value, "ram");
            return (Criteria) this;
        }

        public Criteria andRamGreaterThan(String value) {
            addCriterion("ram >", value, "ram");
            return (Criteria) this;
        }

        public Criteria andRamGreaterThanOrEqualTo(String value) {
            addCriterion("ram >=", value, "ram");
            return (Criteria) this;
        }

        public Criteria andRamLessThan(String value) {
            addCriterion("ram <", value, "ram");
            return (Criteria) this;
        }

        public Criteria andRamLessThanOrEqualTo(String value) {
            addCriterion("ram <=", value, "ram");
            return (Criteria) this;
        }

        public Criteria andRamLike(String value) {
            addCriterion("ram like", value, "ram");
            return (Criteria) this;
        }

        public Criteria andRamNotLike(String value) {
            addCriterion("ram not like", value, "ram");
            return (Criteria) this;
        }

        public Criteria andRamIn(List<String> values) {
            addCriterion("ram in", values, "ram");
            return (Criteria) this;
        }

        public Criteria andRamNotIn(List<String> values) {
            addCriterion("ram not in", values, "ram");
            return (Criteria) this;
        }

        public Criteria andRamBetween(String value1, String value2) {
            addCriterion("ram between", value1, value2, "ram");
            return (Criteria) this;
        }

        public Criteria andRamNotBetween(String value1, String value2) {
            addCriterion("ram not between", value1, value2, "ram");
            return (Criteria) this;
        }

        public Criteria andRomIsNull() {
            addCriterion("rom is null");
            return (Criteria) this;
        }

        public Criteria andRomIsNotNull() {
            addCriterion("rom is not null");
            return (Criteria) this;
        }

        public Criteria andRomEqualTo(String value) {
            addCriterion("rom =", value, "rom");
            return (Criteria) this;
        }

        public Criteria andRomNotEqualTo(String value) {
            addCriterion("rom <>", value, "rom");
            return (Criteria) this;
        }

        public Criteria andRomGreaterThan(String value) {
            addCriterion("rom >", value, "rom");
            return (Criteria) this;
        }

        public Criteria andRomGreaterThanOrEqualTo(String value) {
            addCriterion("rom >=", value, "rom");
            return (Criteria) this;
        }

        public Criteria andRomLessThan(String value) {
            addCriterion("rom <", value, "rom");
            return (Criteria) this;
        }

        public Criteria andRomLessThanOrEqualTo(String value) {
            addCriterion("rom <=", value, "rom");
            return (Criteria) this;
        }

        public Criteria andRomLike(String value) {
            addCriterion("rom like", value, "rom");
            return (Criteria) this;
        }

        public Criteria andRomNotLike(String value) {
            addCriterion("rom not like", value, "rom");
            return (Criteria) this;
        }

        public Criteria andRomIn(List<String> values) {
            addCriterion("rom in", values, "rom");
            return (Criteria) this;
        }

        public Criteria andRomNotIn(List<String> values) {
            addCriterion("rom not in", values, "rom");
            return (Criteria) this;
        }

        public Criteria andRomBetween(String value1, String value2) {
            addCriterion("rom between", value1, value2, "rom");
            return (Criteria) this;
        }

        public Criteria andRomNotBetween(String value1, String value2) {
            addCriterion("rom not between", value1, value2, "rom");
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