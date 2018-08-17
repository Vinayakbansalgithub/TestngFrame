package objrepositories;

import org.openqa.selenium.By;


//Gold URL for different environments
public class GOLDStandAlone {
    public static final String GOLD_UAT_URL = "http://10.237.59.69/home/gold/jsp/partner.jsp";
    public static final String GOLD_SandBox_URL = "http://10.237.59.154/home/gold/jsp/partner.jsp";
    public static final String EAI_Portal = "http://obux065-tst.prod.ren.globalone.net:4500/webdav/Coop/TestODB/czaiuh5d16/TestODB.html";
	
   //Gold  Login_______Page
    public static final String Login_______Page=null;
    public static final By Login_UserName_xpath = By.xpath("(//input[@name='UserName'])[1]");
	public static final By Login_Password_xpath = By.xpath("//input[@name='Password']");
	public static final By Login_Submit_ClassName = By.className("butSubmit_image");
	public static final By Login_dontshowme_xpath = By.xpath("//*[@id='dontshowme']");
	public static final By Login_closeLink_ClassName = By.className("closeLink");
	public static final By Login_CloseLink_byText = By.linkText("Close");
	public static final By Login_CloseLink_ByXpath = By.xpath("//html/body//div[@id='light']//div[@class='closeBtnDiv']/span[@class='closeLink']/a");
	public static final By LogOut_Image = By.className("logout_image");
	
	//Inbox_Orders tab objects
	public static final By iFrame = By.name("SelectorIFrame");
	public static final By iFrameIL = By.tagName("iframe");
	public static final By GOLD_headmenu_orders_xpath = By.xpath("//*[@id='headMenu']/li[2]/a/span");
	public static final By OrderMenu = By.linkText("Orders");
	public static final By CustomersMenu = By.linkText("Customers");
	public static final By ContactsMenu = By.linkText("Contacts");
	public static final By InboxMenu = By.linkText("Inbox");
	public static final By AdministrationMenu = By.linkText("Administration");
	public static final String AdministrationSubMenu_Data = "//td[.='#DATA']";
	public static final By SearchOfficeName_EditBox = By.id("nameValOffice");
	public static final String LeftBarMessage = "//*[@id='LeftErrorBar']//img[@class='#DATA']";
	public static final String SideSubMenuData = "//*[@id='LeftNavBar']//td[.='#DATA']"; 
	public static final By InboxWorkFlowTask = By.xpath("//*[@id='SearchTabStandard']//select[@name='workflowTaskValInbox']");
	public static final String InboxWorkFlowTask_Data = "//*[@id='SearchTabStandard']//select[@name='workflowTaskValInbox']/option[@value='#DATA']";
	public static final String MyUsersUser_Data = "//*[@id='LeftNavBar']//tr[@title='#DATA']/td";
	public static final String MyUserUserBulkTask_Data = "//*[@id='LeftNavBar']//tr[@title='#DATA']/following-sibling::tr[@title='Bulk Tasks']/td";
	public static final String MyUserUserCompletedTask_Data = "//*[@id='LeftNavBar']//tr[@title='#DATA']/following-sibling::tr[@title='Completed Tasks']/td";
	public static final By MyUserActionButton = By.xpath("//img[@class='butActionBlue_image']");
	public static final By MyUserCompletionDateColumn = By.xpath("//a[@class='colNameNormal' and contains(text(),'Completion Date')]");
	public static final String GenericColumnName_Data = "//a[@class='colNameNormal' and contains(text(),'#DATA')]";
	public static final String CustomerSideSubMenuData = "//*[@id='LeftNavBar']//td[.='#DATA']"; 
	public static final String CustomerSideSubMenuData2 = "//*[@id='LeftNavBar']//tr[@title='#DATA']";
	public static final By GOLD_orders_CreateOrder_xpath = By.xpath("//*[@id='CreateOrderImg']");
	public static final By CreateOrderNew = By.xpath("//div[@id='CreateOrderPopUp']//td[.='New']");
	public static final By Contracting_Party_Search = By.xpath("//td[contains(.,'Contracting Party')]/img[1]");
	public static final By CustomerSearchOptions_Select = By.xpath("//select[@name='nameOpCustomer']");
	public static final By Customer_SearchName = By.id("nameValCustomer");
	public static final By Customer_SearchSalesRegion = By.name("salesRegionValCustomer");
	public static final By Customer_SearchSalesCountry = By.name("salesCountryValCustomer");
	public static final By Customer_PrimaryContactSearch = By.xpath("//img[starts-with(@title,'Click to display the Primary Contacts')]");
	public static final By Customer_PrimaryContactLastName = By.id("nameValContact");
	public static final By Customer_PrimaryContactCategory = By.id("categoryValContact");
	public static final String VerifyCustomerPrimaryContact = "//*[@id='label~primarycontact']/ancestor::td/following-sibling::td[contains(.,'#DATA')]"; 
	public static final By Contracting_Party_Customer_Name = By.id("nameValCustomer");
	public static final By Customer_ProcessName = By.id("processName");
	public static final By Customer_ProcessStatus = By.xpath("//select[@name='status']");
	public static final By CustomerProcessID_Capture = By.xpath("//*[@id='processID']/ancestor::td[@class='normalView']"); 

	public static final By Comments_textArea = By.xpath("//textarea[@name='comments']"); 
	public static final By Contract_Search = By.xpath("//label[@id='label~2']/following-sibling::img[1]");
	public static final By OrderTerm = By.xpath("//*[@id='orderTerm']");
	
	public static final By SalesCampaign_Select = By.xpath("//*[@id='salescampaign']");
	public static final By CustomerSiteSurvey_Select = By.xpath("//*[@id='customerSiteSurvey']");
	public static final By CustomerRequestedEarlyDelivery = By.xpath("//*[@id='customerRequestedEarlyDelivery']");
	
	public static final By BillingSearch = By.xpath("//td[contains(.,'Billing')]/img[1]");
	public static final By SearchLocalSite = By.xpath("//td[contains(.,'Local Site')]/img[1]");
	
	// example of parameterizing the object definition with data
	public static final String LocalSite_Data = "//td[.='#DATA']/ancestor::tr/td[1]/img" ;
	
	public static final By RequestedDeliveryDate_Calendar = By.xpath("//*[@id='requestedDate']/img[1]");
	public static final String CalendarDate_Data = "//*[@id='wholedoc']/center//div[.='#DATA']";
	
	public static final By Product_Service = By.xpath("//*[@id='chooseServiceDropDown']");
	public static final By LeadTimeBasis_Search = By.xpath("//img[@Title='Select Lead Time Basis']");
	public static final String LeadTimeBasis_Data = "//td[.='#DATA']"; 
	
	public static final By NonQuotoOrderReason_Select = By.xpath("//*[@id='NonQUOTOOrderReason']");
	public static final By InstallationPreferences_Select = By.xpath("//*[@id='installationPreferences']");
	public static final By CAT_Required_Select = By.xpath("//*[@id='custAcceptTesting']");
	
	//Orders Submission Tasks
	public static final By InboxWorkFlowTask_CustApproval = By.xpath("//*[@id='SearchTabStandard']//select[@name='workflowTaskValInbox']/option[@value='Customer Approval']");
	public static final By InboxWorkFlowTask_CheckAndRelease = By.xpath("//*[@id='SearchTabStandard']//select[@name='workflowTaskValInbox']/option[@value='Check and Release Order']");
	public static final By InboxWorkFlowTask_CaptureTechnicalDetails = By.xpath("//*[@id='SearchTabStandard']//select[@name='workflowTaskValInbox']/option[@value='Capture Technical Details']");
	public static final By InboxWorkFlowTask_ValidateTechnicalDetails = By.xpath("//*[@id='SearchTabStandard']//select[@name='workflowTaskValInbox']/option[@value='Validate Technical Details']");
	public static final By InboxWorkFlowTask_ManageOrder = By.xpath("//*[@id='SearchTabStandard']//select[@name='workflowTaskValInbox']/option[@value='Manage Order']");
	public static final By InboxWorkFlowTask_SendtoCustomerforSignature = By.xpath("//*[@id='SearchTabStandard']//select[@name='workflowTaskValInbox']/option[@value='Send to Customer for Signature']");
	public static final By InboxSearchRollbackFirstOrder=By.xpath("(//img[@class='sqRollback'])[1]/ancestor::tr[contains(@class,'row')]/td[3]");
	public static final By CompleteTask_DropDown = By.xpath("//img[@class='completeTask']");
	public static final By Completetask_Submit = By.xpath("//div[@id='WFActionPopup']//nobr[.='submit']");
	public static final By Completetask_Approve = By.xpath("//div[@id='WFActionPopup']//nobr[.='approve']");
	public static final By Completetask_Reject = By.xpath("//div[@id='WFActionPopup']//nobr[.='reject']");
	public static final By Completetask_Reject_Master = By.xpath("//div[@id='WFActionPopup']//nobr[.='reject Master Order only']");
	public static final By Completetask_Reject_Bundle = By.xpath("//div[@id='WFActionPopup']//nobr[.='reject entire bundle']");
	public static final By Completetask_ReleaseOrder = By.xpath("//div[@id='WFActionPopup']//nobr[.='release order']");
	public static final By Completetask_SubmitAndInformSdm = By.xpath("//div[@id='WFActionPopup']//nobr[.='submit and inform sdm']");
	public static final By GateWayErrorforTS = By.xpath("//*[@id='TaskListRow']//span[contains(.,'Gateway Error')]");
	public static final By CompleteTask_ManageOrder = By.xpath("//td/nobr[.='Manage Order']");
	public static final By TaskListDropDown = By.xpath("//tr[@id='TaskListRow']//img");
	public static final By TaskListSetupBilling = By.xpath("//td/nobr[.='Setup Billing']");
	public static final String TaskListOption = "//td/nobr[.='#DATA']"; 
	public static final By TaskListGateWayErrorForTS = By.xpath("//td/nobr[.='Gateway Error for TS']");
	public static final By TaskListGateWayErrorForDOO = By.xpath("//td/nobr[.='Gateway Error for DOO']");
	public static final By TaskListLegalApproval = By.xpath("//td/nobr[.='Legal Approval']");
	public static final By TaskListInitiateBilling = By.xpath("//td/nobr[.='Initiate Billing']");
	public static final By TaskListCustomerApproval = By.xpath("//td/nobr[.='Customer Approval']");
	public static final String OrderHeaderTask_Data = "//td[@class='orderHeader' AND contains(.,'#DATA')]";
	
