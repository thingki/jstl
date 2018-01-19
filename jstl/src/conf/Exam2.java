package conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.iot.test.common.MybatisSessionFactory;
import com.iot.test.vo.Customer;

public class Exam2 {
	public static void main(String[] args) {
		SqlSessionFactory ssf = MybatisSessionFactory.getSqlSessionFactory();

		SqlSession ss = ssf.openSession();//기본값은 false true로 바꾸면 오토커밋됨
		Customer c = new Customer();
		c.setCustomerName("김명재바보");
		c.setCustomerId(1);
		ss.update("customer.UpdateCustomer", c); //인트값으로 나옴!!
		ss.commit(); //기본값이 false라서 커밋해줘야함~
		Map<String, String> map = new HashMap<String, String>();
		map.put("str", "customerid desc");
		List<Customer> ctList = ss.selectList("customer.selectCustomer", map);
		for(Customer ct:ctList) {
			System.out.println(ct);
		}
	}
}
