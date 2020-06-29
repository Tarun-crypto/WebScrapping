
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

	public static void main(String[] args) {
		/*
		 * Extracting elements from webpage according to our requirement one by one
		 */
		int i=0;
        String name="";
        String phone="";
        String email="";
        String address = "";
        String beds="";
        String baths="";
		Document doc = null;
		String fileName = "/root/Desktop/New-Lead.html";
        try {
			doc = Jsoup.parse(new File(fileName), "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		} 
        Elements body = doc.select("tbody");
		for(Element e : body.select("tr")) {
			i++;
			name = e.select("td.aligncenter font.font16 strong").text();
			if(i==4)
				break;
		}
		Elements verifiedPhone = doc.select("tbody");
		for(Element e : verifiedPhone.select("tr")) {
			//String verifyphone = e.select("font.font12").text();
			i++;
			if(i==19) {
				break;
			}		
		}
		Elements phones = doc.select("tbody");
		for(Element e : phones.select("tr")) {
			i++;
			email = e.getElementsByTag("a").text();
			if(i==43) {
			}
			if(i==44) {
				break;
			}
			 phone = e.getElementsByTag("a").text();
		}
		Elements addresses = doc.select("tbody");
		for(Element e : addresses.select("tr")) {
			address = e.getElementsByTag("a").text();
			i++;
			if(i==78) {
			break;
			}
			
		}
		Elements bedsBaths = doc.select("tbody");
		for(Element e : bedsBaths.select("font.font12")) {
			i++;
			String total = e.select("font.font12").text();
			if(i==89) {
				beds = total.substring(5,7);
				baths = total.substring(13,14);
			}
		}
		
		RealityObject object = new RealityObject(name,email,phone,beds,baths,address);
		try {
			System.out.println(object.getJSON());
		} catch (JsonGenerationException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/*
		 * Writing data onto a File i.e output.json file. This is called persistance Storage
		 */
		File f = new File("/root/Desktop/output.json");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(object.getJSON());
		
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}