	public static final By SendSCNButton = By.className("butSendSCN");
	public static final By SCNEmailBodyText = By.xpath("//*[@name='emailbodytext']");
	public static final By ConfirmEmailSend = By.className("butSend");
	public static final By SearchButton = By.id("searchButton");
	public static final By ResultFirstRow = By.xpath("//*[@id='grid_row_1']");
	public static final By ResultFirstRowImage = By.xpath("//*[@id='grid_row_1']/tr[2]/td[1]/img");
	public static final By OrderCaptureElement = By.xpath("//*[@id='LeftErrorBar']//td[contains(.,'saved successfully')]");
	public static final By L2PPUSIDCaptureElement = By.xpath("//td[@class='normalView']/preceding-sibling::td[contains(.,'CPE USID')]/following-sibling::td[4]");
	
	//Office and project windows
	public static final By Signatory_Search = By.xpath("//td[contains(.,'Technical Contact')]/img[1]");
	public static final By Inbox_Order_Search = By.xpath("//input[@name='orderNb']");
	public static final By Inbox_CompletedTasks_Order_Search = By.xpath("//input[@name='orderNumberValInbox']");
	public static final By Inbox_SearchButton = By.xpath("//*[@id='searchButton']");
	public static final By Inbox_Resultrow = By.xpath("//*[@id='grid_row_1']/td[3]");
	public static final By OrderInfo_EditButton = By.xpath("//img[@class='butEdit']");
	public static final By ButtonCreateNew = By.xpath("//img[@class='butCreateNew']");
	public static final By NewOffice_Name = By.id("officename");
	public static final By NewOffice_salescluster = By.id("salescluster");
	public static final By NewOffice_salescountry = By.id("salescountry");
	public static final By NewOffice_Address = By.id("street1");
	public static final By NewOffice_City = By.id("city");
	public static final By NewOffice_country = By.id("country");
	public static final By NewOffice_salesregion = By.id("salesregion");
	public static final By NewOffice_phone = By.id("phone");
	
	public static final By NewProject_projectname = By.id("projectname");
	public static final By NewProject_EndDate	= By.xpath("//*[@id='endDate']/img[1]");
	public static final By NewProject_numResources = By.id("numResources");
	public static final By NewProject_serviceTypeDisplay = By.name("serviceTypeDisplay");
	public static final By NewProject_objectives = By.xpath("//textarea[@name='objectives']");
	
	//Service Build Page
	public static final String SBuild_______Page=null;
	public static final By Order_SBuildMenu = By.xpath("//td[.='Service build']");
	public static final By Order_SBuildMenu_new = By.xpath("//td[.='New']");
	public static final By SBuild_CatalogID = By.id("catalogID");
	public static final By SBuild_catalogIDSubmitBtn = By.id("catalogIDSubmitBtn");
//	public static final By SBuild_Community_Name = By.id("BNAZZZWUUGKEZQXF44ZDZMNEC5W1SZZZ__0___OLD_text");
	public static final By SBuild_CustomizedCPE = By.id("BNAZZZWUUGKEZQXF44ZDZMNEC5XVI0ZZ__0___attr");
	public static final By SBuild_Community_Name = By.className("sqSelect");
	public static final By SBuild_Community_Name_New = By.id("BNAZZZWUUGKEZQXF44ZDZMNEC5W1SZZZ__0___NEW_text");
	public static final By SBuild_Community_Type_New = By.id("BNAZZZWUUGKEZQXF44ZDZMNEC1ZWSZZZ__0___NEW");
	public static final By SBuild_PrimaryServiceType = By.name("BNAZZZWUUGKEZQXF44ZDZMNECDJMAZZZ__0___OLD");
	public static final String PrimaryServiceType_Data = "//*[@name='BNAZZZWUUGKEZQXF44ZDZMNECDJMAZZZ__0___OLD']/option[#DATA]";
	public static final By SBuild_AddInstance1 = By.xpath("//td[.='Active Prevention']/following-sibling::td/a");
	public static final By SBuild_AddInstance2 = By.xpath("//td[contains(.,'Active Prevention - ')]/following-sibling::td/a");
	public static final By SBuild_AddNumInstance = By.xpath("//*[@id='instances_BNAZZZUUUGKEB4CJO3ZJ1P0NP3BOB2ZZ']");
	public static final By SBuild_AddNumInstance2 = By.xpath("//*[@id='instances_BNAZZZUUUGKEB4CJO3ZJ1P0NPB5QB2ZZ']");												
	public static final By SBuild_AddNumInstanceOK = By.xpath("//input[@id='button_BNAZZZUUUGKEB4CJO3ZJ1P0NP3BOB2ZZ']"); // ("//input[@value='OK']"); //button_BNAZZZUUUGKEB4CJO3ZJ1P0NP3BOB2ZZ
	public static final By SBuild_AddNumInstanceOK_CCS = By.xpath("//input[@id='button_BNAZZZUUUGKEB4CJO3ZJ1P0NPB5QB2ZZ']");
	//public static final By Product_IsMendatory = By.xpath("//input[@name='IsMandatory' and @type='checkbox']");
	public static final By SBuild_Instance1Folder = By.xpath("//*[@id='BNAZZZUUUGKEB4CJO3ZJ1P0NP3BOB2ZZ__0__Img']");
	public static final By SBuild_Instance2Folder = By.xpath("//*[@id='BNAZZZUUUGKEB4CJO3ZJ1P0NPB5QB2ZZ__0__Img']");
	public static final By SBuild_Data_APExtendedDCstandaloneoption = By.xpath("//td[.='AP Extended DC stand-alone option ']/following-sibling::td/select");
	public static final By SBuild_Data_APExtendedDCHAoption = By.xpath("//td[.='AP Extended DC HA option ']/following-sibling::td/select");
	public static final By SBuild_Data_AdditonalCertificates = By.xpath("//*[@id='BNAZZZUUUGKEB4CJO3ZJ1P0NPBWEB2ZZ__0___OLD']");
	public static final By SBuild_ShowDetails = By.xpath("//*[@id='ConfigDetailsImg']/img");
	public static final By SBuild_L3USIDCapture = By.xpath("//td[contains(.,'USID') AND @id='ConfigTechVisible']/following-sibling::td[1]");
	public static final By SBuild_SaveButton = By.xpath("//img[@class='butSave']");
	public static final By SaveButton = By.xpath("//img[@class='butSave']");
	public static final By DeleteButton = By.xpath("//img[@class='butDelete']");
	public static final By SBuild_SubmitTechnical_SRF2Notreq = By.xpath("//div[@id='WFActionPopup']/table/tbody/tr[5]/td[2]/nobr");
	public static final By SBuild_AddRouter = By.xpath("//img[@class='sqAdd']");
	public static final By SBuild_AddRouter_FinishPage = By.xpath("//img[@class='butFinishPage']");
	public static final By SBuild_Select_Router = By.xpath("//select[@name='Routers']");
	public static final By SBuild_PrimaryAccessConnection_Button = By.xpath("//input[@id='Prim_AC']");
	public static final By SBuild_Community_box = By.xpath("//input[@id='|Community_Name_Input_ID|Community Name']");
	public static final By SBuild_CircuitType_Select = By.xpath("//select[@name='Main Circuit Type']");
	public static final By SBuild_PrimaryAccessConnection_Edit = By.xpath("//input[@id='AC_Primary_ID']/following-sibling::img[@class='sqEdit']");
	public static final By SBuild_ServiceInstalation = By.xpath("//td[.='Service Installation']/following-sibling::td/a");          
    public static final By SBuild_ServiceInstalationInstance1 = By.xpath("//*[@id='instances_BNAZZZUUUGKEZT2IP4ZWF00MDQSIE0ZZ']");
    public static final By SBuild_ServiceInstalationFolder1 = By.xpath("//*[@id='BNAZZZUUUGKEZT2IP4ZWF00MDQSIE0ZZ__0__Img']");
    public static final By SBuild_SiteImplimentationValue1 = By.xpath("//*[@id='BNAZZZUUUGKEZT2IP4ZWF00MDUZYO0ZZ__0___OLD']/option[2]");
    public static final By SBuild_PrimaryAccessConnectionATM_Button = By.xpath("//input[@id='AC_ATM_Primary_ID']");
    public static final By SBuild_PrimaryAccessConnectionATM_ButtonEdit = By.xpath("//input[@id='AC_ATM_Primary_ID']/following-sibling::img[@class='sqEdit']");
    public static final By SBuild_CircuitTypeATM = By.xpath("//select[@name='Circuit Type']/option[2]");
    
