package com.jf.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class RecognitionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecognitionExample() {
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

        public Criteria andFacerecIsNull() {
            addCriterion("faceRec is null");
            return (Criteria) this;
        }

        public Criteria andFacerecIsNotNull() {
            addCriterion("faceRec is not null");
            return (Criteria) this;
        }

        public Criteria andFacerecEqualTo(Integer value) {
            addCriterion("faceRec =", value, "facerec");
            return (Criteria) this;
        }

        public Criteria andFacerecNotEqualTo(Integer value) {
            addCriterion("faceRec <>", value, "facerec");
            return (Criteria) this;
        }

        public Criteria andFacerecGreaterThan(Integer value) {
            addCriterion("faceRec >", value, "facerec");
            return (Criteria) this;
        }

        public Criteria andFacerecGreaterThanOrEqualTo(Integer value) {
            addCriterion("faceRec >=", value, "facerec");
            return (Criteria) this;
        }

        public Criteria andFacerecLessThan(Integer value) {
            addCriterion("faceRec <", value, "facerec");
            return (Criteria) this;
        }

        public Criteria andFacerecLessThanOrEqualTo(Integer value) {
            addCriterion("faceRec <=", value, "facerec");
            return (Criteria) this;
        }

        public Criteria andFacerecIn(List<Integer> values) {
            addCriterion("faceRec in", values, "facerec");
            return (Criteria) this;
        }

        public Criteria andFacerecNotIn(List<Integer> values) {
            addCriterion("faceRec not in", values, "facerec");
            return (Criteria) this;
        }

        public Criteria andFacerecBetween(Integer value1, Integer value2) {
            addCriterion("faceRec between", value1, value2, "facerec");
            return (Criteria) this;
        }

        public Criteria andFacerecNotBetween(Integer value1, Integer value2) {
            addCriterion("faceRec not between", value1, value2, "facerec");
            return (Criteria) this;
        }

        public Criteria andScrfingerrecIsNull() {
            addCriterion("scrfingerRec is null");
            return (Criteria) this;
        }

        public Criteria andScrfingerrecIsNotNull() {
            addCriterion("scrfingerRec is not null");
            return (Criteria) this;
        }

        public Criteria andScrfingerrecEqualTo(Integer value) {
            addCriterion("scrfingerRec =", value, "scrfingerrec");
            return (Criteria) this;
        }

        public Criteria andScrfingerrecNotEqualTo(Integer value) {
            addCriterion("scrfingerRec <>", value, "scrfingerrec");
            return (Criteria) this;
        }

        public Criteria andScrfingerrecGreaterThan(Integer value) {
            addCriterion("scrfingerRec >", value, "scrfingerrec");
            return (Criteria) this;
        }

        public Criteria andScrfingerrecGreaterThanOrEqualTo(Integer value) {
            addCriterion("scrfingerRec >=", value, "scrfingerrec");
            return (Criteria) this;
        }

        public Criteria andScrfingerrecLessThan(Integer value) {
            addCriterion("scrfingerRec <", value, "scrfingerrec");
            return (Criteria) this;
        }

        public Criteria andScrfingerrecLessThanOrEqualTo(Integer value) {
            addCriterion("scrfingerRec <=", value, "scrfingerrec");
            return (Criteria) this;
        }

        public Criteria andScrfingerrecIn(List<Integer> values) {
            addCriterion("scrfingerRec in", values, "scrfingerrec");
            return (Criteria) this;
        }

        public Criteria andScrfingerrecNotIn(List<Integer> values) {
            addCriterion("scrfingerRec not in", values, "scrfingerrec");
            return (Criteria) this;
        }

        public Criteria andScrfingerrecBetween(Integer value1, Integer value2) {
            addCriterion("scrfingerRec between", value1, value2, "scrfingerrec");
            return (Criteria) this;
        }

        public Criteria andScrfingerrecNotBetween(Integer value1, Integer value2) {
            addCriterion("scrfingerRec not between", value1, value2, "scrfingerrec");
            return (Criteria) this;
        }

        public Criteria andRearfingerrecIsNull() {
            addCriterion("rearfingerRec is null");
            return (Criteria) this;
        }

        public Criteria andRearfingerrecIsNotNull() {
            addCriterion("rearfingerRec is not null");
            return (Criteria) this;
        }

        public Criteria andRearfingerrecEqualTo(Integer value) {
            addCriterion("rearfingerRec =", value, "rearfingerrec");
            return (Criteria) this;
        }

        public Criteria andRearfingerrecNotEqualTo(Integer value) {
            addCriterion("rearfingerRec <>", value, "rearfingerrec");
            return (Criteria) this;
        }

        public Criteria andRearfingerrecGreaterThan(Integer value) {
            addCriterion("rearfingerRec >", value, "rearfingerrec");
            return (Criteria) this;
        }

        public Criteria andRearfingerrecGreaterThanOrEqualTo(Integer value) {
            addCriterion("rearfingerRec >=", value, "rearfingerrec");
            return (Criteria) this;
        }

        public Criteria andRearfingerrecLessThan(Integer value) {
            addCriterion("rearfingerRec <", value, "rearfingerrec");
            return (Criteria) this;
        }

        public Criteria andRearfingerrecLessThanOrEqualTo(Integer value) {
            addCriterion("rearfingerRec <=", value, "rearfingerrec");
            return (Criteria) this;
        }

        public Criteria andRearfingerrecIn(List<Integer> values) {
            addCriterion("rearfingerRec in", values, "rearfingerrec");
            return (Criteria) this;
        }

        public Criteria andRearfingerrecNotIn(List<Integer> values) {
            addCriterion("rearfingerRec not in", values, "rearfingerrec");
            return (Criteria) this;
        }

        public Criteria andRearfingerrecBetween(Integer value1, Integer value2) {
            addCriterion("rearfingerRec between", value1, value2, "rearfingerrec");
            return (Criteria) this;
        }

        public Criteria andRearfingerrecNotBetween(Integer value1, Integer value2) {
            addCriterion("rearfingerRec not between", value1, value2, "rearfingerrec");
            return (Criteria) this;
        }

        public Criteria andSidefingerrecIsNull() {
            addCriterion("sidefingerRec is null");
            return (Criteria) this;
        }

        public Criteria andSidefingerrecIsNotNull() {
            addCriterion("sidefingerRec is not null");
            return (Criteria) this;
        }

        public Criteria andSidefingerrecEqualTo(Integer value) {
            addCriterion("sidefingerRec =", value, "sidefingerrec");
            return (Criteria) this;
        }

        public Criteria andSidefingerrecNotEqualTo(Integer value) {
            addCriterion("sidefingerRec <>", value, "sidefingerrec");
            return (Criteria) this;
        }

        public Criteria andSidefingerrecGreaterThan(Integer value) {
            addCriterion("sidefingerRec >", value, "sidefingerrec");
            return (Criteria) this;
        }

        public Criteria andSidefingerrecGreaterThanOrEqualTo(Integer value) {
            addCriterion("sidefingerRec >=", value, "sidefingerrec");
            return (Criteria) this;
        }

        public Criteria andSidefingerrecLessThan(Integer value) {
            addCriterion("sidefingerRec <", value, "sidefingerrec");
            return (Criteria) this;
        }

        public Criteria andSidefingerrecLessThanOrEqualTo(Integer value) {
            addCriterion("sidefingerRec <=", value, "sidefingerrec");
            return (Criteria) this;
        }

        public Criteria andSidefingerrecIn(List<Integer> values) {
            addCriterion("sidefingerRec in", values, "sidefingerrec");
            return (Criteria) this;
        }

        public Criteria andSidefingerrecNotIn(List<Integer> values) {
            addCriterion("sidefingerRec not in", values, "sidefingerrec");
            return (Criteria) this;
        }

        public Criteria andSidefingerrecBetween(Integer value1, Integer value2) {
            addCriterion("sidefingerRec between", value1, value2, "sidefingerrec");
            return (Criteria) this;
        }

        public Criteria andSidefingerrecNotBetween(Integer value1, Integer value2) {
            addCriterion("sidefingerRec not between", value1, value2, "sidefingerrec");
            return (Criteria) this;
        }

        public Criteria andFrontfingerrecIsNull() {
            addCriterion("frontfingerRec is null");
            return (Criteria) this;
        }

        public Criteria andFrontfingerrecIsNotNull() {
            addCriterion("frontfingerRec is not null");
            return (Criteria) this;
        }

        public Criteria andFrontfingerrecEqualTo(Integer value) {
            addCriterion("frontfingerRec =", value, "frontfingerrec");
            return (Criteria) this;
        }

        public Criteria andFrontfingerrecNotEqualTo(Integer value) {
            addCriterion("frontfingerRec <>", value, "frontfingerrec");
            return (Criteria) this;
        }

        public Criteria andFrontfingerrecGreaterThan(Integer value) {
            addCriterion("frontfingerRec >", value, "frontfingerrec");
            return (Criteria) this;
        }

        public Criteria andFrontfingerrecGreaterThanOrEqualTo(Integer value) {
            addCriterion("frontfingerRec >=", value, "frontfingerrec");
            return (Criteria) this;
        }

        public Criteria andFrontfingerrecLessThan(Integer value) {
            addCriterion("frontfingerRec <", value, "frontfingerrec");
            return (Criteria) this;
        }

        public Criteria andFrontfingerrecLessThanOrEqualTo(Integer value) {
            addCriterion("frontfingerRec <=", value, "frontfingerrec");
            return (Criteria) this;
        }

        public Criteria andFrontfingerrecIn(List<Integer> values) {
            addCriterion("frontfingerRec in", values, "frontfingerrec");
            return (Criteria) this;
        }

        public Criteria andFrontfingerrecNotIn(List<Integer> values) {
            addCriterion("frontfingerRec not in", values, "frontfingerrec");
            return (Criteria) this;
        }

        public Criteria andFrontfingerrecBetween(Integer value1, Integer value2) {
            addCriterion("frontfingerRec between", value1, value2, "frontfingerrec");
            return (Criteria) this;
        }

        public Criteria andFrontfingerrecNotBetween(Integer value1, Integer value2) {
            addCriterion("frontfingerRec not between", value1, value2, "frontfingerrec");
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