package com.cssnj.ywgl.domain.ywfw;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YwjbCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YwjbCriteria() {
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

        public Criteria andBtIsNull() {
            addCriterion("bt is null");
            return (Criteria) this;
        }

        public Criteria andBtIsNotNull() {
            addCriterion("bt is not null");
            return (Criteria) this;
        }

        public Criteria andBtEqualTo(String value) {
            addCriterion("bt =", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtNotEqualTo(String value) {
            addCriterion("bt <>", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtGreaterThan(String value) {
            addCriterion("bt >", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtGreaterThanOrEqualTo(String value) {
            addCriterion("bt >=", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtLessThan(String value) {
            addCriterion("bt <", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtLessThanOrEqualTo(String value) {
            addCriterion("bt <=", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtLike(String value) {
            addCriterion("bt like", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtNotLike(String value) {
            addCriterion("bt not like", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtIn(List<String> values) {
            addCriterion("bt in", values, "bt");
            return (Criteria) this;
        }

        public Criteria andBtNotIn(List<String> values) {
            addCriterion("bt not in", values, "bt");
            return (Criteria) this;
        }

        public Criteria andBtBetween(String value1, String value2) {
            addCriterion("bt between", value1, value2, "bt");
            return (Criteria) this;
        }

        public Criteria andBtNotBetween(String value1, String value2) {
            addCriterion("bt not between", value1, value2, "bt");
            return (Criteria) this;
        }

        public Criteria andMsIsNull() {
            addCriterion("ms is null");
            return (Criteria) this;
        }

        public Criteria andMsIsNotNull() {
            addCriterion("ms is not null");
            return (Criteria) this;
        }

        public Criteria andMsEqualTo(String value) {
            addCriterion("ms =", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsNotEqualTo(String value) {
            addCriterion("ms <>", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsGreaterThan(String value) {
            addCriterion("ms >", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsGreaterThanOrEqualTo(String value) {
            addCriterion("ms >=", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsLessThan(String value) {
            addCriterion("ms <", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsLessThanOrEqualTo(String value) {
            addCriterion("ms <=", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsLike(String value) {
            addCriterion("ms like", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsNotLike(String value) {
            addCriterion("ms not like", value, "ms");
            return (Criteria) this;
        }

        public Criteria andMsIn(List<String> values) {
            addCriterion("ms in", values, "ms");
            return (Criteria) this;
        }

        public Criteria andMsNotIn(List<String> values) {
            addCriterion("ms not in", values, "ms");
            return (Criteria) this;
        }

        public Criteria andMsBetween(String value1, String value2) {
            addCriterion("ms between", value1, value2, "ms");
            return (Criteria) this;
        }

        public Criteria andMsNotBetween(String value1, String value2) {
            addCriterion("ms not between", value1, value2, "ms");
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

        public Criteria andJbnrIsNull() {
            addCriterion("jbnr is null");
            return (Criteria) this;
        }

        public Criteria andJbnrIsNotNull() {
            addCriterion("jbnr is not null");
            return (Criteria) this;
        }

        public Criteria andJbnrEqualTo(String value) {
            addCriterion("jbnr =", value, "jbnr");
            return (Criteria) this;
        }

        public Criteria andJbnrNotEqualTo(String value) {
            addCriterion("jbnr <>", value, "jbnr");
            return (Criteria) this;
        }

        public Criteria andJbnrGreaterThan(String value) {
            addCriterion("jbnr >", value, "jbnr");
            return (Criteria) this;
        }

        public Criteria andJbnrGreaterThanOrEqualTo(String value) {
            addCriterion("jbnr >=", value, "jbnr");
            return (Criteria) this;
        }

        public Criteria andJbnrLessThan(String value) {
            addCriterion("jbnr <", value, "jbnr");
            return (Criteria) this;
        }

        public Criteria andJbnrLessThanOrEqualTo(String value) {
            addCriterion("jbnr <=", value, "jbnr");
            return (Criteria) this;
        }

        public Criteria andJbnrLike(String value) {
            addCriterion("jbnr like", value, "jbnr");
            return (Criteria) this;
        }

        public Criteria andJbnrNotLike(String value) {
            addCriterion("jbnr not like", value, "jbnr");
            return (Criteria) this;
        }

        public Criteria andJbnrIn(List<String> values) {
            addCriterion("jbnr in", values, "jbnr");
            return (Criteria) this;
        }

        public Criteria andJbnrNotIn(List<String> values) {
            addCriterion("jbnr not in", values, "jbnr");
            return (Criteria) this;
        }

        public Criteria andJbnrBetween(String value1, String value2) {
            addCriterion("jbnr between", value1, value2, "jbnr");
            return (Criteria) this;
        }

        public Criteria andJbnrNotBetween(String value1, String value2) {
            addCriterion("jbnr not between", value1, value2, "jbnr");
            return (Criteria) this;
        }

        public Criteria andBmzbIdIsNull() {
            addCriterion("bmzb_id is null");
            return (Criteria) this;
        }

        public Criteria andBmzbIdIsNotNull() {
            addCriterion("bmzb_id is not null");
            return (Criteria) this;
        }

        public Criteria andBmzbIdEqualTo(String value) {
            addCriterion("bmzb_id =", value, "bmzbId");
            return (Criteria) this;
        }

        public Criteria andBmzbIdNotEqualTo(String value) {
            addCriterion("bmzb_id <>", value, "bmzbId");
            return (Criteria) this;
        }

        public Criteria andBmzbIdGreaterThan(String value) {
            addCriterion("bmzb_id >", value, "bmzbId");
            return (Criteria) this;
        }

        public Criteria andBmzbIdGreaterThanOrEqualTo(String value) {
            addCriterion("bmzb_id >=", value, "bmzbId");
            return (Criteria) this;
        }

        public Criteria andBmzbIdLessThan(String value) {
            addCriterion("bmzb_id <", value, "bmzbId");
            return (Criteria) this;
        }

        public Criteria andBmzbIdLessThanOrEqualTo(String value) {
            addCriterion("bmzb_id <=", value, "bmzbId");
            return (Criteria) this;
        }

        public Criteria andBmzbIdLike(String value) {
            addCriterion("bmzb_id like", value, "bmzbId");
            return (Criteria) this;
        }

        public Criteria andBmzbIdNotLike(String value) {
            addCriterion("bmzb_id not like", value, "bmzbId");
            return (Criteria) this;
        }

        public Criteria andBmzbIdIn(List<String> values) {
            addCriterion("bmzb_id in", values, "bmzbId");
            return (Criteria) this;
        }

        public Criteria andBmzbIdNotIn(List<String> values) {
            addCriterion("bmzb_id not in", values, "bmzbId");
            return (Criteria) this;
        }

        public Criteria andBmzbIdBetween(String value1, String value2) {
            addCriterion("bmzb_id between", value1, value2, "bmzbId");
            return (Criteria) this;
        }

        public Criteria andBmzbIdNotBetween(String value1, String value2) {
            addCriterion("bmzb_id not between", value1, value2, "bmzbId");
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