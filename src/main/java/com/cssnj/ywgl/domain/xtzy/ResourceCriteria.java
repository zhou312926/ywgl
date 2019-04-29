package com.cssnj.ywgl.domain.xtzy;

import java.util.ArrayList;
import java.util.List;

public class ResourceCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceCriteria() {
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

        public Criteria andQxbsIsNull() {
            addCriterion("qxbs is null");
            return (Criteria) this;
        }

        public Criteria andQxbsIsNotNull() {
            addCriterion("qxbs is not null");
            return (Criteria) this;
        }

        public Criteria andQxbsEqualTo(String value) {
            addCriterion("qxbs =", value, "qxbs");
            return (Criteria) this;
        }

        public Criteria andQxbsNotEqualTo(String value) {
            addCriterion("qxbs <>", value, "qxbs");
            return (Criteria) this;
        }

        public Criteria andQxbsGreaterThan(String value) {
            addCriterion("qxbs >", value, "qxbs");
            return (Criteria) this;
        }

        public Criteria andQxbsGreaterThanOrEqualTo(String value) {
            addCriterion("qxbs >=", value, "qxbs");
            return (Criteria) this;
        }

        public Criteria andQxbsLessThan(String value) {
            addCriterion("qxbs <", value, "qxbs");
            return (Criteria) this;
        }

        public Criteria andQxbsLessThanOrEqualTo(String value) {
            addCriterion("qxbs <=", value, "qxbs");
            return (Criteria) this;
        }

        public Criteria andQxbsLike(String value) {
            addCriterion("qxbs like", value, "qxbs");
            return (Criteria) this;
        }

        public Criteria andQxbsNotLike(String value) {
            addCriterion("qxbs not like", value, "qxbs");
            return (Criteria) this;
        }

        public Criteria andQxbsIn(List<String> values) {
            addCriterion("qxbs in", values, "qxbs");
            return (Criteria) this;
        }

        public Criteria andQxbsNotIn(List<String> values) {
            addCriterion("qxbs not in", values, "qxbs");
            return (Criteria) this;
        }

        public Criteria andQxbsBetween(String value1, String value2) {
            addCriterion("qxbs between", value1, value2, "qxbs");
            return (Criteria) this;
        }

