/**

 @Name：layuiAdmin 用户登入和注册等
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License: LPPL

 */

layui.define('form', function (exports) {
    var $ = layui.$
        , layer = layui.layer
        , laytpl = layui.laytpl
        , setter = layui.setter
        , view = layui.view
        , admin = layui.admin
        , form = layui.form;

    var $body = $('body');
    form.verify({
        username: function (value, item) {
            if (value == "" || !(/^[\S]{4}$/.test(value))) {
                return "用户名输入有误";
            }
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '用户名不能有特殊字符';
            }

        }, password: function (value, item) {
            if (value == "" || !(/^[\S]{3,12}$/.test(value))) {
                return "密码输入有误";
            }
        }, vcode: function (value, item) {
            if (value == "" || !(/^[\S]{4}$/.test(value))) {
                return "验证码输入有误";
            }
        }
    });

    //发送短信验证码
    admin.sendAuthCode({
        elem: '#LAY-user-getsmscode'
        , elemPhone: '#LAY-user-login-cellphone'
        , elemVercode: '#LAY-user-login-vercode'
        , ajax: {
            url: layui.setter.base + 'json/user/sms.js' //实际使用请改成服务端真实接口
        }
    });


    //更换图形验证码
    $body.on('click', '#LAY-user-get-vercode', function () {
        var othis = $(this);
        this.src = contextPath + '/user/captcha?t=' + new Date().getTime()
    });

    exports('user', {});
});