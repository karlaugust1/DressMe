package br.com.vsetsistemas.model;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class GeradorDeRelatorios {

	private static final String url = "jdbc:mysql://127.0.0.1/dressme";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String login = "root";
	private static final String pwd = "87009008Karl1";
	private Connection con;

	public GeradorDeRelatorios() {
	}

	public void gerar(String layout, long numero, OutputStream saida) throws Exception {
		// gerando o jasper design
		try {
		
			JasperDesign desenho = JRXmlLoader.load(layout);

			// compila o relatório
			JasperReport relatorio = JasperCompileManager.compileReport(desenho);

			// estabelece conexão
			Class.forName(driver);
			con = DriverManager.getConnection(url, login, pwd);
			Statement stm = con.createStatement();
			String query = "select * from notafiscal as nf inner join produto_notafiscal as pnf on pnf.numeronota = nf.numero inner join empresa e on e.id = nf.empresa where nf.numero="
					+ numero + ";";
			ResultSet rs = stm.executeQuery(query);

			// implementação da interface JRDataSource para DataSource ResultSet
			JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

			// executa o relatório
			Map parametros = new HashMap();
			JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, jrRS);

			// exporta para pdf
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, impressao);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);

			exporter.exportReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}