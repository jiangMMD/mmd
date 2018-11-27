package common;

import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;


public class ComTest {

    @Test
    public void test() throws NoSuchAlgorithmException, SignatureException {
        String str = "amount=10&appId=100492&orderId=782684726385&payee=737012253@qq.com&payer=737012253&key=PPvHMrGxxCiNhPiq1gV22kKsTF7Uxa9k";
        String str1 = "amount=123.456&appId=100492&orderId=782684726385&payee=lisi&payer=zhansan&key=PPvHMrGxxCiNhPiq1gV22kKsTF7Uxa9k";
        System.out.println(DigestUtils.md5DigestAsHex(str.getBytes()));
    }
}
