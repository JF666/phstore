package com.jf.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommidIsNull() {
            addCriterion("commId is null");
            return (Criteria) this;
        }

        public Criteria andCommidIsNotNull() {
            addCriterion("commId is not null");
            return (Criteria) this;
        }

        public Criteria andCommidEqualTo(Integer value) {
            addCriterion("commId =", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidNotEqualTo(Integer value) {
            addCriterion("commId <>", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidGreaterThan(Integer value) {
            addCriterion("commId >", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidGreaterThanOrEqualTo(Integer value) {
            addCriterion("commId >=", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidLessThan(Integer value) {
            addCriterion("commId <", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidLessThanOrEqualTo(Integer value) {
            addCriterion("commId <=", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidIn(List<Integer> values) {
            addCriterion("commId in", values, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidNotIn(List<Integer> values) {
            addCriterion("commId not in", values, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidBetween(Integer value1, Integer value2) {
            addCriterion("commId between", value1, value2, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidNotBetween(Integer value1, Integer value2) {
            addCriterion("commId not between", value1, value2, "commid");
            return (Criteria) this;
        }

        public Criteria andBuyeridIsNull() {
            addCriterion("buyerId is null");
            return (Criteria) this;
        }

        public Criteria andBuyeridIsNotNull() {
            addCriterion("buyerId is not null");
            return (Criteria) this;
        }

        public Criteria andBuyeridEqualTo(Integer value) {
            addCriterion("buyerId =", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridNotEqualTo(Integer value) {
            addCriterion("buyerId <>", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridGreaterThan(Integer value) {
            addCriterion("buyerId >", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyerId >=", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridLessThan(Integer value) {
            addCriterion("buyerId <", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridLessThanOrEqualTo(Integer value) {
            addCriterion("buyerId <=", value, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridIn(List<Integer> values) {
            addCriterion("buyerId in", values, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridNotIn(List<Integer> values) {
            addCriterion("buyerId not in", values, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridBetween(Integer value1, Integer value2) {
            addCriterion("buyerId between", value1, value2, "buyerid");
            return (Criteria) this;
        }

        public Criteria andBuyeridNotBetween(Integer value1, Integer value2) {
            addCriterion("buyerId not between", value1, value2, "buyerid");
            return (Criteria) this;
        }

        public Criteria andSelleridIsNull() {
            addCriterion("sellerId is null");
            return (Criteria) this;
        }

        public Criteria andSelleridIsNotNull() {
            addCriterion("sellerId is not null");
            return (Criteria) this;
        }

        public Criteria andSelleridEqualTo(Integer value) {
            addCriterion("sellerId =", value, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridNotEqualTo(Integer value) {
            addCriterion("sellerId <>", value, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridGreaterThan(Integer value) {
            addCriterion("sellerId >", value, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridGreaterThanOrEqualTo(Integer value) {
            addCriterion("sellerId >=", value, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridLessThan(Integer value) {
            addCriterion("sellerId <", value, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridLessThanOrEqualTo(Integer value) {
            addCriterion("sellerId <=", value, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridIn(List<Integer> values) {
            addCriterion("sellerId in", values, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridNotIn(List<Integer> values) {
            addCriterion("sellerId not in", values, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridBetween(Integer value1, Integer value2) {
            addCriterion("sellerId between", value1, value2, "sellerid");
            return (Criteria) this;
        }

        public Criteria andSelleridNotBetween(Integer value1, Integer value2) {
            addCriterion("sellerId not between", value1, value2, "sellerid");
            return (Criteria) this;
        }

        public Criteria andComminfoIsNull() {
            addCriterion("commInfo is null");
            return (Criteria) this;
        }

        public Criteria andComminfoIsNotNull() {
            addCriterion("commInfo is not null");
            return (Criteria) this;
        }

        public Criteria andComminfoEqualTo(String value) {
            addCriterion("commInfo =", value, "comminfo");
            return (Criteria) this;
        }

        public Criteria andComminfoNotEqualTo(String value) {
            addCriterion("commInfo <>", value, "comminfo");
            return (Criteria) this;
        }

        public Criteria andComminfoGreaterThan(String value) {
            addCriterion("commInfo >", value, "comminfo");
            return (Criteria) this;
        }

        public Criteria andComminfoGreaterThanOrEqualTo(String value) {
            addCriterion("commInfo >=", value, "comminfo");
            return (Criteria) this;
        }

        public Criteria andComminfoLessThan(String value) {
            addCriterion("commInfo <", value, "comminfo");
            return (Criteria) this;
        }

        public Criteria andComminfoLessThanOrEqualTo(String value) {
            addCriterion("commInfo <=", value, "comminfo");
            return (Criteria) this;
        }

        public Criteria andComminfoLike(String value) {
            addCriterion("commInfo like", value, "comminfo");
            return (Criteria) this;
        }

        public Criteria andComminfoNotLike(String value) {
            addCriterion("commInfo not like", value, "comminfo");
            return (Criteria) this;
        }

        public Criteria andComminfoIn(List<String> values) {
            addCriterion("commInfo in", values, "comminfo");
            return (Criteria) this;
        }

        public Criteria andComminfoNotIn(List<String> values) {
            addCriterion("commInfo not in", values, "comminfo");
            return (Criteria) this;
        }

        public Criteria andComminfoBetween(String value1, String value2) {
            addCriterion("commInfo between", value1, value2, "comminfo");
            return (Criteria) this;
        }

        public Criteria andComminfoNotBetween(String value1, String value2) {
            addCriterion("commInfo not between", value1, value2, "comminfo");
            return (Criteria) this;
        }

        public Criteria andApplyIsNull() {
            addCriterion("apply is null");
            return (Criteria) this;
        }

        public Criteria andApplyIsNotNull() {
            addCriterion("apply is not null");
            return (Criteria) this;
        }

        public Criteria andApplyEqualTo(String value) {
            addCriterion("apply =", value, "apply");
            return (Criteria) this;
        }

        public Criteria andApplyNotEqualTo(String value) {
            addCriterion("apply <>", value, "apply");
            return (Criteria) this;
        }

        public Criteria andApplyGreaterThan(String value) {
            addCriterion("apply >", value, "apply");
            return (Criteria) this;
        }

        public Criteria andApplyGreaterThanOrEqualTo(String value) {
            addCriterion("apply >=", value, "apply");
            return (Criteria) this;
        }

        public Criteria andApplyLessThan(String value) {
            addCriterion("apply <", value, "apply");
            return (Criteria) this;
        }

        public Criteria andApplyLessThanOrEqualTo(String value) {
            addCriterion("apply <=", value, "apply");
            return (Criteria) this;
        }

        public Criteria andApplyLike(String value) {
            addCriterion("apply like", value, "apply");
            return (Criteria) this;
        }

        public Criteria andApplyNotLike(String value) {
            addCriterion("apply not like", value, "apply");
            return (Criteria) this;
        }

        public Criteria andApplyIn(List<String> values) {
            addCriterion("apply in", values, "apply");
            return (Criteria) this;
        }

        public Criteria andApplyNotIn(List<String> values) {
            addCriterion("apply not in", values, "apply");
            return (Criteria) this;
        }

        public Criteria andApplyBetween(String value1, String value2) {
            addCriterion("apply between", value1, value2, "apply");
            return (Criteria) this;
        }

        public Criteria andApplyNotBetween(String value1, String value2) {
            addCriterion("apply not between", value1, value2, "apply");
            return (Criteria) this;
        }

        public Criteria andCommstsIsNull() {
            addCriterion("commSts is null");
            return (Criteria) this;
        }

        public Criteria andCommstsIsNotNull() {
            addCriterion("commSts is not null");
            return (Criteria) this;
        }

        public Criteria andCommstsEqualTo(Integer value) {
            addCriterion("commSts =", value, "commsts");
            return (Criteria) this;
        }

        public Criteria andCommstsNotEqualTo(Integer value) {
            addCriterion("commSts <>", value, "commsts");
            return (Criteria) this;
        }

        public Criteria andCommstsGreaterThan(Integer value) {
            addCriterion("commSts >", value, "commsts");
            return (Criteria) this;
        }

        public Criteria andCommstsGreaterThanOrEqualTo(Integer value) {
            addCriterion("commSts >=", value, "commsts");
            return (Criteria) this;
        }

        public Criteria andCommstsLessThan(Integer value) {
            addCriterion("commSts <", value, "commsts");
            return (Criteria) this;
        }

        public Criteria andCommstsLessThanOrEqualTo(Integer value) {
            addCriterion("commSts <=", value, "commsts");
            return (Criteria) this;
        }

        public Criteria andCommstsIn(List<Integer> values) {
            addCriterion("commSts in", values, "commsts");
            return (Criteria) this;
        }

        public Criteria andCommstsNotIn(List<Integer> values) {
            addCriterion("commSts not in", values, "commsts");
            return (Criteria) this;
        }

        public Criteria andCommstsBetween(Integer value1, Integer value2) {
            addCriterion("commSts between", value1, value2, "commsts");
            return (Criteria) this;
        }

        public Criteria andCommstsNotBetween(Integer value1, Integer value2) {
            addCriterion("commSts not between", value1, value2, "commsts");
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