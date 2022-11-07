import com.briup.common.web.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/7/2022-11-07-4:11 PM
 * @Description：PACKAGE_NAME
 */
public class TestToken {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("username","tom");
        map.put("password","123456");
        String token = JwtUtil.sign("1",map);
        System.out.println("token = " + token);
    }
}
