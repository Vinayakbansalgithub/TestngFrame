package config;

public class Configuration {
	
	//public static String testsite="http://twitter.com";
	
	public static String homepage="https://www.magicbricks.com";
	public static String Loginpage="https://www.magicbricks.com/userLogin";

	
	
	
	
	// login page
	
	public static final String emailMobile=".//*[@id='emailOrMobile']";
	public static final String Next="(//button[text()='Next'])[1]";
	public static final String password=".//*[@id='j_password']";
	public static final String Login="//*[@id='btnLogin']";

	
	
	
	
	
	
	// home page
	public static final String Home_Buy="(//a[text()='Buy'])[last()]";
	public static final String Home_Rent="//a[@id='rentTab']";
	public static final String Home_Search="//input[@id='keyword']";
	public static final String Home_Search_Suggestion="(//div[@id='keyword_suggest']/div)[2]";
	public static final String Home_Buy_Property_Type="//div[@id='buy_propertyType']";
	public static final String Home_Rent_Property_Type="//div[@id='rent_propertyType']";
	public static final String Home_Rent_Property_Type_Value="//div[@id='propType_rent']/div/ul/li/span/input";
	public static final String Home_Buy_Property_Type_Value="//div[@id='propType_buy']/div/ul/li/span/input";
	
	public static final String flat="//label[text()='Flat']";
	public static final String office="//label[text()='Office Space']";
	

	
	
	public static final String Rent_Budget="//input[@id='rent_budget_lbl']";
	public static final String Buy_Budget="//input[@id='buy_budget_lbl']";
	public static final String Buy_Budget_Value="//div[@id='budget_buy']/ul/li/span/input";
	public static final String Rent_Budget_Value="//div[@id='budget_rent']/ul/li/span/input";
	public static final String Buy_Budget_Min_Input="//input[@id='rangeMinLinkbudgetBuyinput']";
	public static final String Buy_Budget_Max_Input="//input[@id='rangeMaxLinkbudgetBuyinput']";
	public static final String Rent_Budget_Min_Input="//input[@id='rangeMinLinkbudgetRentinput']";
	public static final String Rent_Budget_Max_Input="//input[@id='rangeMaxLinkbudgetRentinput']";
	public static final String Home_Search_Button="//input[@id='btnPropertySearch']";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// search result page
		public static final String heading=".//*[@id='resultDiv']//h1";
		public static final String List_prop_BHK=".//*[contains(@id,'resultBlockWrapper')]//a/span";
		public static final String List_price=".//div[contains(@id,'priceProperty')]";

		
		

		
		public static final String SRP_Select_Buy_Rent="//input[@id='inputcategory']";
		public static final String SRP_CrossIcon="//div[@class='crossIcon']";
		public static final String SRP_LocalityCity="//textarea[@id='refine_keyword']";
		public static final String SRP_PropertyType="//div[@id='propertyType']";
		public static final String SRP_Select_PropertyType="//div[@id='propType']/div/ul/li/span/input";
		
		
		
		public static final String More=".//*[@id='srpRefine']//div[text()='More']";
		
		
		
		public static final String Bathroom_1="//*[@id='refinebathrooms']/ul//label[contains(text(),'1 Bath')]";
		public static final String Bathroom_2="//*[@id='refinebathrooms']/ul//label[contains(text(),'2 Bath')]";
		public static final String Bathroom_3="//*[@id='refinebathrooms']/ul//label[contains(text(),'2 Bath')]";
		
		public static final String Furnished=".//*[@id='refinefurnished']/ul/li/label[contains(text(),'Furnished')]";
		public static final String SemiFurnished=".//*[@id='refinefurnished']/ul/li/label[contains(text(),'Semi-Furnished')]";
		public static final String Unfurnished =".//*[@id='refinefurnished']/ul/li/label[contains(text(),'Unfurnished ')]";

		
		
		
		public static final String BHK_DD="//*[@id='srpRefine']//div[text()='More']";
		public static final String BHK_1="//ul/li/label[contains(text(),'1 BHK')]";
		public static final String BHK_2="//ul/li/label[contains(text(),'2 BHK')]";
		public static final String BHK_3="/ul/li/label[contains(text(),'3 BHK')]";
		
		public static final String Socity=".//a[contains(@id,'project-link')]";

		
		
		
		
		
	
	
	
	

}
