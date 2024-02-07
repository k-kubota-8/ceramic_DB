package test;

public class TestAny {
	public static void main(String[] args) {
		String str = "test";
		System.out.println(" WHERE TITLE LIKE '%" + str + "%'");
		
		StringBuilder sb = new StringBuilder(str);
		sb = sb.append(" AND result");
		sb = sb.append("AND");
		
		
		
		str = sb.toString();
		System.out.println(str);
		
		System.out.println(sb.length());
		System.out.println(sb.lastIndexOf("AND"));
		
//		System.out.println(sb.delete(15, sb.length()));
		System.out.println(sb.delete(sb.lastIndexOf("AND"), sb.length()));
		
		String str1 = "1300";
		Integer integer ;
		integer = Integer.valueOf(str1);
		System.out.println(integer);
	}
}
