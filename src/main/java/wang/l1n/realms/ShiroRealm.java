package wang.l1n.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/4/15 21:25
 * @description：
 */
public class ShiroRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //将AuthenticationToken转换成UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //从UsernamePasswordToken中获取username
        String username = usernamePasswordToken.getUsername();

        //调用数据库方法，从数据库中查询username对应的用户记录
        System.out.println("数据库中的username："+username);

        //若用户不存在，则可以抛出AuthenticationException异常
        if ("unknown".equals(username)){
            throw new UnknownAccountException("用户不存在");
        }

        //根据用户信息的情况，据欸的那个是否要抛出其他的AuthenticationException异常
        if ("monster".equals(username)){
            throw new LockedAccountException("用户被锁定");
        }

        //根据用户的情况，来构建AuthenticationInfo对象并返回
        //以下信息从数据库中获取
        //principal：认证的实体信息
        Object principal = username;

        //credentials：密码
        Object credentials = null;
        if ("admin".equals(username)){
            credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
        }else if("user".equals(username)){
            credentials = "098d2c478e9c11555ce2823231e02ec1";
        }

        //realmName：当realm对象的name，调用父类的getName()方法即可
        String realmName = getName();

        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);

        SimpleAuthenticationInfo info = null;
        info = new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);
        return info;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "123456";
        Object salt = ByteSource.Util.bytes("admin");
        int hashIterations = 1024;
        Object result = new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
        System.out.println(result);
    }
}