	//Pricing page
	public static final String Pricing_______Page=null;
	public static final By Order_PricingMenu = By.xpath("//td[.='Pricing']");
	public static final String Order_GenericSideMenu_Data = "//td[.='#DATA']";
	public static final By Order_Pricing_EditButton = By.xpath("//img[@class='butEdit']");
	public static final By Order_Pricing_DeselectAllButton = By.xpath("//img[@class='butDeselectAllItems']");
	public static final By Order_Pricing_SelectAllButton = By.xpath("//img[@class='butSelectAll']");
	public static final By Order_Pricing_addMLI = By.xpath("//img[@class='iconAddTopLevelItem']");
	public static final By Order_Pricing_addChild = By.xpath("//img[@class='iconChildAdd']");
	public static final By Order_Pricing_addAttribute = By.xpath("//img[@class='iconAttributeAdd']");
	public static final By Order_Pricing_DeleteMLI = By.xpath("//img[@class='iconChildDelete']");
	public static final By Order_Pricing_EditMLI = By.xpath("//img[@class='iconChildEdit']");
	public static final By QuoteLineItemsTableFirstRow = By.xpath("//*[@id='QuoteLineItems']//nobr[contains(.,'001')]");
	public static final String Order_Pricing_Table_Data = "//td[.='#DATA']";
	public static final By Order_Pricing_OrderFormCheckBoxes = By.xpath("//*[starts-with(@id,'Id_OrderForm:')]");
	public static final String Generic_TableTextData =  "//td[.='#DATA']";
	public static final By Order_Pricing_AddILFPC = By.cssSelector("img[id$='SpyGlassIL:Edit'][class='sqSelect']");
	public static final By Order_Pricing_AddCL = By.cssSelector("img[id$='SpyGlassCL:Edit'][class='sqSelect']");
	public static final By Order_Pricing_MonthlyCharges = By.xpath("(//input[@class='flatInputRight'])[1]");
	public static final By Order_Pricing_MonthlyCharges_New = By.xpath("(//input[@class='FlatInputRight'])[2]");
	public static final By Order_Pricing_One_OffCharge = By.xpath("(//input[@class='flatInputRight'])[2]");
	public static final By Order_Pricing_One_OffCharge_New = By.xpath("(//input[@class='FlatInputRight'])[3]");
	public static final String Order_Pricing_Charges_Data = "(//input[@class='FlatInputRight'])[#DATA]";
	public static final By Order_Pricing_MLISubmit = By.xpath("//span[.='Submit']");
	public static final By CustomerSignatureDateCalendar = By.xpath("//*[@id='custSigDate']/img[1]");
    public static final By ChangeCustomerSignatureDateCalendar = By.xpath("//*[@id='customerSigDateHelper']/following-sibling::a[1]/img");
    public static final By ChangeRequestedDeliveryDate_Calendar = By.xpath("//input[@id='reqChangeDateHelper']/following-sibling::a[1]/img");
	public static final By MileStone_Menu = By.xpath("//td[.='Milestones']");
	public static final By MileStone_ReadyForService = By.xpath("//td[.='Ready For Service']"); 
	public static final By MileStone_ReadyForService_CompletedDate = By.xpath("//*[@id='actualDate']/img[1]");
	public static final By MileStone_ReadyForBilling = By.xpath("//td[.='Ready For Billing']");
    public static final By Approval_CreateTechOrderButton = By.xpath("//span[@class='button_action_standard']");
    public static final By PricingApprovalNb = By.xpath("//input[@name='pricingApprovalNb']/following-sibling::img[1]");
	public static final String PanReason_Data = "//*[@id='noPANReason']/option[#DATA]";
	public static final By OpportunityReferenceNo = By.xpath("//select[@name='equotaRefNb']");
    //Teams_managing
	public static final By TeamsMenu = By.xpath("//td[.='Teams']");
	public static final By Button_ManageTeams = By.className("butManageTeams");
	public static final By SameAsCustomerCheckBox = By.xpath("//*[@id='TeamControlTechSup_Inherit']");
	public static final By TeamControlAddButton = By.id("TeamControlTechSup_add");
	public static final By TeamAddCustomerFirstName = By.id("firstNameValUser");
	public static final By TeamisLockedCheckBox = By.id("TeamControlTechSup_Locked");
	public static final By TeamControlLegal_Inherit = By.id("TeamControlLegal_Inherit");
	public static final By TeamControlLegal_add = By.id("TeamControlLegal_add");
	public static final By TeamControlLegal_SelectBox = By.id("TeamControlLegal"); 
	public static final By TeamControlLegal_Select = By.id("TeamControlLegal_Select");
	public static final By butSaveTeams = By.className("butSaveTeams");
	public static final By InformationdMenu = By.xpath("//td[.='Information']");
	public static final By Information_OpenAssocOrder = By.xpath("//img[@title='Open Associated GOLD Order.']");
	
	//Sales DRF_disconnect orders
	public static final By CircuitMRCStatus = By.xpath("//select[@name='circuitmrc']");
	public static final By RequestedDisconnectedDate = By.xpath("//span[@id='reqDisconnectDate']/img[1]");
	
	//Order_Change_______Page
		public static final String Order_Change_______Page=null;
        public static final By CreateOrderChange = By.xpath("//div[@id='CreateOrderPopUp']//td[.='Change']");
	    public static final By ChO_Selectchange_spyglass = By.xpath("//input [@id='goldOrigOrderNb_text']/following-sibling::img[1]");
	    public static final By ChO_EnterChangeOrder = By.xpath("//input [@name='orderNb']");
	    public static final By ChO_SelectChnangeType = By.xpath("//select[@name='NewchangeType']");
	    public static final By Order_SaveButton = By.xpath("//img[@class='butSave']");
		public static final By Order_StatusSearch = By.xpath("//select[@name='orderStatus']");  
		public static final By Order_PendingSubmenu = By.xpath("//td[contains(text(),'Pending')]"); 
		public static final By Order_CancelledSubmenu = By.xpath("//td[contains(text(),'Cancelled')]"); 
		public static final By Ordertype_Search = By.xpath("//select[@name='orderType']");
		public static final By Inbox_OrderType = By.xpath("//select[@name='orderTypeValInbox']");
		public static final By Inbox_OrderStatus = By.xpath("//select[@name='orderStatusValInbox']");
		public static final By Inbox_changeType = By.xpath("//select[@name='changeTypeValInbox']");
		public static final By Inbox_sourceSystem = By.xpath("//select[@name='sourceSystemVal']");
		public static final By OrderOptions_Infopage = By.xpath("//select[@name='orderType']"); 
		//public static final By CancelOrder_Submenu = By.xpath("//div[@id='order_options']/table/tbody/tr[2]"); 
		//public static final By CancelOrder_Option1 = By.xpath("//div[@id='cancel_menu']/table//td[.='No Longer Required by Customer Other']");
		public static final By CancelOrder_ConfirmCancel = By.xpath("//img[@class='butConfirmCancel']");
		public static final By Order_TypeSearch = By.xpath("//select[@name='orderType']");                   
        public static final By Order_CustomerSearch = By.xpath("//input[@name='customerName']");
        public static final By Customer_PO_Number = By.xpath("//input[@name='CustomerPONb']");
        public static final By Order_PendingCancellationCapture = By.xpath("//*[@id='LeftErrorBar']//td[contains(.,'PENDING CANCELLATION.')]");
        public static final By CancelOrder_UndoCancel = By.xpath("//img[@class='butUndoCancel']");
        public static final By Order_StatusSearch_Approval = By.xpath("//select[@name='orderStatus']/option[contains(text(),'Approval')]");
        public static final By Order_StatusSearch_Pricing = By.xpath("//select[@name='orderStatus']/option[contains(text(),'Pricing')]");
        public static final By CancelOrder_Option1 = By.xpath("//td[@class='completeTaskDropdown']/nobr[contains(text(),'No Longer Required')]");
        public static final By CancelOrder_Submenu = By.xpath("//td[@class='completeTaskDropdown']/nobr[contains(text(),'Cancel Order')]");
		
		public static final By Order_StatusColumn = By.xpath("//*[@id='grid_row_1']/td[11]");
		public static final By Order_SubmittedSuccess = By.xpath("//*[@id='LeftErrorBar']//td[contains(.,'has been submitted')]");
        public static final By Order_NotessubMenu = By.xpath("//*[@id='LeftNavBar']//table//td[contains(.,'Notes')]");
		public static final By Order_ProvisioningRow = By.xpath("//td[.='Provisioning']");
		public static final By Order_ProvisioningMessage = By.xpath("//td/textarea[@name='message']");
		// public static final By Gold_Logout2 = By.xpath("//td/a/img[@class='logout_image']");
		public static final By Gold_Logout = By.name("logout");
		public static final By Gold_Logout2 = By.name("logout");
		public static final By Documents_Menu = By.xpath("//*[@id='LeftNavBar']//table//td[contains(.,'Documents')]");
		public static final By DocumentsElement = By.xpath("//*[@id='mainDiv']//tr[@class='normalView']/td/center");
		public static final By OrderDoc_SCN = By.xpath("//*[@id='GridTableBody']/tr/td[contains(text(),'PDF SCN form')]");
		public static final By OrderDoc_SRF = By.xpath("//*[@id='GridTableBody']/tr/td[contains(text(),'SRF')]");
		public static final By OrderDoc_Galileo = By.xpath("//*[@id='GridTableBody']/tr/td[contains(text(),'Galileo text file')]");
		public static final By OrderDoc_AcknowledgeForm = By.xpath("//*[@id='GridTableBody']/tr/td[contains(text(),'PDF order acknowledge form')]");
		public static final By OrderDoc_orderform  = By.xpath("//*[@id='GridTableBody']/tr/td[contains(text(),'PDF order form')]");
		public static final By OrderDoc_Onlineorderform = By.xpath("//*[@id='GridTableBody']/tr/td[contains(text(),'PDF online order form')]");
		public static final By OrderDoc_XML = By.xpath("//*[@id='GridTableBody']/tr/td[contains(text(),'XML Interface File')]");
		public static final By OrderDoc_DRF_STN = By.xpath("//*[@id='GridTableBody']/tr/td[contains(text(),'PDF DRF/STN')]");
		//Change Order Service Build
		public static final By SB_ChnageOrderNewSB = By.xpath("//td[.='New']");		
		public static final By SB_CPEOptionOldBuild = By.xpath("//*[@id='CPE__0__Img']");		
		public static final By SB_RouterNameOldBuild = By.xpath("//*[@name='RouterName__0___OLD']");	
		public static final By SB_RouternameNewbuild = By.xpath("//input[@name='BNAZZZWUUGKEZQXF44ZDZMNECJQ1I0ZZ__0___OLD']");
		public static final By SB_CpeUSIDNewBuild = By.xpath("//input[@name='BNAZZZWUUGKEZQXF44ZDZMNEC5QYI0ZZ__0___OLD']");
		public static final By SB_AccessUSIDNewBuild = By.xpath("//input[@name='BNAZZZO5UGKEB5IBLUZBZN1MH3CSZZZZ__0___OLD']");
		public static final By SB_CommunityNewBuild = By.xpath("//*[@name='BNAZZZWUUGKEZQXF44ZDZMNEC5EEL0ZZ__0___OLD_text']");
		public static final By Migration_HotCut = By.xpath("//*[@id='mignht']");
		public static final By Migration_PremCut = By.xpath("//*[@id='mignprm']");
		public static final By Migration_SoftCut = By.xpath("//*[@id='mignsoft']");
		public static final By Completetask_SubmitRaise_disconnect = By.xpath("//div[@id='WFActionPopup']//nobr[.='submit & raise disconnect order']");
		
