package com.cssnj.ywgl.domain.ywdm;

import java.util.ArrayList;
import java.util.List;

public class YwmkCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YwmkCriteria() {
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

        public Criteria andDmIsNull() {
            addCriterion("dm is null");
            return (Criteria) this;
        }

        public Criteria andDmIsNotNull() {
            addCriterion("dm is not null");
            return (Criteria) this;
        }

        public Criteria andDmEqualTo(String value) {
            addCriterion("dm =", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmNotEqualTo(String value) {
            addCriterion("dm <>", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmGreaterThan(String value) {
            addCriterion("dm >", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmGreaterThanOrEqualTo(String value) {
            addCriterion("dm >=", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmLessThan(String value) {
            addCriterion("dm <", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmLessThanOrEqualTo(String value) {
            addCriterion("dm <=", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmLike(String value) {
            addCriterion("dm like", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmNotLike(String value) {
            addCriterion("dm not like", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmIn(List<String> values) {
            addCriterion("dm in", values, "dm");
            return (Criteria) this;
        }

        public Criteria andDmNotIn(List<String> values) {
            addCriterion("dm not in", values, "dm");
            return (Criteria) this;
        }

        public Criteria andDmBetween(String value1, String value2) {
            addCriterion("dm between", value1, value2, "dm");
            return (Criteria) this;
        }

        public Criteria andDmNotBetween(String value1, String value2) {
            addCriterion("dm not between", value1, value2, "dm");
            return (Criteria) this;
        }

        public Criteria andMcIsNull() {
            addCriterion("mc is null");
            return (Criteria) this;
        }

        public Criteria andMcIsNotNull() {
            addCriterion("mc is not null");
            return (Criteria) this;
        }

        public Criteria andMcEqualTo(String value) {
            addCriterion("mc =", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotEqualTo(String value) {
            addCriterion("mc <>", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcGreaterThan(String value) {
            addCriterion("mc >", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcGreaterThanOrEqualTo(String value) {
            addCriterion("mc >=", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLessThan(String value) {
            addCriterion("mc <", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLessThanOrEqualTo(String value) {
            addCriterion("mc <=", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLike(String value) {
            addCriterion("mc like", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotLike(String value) {
            addCriterion("mc not like", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcIn(List<String> values) {
            addCriterion("mc in", values, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotIn(List<String> values) {
            addCriterion("mc not in", values, "mc");
            return (Criteria) this;
        }

        public Criteria andMcBetween(String value1, String value2) {
            addCriterion("mc between", value1, value2, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotBetween(String value1, String value2) {
            addCriterion("mc not between", value1, value2, "mc");
            return (Criteria) this;
        }

        public Criteria andYyxtDmIsNull() {
            addCriterion("yyxt_dm is null");
            return (Criteria) this;
        }

        public Criteria andYyxtDmIsNotNull() {
            addCriterion("yyxt_dm is not null");
            return (Criteria) this;
        }

        public Criteria andYyxtDmEqualTo(String value) {
            addCriterion("yyxt_dm =", value, "yyxtDm");
            return (Criteria) this;
        }

        public Criteria andYyxtDmNotEqualTo(String value) {
            addCriterion("yyxt_dm <>", value, "yyxtDm");
            return (Criteria) this;
        }

        public Criteria andYyxtDmGreaterThan(String value) {
            addCriterion("yyxt_dm >", value, "yyxtDm");
            return (Criteria) this;
        }

        public Criteria andYyxtDmGreaterThanOrEqualTo(String value) {
            addCriterion("yyxt_dm >=", value, "yyxtDm");
            return (Criteria) this;
        }

        public Criteria andYyxtDmLessThan(String value) {
            addCriterion("yyxt_dm <", value, "yyxtDm");
            return (Criteria) this;
        }

        public Criteria andYyxtDmLessThanOrEqualTo(String value) {
            addCriterion("yyxt_dm <=", value, "yyxtDm");
            return (Criteria) this;
        }

        public Criteria andYyxtDmLike(String value) {
            addCriterion("yyxt_dm like", value, "yyxtDm");
            return (Criteria) this;
        }

        public Criteria andYyxtDmNotLike(String value) {
            addCriterion("yyxt_dm not like", value, "yyxtDm");
            return (Criteria) this;
        }

        public Criteria andYyxtDmIn(List<String> values) {
            addCriterion("yyxt_dm in", values, "yyxtDm");
            return (Criteria) this;
        }

        public Criteria andYyxtDmNotIn(List<String> values) {
            addCriterion("yyxt_dm not in", values, "yyxtDm");
            return (Criteria) this;
        }

        public Criteria andYyxtDmBetween(String value1, String value2) {
            addCriterion("yyxt_dm between", value1, value2, "yyxtDm");
            return (Criteria) this;
        }

        public Criteria andYyxtDmNotBetween(String value1, String value2) {
            addCriterion("yyxt_dm not between", value1, value2, "yyxtDm");
            return (Criteria) this;
        }

        public Criteria andYxbzIsNull() {
            addCriterion("yxbz is null");
            return (Criteria) this;
        }

        public Criteria andYxbzIsNotNull() {
            addCriterion("yxbz is not null");
            return (Criteria) this;
        }

        public Criteria andYxbzEqualTo(String value) {
            addCriterion("yxbz =", value, "yxbz");
            return (Criteria) this;
        }

        public Criteria andYxbzNotEqualTo(String value) {
            addCriterion("yxbz <>", value, "yxbz");
            return (Criteria) this;
        }

        public Criteria andYxbzGreaterThan(String value) {
            addCriterion("yxbz >", value, "yxbz");
            return (Criteria) this;
        }

        public Criteria andYxbzGreaterThanOrEqualTo(String value) {
            addCriterion("yxbz >=", value, "yxbz");
            return (Criteria) this;
        }

        public Criteria andYxbzLessThan(String value) {
            addCriterion("yxbz <", value, "yxbz");
            return (Criteria) this;
        }

        public Criteria andYxbzLessThanOrEqualTo(String value) {
            addCriterion("yxbz <=", value, "yxbz");
            return (Criteria) this;
        }

        public Criteria andYxbzLike(String value) {
            addCriterion("yxbz like", value, "yxbz");
            return (Criteria) this;
        }

        public Criteria andYxbzNotLike(String value) {
            addCriterion("yxbz not like", value, "yxbz");
            return (Criteria) this;
        }

        public Criteria andYxbzIn(List<String> values) {
            addCriterion("yxbz in", values, "yxbz");
            return (Criteria) this;
        }

        public Criteria andYxbzNotIn(List<String> values) {
            addCriterion("yxbz not in", values, "yxbz");
            return (Criteria) this;
        }

        public Criteria andYxbzBetween(String value1, String value2) {
            addCriterion("yxbz between", value1, value2, "yxbz");
            return (Criteria) this;
        }

        public Criteria andYxbzNotBetween(String value1, String value2) {
            addCriterion("yxbz not between", value1, value2, "yxbz");
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