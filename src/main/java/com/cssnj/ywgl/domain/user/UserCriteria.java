package com.cssnj.ywgl.domain.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andXmIsNull() {
            addCriterion("xm is null");
            return (Criteria) this;
        }

        public Criteria andXmIsNotNull() {
            addCriterion("xm is not null");
            return (Criteria) this;
        }

        public Criteria andXmEqualTo(String value) {
            addCriterion("xm =", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotEqualTo(String value) {
            addCriterion("xm <>", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThan(String value) {
            addCriterion("xm >", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThanOrEqualTo(String value) {
            addCriterion("xm >=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThan(String value) {
            addCriterion("xm <", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThanOrEqualTo(String value) {
            addCriterion("xm <=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLike(String value) {
            addCriterion("xm like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotLike(String value) {
            addCriterion("xm not like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmIn(List<String> values) {
            addCriterion("xm in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotIn(List<String> values) {
            addCriterion("xm not in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmBetween(String value1, String value2) {
            addCriterion("xm between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotBetween(String value1, String value2) {
            addCriterion("xm not between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXbIsNull() {
            addCriterion("xb is null");
            return (Criteria) this;
        }

        public Criteria andXbIsNotNull() {
            addCriterion("xb is not null");
            return (Criteria) this;
        }

        public Criteria andXbEqualTo(String value) {
            addCriterion("xb =", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotEqualTo(String value) {
            addCriterion("xb <>", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThan(String value) {
            addCriterion("xb >", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThanOrEqualTo(String value) {
            addCriterion("xb >=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThan(String value) {
            addCriterion("xb <", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThanOrEqualTo(String value) {
            addCriterion("xb <=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLike(String value) {
            addCriterion("xb like", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotLike(String value) {
            addCriterion("xb not like", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbIn(List<String> values) {
            addCriterion("xb in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotIn(List<String> values) {
            addCriterion("xb not in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbBetween(String value1, String value2) {
            addCriterion("xb between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotBetween(String value1, String value2) {
            addCriterion("xb not between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andCsrqIsNull() {
            addCriterion("csrq is null");
            return (Criteria) this;
        }

        public Criteria andCsrqIsNotNull() {
            addCriterion("csrq is not null");
            return (Criteria) this;
        }

        public Criteria andCsrqEqualTo(Date value) {
            addCriterionForJDBCDate("csrq =", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("csrq <>", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqGreaterThan(Date value) {
            addCriterionForJDBCDate("csrq >", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("csrq >=", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLessThan(Date value) {
            addCriterionForJDBCDate("csrq <", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("csrq <=", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqIn(List<Date> values) {
            addCriterionForJDBCDate("csrq in", values, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("csrq not in", values, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("csrq between", value1, value2, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("csrq not between", value1, value2, "csrq");
            return (Criteria) this;
        }

        public Criteria andYddhIsNull() {
            addCriterion("yddh is null");
            return (Criteria) this;
        }

        public Criteria andYddhIsNotNull() {
            addCriterion("yddh is not null");
            return (Criteria) this;
        }

        public Criteria andYddhEqualTo(String value) {
            addCriterion("yddh =", value, "yddh");
            return (Criteria) this;
        }

        public Criteria andYddhNotEqualTo(String value) {
            addCriterion("yddh <>", value, "yddh");
            return (Criteria) this;
        }

        public Criteria andYddhGreaterThan(String value) {
            addCriterion("yddh >", value, "yddh");
            return (Criteria) this;
        }

        public Criteria andYddhGreaterThanOrEqualTo(String value) {
            addCriterion("yddh >=", value, "yddh");
            return (Criteria) this;
        }

        public Criteria andYddhLessThan(String value) {
            addCriterion("yddh <", value, "yddh");
            return (Criteria) this;
        }

        public Criteria andYddhLessThanOrEqualTo(String value) {
            addCriterion("yddh <=", value, "yddh");
            return (Criteria) this;
        }

        public Criteria andYddhLike(String value) {
            addCriterion("yddh like", value, "yddh");
            return (Criteria) this;
        }

        public Criteria andYddhNotLike(String value) {
            addCriterion("yddh not like", value, "yddh");
            return (Criteria) this;
        }

        public Criteria andYddhIn(List<String> values) {
            addCriterion("yddh in", values, "yddh");
            return (Criteria) this;
        }

        public Criteria andYddhNotIn(List<String> values) {
            addCriterion("yddh not in", values, "yddh");
            return (Criteria) this;
        }

        public Criteria andYddhBetween(String value1, String value2) {
            addCriterion("yddh between", value1, value2, "yddh");
            return (Criteria) this;
        }

        public Criteria andYddhNotBetween(String value1, String value2) {
            addCriterion("yddh not between", value1, value2, "yddh");
            return (Criteria) this;
        }

        public Criteria andGddhIsNull() {
            addCriterion("gddh is null");
            return (Criteria) this;
        }

        public Criteria andGddhIsNotNull() {
            addCriterion("gddh is not null");
            return (Criteria) this;
        }

        public Criteria andGddhEqualTo(String value) {
            addCriterion("gddh =", value, "gddh");
            return (Criteria) this;
        }

        public Criteria andGddhNotEqualTo(String value) {
            addCriterion("gddh <>", value, "gddh");
            return (Criteria) this;
        }

        public Criteria andGddhGreaterThan(String value) {
            addCriterion("gddh >", value, "gddh");
            return (Criteria) this;
        }

        public Criteria andGddhGreaterThanOrEqualTo(String value) {
            addCriterion("gddh >=", value, "gddh");
            return (Criteria) this;
        }

        public Criteria andGddhLessThan(String value) {
            addCriterion("gddh <", value, "gddh");
            return (Criteria) this;
        }

        public Criteria andGddhLessThanOrEqualTo(String value) {
            addCriterion("gddh <=", value, "gddh");
            return (Criteria) this;
        }

        public Criteria andGddhLike(String value) {
            addCriterion("gddh like", value, "gddh");
            return (Criteria) this;
        }

        public Criteria andGddhNotLike(String value) {
            addCriterion("gddh not like", value, "gddh");
            return (Criteria) this;
        }

        public Criteria andGddhIn(List<String> values) {
            addCriterion("gddh in", values, "gddh");
            return (Criteria) this;
        }

        public Criteria andGddhNotIn(List<String> values) {
            addCriterion("gddh not in", values, "gddh");
            return (Criteria) this;
        }

        public Criteria andGddhBetween(String value1, String value2) {
            addCriterion("gddh between", value1, value2, "gddh");
            return (Criteria) this;
        }

        public Criteria andGddhNotBetween(String value1, String value2) {
            addCriterion("gddh not between", value1, value2, "gddh");
            return (Criteria) this;
        }

        public Criteria andDzyxIsNull() {
            addCriterion("dzyx is null");
            return (Criteria) this;
        }

        public Criteria andDzyxIsNotNull() {
            addCriterion("dzyx is not null");
            return (Criteria) this;
        }

        public Criteria andDzyxEqualTo(String value) {
            addCriterion("dzyx =", value, "dzyx");
            return (Criteria) this;
        }

        public Criteria andDzyxNotEqualTo(String value) {
            addCriterion("dzyx <>", value, "dzyx");
            return (Criteria) this;
        }

        public Criteria andDzyxGreaterThan(String value) {
            addCriterion("dzyx >", value, "dzyx");
            return (Criteria) this;
        }

        public Criteria andDzyxGreaterThanOrEqualTo(String value) {
            addCriterion("dzyx >=", value, "dzyx");
            return (Criteria) this;
        }

        public Criteria andDzyxLessThan(String value) {
            addCriterion("dzyx <", value, "dzyx");
            return (Criteria) this;
        }

        public Criteria andDzyxLessThanOrEqualTo(String value) {
            addCriterion("dzyx <=", value, "dzyx");
            return (Criteria) this;
        }

        public Criteria andDzyxLike(String value) {
            addCriterion("dzyx like", value, "dzyx");
            return (Criteria) this;
        }

        public Criteria andDzyxNotLike(String value) {
            addCriterion("dzyx not like", value, "dzyx");
            return (Criteria) this;
        }

        public Criteria andDzyxIn(List<String> values) {
            addCriterion("dzyx in", values, "dzyx");
            return (Criteria) this;
        }

        public Criteria andDzyxNotIn(List<String> values) {
            addCriterion("dzyx not in", values, "dzyx");
            return (Criteria) this;
        }

        public Criteria andDzyxBetween(String value1, String value2) {
            addCriterion("dzyx between", value1, value2, "dzyx");
            return (Criteria) this;
        }

        public Criteria andDzyxNotBetween(String value1, String value2) {
            addCriterion("dzyx not between", value1, value2, "dzyx");
            return (Criteria) this;
        }

        public Criteria andLxIsNull() {
            addCriterion("lx is null");
            return (Criteria) this;
        }

        public Criteria andLxIsNotNull() {
            addCriterion("lx is not null");
            return (Criteria) this;
        }

        public Criteria andLxEqualTo(String value) {
            addCriterion("lx =", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotEqualTo(String value) {
            addCriterion("lx <>", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxGreaterThan(String value) {
            addCriterion("lx >", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxGreaterThanOrEqualTo(String value) {
            addCriterion("lx >=", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxLessThan(String value) {
            addCriterion("lx <", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxLessThanOrEqualTo(String value) {
            addCriterion("lx <=", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxLike(String value) {
            addCriterion("lx like", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotLike(String value) {
            addCriterion("lx not like", value, "lx");
            return (Criteria) this;
        }

        public Criteria andLxIn(List<String> values) {
            addCriterion("lx in", values, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotIn(List<String> values) {
            addCriterion("lx not in", values, "lx");
            return (Criteria) this;
        }

        public Criteria andLxBetween(String value1, String value2) {
            addCriterion("lx between", value1, value2, "lx");
            return (Criteria) this;
        }

        public Criteria andLxNotBetween(String value1, String value2) {
            addCriterion("lx not between", value1, value2, "lx");
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