		public static final By Autodisconnect_Reason = By.xpath("//select[@id='clarificationReason']/option[1]");
		public static final By Autodisconnect_Comments = By.xpath("//textarea[@id='modifDesc']");
		public static final By Autodisconnect_OkButton = By.xpath("//img[@class='buttonok_image']");
		
		public static final By SCNEmailSubject = By.xpath("//*[@id='emailsubject']");     
		public static final By SCNEmailfrom = By.xpath("//textarea[@name='fromaddress']");           
		// Ojects for Webalc Interface
		// public static final String Webalc_SandBox_URL = "http://mnt.webalc.equant.com/realmode.cfm?mode=0";
		// WebALC UAT url
		//public static final String Webalc_SandBox_URL = "http://uat.webalc.equant.com/realmode.cfm?mode=2";
		public static final String Webalc_SandBox_URL = "http://uat.webalc.equant.com/partners";
		public static final By Webalc_Login_UserName_xpath = By.xpath("//input[@name='userid']");
		public static final By Webalc_Login_Password_xpath = By.xpath("//input[@name='password']");
		public static final By Webalc_Login_Submit_xpath = By.xpath("//img[@alt='Login']");
		public static final By Webalc_CPAdmin = By.xpath("//a[contains(.,'CP  Admin  ')]/strong");
		public static final By Webalc_DashBoardMenu = By.xpath("//span[contains(.,'Dashboard')]/preceding-sibling::img");
		public static final By Webalc_Landing_page = By.xpath("//*[@id='welcome_menu']/li[2]/a/img");
		
	    //Search in Inbox and Orders tab
	    public static final By SearchCriteria_OrderType = By.xpath("//select[@name='orderType']");
	    public static final By SearchCriteria_OrderStatus = By.xpath("//select[@name='orderStatus']");
	    public static final By SearchCriteria_Ordertype_ChangeType = By.xpath("//select[@name='changeTypeSearch']");
	    public static final By SearchCriteria_changeTypeInbox = By.xpath("//select[@name='changeTypeValInbox']");
	    public static final By SearchCriteria_productService = By.xpath("//input[@name='productService']");
	    public static final By SearchCriteria_bundledOrderIndicator = By.xpath("//select[@name='bundledOrderIndicator']");
	    public static final By SearchCriteria_customerName = By.xpath("//input[@name='customerName']");
	    public static final By SearchCriteria_sourceSystem = By.xpath("//select[@name='sourceSystem']");
	    public static final By SearchCriteria_salesRegion = By.xpath("//select[@name='salesRegion']");
	    public static final By SearchCriteria_salesCountry = By.xpath("//select[@name='salesCountry']");
	    public static final By SearchCriteria_salesCampaign = By.xpath("//select[@name='salesCampaign']");
	    public static final By SearchCriteria_siteCity = By.xpath("//input[@name='siteCity']");
	    public static final By SearchCriteria_siteCountry = By.xpath("//input[@name='siteCountry']");
	  //Copy functionality
	    public static final By OrderInfomationPage_OptionMenu = By.xpath("//img[@class='butOptionsBlue_image']");
	    public static final By Copy_CommercialInforamtion = By.xpath("//img[@Title='Copies only the Commercial Information page']");
	    public static final By Option_Copy = By.xpath("//*[@id='order_options']//nobr[.='Copy Order']");
	    public static final By Option_CopyCommercialinformationOnly = By.xpath("//*[@id='copy_menu']/table//td[@title='Copies only the Commercial Information page']");
	    public static final By Option_EntireOrderSameLocalSite = By.xpath("//*[@id='copy_menu']/table//td[@title='Copies Commercial, Technical and Pricing Information']");
	    public static final By Option_EntireOrderDifferentLocalSite = By.xpath("//*[@id='copy_menu']//nobr[.='Entire Order (different local site)']");
	    //Templates Functionality
	    public static final By Templates = By.xpath("//td[.='Templates']");
	    public static final By CreateTemplate = By.xpath("//*[@id='CreateOrderImg']");
	    public static final By CommercialTemplate = By.xpath("//td[@class='completeTaskDropdown']//nobr[.='Commercial']");
	    public static final By TemplateName = By.xpath("//input[@name='tName']");   
	    public static final By Template_approve = By.xpath("//td[@class='normalView']//input[@name='commercialApproval_value']");  
	    public static final By Template_createneworder = By.xpath("//img[@class='butCreateNewOrder']"); 
	    //LTB
	    public static final By LTB_product = By.name("productFilterVal");
	    public static final By LTB_Manage = By.xpath("//img[@class='butManageLTB']");
	    public static final By LTB_Add_ProductName=By.id("productName");
	    public static final By LTB_SelectLTB = By.xpath("//*[@id='leadTimeBasis']"); // By.id("leadTimeBasis");
	    public static final By LTB_DeLink = By.xpath("//img[@class='butDeleteLTB']");
	    //notes
	    public static final By ProvisioningSystemNotesRow = By.xpath("//td[.='Provisioning']/following-sibling::td[.='system']");
	    //Bundle orders objects
	    public static final By MasterSiteOrder = By.xpath("//select[@id='bundleorderindicator']/option[contains(text(),'Master Site Order')]");
	    public static final By ChildDeliveryOrder = By.xpath("//select[@id='bundleorderindicator']/option[contains(text(),'Child Delivery Order')]");
	    public static final By DeliveryOrders = By.xpath("//tr[@title='Delivery Orders']");
	    public static final By ProvRefNumber = By.xpath("//img[@title='Provisioning Reference Number']");
	    public static final By L2ppCPEUSID = By.xpath("//td[@title='CPE Unique Service identifier, allocated by GOLD']/following-sibling::td[4]");
	    public static final By BVC_CPEUSID = By.xpath("//input[@name='BNAZZZWUUGKEZQXF44ZDZMNECDPLNZZZ__0___OLD']");
		
	    public static final By L2ppCPEUSIDSerChange = By.xpath("//td[@title='CPE Unique Service identifier, allocated by GOLD']/following-sibling::td[7]");
	    public static final By L2ppCPEUSIDMigHotCut = By.xpath("(//td[contains(text(),'CPE USID')]/following-sibling::td[4])[1]");
	    public static final By EditUser = By.xpath("//img[@title='Edit user']");
	    public static final By CommTechTemplate = By.xpath("//td[@class='completeTaskDropdown']//nobr[.='Commercial/Technical']");
	    public static final By TechnicalTemplate = By.xpath("//td[@class='createOrderDropdown']//nobr[.='Technical']");
	    public static final By TemplateNameEnter = By.xpath("//input[@name='templateName']");
	    public static final By CreateDeliveryOrder = By.xpath("//img[@class='sqAdd']");
	    public static final By FirstChildOrder = By.xpath("//tr[@class='rowListOdd']/td[1]/a[1]");
	    public static final By FirstChild = By.xpath("//td[contains(text(),'Referenced Child Order(s)')]/following-sibling::td/a[1]");
	    public static final By OpenAssociatedOrder = By.xpath("//img[@title='Open Associated GOLD Order.']");
	    public static final By CustomerView = By.xpath("//td[.='Customer View']");
	    public static final By RebuildPage = By.xpath("//img[@title='Regenerate Customer View']");
	    public static final By LeadTime = By.xpath("//input[@id='leadTime']");
	    public static final By AddGOLDUSID = By.xpath("//img[@title='Add GOLD USID']");
	    public static final By OrderAccepted = By.xpath("//td[contains(text(),'Order has been accepted')]");
	    public static final By GOLDUSID_ADDInstances = By.xpath(".//*[@id='instances_BNAZZZO5UGKEZ0UK5UZOJ23MJLWDIWYZ']");
	    public static final By GOLDUSID_OK = By.xpath(".//*[@id='button_BNAZZZO5UGKEZ0UK5UZOJ23MJLWDIWYZ']");
	    public static final By CreateNewUser = By.xpath("//img[@title='Create new user']");
	    
	    // FPC Management
	    public static final By SearchFPC_FPC = By.xpath("//input[@name='FPCFilterVal']");
	    public static final By SearchFPC_Description = By.xpath("//input[@name='DescriptionFilterVal']");
	    public static final By SearchFPC_ServiceID = By.xpath("//input[@name='ServiceIDFilterVal']");
	    public static final By ProductSearch_Services = By.xpath("//input[@name='nameValService']");
	    public static final By ProductFPC_Association = By.xpath("//td[contains(.,'Business Unit')]/ancestor::tr/preceding-sibling::tr[1]/td[2]/following-sibling::td[1]");
	    
