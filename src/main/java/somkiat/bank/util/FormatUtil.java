package somkiat.bank.util;

public class FormatUtil {

	public String formatAccountNo(String accountNo) {
		String sAccountNo = accountNo;
		
		sAccountNo = accountNo.substring(0, 3)+"-"+ accountNo.substring(3, 4)+"-"+ accountNo.substring(4, 9)+"-"+ accountNo.substring(9, 10);
		
		return sAccountNo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FormatUtil fUtil = new FormatUtil();
		String strAccountNo = fUtil.formatAccountNo("1234567890");
		System.out.println(strAccountNo);
	}

}
