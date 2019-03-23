package application.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Optional;
import java.util.logging.Level;

import application.Main;
import application.common.CommonUtil;
import application.common.LogUtil;
import application.dao.Vmg001Dao;
import application.model.TVentuerDataModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Vmg001Controller {

	LogUtil log = new LogUtil();

	Stage stage;
	@FXML
	private Button btnSelect;
	@FXML
	private Button btnClose;
	@FXML
	private Button btnExec;
	@FXML
	private Label label01;
	@FXML
	private TextField path;

	/***
	 * 選択ボタン押下処理
	 */
	@FXML
	public void onClickSelectBtn(ActionEvent e) {

		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("ファイル選択");
		fileChooser.setInitialDirectory(new File("../"));
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSVファイル", "*.csv"));
		File file = fileChooser.showOpenDialog(this.stage);
		if (file != null) {
			String filename = file.getPath().toString();
			this.path.setText(filename);
		}
	}

	/***
	 * 取込ボタン押下処理
	 */
	@FXML
	public void onClickExecBtn(ActionEvent e) {

		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));

		Alert alrt = new Alert(AlertType.CONFIRMATION); //アラートを作成
		alrt.setContentText("取り込み処理を行います。よろしいですか？");
		Optional<ButtonType> result = alrt.showAndWait();
		if (result.get() == ButtonType.OK) { //OKボタンがクリックされたら
			try {
				File f = new File(this.path.getText());
				BufferedReader br = new BufferedReader(new FileReader(f));
				Vmg001Dao dao = new Vmg001Dao();

				String line;
				int num = 0;
				// 1行ずつCSVファイルを読み込む
				while ((line = br.readLine()) != null) {
					num++;
					if (num == 1) {
						// 1行目はヘッダー項目の為、無視
						continue;
					}
					String[] data = line.split(",", 0); // 行をカンマ区切りで配列に変換
					TVentuerDataModel ventuer = createModel(data);
					dao.regist(ventuer);
				}
				br.close();

				Alert alrt2 = new Alert(AlertType.INFORMATION); //アラートを作成
				alrt2.setContentText("取り込みが完了しました。 件数：" + (num-1) + "件");
				alrt2.showAndWait();

			} catch (Exception ex) {
				ex.printStackTrace();
				log.log(Level.SEVERE, "エラーが発生しました。", ex);
				Alert alrtE = new Alert(AlertType.ERROR); //アラートを作成
				alrtE.setContentText("取り込み処理が異常終了しました。");
				alrtE.showAndWait();

			}
		}
	}

	public TVentuerDataModel createModel(String params[]) {
		TVentuerDataModel ventuer = new TVentuerDataModel();

		Long corp = new Long(params[1]);
		ventuer.setCorporateNo(corp);
		ventuer.setCorporateName(CommonUtil.deleteDoubleQuate(params[2]));
		ventuer.seteCorporateName(CommonUtil.deleteDoubleQuate(params[3]));
		ventuer.setPostalCd(CommonUtil.deleteDoubleQuate(params[4]));
		ventuer.setPrefectureName(CommonUtil.deleteDoubleQuate(params[5]));
		ventuer.setPrefectureCd(CommonUtil.deleteDoubleQuate(params[6]));
		ventuer.setCityName(CommonUtil.deleteDoubleQuate(params[7]));
		ventuer.setCiteCd(CommonUtil.deleteDoubleQuate(params[8]));
		ventuer.setAddress(CommonUtil.deleteDoubleQuate(params[9]));
		ventuer.setRepresentativeTitle(CommonUtil.deleteDoubleQuate(params[10]));
		ventuer.setRepresentativeName(CommonUtil.deleteDoubleQuate(params[11]));
		ventuer.setContactTel(CommonUtil.deleteDoubleQuate(params[12]));
		ventuer.setContactFac(CommonUtil.deleteDoubleQuate(params[13]));
		ventuer.setMailAddress(CommonUtil.deleteDoubleQuate(params[14]));
		ventuer.setUrl(CommonUtil.deleteDoubleQuate(params[15]));
		String yyyyMm = params[16];
		if (params[17].length() == 1) {
			yyyyMm = yyyyMm.concat("0").concat(params[17]);
		} else {
			yyyyMm = yyyyMm.concat(params[17]);
		}
		ventuer.setDateOfestablish(yyyyMm);
		ventuer.setCapital(CommonUtil.deleteDoubleQuate(params[18]));
		ventuer.setEmployee(CommonUtil.deleteDoubleQuate(params[19]));
		ventuer.setAmountOfSales(CommonUtil.deleteDoubleQuate(params[20]));
		ventuer.setOperatingIncome(CommonUtil.deleteDoubleQuate(params[21]));
		ventuer.setYearOfPubilicOffering(CommonUtil.deleteDoubleQuate(params[22]));
		ventuer.setListingMarket(CommonUtil.deleteDoubleQuate(params[23]));
		ventuer.setFieldOfMainProductService(CommonUtil.deleteDoubleQuate(params[24]));
		ventuer.setFiledOfMainProductServiceOther(CommonUtil.deleteDoubleQuate(params[25]));
		ventuer.setSupplyFormOfMainProductService(CommonUtil.deleteDoubleQuate(params[26]));
		ventuer.setPatentsOfDomestic(CommonUtil.deleteDoubleQuate(params[27]));
		ventuer.setPatentsOfOverseas(CommonUtil.deleteDoubleQuate(params[28]));
		ventuer.setPatentApplicationOfDomestic(CommonUtil.deleteDoubleQuate(params[29]));
		ventuer.setPatentApplicationOfOverseas(CommonUtil.deleteDoubleQuate(params[30]));
		ventuer.setAnotherLicenseUniversity(CommonUtil.deleteDoubleQuate(params[31]));
		ventuer.setAnotherLicenseCompany(CommonUtil.deleteDoubleQuate(params[32]));
		ventuer.setDocumentNoOfCoretech(CommonUtil.deleteDoubleQuate(params[33]));
		ventuer.setDateOfCoretech(CommonUtil.deleteDoubleQuate(params[34]));
		ventuer.setInventionNameOfCoretech(CommonUtil.deleteDoubleQuate(params[35]));
		ventuer.setInventorOfCoretech(CommonUtil.deleteDoubleQuate(params[36]));
		ventuer.setApplicationNoOfCoretech(CommonUtil.deleteDoubleQuate(params[37]));
		ventuer.setOpenDateOfCoretech(CommonUtil.deleteDoubleQuate(params[38]));
		ventuer.setOpenNoOfCoretech(CommonUtil.deleteDoubleQuate(params[39]));
		ventuer.setApplicantNameOfCoretech(CommonUtil.deleteDoubleQuate(params[40]));
		ventuer.setFirstIpcOfCoretech(CommonUtil.deleteDoubleQuate(params[41]));
		ventuer.setIpcRankOfCoretech(CommonUtil.deleteDoubleQuate(params[42]));
		ventuer.setRankOfTechFieldOfCoretech(CommonUtil.deleteDoubleQuate(params[43]));
		ventuer.setChartOfTechFieldOfCoretech(CommonUtil.deleteDoubleQuate(params[44]));
		ventuer.setPatentidNo(CommonUtil.deleteDoubleQuate(params[45]));
		ventuer.setCurrentOfBusiness(CommonUtil.deleteDoubleQuate(params[46]));
		ventuer.setPocArriveYearOfBusiness(CommonUtil.deleteDoubleQuate(params[47]));
		ventuer.setDeficitArriveYearOfBusiness(CommonUtil.deleteDoubleQuate(params[48]));
		ventuer.setCumdeficitArriveYearOfBusiness(CommonUtil.deleteDoubleQuate(params[49]));
		ventuer.setResolutionDeficitArriveOfBusiness(CommonUtil.deleteDoubleQuate(params[50]));
		ventuer.setExitStrategy(CommonUtil.deleteDoubleQuate(params[51]));
		ventuer.setOtherExirStrategy(CommonUtil.deleteDoubleQuate(params[52]));
		ventuer.setClassOfRelationWithUni(CommonUtil.deleteDoubleQuate(params[53]));
		ventuer.setOtherClassOfRelationWithUni(CommonUtil.deleteDoubleQuate(params[54]));
		ventuer.setAssociatedUni1(CommonUtil.deleteDoubleQuate(params[55]));
		ventuer.setDeptofrelatedStudies1(CommonUtil.deleteDoubleQuate(params[56]));
		ventuer.setResearcher1(CommonUtil.deleteDoubleQuate(params[57]));
		ventuer.setNumOfresearcher1(CommonUtil.deleteDoubleQuate(params[58]));
		ventuer.setResearchMap1(CommonUtil.deleteDoubleQuate(params[59]));
		ventuer.setJobTitle1(CommonUtil.deleteDoubleQuate(params[60]));
		ventuer.setResearchField1(CommonUtil.deleteDoubleQuate(params[61]));
		ventuer.setNumOfResearchSubjects1(CommonUtil.deleteDoubleQuate(params[62]));
		ventuer.setNumOfResearchResults1(CommonUtil.deleteDoubleQuate(params[63]));
		ventuer.setAssociatedUni2(CommonUtil.deleteDoubleQuate(params[64]));
		ventuer.setDeptofrelatedStudies2(CommonUtil.deleteDoubleQuate(params[65]));
		ventuer.setResearcher2(CommonUtil.deleteDoubleQuate(params[66]));
		ventuer.setNumOfresearcher2(CommonUtil.deleteDoubleQuate(params[67]));
		ventuer.setResearchMap2(CommonUtil.deleteDoubleQuate(params[68]));
		ventuer.setJobTitle2(CommonUtil.deleteDoubleQuate(params[69]));
		ventuer.setResearchField2(CommonUtil.deleteDoubleQuate(params[70]));
		ventuer.setNumOfResearchSubjects2(CommonUtil.deleteDoubleQuate(params[71]));
		ventuer.setNumOfResearchResults2(CommonUtil.deleteDoubleQuate(params[72]));
		ventuer.setAssociatedUni3(CommonUtil.deleteDoubleQuate(params[73]));
		ventuer.setDeptofrelatedStudies3(CommonUtil.deleteDoubleQuate(params[74]));
		ventuer.setResearcher3(CommonUtil.deleteDoubleQuate(params[75]));
		ventuer.setNumOfresearcher3(CommonUtil.deleteDoubleQuate(params[76]));
		ventuer.setResearchMap3(CommonUtil.deleteDoubleQuate(params[77]));
		ventuer.setJobTitle3(CommonUtil.deleteDoubleQuate(params[78]));
		ventuer.setResearchField3(CommonUtil.deleteDoubleQuate(params[79]));
		ventuer.setNumOfResearchSubjects3(CommonUtil.deleteDoubleQuate(params[80]));
		ventuer.setNumOfResearchResults3(CommonUtil.deleteDoubleQuate(params[81]));
		ventuer.setAssociatedUni4(CommonUtil.deleteDoubleQuate(params[82]));
		ventuer.setDeptofrelatedStudies4(CommonUtil.deleteDoubleQuate(params[83]));
		ventuer.setResearcher4(CommonUtil.deleteDoubleQuate(params[84]));
		ventuer.setNumOfresearcher4(CommonUtil.deleteDoubleQuate(params[85]));
		ventuer.setResearchMap4(CommonUtil.deleteDoubleQuate(params[86]));
		ventuer.setJobTitle4(CommonUtil.deleteDoubleQuate(params[87]));
		ventuer.setResearchField4(CommonUtil.deleteDoubleQuate(params[88]));
		ventuer.setNumOfResearchSubjects4(CommonUtil.deleteDoubleQuate(params[89]));
		ventuer.setNumOfResearchResults4(CommonUtil.deleteDoubleQuate(params[90]));
		ventuer.setAssociatedUni5(CommonUtil.deleteDoubleQuate(params[91]));
		ventuer.setDeptofrelatedStudies5(CommonUtil.deleteDoubleQuate(params[92]));
		ventuer.setResearcher5(CommonUtil.deleteDoubleQuate(params[93]));
		ventuer.setNumOfresearcher5(CommonUtil.deleteDoubleQuate(params[94]));
		ventuer.setResearchMap5(CommonUtil.deleteDoubleQuate(params[95]));
		ventuer.setJobTitle5(CommonUtil.deleteDoubleQuate(params[96]));
		ventuer.setResearchField5(CommonUtil.deleteDoubleQuate(params[97]));
		ventuer.setNumOfResearchSubjects5(CommonUtil.deleteDoubleQuate(params[98]));
		ventuer.setNumOfResearchResults5(CommonUtil.deleteDoubleQuate(params[99]));
		ventuer.setCoreProductServiceName(CommonUtil.deleteDoubleQuate(params[100]));
		ventuer.setCoreProductServiceStartYear(CommonUtil.deleteDoubleQuate(params[101]));
		ventuer.setCoreProductServiceStartMonth(CommonUtil.deleteDoubleQuate(params[102]));
		ventuer.setCoreProductServiceValue(CommonUtil.deleteDoubleQuate(params[103]));
		ventuer.setCoreProductServiceIntro(CommonUtil.deleteDoubleQuate(params[104]));
		ventuer.setCoreProductServiceIntroUrl(CommonUtil.deleteDoubleQuate(params[105]));
		ventuer.setCoreProductServiceMarket(CommonUtil.deleteDoubleQuate(params[106]));
		ventuer.setCoreProductServiceCompeadv(CommonUtil.deleteDoubleQuate(params[107]));
		ventuer.setCapitalOfFounder(CommonUtil.deleteDoubleQuate(params[108]));
		ventuer.setCapitalOfAcquaintance(CommonUtil.deleteDoubleQuate(params[109]));
		ventuer.setCapttalOfEmployee(CommonUtil.deleteDoubleQuate(params[110]));
		ventuer.setCapitalOfDomesticAngle(CommonUtil.deleteDoubleQuate(params[111]));
		ventuer.setCapitalOfDomesticVcBusiness(CommonUtil.deleteDoubleQuate(params[112]));
		ventuer.setCapitalOfDomesticVcUniversity(CommonUtil.deleteDoubleQuate(params[113]));
		ventuer.setCapitalOfDomesticVcOther(CommonUtil.deleteDoubleQuate(params[114]));
		ventuer.setCapitalOfDomesticBusiness(CommonUtil.deleteDoubleQuate(params[115]));
		ventuer.setCapitalOfDomesticBank(CommonUtil.deleteDoubleQuate(params[116]));
		// 資本構成_国内大学がDBにないのでparams[117]は未使用
		ventuer.setCapitalOfDomesticOther(CommonUtil.deleteDoubleQuate(params[118]));
		ventuer.setCapitalOfOverseaAngle(CommonUtil.deleteDoubleQuate(params[119]));
		ventuer.setCapitalOfOverseaVcBusiness(CommonUtil.deleteDoubleQuate(params[120]));
		ventuer.setCapitalOfOverseaVcUniversity(CommonUtil.deleteDoubleQuate(params[121]));
		ventuer.setCapitalOfOverseaVcOther(CommonUtil.deleteDoubleQuate(params[122]));
		ventuer.setCapitalOfOverseaBusiness(CommonUtil.deleteDoubleQuate(params[123]));
		ventuer.setCapitalOfOverseaBank(CommonUtil.deleteDoubleQuate(params[124]));
		ventuer.setCaptialOfOverseaUniversity(CommonUtil.deleteDoubleQuate(params[125]));
		ventuer.setCaptialOfOverseaOther(CommonUtil.deleteDoubleQuate(params[126]));
		ventuer.setCaptialOfOtherConcrete(CommonUtil.deleteDoubleQuate(params[127]));
		ventuer.setCaptialOfLeadInvestorName(CommonUtil.deleteDoubleQuate(params[128]));
		ventuer.setSubsidyOfNedoVb(CommonUtil.deleteDoubleQuate(params[129]));
		ventuer.setSubsidyOfNedoNewNergy(CommonUtil.deleteDoubleQuate(params[130]));
		ventuer.setSubsidyOfJstStart(CommonUtil.deleteDoubleQuate(params[131]));
		ventuer.setSubsidyOfJstCollab(CommonUtil.deleteDoubleQuate(params[132]));
		ventuer.setSubsidyOfAreaInnovation(CommonUtil.deleteDoubleQuate(params[133]));
		ventuer.setSubsidyOfIctinnovation(CommonUtil.deleteDoubleQuate(params[134]));
		ventuer.setSubsidyOfOther(CommonUtil.deleteDoubleQuate(params[135]));
		ventuer.setSubsidyOfNone(CommonUtil.deleteDoubleQuate(params[136]));
		ventuer.setSubsidyOfOtherConcrete(CommonUtil.deleteDoubleQuate(params[137]));
		ventuer.setCoreProductServiceintroURL2(CommonUtil.deleteDoubleQuate(params[144]));
		ventuer.setCoreProductServiceintroURL3(CommonUtil.deleteDoubleQuate(params[145]));
		ventuer.setCoreProductServiceintroURL4(CommonUtil.deleteDoubleQuate(params[146]));
		ventuer.setCoreProductServiceintroURL5(CommonUtil.deleteDoubleQuate(params[147]));
		ventuer.setSearchDate(CommonUtil.deleteDoubleQuate(params[148]));

		return ventuer;
	}

	/***
	 * 戻るボタン押下処理
	 */
	@FXML
	public void onClickBackBtn(ActionEvent e) {
		log.log(String.format("%s.%s", CommonUtil.getClassName(), CommonUtil.getMethodName()));
		new Main().changeView("view/VMT001.fxml");
	}

}