	    // OIT
	    // public static final By Order_List = By.cssSelector("div.tabs > table > tbody > tr > td a[title='Order List']");
	    public static final By Order_List = By.cssSelector(".tabs>table>tbody>tr>td>ul>li>a>span");
	    public static final By OIT_OrderFormFrame = By.name("contentFrm");
	    public static final By OIT_OrderNumber = By.name("intakeReferenceNumberInOrderList");
	    public static final By OIT_SearchOrders = By.xpath("//input[@alt='Click here to search orders by SearchCriteria']");
	    public static final By OIT_ResultsTable = By.className("dataTable");
	    //created the result row using data SC_Test_0017
	    public static final By OIT_ResultsTableBanner = By.xpath("//table[@class='pagebanner']//td[contains(.,'Orders Found : 1')]");
	    
	    //Clarification tasks objects 
	    public static final By Submit_CommercialClarification1 = By.xpath("//div[@id='WFActionPopup']/table/tbody/tr[2]/td[2]/nobr");
		public static final By Select_ClarificationReason = By.xpath("//select[@id='clarificationReason']/option[2]");
		public static final By Select_ClarificationReasonDisc = By.xpath("//select[@id='clarificationReason']/option[1]");
	    public static final By Enter_Clarificationcommnents = By.xpath("//textarea[@id='modifDesc']");
	    public static final By SelectOK_Clarificationcommnents = By.xpath("//img[@class='buttonok_image']");
	    //public static final By OrderTask_ClarificationforTech = By.xpath("//td[contains(text(),'Commercial Clarification for Technical Details')]");
	    public static final String Verify_CurrentTask = "//span[contains(text(),'#DATA')]";
	    public static final By TaskListInitiateBilling1 = By.xpath("//td/nobr[.='Setup Billing']");
	    
		public static final By Submit_CommercialClarification = By.xpath("//div[@id='WFActionPopup']//nobr[.='commercial clarification']");
		public static final By Submit_TechnicalClarification = By.xpath("//td[@class='completeTaskDropdown']/nobr[.='Technical Clarification']");
		public static final By Submit_TechnicalClarification1 = By.xpath("//td[@class='completeTaskDropdown']/nobr[.='technical clarification']");
		public static final By Submit_DocClarification = By.xpath("//div[@id='WFActionPopup']//nobr[.='DOC clarification']");
		public static final By Submit_DocClarification1 = By.xpath("//div[@id='WFActionPopup']//nobr[.='send to DOC for clarification']");
		public static final By Submit_adminClarification = By.xpath("//div[@id='WFActionPopup']//nobr[.='disconnect administrator clarification']");		
		
		public static final By Task_legalapproval = By.xpath("//td/nobr[.='Legal Approval']");
		public static final By Task_legalClarifciation = By.xpath("//td/nobr[.='Legal Clarification']");
		
		public static final String select_currenttask = "//td/nobr[.='#DATA']";
		
	//	Rules objects		
		public static final By Rules_CreateNew = By.xpath("//img[@class='butCreateNew']");
		public static final By Rule_Name = By.xpath("//input[@id='name']");
		public static final By SelectProduct_ServiceSpy = By.xpath("//td[contains(.,'Product / Service')]/img[1]");
		
		public static final By Select_Product = By.xpath("//select[@id='criteriaSelect']");
		public static final By Select_ProductOK = By.xpath("//img[@id='okButton']");
		public static final By Select_emailNotification = By.xpath("//input[@value='-2147469553']");
		
		public static final By Select_ToUser = By.xpath("//td[contains(.,'GOLD Users')]/img[1]");
		public static final By Select_UserLastName = By.xpath("//input[@id='lastNameValUser']");
		public static final By Select_UserFirstName = By.xpath("//input[@id='firstNameValUser']");
		
		public static final By Select_UserNameOK = By.xpath("//img[@id='searchButton']");
		public static final By Select_CustomOption = By.xpath("//input[@id='emailNotificationMesageType' and @value='2']");
		public static final By Select_DOOTeam_Specific = By.xpath("//input[@id='DelOrdOwner_type' and @value='3']");
		public static final By SelectDOOTeam_SpecificSpy = By.xpath("//td[contains(.,'Specific')]/img[@id='TeamControlDelOrdOwner_add']");
		public static final By Submit_Subject = By.xpath("//input[@name='emailNotificationCustomSubject']");
		
		public static final By Submit_Rule = By.xpath("//img[@class='butSubmit'][1]");
		public static final By Edit_Rule = By.xpath("//img[@class='butEdit'][1]");
		
		public static final By RuleOn_New = By.xpath("//input[@id='checkbox1']");
		public static final By RuleOn_Change = By.xpath("//input[@id='checkbox2']");
		
		public static final By RuleCreation_message = By.xpath("//*[@id='LeftErrorBar']//td[contains(.,'successfully saved')]");
		
		//Products
		public static final By Tools_ProductsSubMenu = By.xpath("//td[.='Products']");
		public static final By Tools_AttributeSubMenu = By.xpath("//td[.='Attributes']");
		public static final By Tools_CompSubMenu = By.xpath("//td[.='Components']");
		public static final By Tools_ElementSubMenu = By.xpath("//td[.='Elements']");
		public static final By Tools_ProductsCreateNew = By.xpath("//img[@class='butCreateNew'][1]");
		public static final By Product_Name = By.xpath("//input[@id='serviceName']");
		public static final By Product_IsService = By.xpath("//input[@name='isService' and @type='checkbox']");
		public static final By Product_IsStandalone = By.xpath("//input[@name='isStandAlone' and @type='checkbox']");
		public static final By Product_CatalogIDDeduction = By.xpath("//input[@name='isCatalogIDDeduction' and @type='checkbox']");
		public static final By Product_BundleSolution = By.xpath("//select[@id='bundleSolution']/option[3]");
	    public static final By Product_NewOption = By.xpath("//input[@id='usage1']");
		public static final By Product_ChangeOption = By.xpath("//input[@id='usage3']");
		public static final By Product_DisconnectOption = By.xpath("//input[@id='usage2']");
		public static final By Product_SelectCatalogueSpy = By.xpath("//td[contains(.,'Catalog Name ')]/img[1]");
		public static final By Product_CatSearch = By.xpath("//input[@name='nameValService']");
		public static final By Product_SelectCatalogue = By.xpath("//td[.='#DATA']");
		public static final By Product_SBCheckbox = By.xpath("//input[@id='prodType']");
		public static final By Product_SBComponentSPY = By.xpath("//td[contains(.,'Components')]/img[1]");
		public static final By ResultSecondRow = By.xpath("//*[@id='grid_row_2']");
		public static final By Product_addComponent = By.xpath("//img[@class='butAddComponent'][1]");
		public static final By Product_CreationMessage = By.xpath("//*[@id='LeftErrorBar']//td[contains(.,'saved successfully')]");
		public static final By Product_NameSearch = By.xpath("//input[@name='nameValService']");
		public static final By Product_SaveButton = By.xpath("//img[@class='butSave'][1]");
		public static final By Product_ActiveStatus = By.xpath("//tr[@id='grid_row_1']/td[contains(.,'Active')]");
		public static final By Product_ActiveStatusCheckbox = By.xpath("//input[@name='isActive']");
		public static final By Product_StatusMessage = By.xpath("//*[@id='LeftErrorBar']//td[contains(.,'selectable for orders')]");
		

		public static final By Nameerror_message = By.xpath("//*[@id='LeftErrorBar']//td[contains(.,'service with an empty name')]");
		public static final By Tools_ElementName = By.xpath("//input[@id='description']");
		public static final By Tools_FieldNameText = By.xpath("//select[@id='fieldType']/option[2]");
		public static final By Tools_FieldNameList = By.xpath("//select[@id='fieldType']/option[3]");
		public static final By Tools_FieldNameNumeric = By.xpath("//select[@id='fieldType']/option[7]");
		public static final By Product_IsMendatory = By.xpath("//input[@name='IsMandatory' and @type='checkbox']");
		public static final By Product_isDisplayedInSCN = By.xpath("//input[@name='isDisplayedInSCN' and @type='checkbox']");
		public static final By Product_helptext = By.xpath("//input[@id='helpText']");
		
		
		
		public static final By Comp_NameSearch = By.xpath("//input[@name='L2nameValService']");
		public static final By Product_ElementSPY = By.xpath("//td[contains(.,'Elements')]/img[1]");
		public static final By Ele_NameSearch = By.xpath("//input[@name='L2nameValServiceInSelector']");
		public static final By Product_AttributeSPY = By.xpath("//td[contains(.,'Select/Change:/Delete Parent')]/img[1]");
		
		public static final By ManitenanceMenu = By.linkText("Maintenance");
		public static final By Product_Uploadspy = By.xpath("(//img[@id='button_browse'])[1]");
		public static final By Product_StartUploadButton = By.xpath("//img[@class='butStartUpload']");
		//public static final By Product_UploadSuccessMessage = By.xpath("//table[@class='contentPane']//div[contains(.,'Data was updated successfully')]");
		public static final By Product_UploadSuccessMessage = By.xpath("//table[@class='contentPane']/tbody/tr/td/div/div");
		
		
		public static final By Product_uploadButton = By.xpath("//td[contains(.,'Upload')]/following-sibling::td/img[1]");
		public static final By Product_productService_button = By.xpath("(//td[contains(.,'Products/Services')]/following-sibling::td)[2]/img");
		public static final By CatalogueLink = By.linkText("Upload Catalog Management Files");
		
