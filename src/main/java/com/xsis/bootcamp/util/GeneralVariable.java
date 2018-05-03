package com.xsis.bootcamp.util;

public interface GeneralVariable {
	
	public static final String RADIO_GROUP = "radiogroup";
	public static final String SHOW_PROGRESS_BAR_TOP = "top";
	public static final String ID_DEVICE = "01";
	
	
	//User Role
	public static final Integer USER_ROLE_SUPERADMIN = 1;
	public static final Integer USER_ROLE_ADMIN = 2;
	public static final Integer USER_ROLE_USERSD = 3;
	
	
	
	public static final String ACTION_CREATE = "create";
	public static final String ACTION_EDIT = "edit";
	public static final String ACTION_VIEW = "view";
	
	// Format 
	public static final String FORMAT_DATE = "yyyy-MM-dd";
	public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
	
	
	
	// Operators
	public class Operator{
		public static final String EQUALS = "=";
		public static final String NOT_EQUALS = "<>";
		public static final String GREATER_THEN = ">";
		public static final String LESS_THEN = "<";
		public static final String GREATER_THEN_OR_EQUAL = ">=";
		public static final String LESS_THEN_OR_EQUAL = "<=";
		public static final String LIKE = "LIKE";
		public static final String BETWEEN = "BETWEEN";
		public static final String IS = "IS";
	}
	
	//Status
	public static final Integer ISDELETE_TRUE = 1;
	public static final Integer ISDELETE_FALSE = 0;
	
	//KODE
	public static final String KODE_BUKU = "KB";
	

}
