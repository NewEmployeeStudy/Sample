package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;

import application.common.LogUtil;
import application.model.TVentuerDataModel;

public class Vmg001Dao {

	LogUtil log = new LogUtil();

	ResourceBundle rb = null;

	public Vmg001Dao() {
		rb = ResourceBundle.getBundle("java");
	}

	public void regist(TVentuerDataModel ventuer) throws Exception {
		if (count(ventuer.getCorporateNo()) == 0) {
			insert(ventuer);
		} else {
			update(ventuer);
		}
	}

	public void insert(TVentuerDataModel ventuer) throws Exception {
		Connection con = null;
		PreparedStatement statement = null;

		try {
			Class.forName("org.sqlite.JDBC");

			con = DriverManager.getConnection(rb.getString("JDBC"));
			con.setAutoCommit(false);
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO T_VENTUERDATA (");
			sb.append("CORPORATENO, CORPORATENAME, ECORPORATENAME, POSTALCD, PREFECTURENAME, ");
			sb.append("PREFECTURECD, CITYNAME, CITECD, ADDRESS, REPRESENTATIVETITLE, ");
			sb.append("REPRESENTATIVENAME, CONTACTTEL, CONTACTFAC, MAILADDRESS, URL, ");
			sb.append("DATEOFESTABLISH, CAPITAL, EMPLOYEE, AMOUNTOFSALES, OPERATINGINCOME, ");
			sb.append(
					"YEAROFPUBILICOFFERING, LISTINGMARKET, FIELDOFMAINPRODUCTSERVICE, FILEDOFMAINPRODUCTSERVICEOTHER, SUPPLYFORMOFMAINPRODUCTSERVICE, ");
			sb.append(
					"PATENTSOFDOMESTIC, PATENTSOFOVERSEAS, PATENTAPPLICATIONOFDOMESTIC, PATENTAPPLICATIONOFOVERSEAS, ANOTHERLICENSEUNIVERSITY, ");
			sb.append(
					"ANOTHERLICENSECOMPANY, DOCUMENTNOOFCORETECH, DATEOFCORETECH, INVENTIONNAMEOFCORETECH, INVENTOROFCORETECH, ");
			sb.append(
					"APPLICATIONNOOFCORETECH, OPENDATEOFCORETECH, OPENNOOFCORETECH, APPLICANTNAMEOFCORETECH, FIRSTIPCOFCORETECH, ");
			sb.append(
					"IPCRANKOFCORETECH, RANKOFTECHFIELDOFCORETECH, CHARTOFTECHFIELDOFCORETECH, PATENTIDNO, CURRENTOFBUSINESS, ");
			sb.append(
					"POCARRIVEYEAROFBUSINESS, DEFICITARRIVEYEAROFBUSINESS, CUMDEFICITARRIVEYEAROFBUSINESS, RESOLUTIONDEFICITARRIVEOFBUSINESS, EXITSTRATEGY, ");
			sb.append(
					"OTHEREXIRSTRATEGY, CLASSOFRELATIONWITHUNI, OTHERCLASSOFRELATIONWITHUNI, ASSOCIATEDUNI1, DEPTOFRELATEDSTUDIES1, ");
			sb.append("RESEARCHER1, NUMOFRESEARCHER1, RESEARCHMAP1, JOBTITLE1, RESEARCHFIELD1, ");
			sb.append(
					"NUMOFRESEARCHSUBJECTS1, NUMOFRESEARCHRESULTS1, ASSOCIATEDUNI2, DEPTOFRELATEDSTUDIES2, RESEARCHER2, ");
			sb.append("NUMOFRESEARCHER2, RESEARCHMAP2, JOBTITLE2, RESEARCHFIELD2, NUMOFRESEARCHSUBJECTS2, ");
			sb.append("NUMOFRESEARCHRESULTS2, ASSOCIATEDUNI3, DEPTOFRELATEDSTUDIES3, RESEARCHER3, NUMOFRESEARCHER3, ");
			sb.append("RESEARCHMAP3, JOBTITLE3, RESEARCHFIELD3, NUMOFRESEARCHSUBJECTS3, NUMOFRESEARCHRESULTS3, ");
			sb.append("ASSOCIATEDUNI4, DEPTOFRELATEDSTUDIES4, RESEARCHER4, NUMOFRESEARCHER4, RESEARCHMAP4, ");
			sb.append("JOBTITLE4, RESEARCHFIELD4, NUMOFRESEARCHSUBJECTS4, NUMOFRESEARCHRESULTS4, ASSOCIATEDUNI5, ");
			sb.append("DEPTOFRELATEDSTUDIES5, RESEARCHER5, NUMOFRESEARCHER5, RESEARCHMAP5, JOBTITLE5, ");
			sb.append(
					"RESEARCHFIELD5, NUMOFRESEARCHSUBJECTS5, NUMOFRESEARCHRESULTS5, COREPRODUCTSERVICENAME, COREPRODUCTSERVICESTARTYEAR, ");
			sb.append(
					"COREPRODUCTSERVICESTARTMONTH, COREPRODUCTSERVICEVALUE, COREPRODUCTSERVICEINTRO, COREPRODUCTSERVICEINTROURL, COREPRODUCTSERVICEMARKET, ");
			sb.append(
					"COREPRODUCTSERVICECOMPEADV, CAPITALOFFOUNDER, CAPITALOFACQUAINTANCE, CAPTTALOFEMPLOYEE, CAPITALOFDOMESTICANGLE, ");
			sb.append(
					"CAPITALOFDOMESTICVCBUSINESS, CAPITALOFDOMESTICVCUNIVERSITY, CAPITALOFDOMESTICVCOTHER, CAPITALOFDOMESTICBUSINESS, CAPITALOFDOMESTICBANK, ");
			sb.append(
					"CAPITALOFDOMESTICOTHER, CAPITALOFOVERSEAANGLE, CAPITALOFOVERSEAVCBUSINESS, CAPITALOFOVERSEAVCUNIVERSITY, CAPITALOFOVERSEAVCOTHER, ");
			sb.append(
					"CAPITALOFOVERSEABUSINESS, CAPITALOFOVERSEABANK, CAPTIALOFOVERSEAUNIVERSITY, CAPTIALOFOVERSEAOTHER, CAPTIALOFOTHERCONCRETE, ");
			sb.append(
					"CAPTIALOFLEADINVESTORNAME, SUBSIDYOFNEDOVB, SUBSIDYOFNEDONEWNERGY, SUBSIDYOFJSTSTART, SUBSIDYOFJSTCOLLAB, ");
			sb.append(
					"SUBSIDYOFAREAINNOVATION, SUBSIDYOFICTINNOVATION, SUBSIDYOFOTHER, SUBSIDYOFNONE, SUBSIDYOFOTHERCONCRETE, ");
			sb.append(
					"COREPRODUCTSERVICEINTROURL2, COREPRODUCTSERVICEINTROURL3, COREPRODUCTSERVICEINTROURL4, COREPRODUCTSERVICEINTROURL5, SEARCHDATE ");
			sb.append(") VALUES (");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
			sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			statement = con.prepareStatement(sb.toString());
			int i = 1;
			statement.setInt(i++, ventuer.getCorporateNo().intValue());
			statement.setString(i++, ventuer.getCorporateName());
			statement.setString(i++, ventuer.geteCorporateName());
			statement.setString(i++, ventuer.getPostalCd());
			statement.setString(i++, ventuer.getPrefectureName());
			statement.setString(i++, ventuer.getPrefectureCd());
			statement.setString(i++, ventuer.getCityName());
			statement.setString(i++, ventuer.getCiteCd());
			statement.setString(i++, ventuer.getAddress());
			statement.setString(i++, ventuer.getRepresentativeTitle());
			statement.setString(i++, ventuer.getRepresentativeName());
			statement.setString(i++, ventuer.getContactTel());
			statement.setString(i++, ventuer.getContactFac());
			statement.setString(i++, ventuer.getMailAddress());
			statement.setString(i++, ventuer.getUrl());
			statement.setString(i++, ventuer.getDateOfestablish());
			statement.setString(i++, ventuer.getCapital());
			statement.setString(i++, ventuer.getEmployee());
			statement.setString(i++, ventuer.getAmountOfSales());
			statement.setString(i++, ventuer.getOperatingIncome());
			statement.setString(i++, ventuer.getYearOfPubilicOffering());
			statement.setString(i++, ventuer.getListingMarket());
			statement.setString(i++, ventuer.getFieldOfMainProductService());
			statement.setString(i++, ventuer.getFiledOfMainProductServiceOther());
			statement.setString(i++, ventuer.getSupplyFormOfMainProductService());
			statement.setString(i++, ventuer.getPatentsOfDomestic());
			statement.setString(i++, ventuer.getPatentsOfOverseas());
			statement.setString(i++, ventuer.getPatentApplicationOfDomestic());
			statement.setString(i++, ventuer.getPatentApplicationOfOverseas());
			statement.setString(i++, ventuer.getAnotherLicenseUniversity());
			statement.setString(i++, ventuer.getAnotherLicenseCompany());
			statement.setString(i++, ventuer.getDocumentNoOfCoretech());
			statement.setString(i++, ventuer.getDateOfCoretech());
			statement.setString(i++, ventuer.getInventionNameOfCoretech());
			statement.setString(i++, ventuer.getInventorOfCoretech());
			statement.setString(i++, ventuer.getApplicationNoOfCoretech());
			statement.setString(i++, ventuer.getOpenDateOfCoretech());
			statement.setString(i++, ventuer.getOpenNoOfCoretech());
			statement.setString(i++, ventuer.getApplicantNameOfCoretech());
			statement.setString(i++, ventuer.getFirstIpcOfCoretech());
			statement.setString(i++, ventuer.getIpcRankOfCoretech());
			statement.setString(i++, ventuer.getRankOfTechFieldOfCoretech());
			statement.setString(i++, ventuer.getChartOfTechFieldOfCoretech());
			statement.setString(i++, ventuer.getPatentidNo());
			statement.setString(i++, ventuer.getCurrentOfBusiness());
			statement.setString(i++, ventuer.getPocArriveYearOfBusiness());
			statement.setString(i++, ventuer.getDeficitArriveYearOfBusiness());
			statement.setString(i++, ventuer.getCumdeficitArriveYearOfBusiness());
			statement.setString(i++, ventuer.getResolutionDeficitArriveOfBusiness());
			statement.setString(i++, ventuer.getExitStrategy());
			statement.setString(i++, ventuer.getOtherExirStrategy());
			statement.setString(i++, ventuer.getClassOfRelationWithUni());
			statement.setString(i++, ventuer.getOtherClassOfRelationWithUni());
			statement.setString(i++, ventuer.getAssociatedUni1());
			statement.setString(i++, ventuer.getDeptofrelatedStudies1());
			statement.setString(i++, ventuer.getResearcher1());
			statement.setString(i++, ventuer.getNumOfresearcher1());
			statement.setString(i++, ventuer.getResearchMap1());
			statement.setString(i++, ventuer.getJobTitle1());
			statement.setString(i++, ventuer.getResearchField1());
			statement.setString(i++, ventuer.getNumOfResearchSubjects1());
			statement.setString(i++, ventuer.getNumOfResearchResults1());
			statement.setString(i++, ventuer.getAssociatedUni2());
			statement.setString(i++, ventuer.getDeptofrelatedStudies2());
			statement.setString(i++, ventuer.getResearcher2());
			statement.setString(i++, ventuer.getNumOfresearcher2());
			statement.setString(i++, ventuer.getResearchMap2());
			statement.setString(i++, ventuer.getJobTitle2());
			statement.setString(i++, ventuer.getResearchField2());
			statement.setString(i++, ventuer.getNumOfResearchSubjects2());
			statement.setString(i++, ventuer.getNumOfResearchResults2());
			statement.setString(i++, ventuer.getAssociatedUni3());
			statement.setString(i++, ventuer.getDeptofrelatedStudies3());
			statement.setString(i++, ventuer.getResearcher3());
			statement.setString(i++, ventuer.getNumOfresearcher3());
			statement.setString(i++, ventuer.getResearchMap3());
			statement.setString(i++, ventuer.getJobTitle3());
			statement.setString(i++, ventuer.getResearchField3());
			statement.setString(i++, ventuer.getNumOfResearchSubjects3());
			statement.setString(i++, ventuer.getNumOfResearchResults3());
			statement.setString(i++, ventuer.getAssociatedUni4());
			statement.setString(i++, ventuer.getDeptofrelatedStudies4());
			statement.setString(i++, ventuer.getResearcher4());
			statement.setString(i++, ventuer.getNumOfresearcher4());
			statement.setString(i++, ventuer.getResearchMap4());
			statement.setString(i++, ventuer.getJobTitle4());
			statement.setString(i++, ventuer.getResearchField4());
			statement.setString(i++, ventuer.getNumOfResearchSubjects4());
			statement.setString(i++, ventuer.getNumOfResearchResults4());
			statement.setString(i++, ventuer.getAssociatedUni5());
			statement.setString(i++, ventuer.getDeptofrelatedStudies5());
			statement.setString(i++, ventuer.getResearcher5());
			statement.setString(i++, ventuer.getNumOfresearcher5());
			statement.setString(i++, ventuer.getResearchMap5());
			statement.setString(i++, ventuer.getJobTitle5());
			statement.setString(i++, ventuer.getResearchField5());
			statement.setString(i++, ventuer.getNumOfResearchSubjects5());
			statement.setString(i++, ventuer.getNumOfResearchResults5());
			statement.setString(i++, ventuer.getCoreProductServiceName());
			statement.setString(i++, ventuer.getCoreProductServiceStartYear());
			statement.setString(i++, ventuer.getCoreProductServiceStartMonth());
			statement.setString(i++, ventuer.getCoreProductServiceValue());
			statement.setString(i++, ventuer.getCoreProductServiceIntro());
			statement.setString(i++, ventuer.getCoreProductServiceIntroUrl());
			statement.setString(i++, ventuer.getCoreProductServiceMarket());
			statement.setString(i++, ventuer.getCoreProductServiceCompeadv());
			statement.setString(i++, ventuer.getCapitalOfFounder());
			statement.setString(i++, ventuer.getCapitalOfAcquaintance());
			statement.setString(i++, ventuer.getCapttalOfEmployee());
			statement.setString(i++, ventuer.getCapitalOfDomesticAngle());
			statement.setString(i++, ventuer.getCapitalOfDomesticVcBusiness());
			statement.setString(i++, ventuer.getCapitalOfDomesticVcUniversity());
			statement.setString(i++, ventuer.getCapitalOfDomesticVcOther());
			statement.setString(i++, ventuer.getCapitalOfDomesticBusiness());
			statement.setString(i++, ventuer.getCapitalOfDomesticBank());
			statement.setString(i++, ventuer.getCapitalOfDomesticOther());
			statement.setString(i++, ventuer.getCapitalOfOverseaAngle());
			statement.setString(i++, ventuer.getCapitalOfOverseaVcBusiness());
			statement.setString(i++, ventuer.getCapitalOfOverseaVcUniversity());
			statement.setString(i++, ventuer.getCapitalOfOverseaVcOther());
			statement.setString(i++, ventuer.getCapitalOfOverseaBusiness());
			statement.setString(i++, ventuer.getCapitalOfOverseaBank());
			statement.setString(i++, ventuer.getCaptialOfOverseaUniversity());
			statement.setString(i++, ventuer.getCaptialOfOverseaOther());
			statement.setString(i++, ventuer.getCaptialOfOtherConcrete());
			statement.setString(i++, ventuer.getCaptialOfLeadInvestorName());
			statement.setString(i++, ventuer.getSubsidyOfNedoVb());
			statement.setString(i++, ventuer.getSubsidyOfNedoNewNergy());
			statement.setString(i++, ventuer.getSubsidyOfJstStart());
			statement.setString(i++, ventuer.getSubsidyOfJstCollab());
			statement.setString(i++, ventuer.getSubsidyOfAreaInnovation());
			statement.setString(i++, ventuer.getSubsidyOfIctinnovation());
			statement.setString(i++, ventuer.getSubsidyOfOther());
			statement.setString(i++, ventuer.getSubsidyOfNone());
			statement.setString(i++, ventuer.getSubsidyOfOtherConcrete());
			statement.setString(i++, ventuer.getCoreProductServiceintroURL2());
			statement.setString(i++, ventuer.getCoreProductServiceintroURL3());
			statement.setString(i++, ventuer.getCoreProductServiceintroURL4());
			statement.setString(i++, ventuer.getCoreProductServiceintroURL5());
			statement.setString(i++, ventuer.getSearchDate());
			// SQL実行
			statement.executeUpdate();
			con.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, "エラーが発生しました。", e);
		} catch (SQLException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, "エラーが発生しました。", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				throw e;
			}
			try {
				if (con != null) {
					con.rollback();
					con.close();
				}
			} catch (SQLException e) {
				throw e;
			}
		}
	}

	public void update(TVentuerDataModel ventuer) throws Exception {
		Connection con = null;
		PreparedStatement statement = null;

		try {
			Class.forName("org.sqlite.JDBC");

			con = DriverManager.getConnection(rb.getString("JDBC"));
			con.setAutoCommit(false);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE T_VENTUERDATA SET ");
			sb.append(
					"CORPORATENAME = ?,  ECORPORATENAME = ?,  POSTALCD = ?,  PREFECTURENAME = ?,  PREFECTURECD = ?,  ");
			sb.append("CITYNAME = ?,  CITECD = ?,  ADDRESS = ?,  REPRESENTATIVETITLE = ?,  REPRESENTATIVENAME = ?,  ");
			sb.append("CONTACTTEL = ?,  CONTACTFAC = ?,  MAILADDRESS = ?,  URL = ?,  DATEOFESTABLISH = ?,  ");
			sb.append(
					"CAPITAL = ?,  EMPLOYEE = ?,  AMOUNTOFSALES = ?,  OPERATINGINCOME = ?,  YEAROFPUBILICOFFERING = ?,  ");
			sb.append(
					"LISTINGMARKET = ?,  FIELDOFMAINPRODUCTSERVICE = ?,  FILEDOFMAINPRODUCTSERVICEOTHER = ?,  SUPPLYFORMOFMAINPRODUCTSERVICE = ?,  PATENTSOFDOMESTIC = ?,  ");
			sb.append(
					"PATENTSOFOVERSEAS = ?,  PATENTAPPLICATIONOFDOMESTIC = ?,  PATENTAPPLICATIONOFOVERSEAS = ?,  ANOTHERLICENSEUNIVERSITY = ?,  ANOTHERLICENSECOMPANY = ?,  ");
			sb.append(
					"DOCUMENTNOOFCORETECH = ?,  DATEOFCORETECH = ?,  INVENTIONNAMEOFCORETECH = ?,  INVENTOROFCORETECH = ?,  APPLICATIONNOOFCORETECH = ?,  ");
			sb.append(
					"OPENDATEOFCORETECH = ?,  OPENNOOFCORETECH = ?,  APPLICANTNAMEOFCORETECH = ?,  FIRSTIPCOFCORETECH = ?,  IPCRANKOFCORETECH = ?,  ");
			sb.append(
					"RANKOFTECHFIELDOFCORETECH = ?,  CHARTOFTECHFIELDOFCORETECH = ?,  PATENTIDNO = ?,  CURRENTOFBUSINESS = ?,  POCARRIVEYEAROFBUSINESS = ?,  ");
			sb.append(
					"DEFICITARRIVEYEAROFBUSINESS = ?,  CUMDEFICITARRIVEYEAROFBUSINESS = ?,  RESOLUTIONDEFICITARRIVEOFBUSINESS = ?,  EXITSTRATEGY = ?,  OTHEREXIRSTRATEGY = ?,  ");
			sb.append(
					"CLASSOFRELATIONWITHUNI = ?,  OTHERCLASSOFRELATIONWITHUNI = ?,  ASSOCIATEDUNI1 = ?,  DEPTOFRELATEDSTUDIES1 = ?,  RESEARCHER1 = ?,  ");
			sb.append(
					"NUMOFRESEARCHER1 = ?,  RESEARCHMAP1 = ?,  JOBTITLE1 = ?,  RESEARCHFIELD1 = ?,  NUMOFRESEARCHSUBJECTS1 = ?,  ");
			sb.append(
					"NUMOFRESEARCHRESULTS1 = ?,  ASSOCIATEDUNI2 = ?,  DEPTOFRELATEDSTUDIES2 = ?,  RESEARCHER2 = ?,  NUMOFRESEARCHER2 = ?,  ");
			sb.append(
					"RESEARCHMAP2 = ?,  JOBTITLE2 = ?,  RESEARCHFIELD2 = ?,  NUMOFRESEARCHSUBJECTS2 = ?,  NUMOFRESEARCHRESULTS2 = ?,  ");
			sb.append(
					"ASSOCIATEDUNI3 = ?,  DEPTOFRELATEDSTUDIES3 = ?,  RESEARCHER3 = ?,  NUMOFRESEARCHER3 = ?,  RESEARCHMAP3 = ?,  ");
			sb.append(
					"JOBTITLE3 = ?,  RESEARCHFIELD3 = ?,  NUMOFRESEARCHSUBJECTS3 = ?,  NUMOFRESEARCHRESULTS3 = ?,  ASSOCIATEDUNI4 = ?,  ");
			sb.append(
					"DEPTOFRELATEDSTUDIES4 = ?,  RESEARCHER4 = ?,  NUMOFRESEARCHER4 = ?,  RESEARCHMAP4 = ?,  JOBTITLE4 = ?,  ");
			sb.append(
					"RESEARCHFIELD4 = ?,  NUMOFRESEARCHSUBJECTS4 = ?,  NUMOFRESEARCHRESULTS4 = ?,  ASSOCIATEDUNI5 = ?,  DEPTOFRELATEDSTUDIES5 = ?,  ");
			sb.append(
					"RESEARCHER5 = ?,  NUMOFRESEARCHER5 = ?,  RESEARCHMAP5 = ?,  JOBTITLE5 = ?,  RESEARCHFIELD5 = ?,  ");
			sb.append(
					"NUMOFRESEARCHSUBJECTS5 = ?,  NUMOFRESEARCHRESULTS5 = ?,  COREPRODUCTSERVICENAME = ?,  COREPRODUCTSERVICESTARTYEAR = ?,  COREPRODUCTSERVICESTARTMONTH = ?,  ");
			sb.append(
					"COREPRODUCTSERVICEVALUE = ?,  COREPRODUCTSERVICEINTRO = ?,  COREPRODUCTSERVICEINTROURL = ?,  COREPRODUCTSERVICEMARKET = ?,  COREPRODUCTSERVICECOMPEADV = ?,  ");
			sb.append(
					"CAPITALOFFOUNDER = ?,  CAPITALOFACQUAINTANCE = ?,  CAPTTALOFEMPLOYEE = ?,  CAPITALOFDOMESTICANGLE = ?,  CAPITALOFDOMESTICVCBUSINESS = ?,  ");
			sb.append(
					"CAPITALOFDOMESTICVCUNIVERSITY = ?,  CAPITALOFDOMESTICVCOTHER = ?,  CAPITALOFDOMESTICBUSINESS = ?,  CAPITALOFDOMESTICBANK = ?,  CAPITALOFDOMESTICOTHER = ?,  ");
			sb.append(
					"CAPITALOFOVERSEAANGLE = ?,  CAPITALOFOVERSEAVCBUSINESS = ?,  CAPITALOFOVERSEAVCUNIVERSITY = ?,  CAPITALOFOVERSEAVCOTHER = ?,  CAPITALOFOVERSEABUSINESS = ?,  ");
			sb.append(
					"CAPITALOFOVERSEABANK = ?,  CAPTIALOFOVERSEAUNIVERSITY = ?,  CAPTIALOFOVERSEAOTHER = ?,  CAPTIALOFOTHERCONCRETE = ?,  CAPTIALOFLEADINVESTORNAME = ?,  ");
			sb.append(
					"SUBSIDYOFNEDOVB = ?,  SUBSIDYOFNEDONEWNERGY = ?,  SUBSIDYOFJSTSTART = ?,  SUBSIDYOFJSTCOLLAB = ?,  SUBSIDYOFAREAINNOVATION = ?,  ");
			sb.append(
					"SUBSIDYOFICTINNOVATION = ?,  SUBSIDYOFOTHER = ?,  SUBSIDYOFNONE = ?,  SUBSIDYOFOTHERCONCRETE = ?,  COREPRODUCTSERVICEINTROURL2 = ?,  ");
			sb.append(
					"COREPRODUCTSERVICEINTROURL3 = ?,  COREPRODUCTSERVICEINTROURL4 = ?,  COREPRODUCTSERVICEINTROURL5 = ?,  SEARCHDATE = ?");

			sb.append("WHERE CORPORATENO = ? ");
			statement = con.prepareStatement(sb.toString());
			int i = 1;
			statement.setString(i++, ventuer.getCorporateName());
			statement.setString(i++, ventuer.geteCorporateName());
			statement.setString(i++, ventuer.getPostalCd());
			statement.setString(i++, ventuer.getPrefectureName());
			statement.setString(i++, ventuer.getPrefectureCd());
			statement.setString(i++, ventuer.getCityName());
			statement.setString(i++, ventuer.getCiteCd());
			statement.setString(i++, ventuer.getAddress());
			statement.setString(i++, ventuer.getRepresentativeTitle());
			statement.setString(i++, ventuer.getRepresentativeName());
			statement.setString(i++, ventuer.getContactTel());
			statement.setString(i++, ventuer.getContactFac());
			statement.setString(i++, ventuer.getMailAddress());
			statement.setString(i++, ventuer.getUrl());
			statement.setString(i++, ventuer.getDateOfestablish());
			statement.setString(i++, ventuer.getCapital());
			statement.setString(i++, ventuer.getEmployee());
			statement.setString(i++, ventuer.getAmountOfSales());
			statement.setString(i++, ventuer.getOperatingIncome());
			statement.setString(i++, ventuer.getYearOfPubilicOffering());
			statement.setString(i++, ventuer.getListingMarket());
			statement.setString(i++, ventuer.getFieldOfMainProductService());
			statement.setString(i++, ventuer.getFiledOfMainProductServiceOther());
			statement.setString(i++, ventuer.getSupplyFormOfMainProductService());
			statement.setString(i++, ventuer.getPatentsOfDomestic());
			statement.setString(i++, ventuer.getPatentsOfOverseas());
			statement.setString(i++, ventuer.getPatentApplicationOfDomestic());
			statement.setString(i++, ventuer.getPatentApplicationOfOverseas());
			statement.setString(i++, ventuer.getAnotherLicenseUniversity());
			statement.setString(i++, ventuer.getAnotherLicenseCompany());
			statement.setString(i++, ventuer.getDocumentNoOfCoretech());
			statement.setString(i++, ventuer.getDateOfCoretech());
			statement.setString(i++, ventuer.getInventionNameOfCoretech());
			statement.setString(i++, ventuer.getInventorOfCoretech());
			statement.setString(i++, ventuer.getApplicationNoOfCoretech());
			statement.setString(i++, ventuer.getOpenDateOfCoretech());
			statement.setString(i++, ventuer.getOpenNoOfCoretech());
			statement.setString(i++, ventuer.getApplicantNameOfCoretech());
			statement.setString(i++, ventuer.getFirstIpcOfCoretech());
			statement.setString(i++, ventuer.getIpcRankOfCoretech());
			statement.setString(i++, ventuer.getRankOfTechFieldOfCoretech());
			statement.setString(i++, ventuer.getChartOfTechFieldOfCoretech());
			statement.setString(i++, ventuer.getPatentidNo());
			statement.setString(i++, ventuer.getCurrentOfBusiness());
			statement.setString(i++, ventuer.getPocArriveYearOfBusiness());
			statement.setString(i++, ventuer.getDeficitArriveYearOfBusiness());
			statement.setString(i++, ventuer.getCumdeficitArriveYearOfBusiness());
			statement.setString(i++, ventuer.getResolutionDeficitArriveOfBusiness());
			statement.setString(i++, ventuer.getExitStrategy());
			statement.setString(i++, ventuer.getOtherExirStrategy());
			statement.setString(i++, ventuer.getClassOfRelationWithUni());
			statement.setString(i++, ventuer.getOtherClassOfRelationWithUni());
			statement.setString(i++, ventuer.getAssociatedUni1());
			statement.setString(i++, ventuer.getDeptofrelatedStudies1());
			statement.setString(i++, ventuer.getResearcher1());
			statement.setString(i++, ventuer.getNumOfresearcher1());
			statement.setString(i++, ventuer.getResearchMap1());
			statement.setString(i++, ventuer.getJobTitle1());
			statement.setString(i++, ventuer.getResearchField1());
			statement.setString(i++, ventuer.getNumOfResearchSubjects1());
			statement.setString(i++, ventuer.getNumOfResearchResults1());
			statement.setString(i++, ventuer.getAssociatedUni2());
			statement.setString(i++, ventuer.getDeptofrelatedStudies2());
			statement.setString(i++, ventuer.getResearcher2());
			statement.setString(i++, ventuer.getNumOfresearcher2());
			statement.setString(i++, ventuer.getResearchMap2());
			statement.setString(i++, ventuer.getJobTitle2());
			statement.setString(i++, ventuer.getResearchField2());
			statement.setString(i++, ventuer.getNumOfResearchSubjects2());
			statement.setString(i++, ventuer.getNumOfResearchResults2());
			statement.setString(i++, ventuer.getAssociatedUni3());
			statement.setString(i++, ventuer.getDeptofrelatedStudies3());
			statement.setString(i++, ventuer.getResearcher3());
			statement.setString(i++, ventuer.getNumOfresearcher3());
			statement.setString(i++, ventuer.getResearchMap3());
			statement.setString(i++, ventuer.getJobTitle3());
			statement.setString(i++, ventuer.getResearchField3());
			statement.setString(i++, ventuer.getNumOfResearchSubjects3());
			statement.setString(i++, ventuer.getNumOfResearchResults3());
			statement.setString(i++, ventuer.getAssociatedUni4());
			statement.setString(i++, ventuer.getDeptofrelatedStudies4());
			statement.setString(i++, ventuer.getResearcher4());
			statement.setString(i++, ventuer.getNumOfresearcher4());
			statement.setString(i++, ventuer.getResearchMap4());
			statement.setString(i++, ventuer.getJobTitle4());
			statement.setString(i++, ventuer.getResearchField4());
			statement.setString(i++, ventuer.getNumOfResearchSubjects4());
			statement.setString(i++, ventuer.getNumOfResearchResults4());
			statement.setString(i++, ventuer.getAssociatedUni5());
			statement.setString(i++, ventuer.getDeptofrelatedStudies5());
			statement.setString(i++, ventuer.getResearcher5());
			statement.setString(i++, ventuer.getNumOfresearcher5());
			statement.setString(i++, ventuer.getResearchMap5());
			statement.setString(i++, ventuer.getJobTitle5());
			statement.setString(i++, ventuer.getResearchField5());
			statement.setString(i++, ventuer.getNumOfResearchSubjects5());
			statement.setString(i++, ventuer.getNumOfResearchResults5());
			statement.setString(i++, ventuer.getCoreProductServiceName());
			statement.setString(i++, ventuer.getCoreProductServiceStartYear());
			statement.setString(i++, ventuer.getCoreProductServiceStartMonth());
			statement.setString(i++, ventuer.getCoreProductServiceValue());
			statement.setString(i++, ventuer.getCoreProductServiceIntro());
			statement.setString(i++, ventuer.getCoreProductServiceIntroUrl());
			statement.setString(i++, ventuer.getCoreProductServiceMarket());
			statement.setString(i++, ventuer.getCoreProductServiceCompeadv());
			statement.setString(i++, ventuer.getCapitalOfFounder());
			statement.setString(i++, ventuer.getCapitalOfAcquaintance());
			statement.setString(i++, ventuer.getCapttalOfEmployee());
			statement.setString(i++, ventuer.getCapitalOfDomesticAngle());
			statement.setString(i++, ventuer.getCapitalOfDomesticVcBusiness());
			statement.setString(i++, ventuer.getCapitalOfDomesticVcUniversity());
			statement.setString(i++, ventuer.getCapitalOfDomesticVcOther());
			statement.setString(i++, ventuer.getCapitalOfDomesticBusiness());
			statement.setString(i++, ventuer.getCapitalOfDomesticBank());
			statement.setString(i++, ventuer.getCapitalOfDomesticOther());
			statement.setString(i++, ventuer.getCapitalOfOverseaAngle());
			statement.setString(i++, ventuer.getCapitalOfOverseaVcBusiness());
			statement.setString(i++, ventuer.getCapitalOfOverseaVcUniversity());
			statement.setString(i++, ventuer.getCapitalOfOverseaVcOther());
			statement.setString(i++, ventuer.getCapitalOfOverseaBusiness());
			statement.setString(i++, ventuer.getCapitalOfOverseaBank());
			statement.setString(i++, ventuer.getCaptialOfOverseaUniversity());
			statement.setString(i++, ventuer.getCaptialOfOverseaOther());
			statement.setString(i++, ventuer.getCaptialOfOtherConcrete());
			statement.setString(i++, ventuer.getCaptialOfLeadInvestorName());
			statement.setString(i++, ventuer.getSubsidyOfNedoVb());
			statement.setString(i++, ventuer.getSubsidyOfNedoNewNergy());
			statement.setString(i++, ventuer.getSubsidyOfJstStart());
			statement.setString(i++, ventuer.getSubsidyOfJstCollab());
			statement.setString(i++, ventuer.getSubsidyOfAreaInnovation());
			statement.setString(i++, ventuer.getSubsidyOfIctinnovation());
			statement.setString(i++, ventuer.getSubsidyOfOther());
			statement.setString(i++, ventuer.getSubsidyOfNone());
			statement.setString(i++, ventuer.getSubsidyOfOtherConcrete());
			statement.setString(i++, ventuer.getCoreProductServiceintroURL2());
			statement.setString(i++, ventuer.getCoreProductServiceintroURL3());
			statement.setString(i++, ventuer.getCoreProductServiceintroURL4());
			statement.setString(i++, ventuer.getCoreProductServiceintroURL5());
			statement.setString(i++, ventuer.getSearchDate());
			statement.setLong(i++, ventuer.getCorporateNo());

			// SQL実行
			statement.executeUpdate();
			con.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, "エラーが発生しました。", e);
		} catch (SQLException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, "エラーが発生しました。", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				throw e;
			}
			try {
				if (con != null) {
					con.rollback();
					con.close();
				}
			} catch (SQLException e) {
				throw e;
			}
		}
	}

	public int count(Long corporateNo) throws Exception {
		int count = 0;
		Connection con = null;
		PreparedStatement statement = null;

		try {
			Class.forName("org.sqlite.JDBC");

			con = DriverManager.getConnection(rb.getString("JDBC"));
			String sql = "SELECT COUNT(*) FROM T_VENTUERDATA WHERE CORPORATENO = ?";
			statement = con.prepareStatement(sql);
			statement.setLong(1, corporateNo);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				throw e;
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw e;
			}
		}
		return count;
	}

}
