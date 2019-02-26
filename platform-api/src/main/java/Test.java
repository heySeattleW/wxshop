import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.platform.entity.CommentVo;

public class Test {

	public static void main(String[] argv) {
		
		String ids="a_b_c,d,e";
		 String[] tempArray = ids.split("[\\,,_]");
         System.out.println(tempArray.length);
	}
}
