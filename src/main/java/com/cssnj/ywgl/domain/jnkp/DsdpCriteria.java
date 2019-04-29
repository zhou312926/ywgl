package com.cssnj.ywgl.domain.jnkp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DsdpCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsdpCriteria() {
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

        public Criteria andSsgxIdIsNull() {
            addCriterion("ssgx_id is null");
            return (Criteria) this;
        }

        public Criteria andSsgxIdIsNotNull() {
            addCriterion("ssgx_id is not null");
            return (Criteria) this;
        }

        public Criteria andSsgxIdEqualTo(String value) {
            addCriterion("ssgx_id =", value, "ssgxId");
            return (Criteria) this;
        }

        public Criteria andSsgxIdNotEqualTo(String value) {
            addCriterion("ssgx_id <>", value, "ssgxId");
            return (Criteria) this;
        }

        public Criteria andSsgxIdGreaterThan(String value) {
            addCriterion("ssgx_id >", value, "ssgxId");
            return (Criteria) this;
        }

        public Criteria andSsgxIdGreaterThanOrEqualTo(String value) {
            addCriterion("ssgx_id >=", value, "ssgxId");
            return (Criteria) this;
        }

        public Criteria andSsgxIdLessThan(String value) {
            addCriterion("ssgx_id <", value, "ssgxId");
            return (Criteria) this;
        }

        public Criteria andSsgxIdLessThanOrEqualTo(String value) {
            addCriterion("ssgx_id <=", value, "ssgxId");
            return (Criteria) this;
        }

        public Criteria andSsgxIdLike(String value) {
            addCriterion("ssgx_id like", value, "ssgxId");
            return (Criteria) this;
        }

        public Criteria andSsgxIdNotLike(String value) {
            addCriterion("ssgx_id not like", value, "ssgxId");
            return (Criteria) this;
        }

        public Criteria andSsgxIdIn(List<String> values) {
            addCriterion("ssgx_id in", values, "ssgxId");
            return (Criteria) this;
        }

        public Criteria andSsgxIdNotIn(List<String> values) {
            addCriterion("ssgx_id not in", values, "ssgxId");
            return (Criteria) this;
        }

        public Criteria andSsgxIdBetween(String value1, String value2) {
            addCriterion("ssgx_id between", value1, value2, "ssgxId");
            return (Criteria) this;
        }

        public Criteria andSsgxIdNotBetween(String value1, String value2) {
            addCriterion("ssgx_id not between", value1, value2, "ssgxId");
            return (Criteria) this;
        }

        public Criteria andGtnlpfIsNull() {
            addCriterion("gtnlpf is null");
            return (Criteria) this;
        }

        public Criteria andGtnlpfIsNotNull() {
            addCriterion("gtnlpf is not null");
            return (Criteria) this;
        }

        public Criteria andGtnlpfEqualTo(Float value) {
            addCriterion("gtnlpf =", value, "gtnlpf");
            return (Criteria) this;
        }

        public Criteria andGtnlpfNotEqualTo(Float value) {
            addCriterion("gtnlpf <>", value, "gtnlpf");
            return (Criteria) this;
        }

        public Criteria andGtnlpfGreaterThan(Float value) {
            addCriterion("gtnlpf >", value, "gtnlpf");
            return (Criteria) this;
        }

        public Criteria andGtnlpfGreaterThanOrEqualTo(Float value) {
            addCriterion("gtnlpf >=", value, "gtnlpf");
            return (Criteria) this;
        }

        public Criteria andGtnlpfLessThan(Float value) {
            addCriterion("gtnlpf <", value, "gtnlpf");
            return (Criteria) this;
        }

        public Criteria andGtnlpfLessThanOrEqualTo(Float value) {
            addCriterion("gtnlpf <=", value, "gtnlpf");
            return (Criteria) this;
        }

        public Criteria andGtnlpfIn(List<Float> values) {
            addCriterion("gtnlpf in", values, "gtnlpf");
            return (Criteria) this;
        }

        public Criteria andGtnlpfNotIn(List<Float> values) {
            addCriterion("gtnlpf not in", values, "gtnlpf");
            return (Criteria) this;
        }

        public Criteria andGtnlpfBetween(Float value1, Float value2) {
            addCriterion("gtnlpf between", value1, value2, "gtnlpf");
            return (Criteria) this;
        }

        public Criteria andGtnlpfNotBetween(Float value1, Float value2) {
            addCriterion("gtnlpf not between", value1, value2, "gtnlpf");
            return (Criteria) this;
        }

        public Criteria andGtnlpjIsNull() {
            addCriterion("gtnlpj is null");
            return (Criteria) this;
        }

        public Criteria andGtnlpjIsNotNull() {
            addCriterion("gtnlpj is not null");
            return (Criteria) this;
        }

        public Criteria andGtnlpjEqualTo(String value) {
            addCriterion("gtnlpj =", value, "gtnlpj");
            return (Criteria) this;
        }

        public Criteria andGtnlpjNotEqualTo(String value) {
            addCriterion("gtnlpj <>", value, "gtnlpj");
            return (Criteria) this;
        }

        public Criteria andGtnlpjGreaterThan(String value) {
            addCriterion("gtnlpj >", value, "gtnlpj");
            return (Criteria) this;
        }

        public Criteria andGtnlpjGreaterThanOrEqualTo(String value) {
            addCriterion("gtnlpj >=", value, "gtnlpj");
            return (Criteria) this;
        }

        public Criteria andGtnlpjLessThan(String value) {
            addCriterion("gtnlpj <", value, "gtnlpj");
            return (Criteria) this;
        }

        public Criteria andGtnlpjLessThanOrEqualTo(String value) {
            addCriterion("gtnlpj <=", value, "gtnlpj");
            return (Criteria) this;
        }

        public Criteria andGtnlpjLike(String value) {
            addCriterion("gtnlpj like", value, "gtnlpj");
            return (Criteria) this;
        }

        public Criteria andGtnlpjNotLike(String value) {
            addCriterion("gtnlpj not like", value, "gtnlpj");
            return (Criteria) this;
        }

        public Criteria andGtnlpjIn(List<String> values) {
            addCriterion("gtnlpj in", values, "gtnlpj");
            return (Criteria) this;
        }

        public Criteria andGtnlpjNotIn(List<String> values) {
            addCriterion("gtnlpj not in", values, "gtnlpj");
            return (Criteria) this;
        }

        public Criteria andGtnlpjBetween(String value1, String value2) {
            addCriterion("gtnlpj between", value1, value2, "gtnlpj");
            return (Criteria) this;
        }

        public Criteria andGtnlpjNotBetween(String value1, String value2) {
            addCriterion("gtnlpj not between", value1, value2, "gtnlpj");
            return (Criteria) this;
        }

        public Criteria andYwnlpfIsNull() {
            addCriterion("ywnlpf is null");
            return (Criteria) this;
        }

        public Criteria andYwnlpfIsNotNull() {
            addCriterion("ywnlpf is not null");
            return (Criteria) this;
        }

        public Criteria andYwnlpfEqualTo(Float value) {
            addCriterion("ywnlpf =", value, "ywnlpf");
            return (Criteria) this;
        }

        public Criteria andYwnlpfNotEqualTo(Float value) {
            addCriterion("ywnlpf <>", value, "ywnlpf");
            return (Criteria) this;
        }

        public Criteria andYwnlpfGreaterThan(Float value) {
            addCriterion("ywnlpf >", value, "ywnlpf");
            return (Criteria) this;
        }

        public Criteria andYwnlpfGreaterThanOrEqualTo(Float value) {
            addCriterion("ywnlpf >=", value, "ywnlpf");
            return (Criteria) this;
        }

        public Criteria andYwnlpfLessThan(Float value) {
            addCriterion("ywnlpf <", value, "ywnlpf");
            return (Criteria) this;
        }

        public Criteria andYwnlpfLessThanOrEqualTo(Float value) {
            addCriterion("ywnlpf <=", value, "ywnlpf");
            return (Criteria) this;
        }

        public Criteria andYwnlpfIn(List<Float> values) {
            addCriterion("ywnlpf in", values, "ywnlpf");
            return (Criteria) this;
        }

        public Criteria andYwnlpfNotIn(List<Float> values) {
            addCriterion("ywnlpf not in", values, "ywnlpf");
            return (Criteria) this;
        }

        public Criteria andYwnlpfBetween(Float value1, Float value2) {
            addCriterion("ywnlpf between", value1, value2, "ywnlpf");
            return (Criteria) this;
        }

        public Criteria andYwnlpfNotBetween(Float value1, Float value2) {
            addCriterion("ywnlpf not between", value1, value2, "ywnlpf");
            return (Criteria) this;
        }

        public Criteria andYwnlpjIsNull() {
            addCriterion("ywnlpj is null");
            return (Criteria) this;
        }

        public Criteria andYwnlpjIsNotNull() {
            addCriterion("ywnlpj is not null");
            return (Criteria) this;
        }

        public Criteria andYwnlpjEqualTo(String value) {
            addCriterion("ywnlpj =", value, "ywnlpj");
            return (Criteria) this;
        }

        public Criteria andYwnlpjNotEqualTo(String value) {
            addCriterion("ywnlpj <>", value, "ywnlpj");
            return (Criteria) this;
        }

        public Criteria andYwnlpjGreaterThan(String value) {
            addCriterion("ywnlpj >", value, "ywnlpj");
            return (Criteria) this;
        }

        public Criteria andYwnlpjGreaterThanOrEqualTo(String value) {
            addCriterion("ywnlpj >=", value, "ywnlpj");
            return (Criteria) this;
        }

        public Criteria andYwnlpjLessThan(String value) {
            addCriterion("ywnlpj <", value, "ywnlpj");
            return (Criteria) this;
        }

        public Criteria andYwnlpjLessThanOrEqualTo(String value) {
            addCriterion("ywnlpj <=", value, "ywnlpj");
            return (Criteria) this;
        }

        public Criteria andYwnlpjLike(String value) {
            addCriterion("ywnlpj like", value, "ywnlpj");
            return (Criteria) this;
        }

        public Criteria andYwnlpjNotLike(String value) {
            addCriterion("ywnlpj not like", value, "ywnlpj");
            return (Criteria) this;
        }

        public Criteria andYwnlpjIn(List<String> values) {
            addCriterion("ywnlpj in", values, "ywnlpj");
            return (Criteria) this;
        }

        public Criteria andYwnlpjNotIn(List<String> values) {
            addCriterion("ywnlpj not in", values, "ywnlpj");
            return (Criteria) this;
        }

        public Criteria andYwnlpjBetween(String value1, String value2) {
            addCriterion("ywnlpj between", value1, value2, "ywnlpj");
            return (Criteria) this;
        }

        public Criteria andYwnlpjNotBetween(String value1, String value2) {
            addCriterion("ywnlpj not between", value1, value2, "ywnlpj");
            return (Criteria) this;
        }

        public Criteria andQtpfIsNull() {
            addCriterion("qtpf is null");
            return (Criteria) this;
        }

        public Criteria andQtpfIsNotNull() {
            addCriterion("qtpf is not null");
            return (Criteria) this;
        }

        public Criteria andQtpfEqualTo(Float value) {
            addCriterion("qtpf =", value, "qtpf");
            return (Criteria) this;
        }

        public Criteria andQtpfNotEqualTo(Float value) {
            addCriterion("qtpf <>", value, "qtpf");
            return (Criteria) this;
        }

        public Criteria andQtpfGreaterThan(Float value) {
            addCriterion("qtpf >", value, "qtpf");
            return (Criteria) this;
        }

        public Criteria andQtpfGreaterThanOrEqualTo(Float value) {
            addCriterion("qtpf >=", value, "qtpf");
            return (Criteria) this;
        }

        public Criteria andQtpfLessThan(Float value) {
            addCriterion("qtpf <", value, "qtpf");
            return (Criteria) this;
        }

        public Criteria andQtpfLessThanOrEqualTo(Float value) {
            addCriterion("qtpf <=", value, "qtpf");
            return (Criteria) this;
        }

        public Criteria andQtpfIn(List<Float> values) {
            addCriterion("qtpf in", values, "qtpf");
            return (Criteria) this;
        }

        public Criteria andQtpfNotIn(List<Float> values) {
            addCriterion("qtpf not in", values, "qtpf");
            return (Criteria) this;
        }

        public Criteria andQtpfBetween(Float value1, Float value2) {
            addCriterion("qtpf between", value1, value2, "qtpf");
            return (Criteria) this;
        }

        public Criteria andQtpfNotBetween(Float value1, Float value2) {
            addCriterion("qtpf not between", value1, value2, "qtpf");
            return (Criteria) this;
        }

        public Criteria andQtpjIsNull() {
            addCriterion("qtpj is null");
            return (Criteria) this;
        }

        public Criteria andQtpjIsNotNull() {
            addCriterion("qtpj is not null");
            return (Criteria) this;
        }

        public Criteria andQtpjEqualTo(String value) {
            addCriterion("qtpj =", value, "qtpj");
            return (Criteria) this;
        }

        public Criteria andQtpjNotEqualTo(String value) {
            addCriterion("qtpj <>", value, "qtpj");
            return (Criteria) this;
        }

        public Criteria andQtpjGreaterThan(String value) {
            addCriterion("qtpj >", value, "qtpj");
            return (Criteria) this;
        }

        public Criteria andQtpjGreaterThanOrEqualTo(String value) {
            addCriterion("qtpj >=", value, "qtpj");
            return (Criteria) this;
        }

        public Criteria andQtpjLessThan(String value) {
            addCriterion("qtpj <", value, "qtpj");
            return (Criteria) this;
        }

        public Criteria andQtpjLessThanOrEqualTo(String value) {
            addCriterion("qtpj <=", value, "qtpj");
            return (Criteria) this;
        }

        public Criteria andQtpjLike(String value) {
            addCriterion("qtpj like", value, "qtpj");
            return (Criteria) this;
        }

        public Criteria andQtpjNotLike(String value) {
            addCriterion("qtpj not like", value, "qtpj");
            return (Criteria) this;
        }

        public Criteria andQtpjIn(List<String> values) {
            addCriterion("qtpj in", values, "qtpj");
            return (Criteria) this;
        }

        public Criteria andQtpjNotIn(List<String> values) {
            addCriterion("qtpj not in", values, "qtpj");
            return (Criteria) this;
        }

        public Criteria andQtpjBetween(String value1, String value2) {
            addCriterion("qtpj between", value1, value2, "qtpj");
            return (Criteria) this;
        }

        public Criteria andQtpjNotBetween(String value1, String value2) {
            addCriterion("qtpj not between", value1, value2, "qtpj");
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