        public Criteria andQxbsNotBetween(String value1, String value2) {
            addCriterion("qxbs not between", value1, value2, "qxbs");
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

        public Criteria andJcIsNull() {
            addCriterion("jc is null");
            return (Criteria) this;
        }

        public Criteria andJcIsNotNull() {
            addCriterion("jc is not null");
            return (Criteria) this;
        }

        public Criteria andJcEqualTo(String value) {
            addCriterion("jc =", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcNotEqualTo(String value) {
            addCriterion("jc <>", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcGreaterThan(String value) {
            addCriterion("jc >", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcGreaterThanOrEqualTo(String value) {
            addCriterion("jc >=", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcLessThan(String value) {
            addCriterion("jc <", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcLessThanOrEqualTo(String value) {
            addCriterion("jc <=", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcLike(String value) {
            addCriterion("jc like", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcNotLike(String value) {
            addCriterion("jc not like", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcIn(List<String> values) {
            addCriterion("jc in", values, "jc");
            return (Criteria) this;
        }

        public Criteria andJcNotIn(List<String> values) {
            addCriterion("jc not in", values, "jc");
            return (Criteria) this;
        }

        public Criteria andJcBetween(String value1, String value2) {
            addCriterion("jc between", value1, value2, "jc");
            return (Criteria) this;
        }

        public Criteria andJcNotBetween(String value1, String value2) {
            addCriterion("jc not between", value1, value2, "jc");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
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

        public Criteria andDkfsIsNull() {
            addCriterion("dkfs is null");
            return (Criteria) this;
        }

        public Criteria andDkfsIsNotNull() {
            addCriterion("dkfs is not null");
            return (Criteria) this;
        }

        public Criteria andDkfsEqualTo(String value) {
            addCriterion("dkfs =", value, "dkfs");
            return (Criteria) this;
        }

        public Criteria andDkfsNotEqualTo(String value) {
            addCriterion("dkfs <>", value, "dkfs");
            return (Criteria) this;
        }

        public Criteria andDkfsGreaterThan(String value) {
            addCriterion("dkfs >", value, "dkfs");
            return (Criteria) this;
        }

        public Criteria andDkfsGreaterThanOrEqualTo(String value) {
            addCriterion("dkfs >=", value, "dkfs");
            return (Criteria) this;
        }

        public Criteria andDkfsLessThan(String value) {
            addCriterion("dkfs <", value, "dkfs");
            return (Criteria) this;
        }

        public Criteria andDkfsLessThanOrEqualTo(String value) {
            addCriterion("dkfs <=", value, "dkfs");
            return (Criteria) this;
        }

        public Criteria andDkfsLike(String value) {
            addCriterion("dkfs like", value, "dkfs");
            return (Criteria) this;
        }

        public Criteria andDkfsNotLike(String value) {
            addCriterion("dkfs not like", value, "dkfs");
            return (Criteria) this;
        }

        public Criteria andDkfsIn(List<String> values) {
            addCriterion("dkfs in", values, "dkfs");
            return (Criteria) this;
        }

        public Criteria andDkfsNotIn(List<String> values) {
            addCriterion("dkfs not in", values, "dkfs");
            return (Criteria) this;
        }

        public Criteria andDkfsBetween(String value1, String value2) {
            addCriterion("dkfs between", value1, value2, "dkfs");
            return (Criteria) this;
        }

        public Criteria andDkfsNotBetween(String value1, String value2) {
            addCriterion("dkfs not between", value1, value2, "dkfs");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andXhIsNull() {
            addCriterion("xh is null");
            return (Criteria) this;
        }

        public Criteria andXhIsNotNull() {
            addCriterion("xh is not null");
            return (Criteria) this;
        }

        public Criteria andXhEqualTo(Integer value) {
            addCriterion("xh =", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotEqualTo(Integer value) {
            addCriterion("xh <>", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThan(Integer value) {
            addCriterion("xh >", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThanOrEqualTo(Integer value) {
            addCriterion("xh >=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThan(Integer value) {
            addCriterion("xh <", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThanOrEqualTo(Integer value) {
            addCriterion("xh <=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhIn(List<Integer> values) {
            addCriterion("xh in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotIn(List<Integer> values) {
            addCriterion("xh not in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhBetween(Integer value1, Integer value2) {
            addCriterion("xh between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotBetween(Integer value1, Integer value2) {
            addCriterion("xh not between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdIsNull() {
            addCriterion("sjgncd_id is null");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdIsNotNull() {
            addCriterion("sjgncd_id is not null");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdEqualTo(String value) {
            addCriterion("sjgncd_id =", value, "sjgncdId");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdNotEqualTo(String value) {
            addCriterion("sjgncd_id <>", value, "sjgncdId");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdGreaterThan(String value) {
            addCriterion("sjgncd_id >", value, "sjgncdId");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdGreaterThanOrEqualTo(String value) {
            addCriterion("sjgncd_id >=", value, "sjgncdId");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdLessThan(String value) {
            addCriterion("sjgncd_id <", value, "sjgncdId");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdLessThanOrEqualTo(String value) {
            addCriterion("sjgncd_id <=", value, "sjgncdId");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdLike(String value) {
            addCriterion("sjgncd_id like", value, "sjgncdId");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdNotLike(String value) {
            addCriterion("sjgncd_id not like", value, "sjgncdId");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdIn(List<String> values) {
            addCriterion("sjgncd_id in", values, "sjgncdId");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdNotIn(List<String> values) {
            addCriterion("sjgncd_id not in", values, "sjgncdId");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdBetween(String value1, String value2) {
            addCriterion("sjgncd_id between", value1, value2, "sjgncdId");
            return (Criteria) this;
        }

        public Criteria andSjgncdIdNotBetween(String value1, String value2) {
            addCriterion("sjgncd_id not between", value1, value2, "sjgncdId");
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