		// sprint4 Harsh
	    public static final By CreateOrderDisconnect = By.xpath("//td[@class='createOrderDropdown']/nobr[contains(.,'Disconnect')]");
	    public static final By ProjectSelect = By.xpath("//img[@class='sqSelect' and @title='Select a Project']");
	    public static final By ModifyMenu = By.xpath("//td[@title='Modify an order out of the context of a task.']/nobr");
	    public static final By WithoutPriceImpact = By.xpath("//td[@class='completeTaskDropdown']/nobr[contains(text(),'Without Price Impact')]");
	    public static final By WithPriceImpact = By.xpath("//td[@class='completeTaskDropdown']/nobr[contains(text(),'With Price Impact')]");
	    public static final By BackToCommercial = By.xpath("//td[@class='completeTaskDropdown']/nobr[contains(text(),'Back to Capture Commercial Details')]");
	    public static final By SaveModifications = By.xpath("//img[contains(@title,'Save modifications')]");
	    public static final By SRFNotReq = By.xpath("//td[@class='completeTaskDropdown']/nobr[contains(text(),'SRF not required')]");
	    public static final By CustNotForApproval = By.xpath("//td[@class='completeTaskDropdown']/nobr[contains(text(),'Notification of Approval')]");
	    public static final By Disconnect_TeamisLockedCheckBox = By.xpath("//input[@id='TeamControlDisconnectAdmin_Locked']");
	    public static final By ModifyMWOPI = By.xpath("//textarea[@id='modifDesc']");
	    public static final By SaveModification = By.xpath("//img[@title='Submit the modifications']");
	    public static final By MWOPIMilestone = By.xpath("//td[.='Modify Without Price Impact']");
	    
	    public static final By AddDTVSTeam = By.xpath("//img[@id='TeamControlDTVS_add']");
        public static final By SitesMenu = By.xpath("//td[.='Sites']");
        public static final By CreateNewSite = By.xpath("//img[@class='butCreateNew']");
        public static final By PartnerWholesaleCheck = By.xpath("//input[@name='partnerWholeSale']");
	    
	    // disconnect
	    public static final By Disconnect_SBuild_BVPNServicePlug_CheckBox = By.xpath("//input[@id='BNAZZZWUUGKEZQXF44ZDZMNECJFCI0ZZ__0___NEW']"); 
  		public static final By Disconnect_SBuild_Accessconnection = By.xpath("//input[contains(@id,'__0___NEW')]");
  	    public static final By Completetask_Valid = By.xpath("//div[@id='WFActionPopup']//nobr[.='valid']");
  		public static final By Completetask_Evaluation_done = By.xpath("//div[@id='WFActionPopup']//nobr[.='Evaluation done']");
  		public static final By Completetask_Reject_Charges = By.xpath("//div[@id='WFActionPopup']//nobr[.='Reject charges']");
  		public static final By Disconnect_TaskListCustomerApproval = By.xpath("//td/nobr[.='Customer approved']");
  		public static final By Disconnect_CustomerSignatureDateCalendar = By.xpath("//*[@id='customerSigDate']/img");
  		public static final By Disconnect_Admin_SameAsCustomerCheckBox = By.xpath("//*[@id='TeamControlDisconnectAdmin_Inherit']");
  		public static final By Disconnect_TeamControlAddButton = By.xpath("//*[@id='TeamControlDisconnectAdmin_add']");
  		
  		//EAI
  		public static final By SeeFlows = By.xpath("html/body/div[1]/div[1]/div[1]/div/a");
        public static final By FromDate = By.xpath("//input[@id='inStartDate']");
        public static final By FlowCode = By.xpath("//input[@id='inFlowCode']");
        public static final By SearchButtonEAI = By.xpath("//input[@name='searchButton']");
        public static final By NbOfFlows = By.xpath("(//tr[@class='heading'])[2]/following-sibling::tr[1]/td[3]/a[1]");
        public static final String OrderNumberSearchEAI = "//table[@class='tableView']/tbody/tr/td[contains(.,'#DATA')]";
        
        // reject object
        public static final By Completetask_Reject_clarificationReason = By.id("clarificationReason"); // Commercial
    	public static final By Completetask_Reject_Comments = By.id("modifDesc");
    	public static final By Completetask_rejectokButton = By.xpath("//img[@name='okButton']");
    	
    	// bulk tasks
    	/*
    	public static final By TeamControlSales_Inherit = By.xpath("//*[@id='TeamControlSales_Inherit']");
    	public static final By TeamControlDelOrdOwner_Inherit = By.xpath("//*[@id='TeamControlDelOrdOwner_Inherit']");
    	*/
    	//tr[@title='Bulk Tasks']/td
    	public static final By BulkTasksMenu = By.xpath("//tr[@title='Bulk Tasks']/td");
    	public static final String BulktaskSubMenu_Data = "//tr[@title='#DATA']/td";
    	public static final String BulktaskOrderRow_Data = "//*[@id='GridTableBody']//td[.='#DATA']";
  		public static final By BulksubmitTaskDropDown = By.xpath("//img[@class='butSubmitBlue_image']");
  		public static final String BulkSubmitTask = "//div[@id='bulk_workflow_task']/table//td[@class='completeTaskDropdown' AND @title='#DATA']";
		//div[@id='bulk_workflow_task']/table//td[@class='completeTaskDropdown' AND @title='Complete Task (SRF2 not required for this order)']
  		 public static final By ViewCategory_Miletone = By.xpath("//select[@name='categoryValMilestone']");
 	    public static final By OrderSearch_BundledOrder = By.xpath("//select[@name='bundledOrderIndicator']");
 	    
 	    //Contract
        
    	public static final By ContractCreateNew = By.xpath("//img[@class='butCreateNew']");
    	public static final By ContractIDBox = By.xpath("//input[@id='contractID']");
    	public static final By LocalCurrencyPricing = By.xpath("//select[@id='LocalCurrencyPricing']");
    	public static final By LegelEntity = By.xpath("//select[@id='legalEntity']");
    	public static final By ContractType = By.xpath("//select[@id='contractType']");
    	public static final By ExpiryDate = By.xpath("//input[@id='expiryDate']");
    	public static final By RaggedType = By.xpath("//select[@id='termType']");
    	public static final By InitialTerm = By.xpath("//select[@id='initialTerm']");
    	public static final By EffectiveDate = By.xpath("//input[@id='effectiveDate']");
    	public static final By ContractID = By.xpath("//input[@id='nameValContract']");
    	
    	//Create Contacts Sumit
        public static final By ContactMenu = By.linkText("Contacts");
        public static final By Searchfirstname_EditBox = By.id("firstName_cnt");
        public static final By Searchlastname_EditBox = By.id("lastName_cnt");
        public static final By Searchphone_EditBox = By.id("phone_cnt");
        public static final By Searchemail_EditBox = By.id("email_cnt");
        //Search Contact and Modify and Delete Sumit
        public static final By Enterfirstname_EditBox = By.id("firstnameValContact");
        public static final By MileStone_PortRDate = By.xpath("//td[.='Port Released Date']");
        
        // Templates and Options menu
        public static final By Template_Popup = By.cssSelector("#CreateOrderPopUp");
    	public static final By ApplyTemplate_Popup1 = By.cssSelector("#order_options");
    	public static final By ApplyTemplate_Popup = By.cssSelector("#apply_template_menu");
    	public static final By CustomerPONo = By.xpath("//input[@name='CustomerPONb']");
    	public static final By TaskListWOPriceOrder = By.xpath("//td/nobr[.='WO Price Order']");
    	public static final By Cancelbutton = By.className("butCancel");
    	public static final By CopyOrder_Popup = By.cssSelector("#copy_menu");
    	public static final By CancelOrder_Popup = By.cssSelector("#cancel_menu");
    	public static final By OrderOptions_Popup = By.cssSelector("#order_options");
		public static final By ModifyOrder_Popup = By.cssSelector("#modif_menu");
    	public static final By PartialBillingMenu = By.xpath("//*[@id='order_options']/table/tbody/tr[10]/td[2]/nobr");
    	public static final By PartialBillingMenu2 = By.xpath("//*[@id='order_options']/table/tbody/tr[8]/td[2]/nobr");
    	public static final By OIT_Logout = By.xpath("//a[@title='Logout']");
    	public static final By Select_PartialBillingReason = By.xpath("//select[@id='clarificationReason']/option[2]");
    	public static final By PartialBillingReason_Comments = By.xpath("//textarea[@id='modifDesc']");
		public static final By PartialBillingReason_OkButton = By.cssSelector(".buttonok_image");
		public static final By PartialBilling_Calendar = By.cssSelector(".sqCalendar");
		public static final By QuoteLineItemsTableFirstRow1 = By.xpath("//td[starts-with(@id,'id_NEW_')]/nobr");
		public static final By SBuild_APCN_MDNSNetworkAccess = By.xpath("//img[@title='Add APCN/MDNS Network Access']");
		public static final By SBuild_APCN_MDNS_AddNumInstance = By.xpath("//*[@id='instances_BNAZZZQ5UGKEZ24MSUZB2NQ4BQJGQ0ZZ']");
		public static final By SBuild_APCN_MDNS_WebALC = By.id("circuitQuoteID");
		public static final By SBuild_SearchButton = By.xpath("//img[@class='editMagnifier']");
		public static final By SBuild_AcceptButton = By.xpath("//img[@class='butAccept']");
		public static final By SBuild_SelectWebalcQuote = By.xpath("//img[@title='Select Webalc Quote']");
		public static final By SBuild_APCN_MDNS_Access = By.id("BNAZZZQ5UGKEZ24MSUZB2NQ4BQJGQ0ZZ__0__Img");
		public static final By SBuild_APCN_MDNS_AddNumInstanceOK = By.xpath("//input[@id='button_BNAZZZQ5UGKEZ24MSUZB2NQ4BQJGQ0ZZ']");
		public static final By SBuildProduct_Category = By.xpath("//*[@name='prodCategory']");
		public static final By SBuildProduct_Service = By.xpath("//*[@id='chooseServiceDropDown']");
		  
