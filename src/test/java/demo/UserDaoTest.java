package demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dada.entity.Member;
import com.dada.service.IMemberService;

/**
 * @author WuTengda
 */
public class UserDaoTest extends BaseTest {

    @Autowired
    private IMemberService iMemberService;

    @Test
    public void addTest() {
    	Member entity = new Member();
        entity.setRealname("吴腾达");
        //int result = this.iMemberService.addUsers(entity);
       // System.out.println("result = " + result);
    }

}
