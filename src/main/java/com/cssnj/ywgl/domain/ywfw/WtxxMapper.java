package com.cssnj.ywgl.domain.ywfw;

import com.cssnj.ywgl.vo.ywfw.WtxxVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

@Mapper
public interface WtxxMapper {
    int countByExample(WtxxCriteria example);

    int deleteByExample(WtxxCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Wtxx record);

    int insertSelective(Wtxx record);

    List<Wtxx> selectByExampleWithRowbounds(WtxxCriteria example, RowBounds rowBounds);

    List<Wtxx> selectByExample(WtxxCriteria example);

    Wtxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Wtxx record, @Param("example") WtxxCriteria example);

    int updateByExample(@Param("record") Wtxx record, @Param("example") WtxxCriteria example);

    int updateByPrimaryKeySelective(Wtxx record);

    int updateByPrimaryKey(Wtxx record);

    int countForWtglList(@Param("yhId") String yhId, @Param("bmzbId") String bmzbId, @Param("bt") String bt, @Param("wtlxDm") String wtlxDm, @Param("yyxtDm") String yyxtDm, @Param("ywmkDm") String ywmkDm);

    List<WtxxVo> selectForWtglList(@Param("yhId") String yhId, @Param("bmzbId") String bmzbId, @Param("bt") String bt, @Param("wtlxDm") String wtlxDm, @Param("yyxtDm") String yyxtDm, @Param("ywmkDm") String ywmkDm, @Param("offset") int offset, @Param("rows") int rows);

    WtxxVo selectByPk(String id);

    int countForWtclList(@Param("yhId") String yhId, @Param("bmzbId") String bmzbId, @Param("bt") String bt, @Param("wtlxDm") String wtlxDm, @Param("yyxtDm") String yyxtDm, @Param("ywmkDm") String ywmkDm);

    List<WtxxVo> selectForWtclList(@Param("yhId") String yhId, @Param("bmzbId") String bmzbId, @Param("bt") String bt, @Param("wtlxDm") String wtlxDm, @Param("yyxtDm") String yyxtDm, @Param("ywmkDm") String ywmkDm, @Param("offset") int offset, @Param("rows") int rows);

    List<WtxxVo> selectForFaczList(@Param("yhId") String yhId, @Param("bmzbId") String bmzbId, @Param("bt") String bt, @Param("wtlxDm") String wtlxDm, @Param("yyxtDm") String yyxtDm, @Param("ywmkDm") String ywmkDm, @Param("offset") int offset, @Param("rows") int rows);

    int insertBatch(List<Wtxx> wtxxes);


    List<WtxxVo> selectForWtHzmxList(Map map);

}