		// change Order 16-3-2016
		public static final By SBuild_Existing_APCN_MDNS = By.xpath("//img[@title='Add Existing APCN/MDNS Network Access']");
		public static final By SBuild_APCN_MDNS_Access2 = By.id("BNAZZZQ5UGKEZ24MSUZB2NQ4BQJGQ0ZZ__1__Img");
		public static final By SBuild_CircuitCode = By.id("BNAZZZQ5UGKEZ24MSUZB2NQ4BQHGQ0ZZ__0___attr_searchbutton");
		public static final By SBuild_CircuitCode2 = By.id("BNAZZZQ5UGKEZ24MSUZB2NQ4BQHGQ0ZZ__1___attr_searchbutton");
		public static final By SBuild_ME = By.xpath("//td[='ME']");
		public static final By SBuild_POP_Code = By.xpath("//td[.='BLRT07']");
		public static final By SBuild_Offer_Name = By.xpath("//td[.='National Dedicated Ethernet - FastE']");
		public static final By SBuild_Access_Speed = By.xpath("//td[='10000']");
				
		// Change order when change type is Service Change
		public static final By SBuild_Service_Change = By.xpath("//*[@name='NewchangeType']");
		public static final By SBuild_New_APCN_MDNS = By.xpath("//img[@title='Add Existing APCN/MDNS Network Access']");
		public static final By Select_View = By.xpath("//select[@id='pricingViews']/option[3]");
		public static final By NoPricedItems = By.xpath("//*[@id='QuoteLineItems']//td[contains(.,'There are no priced items for this order')]");
		public static final By MonthlyChargesData = By.xpath("//*[@id='QuoteLineItems']//td[@id[contains(.,':1:MonthlyCharges')]]");
		public static final By Contracting_Party_Customer_Number = By.xpath("//*[@name='organizationIdValCustomer']"); // By.id("organizationIdValCustomer");
		public static final By Completetask_SendACKCust = By.xpath("//div[@id='WFActionPopup']//nobr[.='Send ACK to customer']");
		public static final By Completetask_SendCOToSITA = By.xpath("//div[@id='WFActionPopup']//nobr[.='Send COF To SITA']");
		public static final By PrimaryEmail_ID = By.xpath("//*[@name='primaryEmail_sita']");
		public static final By Completetask_SendClarificationSITA = By.xpath("//div[@id='WFActionPopup']//nobr[.='Send Clarification To SITA']");
		public static final By Completetask_SendTechnicalClarificationSITA = By.xpath("//div[@id='WFActionPopup']//nobr[.='Send Technical Clarification To SITA']");
		// Priced Items in New Order 17/3/2016
		public static final By Order_Status = By.xpath("//select[@name='orderStatus']");
		public static final By New_OrderNumber = By.xpath("//img[@id='Select Webalc Quote']");
		public static final By New_SearchButton = By.id("searchButton");
		public static final By New_Pricing = By.xpath("//td[.='Pricing']");
		public static final By New_Priced_Items = By.xpath("//*[@name='pricingViews']");
		public static final By New_Price_Items = By.xpath("//id[contains(.,':NewMonthlyCharge']");
		public static final By New_Bundletype = By.xpath("//select[@name='bundledOrderIndicator']");
		public static final By Disconnect_Pricing = By.xpath("//td[.='Penalties']");
		public static final By Disconnect_Priced_Items = By.xpath("//*[@id='pricingViews']");
		public static final By New_Priced_Items2 = By.xpath("//*[@id='pricingViews']/option[3]");
		
		/* 24 Mar 2016 Technical Template */
		public static final By Template_edit = By.xpath("//img[@title='Edit this order']");
		public static final By Tecnical_message = By.xpath("//*[@id='LeftErrorBar']//td[contains(.,'Successfully copied')]");
		
		public static final By PrimaryD1Throughput_Data = By.name("BNAZZZWUUGKEZQXF44ZDZMNEC1CMAZZZ__0___OLD");
		public static final By PrimaryD2Throughput_Data = By.name("BNAZZZWUUGKEZQXF44ZDZMNECDAMAZZZ__0___OLD");
		public static final By PrimaryD3Throughput_Data = By.name("BNAZZZWUUGKEZQXF44ZDZMNEC5TMAZZZ__0___OLD");
		public static final By SecondaryD1Throughput_Data = By.name("BNAZZZWUUGKEZQXF44ZDZMNEC1Y3AZZZ__0___OLD");
		public static final By SecondaryD2Throughput_Data = By.name("BNAZZZWUUGKEZQXF44ZDZMNEC5JVAZZZ__0___OLD");
		public static final By SecondaryD3Throughput_Data = By.name("BNAZZZWUUGKEZQXF44ZDZMNECJRVAZZZ__0___OLD");
		public static final By SaveTemplate_Popup = By.cssSelector("#create_template_menu");
		public static final By Template_Name = By.xpath("//input[@name='tName']");
		
		public static final By Order_Milestone = By.xpath("//td[.='Customer Appr...']");
		public static final By Submit_Milestone = By.xpath("//img[@Title='Bulk Tasks']");
		public static final By Milestone = By.xpath("//td[.='Milestones']");
		public static final By View_Category = By.xpath("//*[@name='categoryValMilestone']");
		public static final By Milestone_Capture = By.xpath("//*[@id='grid_row_1']/td[3]");
		public static final By MilestoneDropDown = By.xpath("//select[@name='title']"); // A25 - General
        public static final By AddToOrderButton = By.xpath("//html/body/form[2]/table/tbody/tr/td/table[1]/tbody/tr/td[2]/img");
        public static final By BulkTaskOKButton = By.xpath("html/body/table/tbody/tr[1]/td[2]/img");
        public static final By TargetDate_Calendar = By.xpath("//*[@id='targetDate']/img[1]");
        public static final By Create_User = By.xpath("//img[@title='Create this user']");
        public static final By ftid = By.id("ftid");
        public static final By OrangeSiteRef = By.xpath("//*[@id='orangeSiteNameValSite']");
        public static final By LocalCurrencyList = By.xpath("//*[@id='localcurrencylist']");
        
        // Added on 02/06/2016
        public static final By MLANEquipmentOrdering = By.xpath("//img[@title='Add MLAN Equipment Ordering']");
     	public static final By MLANServices_AddNumInstance = By.xpath("//*[@id='instances_BNAZZZO5UGKEZ0UK5UZOJ23MJLNCVHYZ']");
     	public static final By MLANProfile = By.xpath("//img[@title='Add MLAN Profile']");
     	public static final By MLANProfile_AddNumInstance = By.xpath("//*[@id='instances_BNAZZZO5UGKEZ0UK5UZOJ23MJUNCVHYZ']");
     	public static final By MLANProfile_OK = By.xpath("//*[@id='button_BNAZZZO5UGKEZ0UK5UZOJ23MJUNCVHYZ']");
     	public static final By MLANProfile_Expand = By.xpath("//*[@id='BNAZZZO5UGKEZ0UK5UZOJ23MJUNCVHYZ__0__Img']");
     	public static final By MLANProfile_Community = By.xpath("//*[@id='BNAZZZO5UGKEZ0UK5UZOJ23MJUFCVHYZ__0___OLD_text']");
     	public static final By MLANServiceManagement = By.xpath("//img[@title='Add Service Management (Service Select)']");
     	public static final By MLANerviceManagement_AddNumInstance = By.xpath("//*[@id='instances_BNAZZZO5UGKEZ0UK5UZOJ23MJQNCVHYZ']");
     	public static final By MLANerviceManagement_OK = By.xpath("//*[@id='button_BNAZZZO5UGKEZ0UK5UZOJ23MJQNCVHYZ']");
     	public static final By MLANEquipmentOrdering_Expand = By.xpath("//*[@id='BNAZZZO5UGKEZ0UK5UZOJ23MJLNCVHYZ__0__Img']");
     	public static final By PAN_Data = By.xpath("//*[@id='noreasonDIV']");
        public static final By NewMLANEquipmentOrdering = By.xpath("//img[@title='Add Existing MLAN Equipment Ordering']");
        public static final By NewMLANerviceManagement_OK = By.xpath("//*[@id='button_BNAZZZO5UGKEZ0UK5UZOJ23MJLNCVHYZ']");
        public static final By NewMLANProfile = By.xpath("//img[@title='Add Existing MLAN Profile']");
        public static final By NewMLANServiceManagement = By.xpath("//img[@title='Add Existing Service Management (Service Select)']");
        public static final By NewMLANProfile_Expand = By.xpath("//*[@id='BNAZZZO5UGKEZ0UK5UZOJ23MJUNCVHYZ__0__Img']");
        public static final By NewMLANProfile_Community = By.xpath("//*[@id='BNAZZZO5UGKEZ0UK5UZOJ23MJUFCVHYZ__0___NEW_text']");
        public static final By NewMLANProfile_Expand1= By.xpath("//*[@id='BNAZZZO5UGKEZ0UK5UZOJ23MJUNCVHYZ__0__Img']"); 
        public static final By NewMLANProfile_Community1 = By.xpath("//*[@id='BNAZZZO5UGKEZ0UK5UZOJ23MJUFCVHYZ__1___NEW_text']");
        public static final By NewMLANService = By.xpath("//*[@id='BNAZZZO5UGKEZ0UK5UZOJ23MJYMCVHYZ__0___attr']");
        public static final By NewMLANSErvice_Expand = By.xpath("//*[@id='BNAZZZO5UGKEZ0UK5UZOJ23MJLNCVHYZ__0__Img']");

