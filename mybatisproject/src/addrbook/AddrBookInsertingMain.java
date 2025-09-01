package addrbook;

import java.util.List;

public class AddrBookInsertingMain {

	public static void main(String[] args) throws Exception {

		System.out.println("addrbook id list");
		AddrBookVO vo = new AddrBookVO();
		vo.abName = "haha";
		vo.abEmail = "hahajava@naver.com";
		vo.abTel = "010-1111-1111";
		boolean result = new AddrBookDAO().insertDB(vo);
		System.out.println(result);

		result = new AddrBookDAO().deleteDB(3);
		System.out.println(result);

	}

}
