package bridalwear;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import bridalwear.Products;

public class InitContextParam implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext context = arg0.getServletContext();
		String catalogFileName = context.getInitParameter("fileName");
		InputStream is = null;
		BufferedReader catReader = null;
		try{ 
			is = context.getResourceAsStream(catalogFileName);
			catReader= new BufferedReader(new InputStreamReader(is));
			String productString;
			List<Products> catalog = new ArrayList<Products>();
			while ((productString = catReader.readLine()) !=null) {
				StringTokenizer tokens = new StringTokenizer(productString, ",");
				String code = tokens.nextToken();
				String name = tokens.nextToken();
				double price = new Double(tokens.nextToken());
				String image = tokens.nextToken();
				Products p = new Products();
				p.setProductCode(code);
				p.setProductName(name);
				p.setProductImage(image);
				p.setProductPrice(price);
				catalog.add(p);
			}
			context.setAttribute("catalog", catalog);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is!=null){
				try{ 
					is.close();
				}catch (Exception e) {
				}
			}
			if (catReader !=null) {
				try{
					catReader.close();
				}catch (Exception e) {
				}
				
        	}

			}
			
		}



}