		public static final By Submit_Popup = By.cssSelector("#WFActionPopup");
      	public static final By CopyMenu = By.cssSelector("#copy_menu");
    	public static final By OptionsMenu = By.cssSelector("#order_options");
    	public static final By CancelMenu = By.cssSelector("#cancel_menu");
    	// public static final By ActionsMenu = By.cssSelector("#butActionBlueRollover_image");\
    	public static final By ActionsMenu = By.xpath("//table[@class='contentPane']/tbody/tr/td/table[2]/tbody/tr/td[3]/img");
       	public static final By BulkMenu = By.cssSelector("#bulk_submit");
       	public static final By BackToOrderTypeMenu = By.cssSelector("#modifWpi_menu");
       	
    	public static final String TargetDate_Data = "//*[@id='wholedoc']/center//div[.='#DATA']";
    	public static final By BulkTaskSucessMessage = By.xpath("html/body/table/tbody/tr[3]/td[2]");
    	public static final By PricingViews = By.xpath("//*[@id='pricingViews']"); // Priced Items
    	public static final By PricdeItemViews = By.xpath("//tr[@class='rowListOdd']/td[contains(.,'Active Prevention')]");
    	public static final By SaveOrder = By.xpath("//img[@class='butSavebutSaveRollover']");
    	public static final By PrimaryEmailSITA = By.xpath("//html/body/form[2]/table/tbody/tr/td/table[4]/tbody/tr[2]/td[2]/textarea");
    	public static final By SendMailSITA = By.xpath("//html/body/form[2]/table/tbody/tr/td/table[1]/tbody/tr/td[1]/img");
    	public static final By SBuild_SubmitTechnical_SendTechClarificationSITA = By.xpath("//div[@id='WFActionPopup']/table/tbody/tr[11]/td[2]/nobr");
    	public static final By Order_SubmittedMilestoneSITAClarificationComm = By.xpath("//*[@id='grid_row_2']//td[contains(.,'SITA Clarification for Commercia...')]");
    	public static final By Order_SubmittedMilestoneSITATechnicalComm = By.xpath("//*[@id='grid_row_2']//td[contains(.,'SITA Clarification for Technical...')]");
    	public static final By Order_SubmittedMilestoneSendACKCustomer = By.xpath("//*[@id='grid_row_2']//td[contains(.,'Send ACK to Customer')]");
    	public static final By Order_SubmittedMilestoneNoteSuccess = By.xpath("//*[@id='grid_row_1']//td[contains(.,'Customer Updates')]");
    	
    	public static final By ModifyMenu2 = By.cssSelector("#modif_menu");
    	public static final By Options_ModifyOrder = By.xpath("//div[@id='order_options']//nobr[.='Modify Order']");
    	public static final By ModifyOrder_WithPriceImpact = By.xpath("//div[@id='modif_menu']//nobr[.='With Price Impact']");
    	public static final By ModifyOrder_WithPriceImpact_BackCaptureTechnicalDetails = By.xpath("//div[@id='modifWpi_menu']//nobr[.='Back to Capture Technical Details']");
    	public static final By ClarificationReason = By.xpath("//*[@id='clarificationReason']");
    	public static final By ClarificationOkButton = By.xpath("//img[@class='buttonok_image']");   // "img[@name='okButton']"); // "//html/body/table/tbody/tr[3]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[3]/img
    	public static final By Order_StatusAfterModification = By.xpath("//*[@id='grid_row_1']//td[contains(.,'Creation')]");
    	public static final By TaskListCheckandReleaseOrder = By.xpath("//td/nobr[.='Check and Release Order']");
    	public static final By TaskListManageOrder = By.xpath("//*[@id='TaskListMenu']/table/tbody/tr[6]/td[2]/nobr[.='Manage Order']");
    	public static final By CreationTask = By.xpath("//td/span[contains(.='Capture Technical Details']");
    	public static final By SCNPath = By.xpath("//td[@class='menuListHeader']/strong[contains(.,'SCN')]"); // ("//td[@class='menuListHeader' AND contains(.,'SCN')]");  // 
    	public static final By ModifyOrder_WithPriceImpact_BackCaptureQueryDetails = By.xpath("//div[@id='modifWpi_menu']//nobr[.='Back to Capture Query Details']"); // ("//*[@id='modifWpi_menu']/table/tbody/tr[2]/td[2]/nobr"); // ;
    	public static final By ModifyOrder_WithPriceImpact_BackCaptureTechnicalDetails2 = By.xpath("//div[@id='modifWpi_menu']//nobr[.='Back to Capture Technical Details']");
    	public static final By MWPINotesRow = By.xpath("//*[@id='grid_row_1']//td[contains(.,'Modify With Price Impact')]");
    	public static final By MWPIMilestoneRow = By.xpath("//*[@id='grid_row_4']//td[contains(.,'Modified with price impact--Inte...')]");
    	public static final By MWPI_Submit = By.xpath("//img[@name='okButton']");
    	
		public static final By sInstalledOfferID = By.xpath("//tr[@class='normalView']//td[contains(.,'Offer ID')]/following::td");
		public static final By InstalledOfferMenu = By.linkText("Installed Offers");
		public static final By InstalledOfferID = By.xpath("//*[@id='installedOfferId']");
		public static final By GOLD_orders_CreateOrder_InstalledOffer_xpath = By.xpath("//html/body/form[2]/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td/table[2]/tbody/tr/td[2]/img");
		public static final String GOLD_orders_CreateOrder_InstalledOffer_xpath2 = "//html/body/form[2]/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td/table[2]/tbody/tr/td[2]/img";
		public static final By InstalledOffer_CreateOrderChange = By.xpath(".//*[@id='create_order']/table/tbody/tr[2]/td[2]/nobr");
		public static final By InstalledOffer_CreateOrderDisconnect = By.xpath(".//*[@id='create_order']/table/tbody/tr[4]/td[2]/nobr");
	
		public static final By TaskListMenu_Popup1 = By.cssSelector("#TaskListMenu");
    	// public static final By TaskListMenu_Popup0 = By.cssSelector(".button_action_standard");
    	public static final By TaskListMenu_Popup0 = By.cssSelector("#TaskListRow");
    	
    	//DOS Product 2/8/2016
     	public static final By GOLDUSID = By.xpath("//img[@title='Add GOLD USID']");
     	// public static final By GOLDUSID_ADDInstances = By.xpath("//*[@id='instances_BNAZZZO5UGKEZ0UK5UZOJ23MJLWDIWYZ']");
     	// public static final By GOLDUSID_OK = By.xpath("//*[@id='button_BNAZZZO5UGKEZ0UK5UZOJ23MJLWDIWYZ']");
     	public static final By Installation = By.xpath("//*[@id='installationPreferences']");
     	
     	//To select contract third row 10/07/2017
     	public static final By ResultThirdRow = By.xpath("//*[@id='grid_row_3']");
     	public static final By LocalSite_ResultFirstRow = By.xpath("//*[@id='grid_row_1']/td[1]");
		
  		//To Select Service Accptance Contact 21/08/2017
     	public static final By Service_Acceptance_Search = By.xpath("//td[contains(.,'Service Acceptance Contact')]/img[1]");
     	
     	//To select early Local siye validation
     	public static final By EarlyLocalSiteValidation = By.xpath("//*[@id='earlyLocalSiteValid']");
     	
     	//03 - Jan -2018 To add multiple instances in active prevention channel user
     	 public static final By AddNewActivePrevention = By.xpath("//img[@title='Add Existing Active Prevention']");
     	 
     	// 11 Jan 2018 To add MLAN service from Active prevention to MLAN
     	public static final By MLANService = By.xpath("//img[@title='Add MLAN Service Identification']");
    	public static final By MLANServiceName = By.xpath("//*[@id='BNAZZZO5UGKEZ0UK5UZOJ23MJYMCVHYZ__0___OLD']");
    	
    	// 18 -1 2018 To add APCN/MDNS
    	
    	public static final By SBuild_APCN_MDNS = By.xpath("//img[@title='Add Network Access']");
    	public static final By SBuild_APCN_MDNS_Instance = By.xpath("//*[@id='instances_BNAZZZO5UGKEZSFQGUZQQPN4140U1RZZ']");
    	public static final By SBuild_APCN_MDNS_AddNumInstance_OK = By.xpath("//input[@id='button_BNAZZZO5UGKEZSFQGUZQQPN4140U1RZZ']");
    	public static final By SBuild_APCN_MDNS_Extend = By.id("BNAZZZO5UGKEZSFQGUZQQPN4140U1RZZ__0__Img");
    	
    	// installation tab 29 - 01-2018
    	public static final By GOLD_headmenu_InstallationOffers_xpath = By.xpath("//*[@id='headMenu']/li[3]/a/span");
    	public static final By Contracting_Party_Ico1 = By.xpath("//*[@id='contractingPartyIC01']");
    	public static final By Export = By.xpath("//img[@class='butExport']");
    	public static final By Document_Category = By.xpath("//*[@id='documentCategory']");
    	public static final By Document_Description = By.xpath("//*[@id='docDesc']");  	    	
    	public static final By Document_Submit = By.xpath("//img[@class='butSubmit']");
    	public static final By End_user_Ico1 = By.xpath("//*[@id='endUserIC01']");
    	public static final By Document_List = By.xpath("//td[.='Documents List']");
    	public static final By Download_Excel = By.xpath("//img[@class='docLargeUnknown']");
    	
    	// Added by Jagjeet
    	public static final By DeliverSRF2 = By.xpath("//div[@id='WFActionPopup']//td[.='Submit SRF2']");
    	public static final By InboxCompletedTasks = By.xpath(".//table[@id='LeftNavBar']//tr[.='Completed Tasks']");
    	public static final By CurrentTask = By.xpath("//td[contains(.,'Current Task')]/span | //span[@class='button_action_standard']");
}