package com.jf.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class ScreenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScreenExample() {
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

        public Criteria andScreennameIsNull() {
            addCriterion("screenName is null");
            return (Criteria) this;
        }

        public Criteria andScreennameIsNotNull() {
            addCriterion("screenName is not null");
            return (Criteria) this;
        }

        public Criteria andScreennameEqualTo(String value) {
            addCriterion("screenName =", value, "screenname");
            return (Criteria) this;
        }

        public Criteria andScreennameNotEqualTo(String value) {
            addCriterion("screenName <>", value, "screenname");
            return (Criteria) this;
        }

        public Criteria andScreennameGreaterThan(String value) {
            addCriterion("screenName >", value, "screenname");
            return (Criteria) this;
        }

        public Criteria andScreennameGreaterThanOrEqualTo(String value) {
            addCriterion("screenName >=", value, "screenname");
            return (Criteria) this;
        }

        public Criteria andScreennameLessThan(String value) {
            addCriterion("screenName <", value, "screenname");
            return (Criteria) this;
        }

        public Criteria andScreennameLessThanOrEqualTo(String value) {
            addCriterion("screenName <=", value, "screenname");
            return (Criteria) this;
        }

        public Criteria andScreennameLike(String value) {
            addCriterion("screenName like", value, "screenname");
            return (Criteria) this;
        }

        public Criteria andScreennameNotLike(String value) {
            addCriterion("screenName not like", value, "screenname");
            return (Criteria) this;
        }

        public Criteria andScreennameIn(List<String> values) {
            addCriterion("screenName in", values, "screenname");
            return (Criteria) this;
        }

        public Criteria andScreennameNotIn(List<String> values) {
            addCriterion("screenName not in", values, "screenname");
            return (Criteria) this;
        }

        public Criteria andScreennameBetween(String value1, String value2) {
            addCriterion("screenName between", value1, value2, "screenname");
            return (Criteria) this;
        }

        public Criteria andScreennameNotBetween(String value1, String value2) {
            addCriterion("screenName not between", value1, value2, "screenname");
            return (Criteria) this;
        }

        public Criteria andScreensizeIsNull() {
            addCriterion("screenSize is null");
            return (Criteria) this;
        }

        public Criteria andScreensizeIsNotNull() {
            addCriterion("screenSize is not null");
            return (Criteria) this;
        }

        public Criteria andScreensizeEqualTo(String value) {
            addCriterion("screenSize =", value, "screensize");
            return (Criteria) this;
        }

        public Criteria andScreensizeNotEqualTo(String value) {
            addCriterion("screenSize <>", value, "screensize");
            return (Criteria) this;
        }

        public Criteria andScreensizeGreaterThan(String value) {
            addCriterion("screenSize >", value, "screensize");
            return (Criteria) this;
        }

        public Criteria andScreensizeGreaterThanOrEqualTo(String value) {
            addCriterion("screenSize >=", value, "screensize");
            return (Criteria) this;
        }

        public Criteria andScreensizeLessThan(String value) {
            addCriterion("screenSize <", value, "screensize");
            return (Criteria) this;
        }

        public Criteria andScreensizeLessThanOrEqualTo(String value) {
            addCriterion("screenSize <=", value, "screensize");
            return (Criteria) this;
        }

        public Criteria andScreensizeLike(String value) {
            addCriterion("screenSize like", value, "screensize");
            return (Criteria) this;
        }

        public Criteria andScreensizeNotLike(String value) {
            addCriterion("screenSize not like", value, "screensize");
            return (Criteria) this;
        }

        public Criteria andScreensizeIn(List<String> values) {
            addCriterion("screenSize in", values, "screensize");
            return (Criteria) this;
        }

        public Criteria andScreensizeNotIn(List<String> values) {
            addCriterion("screenSize not in", values, "screensize");
            return (Criteria) this;
        }

        public Criteria andScreensizeBetween(String value1, String value2) {
            addCriterion("screenSize between", value1, value2, "screensize");
            return (Criteria) this;
        }

        public Criteria andScreensizeNotBetween(String value1, String value2) {
            addCriterion("screenSize not between", value1, value2, "screensize");
            return (Criteria) this;
        }

        public Criteria andResolutionIsNull() {
            addCriterion("resolution is null");
            return (Criteria) this;
        }

        public Criteria andResolutionIsNotNull() {
            addCriterion("resolution is not null");
            return (Criteria) this;
        }

        public Criteria andResolutionEqualTo(String value) {
            addCriterion("resolution =", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotEqualTo(String value) {
            addCriterion("resolution <>", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionGreaterThan(String value) {
            addCriterion("resolution >", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionGreaterThanOrEqualTo(String value) {
            addCriterion("resolution >=", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionLessThan(String value) {
            addCriterion("resolution <", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionLessThanOrEqualTo(String value) {
            addCriterion("resolution <=", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionLike(String value) {
            addCriterion("resolution like", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotLike(String value) {
            addCriterion("resolution not like", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionIn(List<String> values) {
            addCriterion("resolution in", values, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotIn(List<String> values) {
            addCriterion("resolution not in", values, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionBetween(String value1, String value2) {
            addCriterion("resolution between", value1, value2, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotBetween(String value1, String value2) {
            addCriterion("resolution not between", value1, value2, "resolution");
            return (Criteria) this;
        }

        public Criteria andScreenoccIsNull() {
            addCriterion("screenOcc is null");
            return (Criteria) this;
        }

        public Criteria andScreenoccIsNotNull() {
            addCriterion("screenOcc is not null");
            return (Criteria) this;
        }

        public Criteria andScreenoccEqualTo(String value) {
            addCriterion("screenOcc =", value, "screenocc");
            return (Criteria) this;
        }

        public Criteria andScreenoccNotEqualTo(String value) {
            addCriterion("screenOcc <>", value, "screenocc");
            return (Criteria) this;
        }

        public Criteria andScreenoccGreaterThan(String value) {
            addCriterion("screenOcc >", value, "screenocc");
            return (Criteria) this;
        }

        public Criteria andScreenoccGreaterThanOrEqualTo(String value) {
            addCriterion("screenOcc >=", value, "screenocc");
            return (Criteria) this;
        }

        public Criteria andScreenoccLessThan(String value) {
            addCriterion("screenOcc <", value, "screenocc");
            return (Criteria) this;
        }

        public Criteria andScreenoccLessThanOrEqualTo(String value) {
            addCriterion("screenOcc <=", value, "screenocc");
            return (Criteria) this;
        }

        public Criteria andScreenoccLike(String value) {
            addCriterion("screenOcc like", value, "screenocc");
            return (Criteria) this;
        }

        public Criteria andScreenoccNotLike(String value) {
            addCriterion("screenOcc not like", value, "screenocc");
            return (Criteria) this;
        }

        public Criteria andScreenoccIn(List<String> values) {
            addCriterion("screenOcc in", values, "screenocc");
            return (Criteria) this;
        }

        public Criteria andScreenoccNotIn(List<String> values) {
            addCriterion("screenOcc not in", values, "screenocc");
            return (Criteria) this;
        }

        public Criteria andScreenoccBetween(String value1, String value2) {
            addCriterion("screenOcc between", value1, value2, "screenocc");
            return (Criteria) this;
        }

        public Criteria andScreenoccNotBetween(String value1, String value2) {
            addCriterion("screenOcc not between", value1, value2, "screenocc");
            return (Criteria) this;
        }

        public Criteria andScreenshapeIsNull() {
            addCriterion("screenShape is null");
            return (Criteria) this;
        }

        public Criteria andScreenshapeIsNotNull() {
            addCriterion("screenShape is not null");
            return (Criteria) this;
        }

        public Criteria andScreenshapeEqualTo(String value) {
            addCriterion("screenShape =", value, "screenshape");
            return (Criteria) this;
        }

        public Criteria andScreenshapeNotEqualTo(String value) {
            addCriterion("screenShape <>", value, "screenshape");
            return (Criteria) this;
        }

        public Criteria andScreenshapeGreaterThan(String value) {
            addCriterion("screenShape >", value, "screenshape");
            return (Criteria) this;
        }

        public Criteria andScreenshapeGreaterThanOrEqualTo(String value) {
            addCriterion("screenShape >=", value, "screenshape");
            return (Criteria) this;
        }

        public Criteria andScreenshapeLessThan(String value) {
            addCriterion("screenShape <", value, "screenshape");
            return (Criteria) this;
        }

        public Criteria andScreenshapeLessThanOrEqualTo(String value) {
            addCriterion("screenShape <=", value, "screenshape");
            return (Criteria) this;
        }

        public Criteria andScreenshapeLike(String value) {
            addCriterion("screenShape like", value, "screenshape");
            return (Criteria) this;
        }

        public Criteria andScreenshapeNotLike(String value) {
            addCriterion("screenShape not like", value, "screenshape");
            return (Criteria) this;
        }

        public Criteria andScreenshapeIn(List<String> values) {
            addCriterion("screenShape in", values, "screenshape");
            return (Criteria) this;
        }

        public Criteria andScreenshapeNotIn(List<String> values) {
            addCriterion("screenShape not in", values, "screenshape");
            return (Criteria) this;
        }

        public Criteria andScreenshapeBetween(String value1, String value2) {
            addCriterion("screenShape between", value1, value2, "screenshape");
            return (Criteria) this;
        }

        public Criteria andScreenshapeNotBetween(String value1, String value2) {
            addCriterion("screenShape not between", value1, value2, "screenshape");
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