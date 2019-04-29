package com.cssnj.ywgl.service.common;

import com.cssnj.ywgl.domain.xtqx.RoleMenuMapper;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import com.cssnj.ywgl.vo.xtzy.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/3/21 15:17
 */
@Service
public class MenuService extends BaseService {


    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("loadMenu".equals(jsonRequest.getHandle())) {
            return loadMenu(jsonRequest);
        }
        return null;
    }

    private JsonResponse loadMenu(JsonRequest<Map> jsonRequest) {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        //        List params = new ArrayList();
//        params.add(loginInfo.getYhId());
//        String sql = "";
//        List<Menu> allMenus = queryDaoImpl.query(sql, params, Menu.class);
        List<ResourceVo> allMenus = roleMenuMapper.selectForLogin(loginInfo.getYhId());
        List<ResourceVo> menus = new ArrayList<>();
        for (ResourceVo menu : allMenus) {
            if ("0".equals(menu.getLx()) && "00".equals(menu.getSjgncdId())) {
                reloadMenu(menu, allMenus);
                menus.add(menu);
            }
        }

        for (int i = menus.size() - 1; i >= 0; i--) {
            ResourceVo menu = menus.get(i);
            if (menu.getChilds().size() == 0) {
                menus.remove(i);
            }
        }
        Map map = new HashMap();
        map.put("menus", menus);
        jsonResponse.setData(map);
        return jsonResponse;
    }

    private void reloadMenu(ResourceVo parent, List<ResourceVo> allMenus) {

        for (ResourceVo menu : allMenus) {
            if ("0".equals(parent.getLx()) && parent.getId().equals(menu.getSjgncdId())) {
                if ("0".equals(menu.getLx())) {
                    reloadMenu(menu, allMenus);
                }
//                if (parent.get("child") == null) {
//                    parent.put("child", new ArrayList<>());
//                }
//                ((List<Map<String, Object>>) parent.get("child")).add(menu);
                if ("1".equals(menu.getLx()) || ("0".equals(menu.getLx()) && menu.getChilds().size() > 0)) {
                    parent.getChilds().add(menu);
                }

            }
        }
    }
}
