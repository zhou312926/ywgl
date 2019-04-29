package com.cssnj.ywgl.domain.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserNoticeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserNoticeCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andYhIdIsNull() {
            addCriterion("yh_id is null");
            return (Criteria) this;
        }

        public Criteria andYhIdIsNotNull() {
            addCriterion("yh_id is not null");
            return (Criteria) this;
        }

        public Criteria andYhIdEqualTo(String value) {
            addCriterion("yh_id =", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdNotEqualTo(String value) {
            addCriterion("yh_id <>", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdGreaterThan(String value) {
            addCriterion("yh_id >", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdGreaterThanOrEqualTo(String value) {
            addCriterion("yh_id >=", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdLessThan(String value) {
            addCriterion("yh_id <", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdLessThanOrEqualTo(String value) {
            addCriterion("yh_id <=", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdLike(String value) {
            addCriterion("yh_id like", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdNotLike(String value) {
            addCriterion("yh_id not like", value, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdIn(List<String> values) {
            addCriterion("yh_id in", values, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdNotIn(List<String> values) {
            addCriterion("yh_id not in", values, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdBetween(String value1, String value2) {
            addCriterion("yh_id between", value1, value2, "yhId");
            return (Criteria) this;
        }

        public Criteria andYhIdNotBetween(String value1, String value2) {
            addCriterion("yh_id not between", value1, value2, "yhId");
            return (Criteria) this;
        }

        public Criteria andTzggIdIsNull() {
            addCriterion("tzgg_id is null");
            return (Criteria) this;
        }

        public Criteria andTzggIdIsNotNull() {
            addCriterion("tzgg_id is not null");
            return (Criteria) this;
        }

        public Criteria andTzggIdEqualTo(String value) {
            addCriterion("tzgg_id =", value, "tzggId");
            return (Criteria) this;
        }

        public Criteria andTzggIdNotEqualTo(String value) {
            addCriterion("tzgg_id <>", value, "tzggId");
            return (Criteria) this;
        }

        public Criteria andTzggIdGreaterThan(String value) {
            addCriterion("tzgg_id >", value, "tzggId");
            return (Criteria) this;
        }

        public Criteria andTzggIdGreaterThanOrEqualTo(String value) {
            addCriterion("tzgg_id >=", value, "tzggId");
            return (Criteria) this;
        }

        public Criteria andTzggIdLessThan(String value) {
            addCriterion("tzgg_id <", value, "tzggId");
            return (Criteria) this;
        }

        public Criteria andTzggIdLessThanOrEqualTo(String value) {
            addCriterion("tzgg_id <=", value, "tzggId");
            return (Criteria) this;
        }

        public Criteria andTzggIdLike(String value) {
            addCriterion("tzgg_id like", value, "tzggId");
            return (Criteria) this;
        }

        public Criteria andTzggIdNotLike(String value) {
            addCriterion("tzgg_id not like", value, "tzggId");
            return (Criteria) this;
        }

        public Criteria andTzggIdIn(List<String> values) {
            addCriterion("tzgg_id in", values, "tzggId");
            return (Criteria) this;
        }

        public Criteria andTzggIdNotIn(List<String> values) {
            addCriterion("tzgg_id not in", values, "tzggId");
            return (Criteria) this;
        }

        public Criteria andTzggIdBetween(String value1, String value2) {
            addCriterion("tzgg_id between", value1, value2, "tzggId");
            return (Criteria) this;
        }

        public Criteria andTzggIdNotBetween(String value1, String value2) {
            addCriterion("tzgg_id not between", value1, value2, "tzggId");
            return (Criteria) this;
        }

        public Criteria andQrbzIsNull() {
            addCriterion("qrbz is null");
            return (Criteria) this;
        }

        public Criteria andQrbzIsNotNull() {
            addCriterion("qrbz is not null");
            return (Criteria) this;
        }

        public Criteria andQrbzEqualTo(String value) {
            addCriterion("qrbz =", value, "qrbz");
            return (Criteria) this;
        }

        public Criteria andQrbzNotEqualTo(String value) {
            addCriterion("qrbz <>", value, "qrbz");
            return (Criteria) this;
        }

        public Criteria andQrbzGreaterThan(String value) {
            addCriterion("qrbz >", value, "qrbz");
            return (Criteria) this;
        }

        public Criteria andQrbzGreaterThanOrEqualTo(String value) {
            addCriterion("qrbz >=", value, "qrbz");
            return (Criteria) this;
        }

        public Criteria andQrbzLessThan(String value) {
            addCriterion("qrbz <", value, "qrbz");
            return (Criteria) this;
        }

        public Criteria andQrbzLessThanOrEqualTo(String value) {
            addCriterion("qrbz <=", value, "qrbz");
            return (Criteria) this;
        }

        public Criteria andQrbzLike(String value) {
            addCriterion("qrbz like", value, "qrbz");
            return (Criteria) this;
        }

        public Criteria andQrbzNotLike(String value) {
            addCriterion("qrbz not like", value, "qrbz");
            return (Criteria) this;
        }

        public Criteria andQrbzIn(List<String> values) {
            addCriterion("qrbz in", values, "qrbz");
            return (Criteria) this;
        }

        public Criteria andQrbzNotIn(List<String> values) {
            addCriterion("qrbz not in", values, "qrbz");
            return (Criteria) this;
        }

        public Criteria andQrbzBetween(String value1, String value2) {
            addCriterion("qrbz between", value1, value2, "qrbz");
            return (Criteria) this;
        }

        public Criteria andQrbzNotBetween(String value1, String value2) {
            addCriterion("qrbz not between", value1, value2, "qrbz");
            return (Criteria) this;
        }

        public Criteria andLrryIsNull() {
            addCriterion("lrry is null");
            return (Criteria) this;
        }

        public Criteria andLrryIsNotNull() {
            addCriterion("lrry is not null");
            return (Criteria) this;
        }

        public Criteria andLrryEqualTo(String value) {
            addCriterion("lrry =", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryNotEqualTo(String value) {
            addCriterion("lrry <>", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryGreaterThan(String value) {
            addCriterion("lrry >", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryGreaterThanOrEqualTo(String value) {
            addCriterion("lrry >=", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryLessThan(String value) {
            addCriterion("lrry <", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryLessThanOrEqualTo(String value) {
            addCriterion("lrry <=", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryLike(String value) {
            addCriterion("lrry like", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryNotLike(String value) {
            addCriterion("lrry not like", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryIn(List<String> values) {
            addCriterion("lrry in", values, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryNotIn(List<String> values) {
            addCriterion("lrry not in", values, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryBetween(String value1, String value2) {
            addCriterion("lrry between", value1, value2, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryNotBetween(String value1, String value2) {
            addCriterion("lrry not between", value1, value2, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrsjIsNull() {
            addCriterion("lrsj is null");
            return (Criteria) this;
        }

        public Criteria andLrsjIsNotNull() {
            addCriterion("lrsj is not null");
            return (Criteria) this;
        }

        public Criteria andLrsjEqualTo(Date value) {
            addCriterion("lrsj =", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjNotEqualTo(Date value) {
            addCriterion("lrsj <>", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjGreaterThan(Date value) {
            addCriterion("lrsj >", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjGreaterThanOrEqualTo(Date value) {
            addCriterion("lrsj >=", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjLessThan(Date value) {
            addCriterion("lrsj <", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjLessThanOrEqualTo(Date value) {
            addCriterion("lrsj <=", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjIn(List<Date> values) {
            addCriterion("lrsj in", values, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjNotIn(List<Date> values) {
            addCriterion("lrsj not in", values, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjBetween(Date value1, Date value2) {
            addCriterion("lrsj between", value1, value2, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjNotBetween(Date value1, Date value2) {
            addCriterion("lrsj not between", value1, value2, "lrsj");
            return (Criteria) this;
        }

        public Criteria andXgryIsNull() {
            addCriterion("xgry is null");
            return (Criteria) this;
        }

        public Criteria andXgryIsNotNull() {
            addCriterion("xgry is not null");
            return (Criteria) this;
        }

        public Criteria andXgryEqualTo(String value) {
            addCriterion("xgry =", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryNotEqualTo(String value) {
            addCriterion("xgry <>", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryGreaterThan(String value) {
            addCriterion("xgry >", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryGreaterThanOrEqualTo(String value) {
            addCriterion("xgry >=", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryLessThan(String value) {
            addCriterion("xgry <", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryLessThanOrEqualTo(String value) {
            addCriterion("xgry <=", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryLike(String value) {
            addCriterion("xgry like", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryNotLike(String value) {
            addCriterion("xgry not like", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryIn(List<String> values) {
            addCriterion("xgry in", values, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryNotIn(List<String> values) {
            addCriterion("xgry not in", values, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryBetween(String value1, String value2) {
            addCriterion("xgry between", value1, value2, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryNotBetween(String value1, String value2) {
            addCriterion("xgry not between", value1, value2, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgsjIsNull() {
            addCriterion("xgsj is null");
            return (Criteria) this;
        }

        public Criteria andXgsjIsNotNull() {
            addCriterion("xgsj is not null");
            return (Criteria) this;
        }

        public Criteria andXgsjEqualTo(Date value) {
            addCriterion("xgsj =", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjNotEqualTo(Date value) {
            addCriterion("xgsj <>", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjGreaterThan(Date value) {
            addCriterion("xgsj >", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjGreaterThanOrEqualTo(Date value) {
            addCriterion("xgsj >=", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjLessThan(Date value) {
            addCriterion("xgsj <", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjLessThanOrEqualTo(Date value) {
            addCriterion("xgsj <=", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjIn(List<Date> values) {
            addCriterion("xgsj in", values, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjNotIn(List<Date> values) {
            addCriterion("xgsj not in", values, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjBetween(Date value1, Date value2) {
            addCriterion("xgsj between", value1, value2, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjNotBetween(Date value1, Date value2) {
            addCriterion("xgsj not between", value1, value2, "xgsj");
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